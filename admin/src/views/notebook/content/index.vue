<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--目录数据-->
      <el-col :span="5" :xs="24">
        <div class="head-container">
          <el-input
            v-model="catalogName"
            placeholder="请输入目录名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="catalogOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :highlight-current="true"
            :filter-node-method="filterNode"
            ref="tree"
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--笔记数据-->
      <el-col :span="19" :xs="24">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
                 label-width="68px" @submit.native.prevent>
          <el-form-item label="搜索笔记" prop="searchValue">
            <el-input
              v-model="queryParams.searchValue"
              placeholder="请输入搜索关键字"
              clearable
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
              v-hasPermi="['notebook:content:add']"
            >新增
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
              v-hasPermi="['notebook:content:remove']"
            >删除
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['notebook:content:export']"
            >导出
            </el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contentList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="60" align="center"/>
          <el-table-column label="ID" align="center" prop="id" width="60"/>
          <el-table-column label="标题" align="left" prop="title"/>
          <el-table-column label="排序" align="center" prop="rank" width="60"/>
          <el-table-column label="创建时间" align="center" prop="createTime" width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="更新时间" align="center" prop="updateTime" width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.updateTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleEdit(scope.row)"
                v-hasPermi="['notebook:content:edit']"
              >编辑
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-setting"
                @click="handleSetting(scope.row)"
                v-hasPermi="['notebook:content:setting']"
              >设置
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-view"
                @click="handlePreview(scope.row)"
                v-hasPermi="['notebook:content:token']"
              >预览
              </el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-coin"
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
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改笔记内容对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="笔记标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入笔记标题"/>
        </el-form-item>
        <el-form-item label="所属目录" prop="catalogId">
          <treeselect v-model="form.catalogId" :options="catalogOptions" :normalizer="normalizer" :show-count="true"
                      placeholder="请选择所属目录"/>
        </el-form-item>
        <el-form-item label="排序" prop="rank">
          <el-input-number v-model="form.rank" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="是否分享" v-show="form.id!=null">
          <el-radio-group v-model="share.isShare">
            <el-radio
              v-for="dict in dict.type.sys_yes_no"
              :key="dict.value"
              :label="dict.value"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="分享时长" v-show="share.isShare=='Y'">
          <el-input-number v-model="share.shareDays" controls-position="right" :min="0"
                           placeholder="设置'0'或留空代表永久分享"/>
          （单位：天）
        </el-form-item>
        <el-form-item label="分享密码" v-show="share.isShare=='Y'">
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
    <el-dialog :title="title" :visible.sync="openHistory" width="900px" append-to-body>
      <el-row>
        <el-col :span="5">
          <el-menu @select="handleSelectHistory" default-active="0"
                   style="height: 500px;overflow-y:auto;overflow-x:hidden;">
            <el-menu-item v-for="(h,i) in historyList" :index="i.toString()">
              <span>{{ parseTime(h.createTime) }}</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="19">
          <el-form ref="form" :model="historyForm" label-width="80px">
            <el-form-item label="标题" prop="title">
              <el-input v-model="historyForm.title" :disabled="true"></el-input>
            </el-form-item>
            <el-row>
              <el-col :span="12">
                <el-form-item label="目录" prop="catalogId">
                  <treeselect v-model="historyForm.catalogId" :options="catalogOptions" :normalizer="normalizer"
                              :disabled="true"/>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="排序" prop="rank">
                  <el-input-number v-model="historyForm.rank" controls-position="right" :min="0"
                                   :disabled="true"></el-input-number>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item label="内容">
              <el-input type="textarea" v-model="historyForm.content" rows="15" :disabled="true"
                        resize="none"></el-input>
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

<script>
import {addContent, delContent, getContent, listContent, updateContent, generateToken} from "@/api/notebook/content";
import {delShare, getShare, saveShare} from "@/api/notebook/share";
import {treeselect} from "@/api/notebook/catalog";
import {listHistory} from "@/api/notebook/history";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Content",
  dicts: ["sys_yes_no"],
  components: {Treeselect},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 笔记表格数据
      contentList: null,
      // 弹出层标题
      title: "",
      // 目录树选项
      catalogOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 目录名称
      catalogName: undefined,
      // 表单参数
      form: {},
      // 是否显示历史层
      openHistory: false,
      // 历史笔记列表数据
      historyList: null,
      // 历史笔记表单参数
      historyForm: {},
      defaultProps: {
        children: "children",
        label: "name"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        catalogId: null,
        title: null,
        content: null,
        rank: null,
        deleteFlag: 0
      },
      // 表单校验
      rules: {
        catalogId: [
          {required: true, message: "笔记所属目录不能为空", trigger: "blur"}
        ],
        title: [
          {required: true, message: "笔记标题不能为空", trigger: "blur"}
        ]
      },
      // 分享内容
      share: {
        isShare: 'N',
        shareDays: 0,
        shareSecret: null
      }
    };
  },
  watch: {
    // 根据名称筛选目录树
    catalogName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getTreeselect();
  },
  methods: {
    /** 查询笔记列表 */
    getList() {
      this.loading = true;
      listContent(this.queryParams).then(response => {
          this.contentList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 转换菜单数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.id,
        label: node.name,
        children: node.children
      };
    },
    /** 查询目录下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.catalogOptions = response.data;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.catalogId = data.id;
      this.handleQuery();
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
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
      this.share = {
        isShare: 'N',
        shareDays: 0,
        shareSecret: null
      }
      this.resetForm("form");
    },
    // 笔记历史表单重置
    resetHistory() {
      this.historyForm = {
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
      this.resetForm("historyForm");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateContent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
            if (this.share.isShare == 'Y') {
              saveShare({
                contentId: this.form.id,
                shareDays: this.share.shareDays,
                shareSecret: this.share.shareSecret
              });
            } else {
              delShare(this.form.id)
            }
          } else {
            addContent(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加笔记基本信息";
      this.form.catalogId = this.queryParams.catalogId;
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除笔记编号为"' + ids + '"的数据项？').then(function () {
        return delContent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** Markdown编辑按钮操作 */
    handleEdit(row) {
      this.$router.push({path: "/note/editor/" + row.id});
    },
    /** 修改按钮操作 */
    handleSetting(row) {
      this.reset();
      const id = row.id || this.ids
      getContent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改笔记基本信息";
      });
      getShare(id).then(response => {
        if (response.data) {
          this.share.isShare = 'Y';
          this.share.shareDays = response.data.shareDays;
          this.share.shareSecret = response.data.shareSecret;
        }
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('notebook/content/export', {
        ...this.queryParams
      }, `content_${new Date().getTime()}.xlsx`)
    },
    /** 预览按钮操作 */
    handlePreview(row) {
      generateToken().then(response => {
        window.open("/note/" + row.id + ".html?token=" + response.data)
      });
    },
    /** 历史按钮操作 */
    handleHistory(row) {
      this.historyList = null;
      this.resetHistory();
      this.openHistory = true;
      this.title = "【" + row.title + "】笔记历史版本";
      listHistory({contentId: row.id}).then(response => {
        if (response.total > 0) {
          this.historyList = response.rows;
          this.historyForm = this.historyList[0];
        }
      });
    },
    /** 历史选中操作 */
    handleSelectHistory(key, keyPath) {
      this.historyForm = this.historyList[parseInt(key)];
    },
    /** 恢复按钮操作 */
    handleReset() {
      let history = this.historyForm;
      if (history.contentId) {
        this.$modal.confirm('确认恢复当前笔记到【' + history.createTime + '】的版本？').then(function () {
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
          this.getList();
          this.$modal.msgSuccess("恢复成功");
        });
      } else {
        this.$modal.msgError("当前笔记没有历史版本")
      }
    }
  }
};
</script>

<style scoped>
</style>
