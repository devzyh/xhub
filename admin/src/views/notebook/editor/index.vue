<template>
  <div class="app-container">
    <el-form :model="form" :rules="rules" size="small">
      <el-form-item prop="title">
        <el-input v-model="form.title"
                  style="width: calc(100% - 100px)"
                  placeholder="请输入笔记标题">
        </el-input>
        <el-button
          style="margin-left: 10px;width: 90px"
          type="primary"
          @click="handleSave">保存
        </el-button>
      </el-form-item>
    </el-form>
    <div id="vditor" name="vditor"></div>
  </div>
</template>

<script>
import Vditor from "vditor"
import "vditor/dist/index.css"
import {getContent, updateContent} from "@/api/notebook/content";
import {getToken} from "@/utils/auth";

export default {
  name: "Editor",
  data() {
    return {
      vditor: undefined,
      cachePrefix: "mdcache:",
      form: {
        id: 0,
        title: "",
        content: ""
      },
      // 表单校验
      rules: {
        title: [
          {required: true, message: "笔记标题不能为空", trigger: "blur"}
        ]
      }
    }
  },
  mounted() {
    // 参考：https://ld246.com/article/1549638745630
    this.vditor = new Vditor("vditor", {
      cdn: 'https://unpkg.com/vditor@3.8.14/',
      height: "75vh",
      lang: "zh_CN",
      mode: "ir",
      theme: "classic",
      icon: "ant",
      toolbar: [
        // "emoji",
        "headings",
        "bold",
        "italic",
        "strike",
        "link",
        "|",
        "list",
        "ordered-list",
        "check",
        "outdent",
        "indent",
        "|",
        "quote",
        "line",
        "code",
        "inline-code",
        "insert-before",
        "insert-after",
        "|",
        "upload",
        // "record",
        "table",
        "|",
        "undo",
        "redo",
        "|",
        "fullscreen",
        // "edit-mode",
        {
          name: "more",
          toolbar: [
            "both",
            "code-theme",
            "content-theme",
            "export",
            "outline",
            "preview",
            // "devtools",
            // "info",
            // "help",
          ],
        },
      ],
      fullscreen: {
        "index": 1080
      },
      tab: "    ",
      toolbarConfig: {
        hide: false,
        pin: false
      },
      outline: {
        enable: true
      },
      counter: {
        enable: true
      },
      cache: {
        enable: true,
        id: this.cachePrefix + this.$route.params.id
      },
      preview: {
        hljs: {
          enable: true,
          style: "monokailight",
          lineNumber: true
        },
        markdown: {
          codeBlockPreview: false,
        }
      },
      upload: {
        fieldName: "files",
        accept: "image/*",
        max: 10 * 1024 * 1024,
        multiple: true,
        url: process.env.VUE_APP_BASE_API + "/common/uploads",
        headers: {
          Authorization: "Bearer " + getToken(),
        },
        withCredentials: false,
        format(files, responseText) {
          let resp = JSON.parse(responseText)
          let fileMap = {}
          let fileNames = resp.originalFilenames.split(",");
          let urls = resp.urls.split(",");
          for (let i = 0; i < fileNames.length; i++) {
            fileMap[fileNames[i]] = urls[i];
          }
          return JSON.stringify({
            code: resp.code,
            msg: resp.msg,
            data: {
              errFiles: [],
              succMap: fileMap
            }
          })
        },
        error(msg) {
          this.$modal.msgSuccess("图片上传失败：" + msg);
        }
      },
      after: () => {
        const id = this.$route.params.id
        if (id) {
          getContent(id).then(response => {
            this.form = response.data;
            if (!this.form.content) {
              this.form.content = "";
            }
            // 优先取本地缓存
            if (window.localStorage) {
              let localContent = window.localStorage.getItem(this.cachePrefix + id);
              if (localContent) {
                this.form.content = localContent;
              }
            }
            this.vditor.setValue(this.form.content, true);
            this.visitedViews[this.visitedViews.length - 1].title = "编辑【" + this.form.id + "】";
          });
        }
      }
    })
  },
  methods: {
    handleSave() {
      if (!this.form.title) {
        return this.$modal.msgError("请输入笔记标题");
      }
      this.form.content = this.vditor.getValue();
      updateContent(this.form).then(response => {
        this.$modal.msgSuccess("保存成功");
      });
    }
  },
  computed: {
    visitedViews() {
      return this.$store.state.tagsView.visitedViews
    }
  }
}
</script>

<style scoped>
</style>
