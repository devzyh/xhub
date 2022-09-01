<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px"
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
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
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
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['notebook:share:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="shareList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="60" align="center"/>
      <el-table-column label="笔记ID" width="80" align="center" prop="contentId"/>
      <el-table-column label="笔记标题" align="left" prop="title">
        <template slot-scope="scope">
          <el-link type="primary" @click="handleLink(scope.row)">{{ scope.row.title }}</el-link>
        </template>
      </el-table-column>
      <el-table-column label="访问密码" align="center" prop="shareSecret">
        <template slot-scope="scope">
          <span v-if="!scope.row.shareSecret">无密码</span>
          <span v-if="scope.row.shareSecret">{{ scope.row.shareSecret }}</span>
        </template>
      </el-table-column>
      <el-table-column label="到期时间" align="center">
        <template slot-scope="scope">
          <span v-if="scope.row.shareDays==0">至无限期</span>
          <span v-if="scope.row.shareDays>0">{{
              parseTime(dateAddDays(scope.row.updateTime, scope.row.shareDays))
            }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-copy-document"
            v-clipboard:copy="getLink(scope.row)"
            v-clipboard:success="copySuccess"
            v-clipboard:error="copyFailed"
          >复制链接
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
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
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import {delShare, listShare} from "@/api/notebook/share";

export default {
  name: "Share",
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
      // 笔记分享表格数据
      shareList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        title: null,
        pageNum: 1,
        pageSize: 10,
        shareSecret: null,
        shareDays: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询笔记分享列表 */
    getList() {
      this.loading = true;
      listShare(this.queryParams).then(response => {
        this.shareList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        contentId: null,
        shareSecret: null,
        shareDays: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
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
      this.ids = selection.map(item => item.contentId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const contentIds = row.contentId || this.ids;
      this.$modal.confirm('是否确认取消笔记ID为"' + contentIds + '"的笔记分享？').then(function () {
        return delShare(contentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("取消成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('notebook/share/export', {
        ...this.queryParams
      }, `share_${new Date().getTime()}.xlsx`)
    },
    /** 访问按钮操作 */
    handleLink(row) {
      window.open(this.getLink(row));
    },
    /** 时间增加指定天数 **/
    dateAddDays(date, days) {
      if (!days) {
        days = 1;
      }
      var date = new Date(date);
      date.setDate(date.getDate() + days);
      return date;
    },
    /** 获取访问链接 */
    getLink(row) {
      let url = "/share/" + row.contentId + ".html";
      if (row.shareSecret) {
        url = url + "?secret=" + row.shareSecret;
      }
      return window.location.href.replace(window.location.pathname, "") + url;
    },
    /** 复制成功 */
    copySuccess() {
      this.$modal.msgSuccess("复制成功");
    },
    /** 复制失败 */
    copyFailed() {
      this.$modal.msgError("复制失败");
    }
  }
};
</script>
