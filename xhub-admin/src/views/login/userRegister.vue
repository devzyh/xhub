<template>
  <div>
    <p class="login-title">
      注册账号
    </p>
    <el-form class="login-form"
             status-icon
             :rules="registerRules"
             ref="registerRef"
             :model="registerForm"
             label-width="0">
      <el-form-item prop="username">
        <el-input @keyup.enter.native="handleRegister"
                  v-model="registerForm.username"
                  auto-complete="off"
                  placeholder="请输入用户名">
          <template #prefix>
            <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon"/>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input @keyup.enter.native="handleRegister"
                  :type="passwordType"
                  v-model="registerForm.password"
                  auto-complete="off"
                  placeholder="请输入密码">
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
      <el-form-item prop="confirmPassword">
        <el-input @keyup.enter.native="handleRegister"
                  :type="passwordType"
                  v-model="registerForm.confirmPassword"
                  auto-complete="off"
                  placeholder="请再次输入密码">
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
        <el-input @keyup.enter.native="handleRegister"
                  v-model="registerForm.code"
                  auto-complete="off"
                  placeholder="请输入验证码">
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
      <el-form-item>
        <el-button
            type="primary"
            @click.native.prevent="handleRegister"
            class="login-submit">
          <span v-if="!loading">注 册</span>
          <span v-else>注 册 中...</span>
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup name="userRegister">
import {getCodeImg, register} from "@/api/login";
import {ElMessageBox} from "element-plus";

const router = useRouter();
const {proxy} = getCurrentInstance();

const loading = ref(false);
const codeUrl = ref("");
const checked = ref(false);
const passwordType = ref("password");
const registerForm = ref({
  username: "",
  password: "",
  confirmPassword: "",
  code: "",
  uuid: ""
});
const equalToPassword = (rule, value, callback) => {
  if (registerForm.value.password !== value) {
    callback(new Error("两次输入的密码不一致"));
  } else {
    callback();
  }
};
const registerRules = {
  username: [
    {required: true, trigger: "blur", message: "请输入您的账号"},
    {min: 2, max: 20, message: '用户账号长度必须介于 2 和 20 之间', trigger: 'blur'}
  ],
  password: [
    {required: true, trigger: "blur", message: "请输入您的密码"},
    {min: 5, max: 20, message: '用户密码长度必须介于 5 和 20 之间', trigger: 'blur'}
  ],
  confirmPassword: [
    {required: true, trigger: "blur", message: "请再次输入您的密码"},
    {required: true, validator: equalToPassword, trigger: "blur"}
  ],
  code: [{required: true, trigger: "change", message: "请输入验证码"}]
};


function showPassword() {
  return passwordType.value === "" ? (passwordType.value = "password") : (passwordType.value = "");
}

function getCode() {
  getCodeImg().then(res => {
    codeUrl.value = "data:image/gif;base64," + res.img;
    registerForm.value.uuid = res.uuid;
  });
}

function handleRegister() {
  proxy.$refs.registerRef.validate(valid => {
    if (valid) {
      loading.value = true;
      register(registerForm.value).then(res => {
        const username = registerForm.value.username;
        ElMessageBox.alert("<font color='red'>恭喜你，您的账号 " + username + " 注册成功！</font>", "系统提示", {
          dangerouslyUseHTMLString: true,
          type: "success",
        }).then(() => {
          loading.value = false;
          proxy.$emit("ok");
        }).catch(() => {
        });
      }).catch(() => {
        loading.value = false;
        getCode();
      })
    }
  });
}

getCode();
</script>

<style></style>
