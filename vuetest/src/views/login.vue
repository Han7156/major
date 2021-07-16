<template>
<body>
<div id="d1">
 <h1>登录</h1>
  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" id="a">
    <el-form-item label="用户名" prop="pass">
      <i class="el-icon-user-solid"></i><el-input type="username" v-model="ruleForm.username" autocomplete="off" style="width: 300px"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="checkPass">
      <i class="el-icon-lock"></i> <el-input type="password" v-model="ruleForm.password" autocomplete="off" style="width: 300px"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>


</div>
</body>
</template>
  <script>
    export default {
      data() {

        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入用户名'));
          } else {
            if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            callback();
          }
        };
        return {
          ruleForm: {
            username: '',
            password: '',

          },
          rules: {
            username: [
              { validator: validatePass, trigger: 'blur' }
            ],
            password: [
              { validator: validatePass2, trigger: 'blur' }
            ]
          }
        };
      },
      methods: {
        submitForm(formName) {
          // alert("ok")
          var this_=this;
          var username=this_.ruleForm.username;
          var password=this_.ruleForm.password;
          axios.get('http://localhost:8081/login?username='+username+'&password='+password).then(function (resp){
              // console.log(resp.data.success)
            if (resp.data.success){
              this_.$alert('欢迎你'+username+'', '登陆成功', {
                confirmButtonText: '确定',
                callback: action => {
                  this_.$router.push('/shouye');
                }
              })
            }else {
              this_.$message('添加失败');
            }
          })
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
  </script>
<style scoped>
#d1 {
  margin: 200px 0 0 600px;
}
h1{
  margin-left: 225px;
}

</style>