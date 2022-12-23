<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--目录数据-->
      <el-col :span="5" :xs="24">
        <div class="head-container hidden-xs-only">
          <el-input
              v-model="catalogNameKey"
              placeholder="请输入目录名称"
              clearable
              prefix-icon="Search"
              style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container hidden-xs-only">
          <el-tree
              ref="treeRef"
              node-key="id"
              :data="catalogOptions"
              :props="catalogProps"
              :expand-on-click-node="false"
              :highlight-current="true"
              :filter-node-method="filterCatalogNode"
              @node-click="handleNodeClick"
          />
        </div>
        <div class="head-container hidden-sm-and-up">
          <el-tree-select
              v-model="queryParams.catalogId"
              :data="catalogOptions"
              :props="catalogProps"
              value-key="id"
              :filter-node-method="filterCatalogNode"
              filterable
              placeholder="请选择笔记目录"
              class="catalogSelect"
              check-strictly
              @node-click="handleNodeClick"
          />
          <p/>
        </div>
      </el-col>
      <!--笔记数据-->
      <el-col :span="19" :xs="24">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch"
                 @submit.native.prevent>
          <el-form-item :label="`【${currentCatalogName}】搜索`" prop="searchValue">
            <el-input
                v-model="queryParams.searchValue"
                placeholder="请输入搜索关键字"
                clearable
                style="width: 240px"
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
                type="primary"
                plain
                icon="Plus"
                @click="handleAdd"
                v-hasPermi="['notebook:content:add']"
            >新增
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-upload
                accept=".md,.txt"
                :show-file-list="false"
                :headers="headers"
                :action="getImportAction()"
                :before-upload="handleBeforeUpload"
                :on-error="handleUploadError"
                :on-success="handleUploadSuccess">
              <el-button type="warning" icon="Upload"
                         @click="handleImport($event)"
                         v-hasPermi="['notebook:content:import']">导入
              </el-button>
            </el-upload>
          </el-col>
          <el-col :span="1.5">
            <el-button
                type="danger"
                plain
                icon="Delete"
                :disabled="multiple"
                @click="handleDelete"
                v-hasPermi="['notebook:content:remove']"
            >删除
            </el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contentList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="60" align="center"/>
          <el-table-column label="ID" align="center" prop="id" width="60"/>
          <el-table-column label="标题" align="left" prop="title">
            <template #default="scope">
              <el-link type="primary" @click="handlePreview(scope.row)">{{ scope.row.title }}</el-link>
            </template>
          </el-table-column>
          <el-table-column label="创建时间" align="center" prop="createTime" width="160">
            <template #default="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="更新时间" align="center" prop="updateTime" width="160">
            <template #default="scope">
              <span>{{ parseTime(scope.row.updateTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template #default="scope">
              <el-button
                  size="small"
                  type="text"
                  icon="Edit"
                  @click="handleEdit(scope.row)"
                  v-hasPermi="['notebook:content:edit']"
              >编辑
              </el-button>
              <el-button
                  size="small"
                  type="text"
                  icon="Setting"
                  @click="handleSetting(scope.row)"
                  v-hasPermi="['notebook:content:setting']"
              >设置
              </el-button>
              <el-button
                  size="small"
                  type="text"
                  icon="Download"
                  @click="handleDownload(scope.row)"
                  v-hasPermi="['notebook:content:download']"
              >下载
              </el-button>
              <el-button
                  size="small"
                  type="text"
                  icon="Coin"
                  @click="handleHistory(scope.row)"
                  v-hasPermi="['notebook:content:history']"
              >历史
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
      </el-col>
    </el-row>

    <!-- 添加或修改笔记内容对话框 -->
    <el-dialog :title="title" v-model="open" :close-on-click-modal="false" width="500px" append-to-body>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="笔记标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入笔记标题"/>
        </el-form-item>
        <el-form-item label="所属目录" prop="catalogId">
          <el-tree-select
              v-model="form.catalogId"
              :data="catalogOptions"
              :props="catalogProps"
              value-key="id"
              :filter-node-method="filterCatalogNode"
              filterable
              placeholder="请选择所属目录"
              class="catalogSelect"
              check-strictly
          />
        </el-form-item>
        <el-form-item label="是否分享" v-show="form.id!=null">
          <el-radio-group v-model="share.isShare">
            <el-radio
                v-for="dict in sys_yes_no"
                :key="dict.value"
                :label="dict.value"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="分享时长" v-show="share.isShare==='Y'">
          <el-input-number v-model="share.shareDays" controls-position="right" :min="0"
                           placeholder="设置'0'或留空代表永久分享"/>
          （单位：天）
        </el-form-item>
        <el-form-item label="分享密码" v-show="share.isShare==='Y'">
          <el-input v-model="share.shareSecret" placeholder="不设置表示无需密码"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime" v-show="form.id!=null">
          <el-input v-model="form.createTime" :readonly="true" :disabled="true"/>
        </el-form-item>
        <el-form-item label="更新时间" prop="updateTime" v-show="form.id!=null">
          <el-input v-model="form.updateTime" :readonly="true" :disabled="true"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 查看与恢复笔记历史对话框 -->
    <el-dialog :title="title" v-model="historyOpen" :close-on-click-modal="false" width="900px" append-to-body>
      <el-row>
        <el-col :span="5">
          <el-menu class="historyMenu" @select="handleSelectHistory" default-active="0">
            <el-menu-item v-for="(h,i) in historyList" :key="i" :index="i.toString()">
              <span>{{ parseTime(h.createTime) }}</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="19">
          <el-form ref="historyFormRef" :model="historyForm" label-width="80px">
            <el-form-item label="标题" prop="title">
              <el-input v-model="historyForm.title" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="目录" prop="catalogId">
              <el-tree-select
                  disabled
                  v-model="historyForm.catalogId"
                  :data="catalogOptions"
                  :props="catalogProps"
                  value-key="id"
                  :filter-node-method="filterCatalogNode"
                  filterable
                  placeholder="请选择所属目录"
                  class="catalogSelect"
                  check-strictly
              />
            </el-form-item>
            <el-form-item label="内容">
              <el-input type="textarea" v-model="historyForm.content" rows="15" :disabled="true"
                        resize="none" class="hisContent"></el-input>
            </el-form-item>
            <el-form-item style="text-align: right;">
              <el-button type="danger" @click="handleReset">恢复到此版本</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script setup name="Content">
import {addContent, delContent, generateToken, getContent, listContent, updateContent} from "@/api/notebook/content";
import {delShare, getShare, saveShare} from "@/api/notebook/share";
import {treeSelect} from "@/api/notebook/catalog";
import {listHistory} from "@/api/notebook/history";
import {getToken} from "@/utils/auth";


const router = useRouter();
const {proxy} = getCurrentInstance();
const {sys_yes_no} = proxy.useDict("sys_yes_no");

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
// 笔记表格数据
const contentList = ref(null);
// 弹出层标题
const title = ref("");
// 目录树选项
const catalogOptions = ref([]);
// 目录名称关键字
const catalogNameKey = ref(undefined);
// 是否显示弹出层
const open = ref(false);
// 表单参数
const form = ref({});
// 是否显示历史层
const historyOpen = ref(false);
// 历史笔记列表数据
const historyList = ref(null);
// 历史笔记表单参数
const historyForm = ref({});
// 目录树节点属性
const catalogProps = {value: 'id', label: 'name', children: 'children'};
// 当前目录名称
const currentCatalogName = ref("全部笔记");
// 查询参数
const queryParams = ref({
  pageNum: 1,
  pageSize: 10,
  searchValue: null,
  catalogId: null,
  title: null,
  content: null,
  rank: null
});
// 表单校验
const rules = {
  catalogId: [
    {required: true, message: "笔记所属目录不能为空", trigger: "blur"}
  ],
  title: [
    {required: true, message: "笔记标题不能为空", trigger: "blur"}
  ]
};
// 分享内容
const share = ref({
  isShare: 'N',
  shareDays: 0,
  shareSecret: null
});
// 请求头Token
const headers = ref({
  Authorization: "Bearer " + getToken(),
});
// 笔记缓存前缀
const cachePrefix = ref("mcache:");

/** 查询笔记列表 */
function getList() {
  loading.value = true;
  listContent(queryParams.value).then(response => {
        contentList.value = response.rows;
        total.value = response.total;
        loading.value = false;
      }
  );
}


/** 查询目录下拉树结构 */
function getTreeSelect() {
  treeSelect().then(response => {
    catalogOptions.value = response.data;
  });
}

/** 筛选目录树节点 */
function filterCatalogNode(value, data) {
  if (!value) return true;
  return data.name.toLowerCase().includes(value.toLowerCase());
}

/** 节点单击事件 */
function handleNodeClick(data) {
  queryParams.value.catalogId = data.id;
  currentCatalogName.value = data.name;
  handleQuery();
}

/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
}

/** 表单重置 */
function reset() {
  form.value = {
    id: null,
    catalogId: null,
    title: null,
    content: null,
    rank: null,
    createBy: null,
    createTime: null,
    updateBy: null,
    updateTime: null,
    remark: null,
    deleteFlag: 0
  };
  share.value = {
    isShare: 'N',
    shareDays: 0,
    shareSecret: null
  }
  proxy.resetForm("formRef");
}

/** 笔记历史表单重置 */
function resetHistory() {
  historyForm.value = {
    id: null,
    catalogId: null,
    contentId: null,
    title: null,
    content: null,
    rank: null,
    createBy: null,
    createTime: null,
    updateBy: null,
    updateTime: null,
    remark: null
  };
  proxy.resetForm("historyFormRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.$refs["treeRef"].setCurrentKey(null);
  queryParams.value.catalogId = null;
  currentCatalogName.value = "全部笔记";
  proxy.resetForm("queryRef");
  getList();
}

/** 多选框选中数据 */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length !== 1
  multiple.value = !selection.length
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["formRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        form.value.content = null;
        updateContent(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
        if (share.value.isShare === 'Y') {
          saveShare({
            contentId: form.value.id,
            shareDays: share.value.shareDays,
            shareSecret: share.value.shareSecret
          });
        } else {
          delShare(form.value.id)
        }
      } else {
        addContent(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加笔记基本信息";
  form.value.catalogId = queryParams.value.catalogId;
}

/** 删除按钮操作 */
function handleDelete(row) {
  const select = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除笔记编号为"' + select + '"的数据项？').then(function () {
    return delContent(select);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
}

/** Markdown编辑按钮操作 */
function handleEdit(row) {
  router.push({
    name: "Editor/:id",
    params: {
      id: row.id,
      title: row.title
    }
  });
}

/** 修改按钮操作 */
function handleSetting(row) {
  reset();
  const select = row.id || ids.value
  getContent(select).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改笔记基本信息";
  });
  getShare(select).then(response => {
    if (response.data) {
      share.value.isShare = 'Y';
      share.value.shareDays = response.data.shareDays;
      share.value.shareSecret = response.data.shareSecret;
    }
  });
}

/** 预览按钮操作 */
function handlePreview(row) {
  generateToken().then(response => {
    let url = "/share/" + row.id + ".html?token=" + response.data
    const env = import.meta.env
    if ((env.DEV)) {
      url = env.VITE_APP_API + url
    }
    window.open(url)
  });
}

/** 下载按钮操作 */
function handleDownload(row) {
  getContent(row.id).then(async (res) => {
    if (res.code === 200) {
      const blob = new Blob([res.data.content], {type: 'application/markdown'})
      proxy.$download.saveAs(blob, res.data.title + ".md")
    } else {
      proxy.$modal.msgError(res.msg);
    }
  })
}

/** 历史按钮操作 */
function handleHistory(row) {
  historyList.value = null;
  resetHistory();
  historyOpen.value = true;
  title.value = "【" + row.title + "】笔记历史版本";
  listHistory({contentId: row.id}).then(response => {
    if (response.total > 0) {
      historyList.value = response.rows;
      historyForm.value = historyList.value[0];
    }
  });
}

/** 历史选中操作 */
function handleSelectHistory(key, keyPath) {
  if (key) {
    historyForm.value = historyList.value[parseInt(key)];
  }
}

/** 恢复按钮操作 */
function handleReset() {
  let history = historyForm.value;
  if (history.contentId) {
    proxy.$modal.confirm('确认恢复当前笔记到【' + history.createTime + '】的版本？').then(function () {
      let content = {
        id: history.contentId,
        catalogId: history.catalogId,
        title: history.title,
        content: history.content,
        rank: history.rank,
        remark: history.remark
      }
      return updateContent(content);
    }).then(() => {
      getList();
      proxy.$cache.local.remove(cachePrefix.value + history.contentId);
      proxy.$modal.msgSuccess("恢复成功");
    });
  } else {
    proxy.$modal.msgError("当前笔记没有历史版本")
  }
}

/** 导入按钮操作 */
function handleImport(event) {
  // 必须选择目录
  if (!queryParams.value.catalogId) {
    proxy.$modal.msgError(`请在左侧选择导入笔记的目录!`);
    event.stopPropagation();
  }
}

/** 动态导入路径 */
function getImportAction() {
  return import.meta.env.VITE_APP_BASE_API + "/notebook/content/import/" + queryParams.value.catalogId
}

/** 导入前操作 */
function handleBeforeUpload(file) {
  proxy.$modal.loading("正在上传文件，请稍候...");
  return true;
}

/** 导入失败 */
function handleUploadError(err) {
  proxy.$modal.msgError("导入文件失败，请重试");
  proxy.$modal.closeLoading()
}

/** 导入成功回调 */
function handleUploadSuccess(resp) {
  if (resp.code === 200) {
    proxy.$modal.msgSuccess("文件导入成功");
    proxy.$modal.closeLoading();
    getList();
  } else {
    proxy.$modal.msgError(resp.msg);
    proxy.$modal.closeLoading();
  }
}

/** 监控目录关键字 */
watch(catalogNameKey, (val) => {
  proxy.$refs["treeRef"].filter(val);
})

getList();
getTreeSelect();
</script>

<style lang="scss">
.catalogSelect {
  width: 100%;
}

.historyMenu {
  height: 500px;
  overflow-y: auto;
  overflow-x: hidden;
}

.historyMenu::-webkit-scrollbar {
  width: 4px;
  height: 4px
}

.historyMenu::-webkit-scrollbar-thumb {
  background-color: #c9cdd4;
  outline: none;
  border-radius: 2px;
}

.historyMenu::-webkit-scrollbar-track {
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 2px;
}

.hisContent textarea::-webkit-scrollbar {
  width: 4px;
  height: 4px
}

.hisContent textarea::-webkit-scrollbar-thumb {
  background-color: #c9cdd4;
  outline: none;
  border-radius: 2px;
}

.hisContent textarea::-webkit-scrollbar-track {
  -webkit-box-shadow: none;
  box-shadow: none;
  border-radius: 2px;
}
</style>
