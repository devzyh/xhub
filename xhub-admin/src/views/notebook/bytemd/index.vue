<template>
  <div class="app-container">
    <input type="hidden" id="saveMarkdown" @click="save"/>
    <div class="mde">
      <Editor :value="form.content"
              :plugins="plugins"
              :locale="zhHans"
              :uploadImages="uploadImage"
              @change="handleChange"/>
    </div>
  </div>
</template>

<script setup name="ByteMD">
import {Editor} from '@bytemd/vue-next'
import 'bytemd/dist/index.min.css'
import 'juejin-markdown-themes/dist/juejin.min.css'
import 'highlight.js/styles/vs.css'
import zhHans from 'bytemd/locales/zh_Hans.json'
import breaks from '@bytemd/plugin-breaks'
import frontmatter from '@bytemd/plugin-frontmatter'
import gemoji from '@bytemd/plugin-gemoji'
import gfm from '@bytemd/plugin-gfm'
import zhHansGfm from '@bytemd/plugin-gfm/locales/zh_Hans.json'
import highlight from '@bytemd/plugin-highlight'
import mediumZoom from '@bytemd/plugin-medium-zoom'
import mermaid from '@bytemd/plugin-mermaid'
import zhHansMermaid from '@bytemd/plugin-mermaid/locales/zh_Hans.json'
import {uploads} from '@/api/common/upload'
import {getContent, updateEditor} from "@/api/notebook/content";

const route = useRoute();
const {proxy} = getCurrentInstance();

// 编辑器插件
const plugins = [
  breaks(),
  frontmatter(),
  gemoji(),
  gfm({locale: zhHansGfm}),
  highlight(),
  mediumZoom(),
  mermaid({locale: zhHansMermaid})
]
// 笔记内容
const form = ref({
  id: 0,
  content: ""
});
// 编辑控制
const ctrl = ref({
  changed: false,
  inited: false
});

/** 页面初始化 */
onMounted(() => {
  // 获取笔记内容
  const id = route.params.id;
  if (id && !isNaN(id)) {
    getContent(id).then(response => {
      // 权限错误

      // 编辑数据
      const data = response.data;
      form.value.id = data.id;
      form.value.content = data.content;

      // 页面标题
      const obj = Object.assign({}, route, {title: data.title})
      proxy.$tab.updatePage(obj);
    });
  }

  // 控制预览
  if (route.params.view === "read") {
    clickRight();
    clickRight(3);
  }
});

/** 内容更新事件 */
function handleChange(v) {
  form.value.content = v
  if (ctrl.value.inited) {
    ctrl.value.changed = true
  } else {
    ctrl.value.inited = true
  }
}

/** 批量上传图片 */
async function uploadImage(files) {
  console.log('files', files)
  let fileList = []
  await uploads(files).then(({data}) => {
    let fileNames = data.originalFilenames.split(",");
    let urls = data.urls.split(",");
    for (let i = 0; i < fileNames.length; i++) {
      fileList.push({
        title: fileNames[i],
        url: urls[i]
      })
    }
  });
  return fileList;
}

/** 保存笔记内容 */
function save() {
  updateEditor(form.value).then(response => {
    proxy.$modal.msgSuccess("保存成功");
  });
}

/** 点击右侧工具栏按钮 */
function clickRight(index = 0) {
  document.getElementsByClassName('bytemd-toolbar-right')[0].children[index].click();
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

    .bytemd-preview pre code::-webkit-scrollbar {
      width: 4px;
      height: 4px
    }

    .bytemd-preview pre code::-webkit-scrollbar-thumb {
      background-color: #c9cdd4;
      outline: none;
      border-radius: 2px;
    }

    .bytemd-preview pre code::-webkit-scrollbar-track {
      -webkit-box-shadow: none;
      box-shadow: none;
      border-radius: 2px;
    }

  }
}

.el-notification {
  z-index: 99999 !important;
}
</style>
