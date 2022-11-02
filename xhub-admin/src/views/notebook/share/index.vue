<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryParamsRef" :inline="true" v-show="showSearch" label-width="68px"
             @submit.native.prevent>
      <el-form-item label="笔记标题" prop="title">
        <el-input
            v-model="queryParams.title"
            placeholder="请输入笔记标题"
            clearable
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['notebook:share:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['notebook:share:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="shareList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="60" align="center"/>
      <el-table-column label="笔记ID" width="80" align="center" prop="contentId"/>
      <el-table-column label="笔记标题" align="left" prop="title">
        <template #default="scope">
          <el-link type="primary" @click="handleLink(scope.row)">{{ scope.row.title }}</el-link>
        </template>
      </el-table-column>
      <el-table-column label="访问密码" align="center" prop="shareSecret">
        <template #default="scope">
          <span v-if="!scope.row.shareSecret">无密码</span>
          <span v-if="scope.row.shareSecret">{{ scope.row.shareSecret }}</span>
        </template>
      </el-table-column>
      <el-table-column label="到期时间" align="center">
        <template #default="scope">
          <span v-if="scope.row.shareDays===0">至无限期</span>
          <span v-if="scope.row.shareDays>0">{{
              parseTime(dateAddDays(scope.row.updateTime, scope.row.shareDays))
            }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              size="small"
              type="text"
              icon="Document"
              v-copyText="getLink(scope.row)"
              v-copyText:callback="copySuccess"
          >复制链接
          </el-button>
          <el-button
              size="small"
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['notebook:share:remove']"
          >取消分享
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
        v-show="total>0"
        :total="total"
        v-model:page="queryParams.pageNum"
        v-model:limit="queryParams.pageSize"
        @pagination="getList"
    />
  </div>
</template>

<script setup name="Share">
import {delShare, listShare} from "@/api/notebook/share";


const {proxy} = getCurrentInstance();

// 遮罩层
const loading = ref(true);
// 选中数组
const ids = ref([]);
// 非单个禁用
const single = ref(true);
// 非多个禁用
const multiple = ref(true);
// 显示搜索条件
const showSearch = ref(true);
// 总条数
const total = ref(0);
// 笔记分享表格数据
const shareList = ref(null);
// 弹出层标题
const title = ref("");
// 是否显示弹出层
const open = ref(false);
// 查询参数
const queryParams = ref({
  title: null,
  pageNum: 1,
  pageSize: 10,
  shareSecret: null,
  shareDays: null,
});
// 表单参数
const form = ref({});


/** 查询笔记分享列表 */
function getList() {
  loading.value = true;
  listShare(queryParams.value).then(response => {
    shareList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    contentId: null,
    shareSecret: null,
    shareDays: null,
    createBy: null,
    createTime: null,
    updateBy: null,
    updateTime: null,
    remark: null
  };
  proxy.resetForm("formRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryParamsRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.contentId)
  single.value = selection.length !== 1
  multiple.value = !selection.length
}

/** 删除按钮操作 */
function handleDelete(row) {
  const contentIds = row.contentId || ids.value;
  proxy.$modal.confirm('是否确认取消笔记ID为"' + contentIds + '"的笔记分享？').then(function () {
    return delShare(contentIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("取消成功");
  }).catch(() => {
  });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('notebook/share/export', {
    ...queryParams.value
  }, `note_share_${new Date().getTime()}.xlsx`)
}

/** 访问按钮操作 */
function handleLink(row) {
  window.open(getLink(row));
}

/** 时间增加指定天数 **/
function dateAddDays(dateStr, days) {
  if (!days) {
    days = 1;
  }
  let date = new Date(dateStr);
  return date.setDate(date.getDate() + days);
}

/** 获取访问链接 */
function getLink(row) {
  const env = import.meta.env;
  let url = "/share/" + row.contentId + ".html";
  if (row.shareSecret) {
    url = url + "?secret=" + row.shareSecret;
  }
  if (env.DEV) {
    url = env.VITE_APP_API + url;
  }
  return url;
}

/** 复制成功 */
function copySuccess() {
  proxy.$modal.msgSuccess("复制成功");
}

getList();
</script>
