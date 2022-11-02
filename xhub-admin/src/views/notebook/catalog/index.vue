<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryParamsRef"
             :inline="true" v-show="showSearch" label-width="68px"
             @submit.native.prevent>
      <el-form-item label="目录名称" prop="name">
        <el-input
            v-model="queryParams.name"
            placeholder="请输入目录名称"
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
            type="primary"
            plain
            icon="Plus"
            @click="handleAdd"
            v-hasPermi="['notebook:catalog:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="info"
            plain
            icon="Sort"
            @click="toggleExpandAll"
        >展开/折叠
        </el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table
        v-if="refreshTable"
        v-loading="loading"
        :data="catalogList"
        row-key="id"
        :default-expand-all="isExpandAll"
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
    >
      <el-table-column label="目录名称" align="left" prop="name"/>
      <el-table-column label="排序" align="center" prop="rank"/>
      <el-table-column label="创建时间" align="center" prop="createTime"/>
      <el-table-column label="更新时间" align="center" prop="updateTime"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              size="small"
              type="text"
              icon="Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['notebook:catalog:edit']"
          >修改
          </el-button>
          <el-button
              size="small"
              type="text"
              icon="Plus"
              @click="handleAdd(scope.row)"
              v-hasPermi="['notebook:catalog:add']"
          >新增
          </el-button>
          <el-button
              size="small"
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['notebook:catalog:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改笔记目录对话框 -->
    <el-dialog :title="title" v-model="open" :close-on-click-modal="false" width="500px" append-to-body>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="上级目录" prop="parentId">
          <el-tree-select
              v-model="form.parentId"
              :data="catalogOptions"
              :props="catalogProps"
              value-key="id"
              :filter-node-method="filterCatalogNode"
              filterable
              placeholder="上级目录"
              class="catalogSelect"
              check-strictly
          />
        </el-form-item>
        <el-form-item label="目录名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称"/>
        </el-form-item>
        <el-form-item label="排序" prop="rank">
          <el-input-number v-model="form.rank" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-input v-model="form.createTime" :readonly="true" :disabled="true"/>
        </el-form-item>
        <el-form-item label="更新时间" prop="updateTime">
          <el-input v-model="form.updateTime" :readonly="true" :disabled="true"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script setup name="Catalog">
import {listCatalog, getCatalog, delCatalog, addCatalog, updateCatalog} from "@/api/notebook/catalog";


const router = useRouter();
const {proxy} = getCurrentInstance();

// 遮罩层
const loading = ref(true);
// 显示搜索条件
const showSearch = ref(true);
// 笔记目录表格数据
const catalogList = ref([]);
// 笔记目录树选项
const catalogOptions = ref([]);
// 弹出层标题
const title = ref("");
// 是否显示弹出层
const open = ref(false);
// 是否展开，默认全部展开
const isExpandAll = ref(false);
// 重新渲染表格状态
const refreshTable = ref(true);
// 查询参数
const queryParams = ref({
  parentId: null,
  name: null,
  rank: null,
  deleteFlag: 0
});
// 表单参数
const form = ref({});
// 表单校验
const rules = {
  parentId: [
    {required: true, message: "父级ID不能为空", trigger: "blur"}
  ],
  name: [
    {required: true, message: "名称不能为空", trigger: "blur"}
  ]
};
// 目录树节点属性
const catalogProps = {value: 'id', label: 'name', children: 'children'};


/** 查询笔记目录列表 */
function getList() {
  loading.value = true;
  listCatalog(queryParams.value).then(response => {
    catalogList.value = proxy.handleTree(response.data, "id", "parentId");
    loading.value = false;
  });
}

/** 筛选目录树节点 */
function filterCatalogNode(value, data) {
  if (!value) return true;
  return data.name.toLowerCase().includes(value.toLowerCase());
}

/** 查询笔记目录下拉树结构 */
function getTreeSelect() {
  listCatalog().then(response => {
    catalogOptions.value = [];
    const data = {id: 0, name: '笔记目录', children: []};
    data.children = proxy.handleTree(response.data, "id", "parentId");
    catalogOptions.value.push(data);
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
    parentId: null,
    name: null,
    rank: null,
    createBy: null,
    createTime: null,
    updateBy: null,
    updateTime: null,
    remark: null,
    deleteFlag: 0
  };
  proxy.resetForm("formRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryParamsRef");
  handleQuery();
}

/** 新增按钮操作 */
function handleAdd(row) {
  reset();
  getTreeSelect();
  if (row != null && row.id) {
    form.value.parentId = row.id;
  } else {
    form.value.parentId = 0;
  }
  open.value = true;
  title.value = "添加笔记目录";
}

/** 展开/折叠操作 */
function toggleExpandAll() {
  refreshTable.value = false;
  isExpandAll.value = !isExpandAll.value;
  nextTick(() => {
    refreshTable.value = true;
  });
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  getTreeSelect();
  if (row != null) {
    form.value.parentId = row.id;
  }
  getCatalog(row.id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改笔记目录";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["formRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateCatalog(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addCatalog(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除笔记目录编号为"' + row.id + '"的数据项？').then(function () {
    return delCatalog(row.id);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
}

getList();
</script>

<style lang="scss">
.catalogSelect {
  width: 100%;
}
</style>
