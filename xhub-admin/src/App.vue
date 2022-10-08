<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  metaInfo() {
    return {
      title: this.$store.state.settings.dynamicTitle && this.$store.state.settings.title,
      titleTemplate: title => {
        return title ? `${title} - ${process.env.VUE_APP_TITLE}` : process.env.VUE_APP_TITLE
      }
    }
  },
  mounted() {
    // 全局按键监听
    document.onkeydown = (e) => {
      const path = this.$route.path;

      // Ctrl+S 组合按键
      if ((e.ctrlKey || e.metaKey) && e.key === 's') {
        // 编辑器界面
        if (path.indexOf('/notebook/editor') >= 0) {
          document.getElementById("saveMarkdown").click();
          e.preventDefault();
        }

      }
    }
  }
}
</script>
