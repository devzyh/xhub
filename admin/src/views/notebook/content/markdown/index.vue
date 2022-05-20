<template>
  <div class="app-container">
    <div id="vditor" name="markdown"></div>
  </div>
</template>
<script>
import Vditor from "vditor"
import "vditor/dist/index.css"

export default {
  data() {
    return {
      vditor: ""
    }
  },
  mounted() {
    // 参考：https://ld246.com/article/1549638745630
    this.vditor = new Vditor("vditor", {
      cdn: 'https://unpkg.com/vditor@3.8.14/',
      height: "83vh",
      lang: "zh_CN",
      mode: "ir",
      theme: "classic",
      icon: "ant",
      toolbar: [
        {
          hotkey: '⇧⌘S',
          name: 'sponsor',
          tipPosition: 's',
          tip: '成为赞助者',
          className: 'right',
          click() {
            alert('捐赠地址：https://ld246.com/sponsor')
          },
        },
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
        this.vditor.setValue("");
      }
    })
  },
  methods: {}
}
</script>

<style>
</style>
