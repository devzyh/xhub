<template>
  <div>
    <p class="login-title">
      注册账号
    </p>
    <el-form class="login-form"
             status-icon
             :rules="registerRules"
             ref="registerForm"
             :model="registerForm"
             label-width="0">
      <el-form-item prop="username">
        <el-input size="small"
                  @keyup.enter.native="handleRegister"
                  v-model="registerForm.username"
                  auto-complete="off"
                  placeholder="请输入用户名">
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon"/>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          size="small"
          @keyup.enter.native="handleRegister"
          :type="passwordType"
          v-model="registerForm.password"
          auto-complete="off"
          placeholder="请输入密码"
        >
          <i class="el-icon-view el-input__icon"
             slot="suffix"
             @click="showPassword"></i>
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon"/>
        </el-input>
      </el-form-item>
      <el-form-item prop="confirmPassword">
        <el-input
          size="small"
          @keyup.enter.native="handleRegister"
          :type="passwordType"
          v-model="registerForm.confirmPassword"
          auto-complete="off"
          placeholder="请再次输入密码"
        >
          <i class="el-icon-view el-input__icon"
             slot="suffix"
             @click="showPassword"></i>
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon"/>
        </el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-row :span="24">
          <el-col :span="16">
            <el-input
              size="small"
              @keyup.enter.native="handleRegister"
              v-model="registerForm.code"
              auto-complete="off"
              placeholder="请输入验证码">
              <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon"/>
            </el-input>
          </el-col>
          <el-col :span="8">
            <div class="login-code">
              <img :src="codeUrl"
                   class="login-code-img"
                   @click="getCode"/>
            </div>
          </el-col>
        </el-row>
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

<script>
import {getCodeImg, register} from "@/api/login";

export default {
  name: "userRegister",
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.registerForm.password !== value) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };
    return {
      loading: false,
      codeUrl: "",
      registerForm: {
        username: "",
        password: "",
        confirmPassword: "",
        code: "",
        uuid: ""
      },
      checked: false,
      registerRules: {
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
      },
      passwordType: "password"
    };
  },
  created() {
    this.getCode();
  },
  methods: {
    showPassword() {
      this.passwordType == ""
        ? (this.passwordType = "password")
        : (this.passwordType = "");
    },
    getCode() {
      getCodeImg().then(res => {
        this.codeUrl = "data:image/gif;base64," + res.img;
        this.registerForm.uuid = res.uuid;
      });
    },
    handleRegister() {
      this.$refs.registerForm.validate(valid => {
        if (valid) {
          this.loading = true;
          register(this.registerForm).then(res => {
            const username = this.registerForm.username;
            this.$alert("<font color='red'>恭喜你，您的账号 " + username + " 注册成功！</font>", '系统提示', {
              dangerouslyUseHTMLString: true,
              type: 'success'
            }).then(() => {
              this.$emit("ok");
            }).catch(() => {
            });
          }).catch(() => {
            this.loading = false;
            if (this.captchaOnOff) {
              this.getCode();
            }
          })
        }
      });
    }
  }
};
</script>

<style></style>
