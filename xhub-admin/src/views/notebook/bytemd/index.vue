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
import 'juejin-markdown-themes/dist/vuepress.min.css'
import zhHans from 'bytemd/locales/zh_Hans.json'
import breaks from '@bytemd/plugin-breaks'
import frontmatter from '@bytemd/plugin-frontmatter'
import gemoji from '@bytemd/plugin-gemoji'
import gfm from '@bytemd/plugin-gfm'
import zhHansGfm from '@bytemd/plugin-gfm/locales/zh_Hans.json'
import mediumZoom from '@bytemd/plugin-medium-zoom'
import mermaid from '@bytemd/plugin-mermaid'
import zhHansMermaid from '@bytemd/plugin-mermaid/locales/zh_Hans.json'
import useTagsViewStore from '@/store/modules/tagsView'
import {uploads} from '@/api/common/upload'
import {getContent, updateContent} from "@/api/notebook/content";


const route = useRoute();
const {proxy} = getCurrentInstance();
const tagsViewStore = useTagsViewStore();

// 编辑器插件
const plugins = [
  breaks(),
  frontmatter(),
  gemoji(),
  gfm({locale: zhHansGfm}),
  mediumZoom(),
  mermaid({locale: zhHansMermaid})
]
// 笔记内容
const form = ref({
  id: 0,
  content: ""
});
// 笔记缓存前缀
const cachePrefix = ref("mdcache:");


/** 页面初始化 */
onMounted(() => {
  const id = route.params.id;
  const title = route.params.title;
  const contentKey = cachePrefix.value + id;
  if (id && !isNaN(id)) {
    // 优先取本地缓存
    let localContent = proxy.$cache.local.get(contentKey);
    if (localContent) {
      form.value.id = id;
      form.value.content = localContent;
    }

    // 本地不存在从远程获取
    if (!localContent) {
      getContent(id).then(response => {
        const data = response.data;
        form.value.id = data.id;
        form.value.content = data.content;
        if (form.value.content) {
          proxy.$cache.local.set(contentKey, form.value.content);
        } else {
          form.value.content = "";
        }
      });
    }

    // 页面标题重写
    if (title) {
      const obj = Object.assign({}, route, {title: title})
      proxy.$tab.updatePage(obj);
    }
  }
});

/** 内容更新事件 */
function handleChange(v) {
  form.value.content = v
  proxy.$cache.local.set(cachePrefix.value + form.value.id, v);
}

/** 批量上传图片 */
async function uploadImage(files) {
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
}

/** 保存笔记内容 */
function save() {
  updateContent(form.value).then(response => {
    proxy.$modal.msgSuccess("保存成功");
  });
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
