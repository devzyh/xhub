<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryParamsRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="分组" prop="item">
        <el-select v-model="queryParams.item">
          <el-option
              v-for="dict in fav_link_item"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input
            v-model="queryParams.name"
            placeholder="请输入名称"
            clearable
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="打开方式" prop="target">
        <el-select v-model="queryParams.target">
          <el-option
              v-for="dict in web_open_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
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
            v-hasPermi="['fav:link:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['fav:link:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['fav:link:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="favoriteList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="ID" align="center" prop="id" width="60"/>
      <el-table-column label="链接分组" align="center" prop="item" width="100"/>
      <el-table-column label="显示名称" align="left" prop="name"/>
      <el-table-column label="链接地址" align="left" prop="href"/>
      <el-table-column label="显示顺序" align="center" prop="seq" width="80"/>
      <el-table-column label="打开方式" align="center" prop="target" width="100">
        <template #default="scope">
          <dict-tag :options="web_open_type" :value="scope.row.target"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              size="small"
              type="text"
              icon="Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['fav:link:edit']"
          >修改
          </el-button>
          <el-button
              size="small"
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['fav:link:remove']"
          >删除
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

    <!-- 添加或修改主页链接对话框 -->
    <el-dialog :title="title" v-model="open" :close-on-click-modal="false" width="500px" append-to-body>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="分组" prop="item">
          <el-select v-model="form.item">
            <el-option
                v-for="dict in fav_link_item"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="显示名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入显示名称"/>
        </el-form-item>
        <el-form-item label="链接地址" prop="href">
          <el-input v-model="form.href" placeholder="请输入链接地址"/>
        </el-form-item>
        <el-form-item label="链接备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入链接备注"/>
        </el-form-item>
        <el-form-item label="图像地址" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入图像地址"/>
        </el-form-item>
        <el-form-item label="显示顺序" prop="seq">
          <el-input-number v-model="form.seq" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="打开方式" prop="target">
          <el-select v-model="form.target">
            <el-option
                v-for="dict in web_open_type"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script setup name="Favorite">
import {listFavorite, getFavorite, delFavorite, addFavorite, updateFavorite} from "@/api/favorite/link";

const {proxy} = getCurrentInstance();
const {fav_link_item, web_open_type} = proxy.useDict("fav_link_item", "web_open_type");

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
// 主页链接表格数据
const favoriteList = ref([]);
// 弹出层标题
const title = ref("");
// 是否显示弹出层
const open = ref(false);
// 查询参数
const queryParams = ref({
  pageNum: 1,
  pageSize: 10,
  item: null,
  name: null,
  href: null,
  icon: null,
  seq: null,
  target: null
});
// 表单参数
const form = ref({});
// 表单校验
const rules = {
  item: [
    {required: true, message: "链接分组不能为空", trigger: "blur"}
  ],
  name: [
    {required: true, message: "链接名称不能为空", trigger: "blur"}
  ],
  href: [
    {required: true, message: "链接地址不能为空", trigger: "blur"}
  ],
  seq: [
    {required: true, message: "显示顺序不能为空", trigger: "blur"}
  ],
  target: [
    {required: true, message: "打开方式不能为空", trigger: "blur"}
  ]
};

/** 查询主页链接列表 */
function getList() {
  loading.value = true;
  listFavorite(queryParams.value).then(response => {
    favoriteList.value = response.rows;
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
    id: null,
    item: null,
    name: null,
    href: null,
    remark: null,
    icon: null,
    seq: null,
    target: null
  };
  proxy.resetForm("form");
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
  ids.value = selection.map(item => item.id)
  single.value = selection.length !== 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加链接信息";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const select = row.id || ids.value
  getFavorite(select).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改链接信息";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["formRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateFavorite(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addFavorite(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const select = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除主页链接编号为"' + select + '"的数据项？').then(function () {
    return delFavorite(select);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('fav/link/export', {
    ...queryParams.value
  }, `fav_link_${new Date().getTime()}.xlsx`)
}

getList();
</script>
