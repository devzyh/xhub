<template>
  <router-view/>
</template>

<script setup>
import useSettingsStore from '@/store/modules/settings'
import {handleThemeStyle} from '@/utils/theme'


const route = useRoute();


/** 全局按键监听 */
function keyDown() {
  document.onkeydown = (e) => {
    const path = route.path;

    // Ctrl+S 组合按键
    if ((e.ctrlKey || e.metaKey) && (e.key === 's' || e.key === 'S')) {
      // 编辑器界面
      if (path.indexOf('/notebook/editor') >= 0) {
        document.getElementById("saveMarkdown").click();
        e.preventDefault();
      }

    }
  }
}

onMounted(() => {
  nextTick(() => {
    // 初始化主题样式
    handleThemeStyle(useSettingsStore().theme);
    // 全局按键监听
    keyDown();
  })
})
</script>
