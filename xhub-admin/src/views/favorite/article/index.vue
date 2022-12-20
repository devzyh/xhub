<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
            v-model="queryParams.title"
            placeholder="请输入标题"
            clearable
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="来源平台" prop="source">
        <el-select v-model="queryParams.source">
          <el-option
              v-for="dict in fav_article_source"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="关联标签" prop="tags">
        <el-select v-model="queryParams.tags" multiple filterable>
          <el-option
              v-for="tag in tagList"
              :key="tag.id"
              :label="tag.name"
              :value="tag.id"
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
            v-hasPermi="['fav:article:add']"
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
            v-hasPermi="['fav:article:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['fav:article:export']"
        >导出
        </el-button>
      </el-col>

      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="articleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="ID" align="center" prop="id" width="60"/>
      <el-table-column label="文章标题" align="left" prop="title"/>
      <el-table-column label="文章地址" align="left" prop="url"/>
      <el-table-column label="来源平台" align="center" prop="source" width="120">
        <template #default="scope">
          <dict-tag :options="fav_article_source" :value="scope.row.source"/>
        </template>
      </el-table-column>
      <el-table-column label="发布日期" align="center" prop="releaseDate" width="120">
        <template #default="scope">
          <span>{{ parseTime(scope.row.releaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button
              size="small"
              type="text"
              icon="Edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['fav:article:edit']"
          >修改
          </el-button>
          <el-button
              size="small"
              type="text"
              icon="Delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['fav:article:remove']"
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

    <!-- 添加或修改文章对话框 -->
    <el-dialog :title="title" v-model="open" :close-on-click-modal="false" width="500px" append-to-body>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="文章标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题"/>
        </el-form-item>
        <el-form-item label="文章地址" prop="url">
          <el-input v-model="form.url" placeholder="请输入地址"/>
        </el-form-item>
        <el-form-item label="关联标签">
          <el-select v-model="form.tags" multiple filterable placeholder="请选择文章标签" style="width: 100%">
            <el-option
                v-for="tag in tagList"
                :key="tag.id"
                :label="tag.name"
                :value="tag.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="内容摘要" prop="digest">
          <el-input v-model="form.digest" type="textarea" placeholder="请输入内容摘要" rows="5"/>
        </el-form-item>
        <el-form-item label="来源平台" prop="source">
          <el-select v-model="form.source">
            <el-option
                v-for="dict in fav_article_source"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="发布日期" prop="releaseDate">
          <el-date-picker
              clearable
              v-model="form.releaseDate"
              type="date"
              value-format="YYYY-MM-DD"
              placeholder="请选择发布日期"
          >
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script setup name="Article">
import {listArticle, getArticle, delArticle, addArticle, updateArticle} from "@/api/favorite/article";
import {allTag} from '@/api/favorite/tag'

const {proxy} = getCurrentInstance();
const {fav_article_source} = proxy.useDict("fav_article_source");

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
// 文章表格数据
const articleList = ref([]);
// 文章标签数据
const tagList = ref([]);
// 弹出层标题
const title = ref("");
// 是否显示弹出层
const open = ref(false);
// 查询参数
const queryParams = ref({
  pageNum: 1,
  pageSize: 10,
  title: null,
  url: null,
  digest: null,
  source: null,
  releaseDate: null,
  tags: null
});
// 表单参数
const form = ref({});
// 表单校验
const rules = {
  title: [
    {required: true, message: "文章标题不能为空", trigger: "blur"}
  ],
  url: [
    {required: true, message: "文章地址不能为空", trigger: "blur"}
  ],
  source: [
    {required: true, message: "来源平台不能为空", trigger: "blur"}
  ],
  releaseDate: [
    {required: true, message: "发布日期不能为空", trigger: "blur"}
  ]
};

/** 查询文章列表 */
function getList() {
  loading.value = true;
  listArticle(queryParams.value).then(response => {
    articleList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

/** 查询文章标签 */
function getTagList() {
  allTag().then(response => {
    tagList.value = response;
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
    title: null,
    url: null,
    digest: null,
    source: null,
    releaseDate: null
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
  proxy.resetForm("queryRef");
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
  title.value = "添加文章信息";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const select = row.id || ids.value
  getArticle(select).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改文章信息";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["formRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateArticle(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addArticle(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除文章编号为"' + select + '"的数据项？').then(function () {
    return delArticle(select);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('fav/article/export', {
    ...queryParams.value
  }, `fav_article_${new Date().getTime()}.xlsx`)
}

getList();
getTagList();
</script>
