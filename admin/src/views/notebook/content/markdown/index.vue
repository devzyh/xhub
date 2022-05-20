<template>
  <div ref="editor"></div>
</template>

<script>
import { defaultValueCtx, Editor, rootCtx } from '@milkdown/core';
import { nord } from '@milkdown/theme-nord';
import { commonmark } from '@milkdown/preset-commonmark';
export default {
  name: 'Editor',
  props: {
    msg: String,
  },
  mounted() {
    Editor.make()
      .config((ctx) => {
        ctx.set(rootCtx, this.$refs.editor);
        ctx.set(defaultValueCtx, this.$props.msg);
      })
      .use(nord)
      .use(commonmark)
      .create();
  },
};
</script>

<style></style>
