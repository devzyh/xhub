<template>
  <div class="app-container">
    <input type="hidden" id="saveMarkdown" @click="save"/>
    <div class="mde">
      <Editor :value="this.form.content"
              :plugins="plugins"
              :locale="zhHans"
              :uploadImages="uploadImage"
              @change="handleChange"/>
    </div>
  </div>
</template>

<script>
import {Editor} from '@bytemd/vue'
import 'bytemd/dist/index.min.css'
import 'juejin-markdown-themes/dist/github.min.css'
import "highlight.js/styles/github.css";
import zhHans from 'bytemd/locales/zh_Hans.json'
import breaks from '@bytemd/plugin-breaks'
import frontmatter from '@bytemd/plugin-frontmatter'
import gemoji from '@bytemd/plugin-gemoji'
import gfm from '@bytemd/plugin-gfm'
import zhHansGfm from '@bytemd/plugin-gfm/locales/zh_Hans.json'
import highlight from '@bytemd/plugin-highlight'
import highlightSsr from '@bytemd/plugin-highlight-ssr'
import mediumZoom from '@bytemd/plugin-medium-zoom'
import mermaid from '@bytemd/plugin-mermaid'
import zhHansMermaid from '@bytemd/plugin-mermaid/locales/zh_Hans.json'
import {uploads} from '@/api/common/upload'
import {getContent, updateContent} from "@/api/notebook/content";

const plugins = [
  breaks(),
  frontmatter(),
  gemoji(),
  gfm({locale: zhHansGfm}),
  highlight(),
  highlightSsr(),
  mediumZoom(),
  mermaid({locale: zhHansMermaid})
]

export default {
  name: "ByteMD",
  components: {Editor},
  data() {
    return {
      plugins,
      zhHans,
      form: {
        id: 0,
        title: "",
        content: ""
      },
      cachePrefix: "mdcache:",
    }
  },
  mounted() {
    const id = this.$route.params.id;
    const title = this.$route.params.title;
    const contentKey = this.cachePrefix + id;
    if (id && !isNaN(id)) {
      // 优先取本地缓存
      let localContent;
      if (window.localStorage) {
        localContent = window.localStorage.getItem(contentKey);
        if (localContent) {
          this.form.id = id;
          this.form.content = localContent;
        }
      }

      // 本地不存在从远程获取
      if (!localContent) {
        getContent(id).then(response => {
          this.form = response.data;
          if (this.form.content) {
            window.localStorage.setItem(contentKey, this.form.content);
          } else {
            this.form.content = "";
          }
        });
      }

      // 页面标题重写
      if (title) {
        this.visitedViews[this.visitedViews.length - 1].title = title;
      }
    }
  },
  methods: {
    // 内容更新事件
    handleChange(v) {
      this.form.content = v
      window.localStorage.setItem(this.cachePrefix + this.form.id, v);
    },
    // 批量上传图片
    async uploadImage(files) {
      console.log('files', files)
      let fileList = []
      await uploads(files).then(resp => {
        let fileNames = resp.originalFilenames.split(",");
        let urls = resp.urls.split(",");
        for (let i = 0; i < fileNames.length; i++) {
          fileList.push({
            title: fileNames[i],
            url: urls[i]
          })
        }
      });
      return fileList;
    },
    // 保存笔记内容
    save() {
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

<style lang="scss">
.mde {
  .bytemd {
    height: calc(100vh - 125px);
    z-index: 9999;

    .bytemd-dropdown {
      overflow: hidden;
    }

    .markdown-body img {
      max-width: 100%;
    }

    .CodeMirror-vscrollbar::-webkit-scrollbar {
      width: 4px;
      height: 4px
    }

    .CodeMirror-vscrollbar::-webkit-scrollbar-thumb {
      background-color: #c9cdd4;
      outline: none;
      border-radius: 2px;
    }

    .CodeMirror-vscrollbar::-webkit-scrollbar-track {
      -webkit-box-shadow: none;
      box-shadow: none;
      border-radius: 2px;
    }

    .bytemd-preview::-webkit-scrollbar {
      width: 4px;
      height: 4px
    }

    .bytemd-preview::-webkit-scrollbar-thumb {
      background-color: #c9cdd4;
      outline: none;
      border-radius: 2px;
    }

    .bytemd-preview::-webkit-scrollbar-track {
      -webkit-box-shadow: none;
      box-shadow: none;
      border-radius: 2px;
    }
  }
}

.el-message {
  z-index: 99999 !important;
}
</style>
