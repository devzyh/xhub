<template>
  <div class="login-container">
    <div class="login-time">
      {{ time }}
    </div>
    <div class="login-weaper  animated bounceInDown">
      <div class="login-left animate__animated animate__fadeInLeft">
        <img class="img" src="@/assets/images/logo.png" alt=""/>
        <p class="title">软件工具箱</p>
        <p>{{ '©2022 V' + version }}</p>
      </div>
      <div class="login-border animate__animated animate__fadeInRight">
        <div class="login-main">
          <user-login v-if="activeName === 'userLogin'"></user-login>
          <user-register v-else-if="activeName==='userRegister'" @ok="activeName='userLogin'"></user-register>
          <div class="login-menu" v-if="enableRegister">
            <a href="#"
               @click.stop="activeName='userLogin'">已有账号登录</a>
            <a href="#"
               @click.stop="activeName='userRegister'">账号密码注册</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup name="login">
import "@/assets/styles/login.scss";
import UserLogin from "./userLogin";
import UserRegister from "./userRegister";
import config from '@/../package.json'

const time = ref("");
const version = config.version;
const enableRegister = ref(false);
const activeName = ref("userLogin");

function getTime() {
  const date = new Date();
  var Y = date.getFullYear() + '年';
  var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '月';
  var D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()) + '日';
  var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + '时';
  var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + '分';
  var s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() + '秒';
  time.value = Y + M + D + h + m + s;
}

getTime();
setInterval(() => {
  getTime();
}, 1000);
</script>
