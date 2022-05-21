<template>
  <div class="app-container">
    <el-form :model="form" ref="queryForm" size="small">
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

export default {
  name: "Editor",
  data() {
    return {
      vditor: "",
      form: {
        id: 1,//undefined,
        title: undefined,
        content: undefined
      }
    }
  },
  mounted() {
    // 参考：https://ld246.com/article/1549638745630
    this.vditor = new Vditor("vditor", {
      cdn: 'https://unpkg.com/vditor@3.8.14/',
      height: "81vh",
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
        // "fullscreen",
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
        enable: false
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
      after: () => {
        getContent(this.form.id).then(response => {
          this.form = response.data;
          this.vditor.setValue(this.form.content, true)
        });
      }
    })
  },
  methods: {
    handleSave() {
    }
  }
}
</script>

<style>
</style>
