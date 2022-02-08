<template>
  <div class="login-container">
    <div class="login-module">
      <el-row>
        <el-col :span="12">
          <img
            src="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/400/h/400"
            alt=""
            srcset=""
            width="400px"
            height="400px"
            style="border-top-left-radius: 8px; border-bottom-left-radius: 8px"
          />
        </el-col>
        <el-col :span="12">
          <el-form
            ref="loginForm"
            :model="loginForm"
            :rules="loginRules"
            class="login-form"
            auto-complete="on"
            label-position="left"
          >
            <div class="title-container">
              <div class="title">Welcome Back!</div>
            </div>
            <el-form-item prop="username">
              <span span class="svg-container">
                <svg-icon icon-class="user" />
              </span>
              <el-input
                ref="username"
                v-model="loginForm.username"
                placeholder="Username"
                name="username"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="password">
              <span class="svg-container">
                <svg-icon icon-class="password" />
              </span>
              <el-input
                :key="passwordType"
                ref="password"
                v-model="loginForm.password"
                :type="passwordType"
                placeholder="Password"
                name="password"
                tabindex="2"
                auto-complete="on"
                @keyup.enter.native="handleLogin"
              />
              <span class="show-pwd" @click="showPwd">
                <svg-icon
                  :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"
                />
              </span>
            </el-form-item>
            <el-button
              :loading="loading"
              type="primary"
              style="width: 100%; margin-bottom: 30px"
              @click.native.prevent="handleLogin"
              >Sign in</el-button
            >
            <div class="tips">
              <span style="margin-right: 20px">username: admin</span>
              <span> password: any</span>
            </div>
          </el-form>
        </el-col>
      </el-row>
    </div>
    <!-- 填写三个密保问题 -->
    <el-dialog
      title="Please fill in security questions"
      :visible.sync="centerDialogVisibleFill"
      width="30%"
    >
      <h4>The first security question</h4>
      <el-select
        @change="selectChange"
        class="securityQuestions"
        v-model="firstSecurityQuestionsSelect"
        filterable
        placeholder="Please select"
      >
        <el-option
          :disabled="item.disabled"
          v-for="item in allOptions"
          :key="item.question"
          :label="item.question"
          :value="item.question"
        >
        </el-option>
      </el-select>
      <el-input
        class="securityQuestions"
        v-model="firstSecurityQuestionsInput"
        placeholder="Please enter"
      ></el-input>
      <h4>The second security question</h4>
      <el-select
        @change="selectChange"
        class="securityQuestions"
        v-model="secondSecurityQuestionsSelect"
        filterable
        placeholder="Please select"
      >
        <el-option
          :disabled="item.disabled"
          v-for="item in allOptions"
          :key="item.question"
          :label="item.question"
          :value="item.question"
        >
        </el-option>
      </el-select>
      <el-input
        class="securityQuestions"
        v-model="secondSecurityQuestionsInput"
        placeholder="Please enter"
      ></el-input>
      <h4>The third security question</h4>
      <el-select
        @change="selectChange"
        class="securityQuestions"
        v-model="thirdSecurityQuestionsSelect"
        filterable
        placeholder="Please select"
      >
        <el-option
          :disabled="item.disabled"
          v-for="item in allOptions"
          :key="item.question"
          :label="item.question"
          :value="item.question"
        >
        </el-option>
      </el-select>
      <el-input
        class="securityQuestions"
        v-model="thirdSecurityQuestionsInput"
        placeholder="Please enter"
      ></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisibleFill = false">Cancel</el-button>
        <el-button type="primary" @click="centerDialogVisibleFillClick"
          >Submit</el-button
        >
      </span>
    </el-dialog>
    <!-- 填写一个密保问题 -->
    <el-dialog
      title="Please answer security questions"
      :visible.sync="centerDialogVisibleAnswer"
      width="30%"
    >
      <el-select
        class="securityQuestions"
        v-model="securityQuestionsAnswerSelect"
        filterable
        placeholder="Please select"
      >
        <el-option
          v-for="item in answerOptions"
          :key="item.questionAnswer"
          :label="item.question"
          :value="item.questionAnswer"
        >
        </el-option>
      </el-select>
      <el-input
        class="securityQuestions"
        v-model="securityQuestionsAnswerInput"
        placeholder="Please enter"
      ></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisibleAnswer = false">Cancel</el-button>
        <el-button type="primary" @click="centerDialogVisibleAnswerClick"
          >Submit</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  allQuestions,
  submitQuestions,
  answerQuestions,
  addStaff,
} from "@/api/user";
import Qs from 'qs';
export default {
  name: "Login",
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error("The password can not be less than 6 digits"));
      } else {
        callback();
      }
    };
    return {
      userId: "",
      answerIndex:0,
      centerDialogVisibleFill: false,
      centerDialogVisibleAnswer: false,
      // 填写密保问题
      firstSecurityQuestionsSelect: "",
      firstSecurityQuestionsInput: "",
      secondSecurityQuestionsSelect: "",
      secondSecurityQuestionsInput: "",
      thirdSecurityQuestionsSelect: "",
      thirdSecurityQuestionsInput: "",
      // 回答密保问题
      securityQuestionsAnswerSelect: "",
      securityQuestionsAnswerInput: "",
      loginForm: {
        username: "",
        password: "",
      },
      loginRules: {
        username: [{ required: true, trigger: "blur" }],
        password: [
          { required: true, trigger: "blur", validator: validatePassword },
        ],
      },
      loading: false,
      passwordType: "password",
      redirect: undefined,
      allOptions: [],
      answerOptions: [],
    };
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true,
    },
  },
  created() {},
  methods: {
    selectChange(value){
      this.allOptions.forEach((element)=>{
        element.disabled = false
        if(this.firstSecurityQuestionsSelect==element.question){
          element.disabled = true
        }
        if(this.secondSecurityQuestionsSelect==element.question){
          element.disabled = true
        }
        if(this.thirdSecurityQuestionsSelect==element.question){
          element.disabled = true
        }
      })
    },
    // 列出所有问题 p
    allQuestions() {
      let data = {};
      allQuestions(data)
        .then((response) => {
          this.allOptions = response;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // 第一次登录提交问题 g
    submitQuestions() {
      let UserID = this.$store.state.user.userId;
      let arrayList = [
        {Question:this.firstSecurityQuestionsSelect,Answer:this.firstSecurityQuestionsInput,UserID},
        {Question:this.secondSecurityQuestionsSelect,Answer:this.secondSecurityQuestionsInput,UserID},
        {Question:this.thirdSecurityQuestionsSelect,Answer:this.thirdSecurityQuestionsInput,UserID},
      ]
      arrayList.forEach((element,index)=>{
        submitQuestions(element)
        .then((response) => {
          if(index==2){
            this.centerDialogVisibleFill = false;
            this.$router.push({ path: this.redirect || "/" });
             this.$message({
            message: response.msg,
            type: "success",
          });
          }
        })
        .catch((error) => {
          console.log(error);
        });
      })
      
    },
    // 登录之后回答问题 p
    answerQuestions() {
      let data = {
        UserID: this.$store.state.user.userId,
      };
      answerQuestions(data)
        .then((response) => {
          response.forEach((element, index) => {
            element.questionAnswer = element.questionId + "|" + element.answer;
          });
          this.answerOptions = response;
          // this.securityQuestionsAnswerSelect =
          //   response[
          //     Math.floor(Math.random() * response.length)
          //   ].questionAnswer;
          this.securityQuestionsAnswerSelect = response[this.answerIndex].questionAnswer
        })
        .catch((error) => {
         
        })
    },
    // 添加staff g
    addStaff() {
      let params = {};
      addStaff({ params })
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
        });
    },
    // 填写三个问题
    centerDialogVisibleFillClick() {
      this.submitQuestions();
    },
    // 回答问题
    centerDialogVisibleAnswerClick() {
      let answer = this.securityQuestionsAnswerSelect.split("|");
      if (answer[1] == this.securityQuestionsAnswerInput) {
        this.answerIndex = 0
        this.$router.push("/");
      } else {
        this.securityQuestionsAnswerInput = ""
          this.answerIndex++
        if(this.answerIndex<this.answerOptions.length){
          this.securityQuestionsAnswerSelect = this.answerOptions[this.answerIndex].questionAnswer
          this.$message({
            message: "login error",
            type: "warning",
          });
        }else{
          this.$message({
            message: "All security questions answered incorrectly, your account has been locked",
            type: "warning",
          });
        }
      }
    },
    showPwd() {
      if (this.passwordType === "password") {
        this.passwordType = "";
      } else {
        this.passwordType = "password";
      }
      this.$nextTick(() => {
        this.$refs.password.focus();
      });
    },
    handleLogin() {
      let that = this;
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          this.$store
            .dispatch("user/login", this.loginForm)
            .then((result) => {
              that.$store
                .dispatch("user/getInfo", {
                  userName: that.loginForm.username,
                })
                .then((res) => {
                  that.$nextTick(() => {
                    that.userId = that.$store.state.user.userId;
                  });
                  let { isFirst } = result;
                  if (isFirst == "false") {
                    this.answerQuestions();
                    this.centerDialogVisibleAnswer = true;
                  } else if (isFirst == "true") {
                    this.allQuestions();
                    this.centerDialogVisibleFill = true;
                  }
                  this.loading = false;
                });
            })
            .catch(() => {
              this.loading = false;
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #fff;
$light_gray: #000;
$cursor: #000;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid #dddddd;
    background: #fff;
    border-radius: 50px;
    color: #000;
  }

  .securityQuestions {
    width: 100%;
    .el-input {
      width: 100%;
    }
    .el-input__inner {
      -webkit-appearance: none;
      background-color: #fff;
      background-image: none;
      border-radius: 4px;
      border: 1px solid #dcdfe6;
      box-sizing: border-box;
      color: #606266;
      display: inline-block;
      font-size: inherit;
      height: 40px;
      line-height: 40px;
      outline: none;
      padding: 0 15px;
      transition: border-color 0.2s cubic-bezier(0.645, 0.045, 0.355, 1);
      width: 100%;
    }
  }
}
</style>

<style lang="scss" scoped>
$bg: #ffffff;
$dark_gray: #889aa4;
$light_gray: #000;

.login-container {
  position: relative;
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-module {
    position: absolute;
    top: 50%;
    left: 50%;
    height: 400px;
    width: 800px;
    margin-top: -200px;
    border-radius: 10px;
    margin-left: -400px;
    border: 1px solid #ebeef5;
    background: #ffffff;
    box-shadow: 15px 15px 12px 2px rgba(0, 0, 0, 0.1);
  }

  .login-form {
    position: relative;
    width: 800px;
    max-width: 100%;
    padding: 60px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }

  .securityQuestions {
    width: 100%;
    .el-input {
      width: 100%;
    }
    .el-input__inner {
      -webkit-appearance: none;
      background-color: #fff;
      background-image: none;
      border-radius: 4px;
      border: 1px solid #dcdfe6;
      box-sizing: border-box;
      color: #606266;
      display: inline-block;
      font-size: inherit;
      height: 40px;
      line-height: 40px;
      outline: none;
      padding: 0 15px;
      transition: border-color 0.2s cubic-bezier(0.645, 0.045, 0.355, 1);
      width: 100%;
    }
  }
}
</style>
