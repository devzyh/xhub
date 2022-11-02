<template>
  <div>
    <p class="login-title">
      登录系统
    </p>
    <el-form
        class="login-form"
        status-icon
        :rules="loginRules"
        ref="loginRef"
        :model="loginForm"
        label-width="0">
      <el-form-item prop="username">
        <el-input
            @keyup.enter.native="handleLogin"
            v-model="loginForm.username"
            auto-complete="off"
            placeholder="请输入用户名"
        >
          <template #prefix>
            <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon"/>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
            @keyup.enter.native="handleLogin"
            :type="passwordType"
            v-model="loginForm.password"
            auto-complete="off"
            placeholder="请输入密码"
        >
          <template #prefix>
            <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon"/>
          </template>
          <template #suffix>
            <el-icon slot="suffix" class="login-password-show">
              <View v-if="passwordType === 'password'" @click="showPassword"/>
              <Hide v-if="passwordType === ''" @click="showPassword"/>
            </el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input
            @keyup.enter.native="handleLogin"
            v-model="loginForm.code"
            auto-complete="off"
            placeholder="请输入验证码"
        >
          <template #prefix>
            <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon"/>
          </template>
          <template #append>
            <div class="login-code">
              <img :src="codeUrl" class="login-code-img" @click="getCode"/>
            </div>
          </template>
        </el-input>
      </el-form-item>
      <el-checkbox v-model="loginForm.rememberMe">记住密码</el-checkbox>
      <el-form-item>
        <el-button
            type="primary"
            @click.native.prevent="handleLogin"
            class="login-submit"
            :loading="loading"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script setup name="userLogin">
import {getCodeImg} from "@/api/login";
import Cookies from "js-cookie";
import {decrypt, encrypt} from '@/utils/jsencrypt';
import useUserStore from '@/store/modules/user';

const userStore = useUserStore();
const router = useRouter();
const {proxy} = getCurrentInstance();

const loading = ref(false);
const redirect = ref(undefined);
const passwordType = ref("password");
const codeUrl = ref("");
const loginForm = ref({
  username: "",
  password: "",
  rememberMe: false,
  code: "",
  uuid: ""
});
const loginRules = {
  username: [
    {required: true, trigger: "change", message: "请输入您的账号"}
  ],
  password: [
    {required: true, trigger: "change", message: "请输入您的密码"}
  ],
  code: [{required: true, trigger: "change", message: "请输入验证码"}]
};

function getCode() {
  getCodeImg().then(res => {
    codeUrl.value = "data:image/gif;base64," + res.img;
    loginForm.value.uuid = res.uuid;
  });
}

function getCookie() {
  const username = Cookies.get("username");
  const password = Cookies.get("password");
  const rememberMe = Cookies.get('rememberMe')
  loginForm.value = {
    username: username === undefined ? loginForm.username : username,
    password: password === undefined ? loginForm.password : decrypt(password),
    rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
  };
}

function showPassword() {
  return passwordType.value === "" ? (passwordType.value = "password") : (passwordType.value = "");
}

function handleLogin() {
  proxy.$refs.loginRef.validate(valid => {
    if (valid) {
      loading.value = true;
      if (loginForm.value.rememberMe) {
        Cookies.set("username", loginForm.value.username, {expires: 30});
        Cookies.set("password", encrypt(loginForm.value.password), {expires: 30});
        Cookies.set('rememberMe', loginForm.value.rememberMe, {expires: 30});
      } else {
        Cookies.remove("username");
        Cookies.remove("password");
        Cookies.remove('rememberMe');
      }
      userStore.login(loginForm.value).then(() => {
        router.push({path: redirect.value || "/"}).catch(() => {
        });
      }).catch(() => {
        loading.value = false;
        getCode();
      });
    }
  });
}

getCode();
getCookie();
</script>

<style></style>
