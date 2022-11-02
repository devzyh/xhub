<template>
  <div>
    <i-frame v-model:src="url"></i-frame>
  </div>
</template>

<script setup>
import iFrame from '@/components/iframe'

import {ref} from 'vue';

const url = ref('/druid/login.html');
</script>
