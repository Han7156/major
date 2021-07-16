<template>
  <div>

  <el-breadcrumb separator-class="el-icon-arrow-right" id="a">
    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>学院列表</el-breadcrumb-item>
  </el-breadcrumb>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" id="b">
    <el-form-item label="专业名" prop="mname">
      <el-input v-model="ruleForm.mname"></el-input>
    </el-form-item>
    <el-form-item label="学分" prop="credit">
    <el-input v-model="ruleForm.credit"></el-input>
    </el-form-item>
    <el-form-item label="学制" prop="lifeyear">
    <el-input v-model="ruleForm.lifeyear"></el-input>
    </el-form-item>
    <el-form-item label="学院名" prop="cid">
      <el-input v-model="ruleForm.cid"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>
  <script>
    export default {
      data() {
        return {
          ruleForm: {
            mname: '',
            credit:'',
            lifeyear:'',
            cid:''
          },
          rules: {
            mname: [
              { required: true, message: '请输入专业名', trigger: 'blur' },
            ],
            credit: [
              { required: true, message: '请输入专业名', trigger: 'blur' },
            ],
            lifeyear: [
              { required: true, message: '请输入专业名', trigger: 'blur' },
            ],
            cid: [
              { required: true, message: '请输入专业名', trigger: 'blur' },
            ]
          }
        };
      },
      methods: {
        submitForm(formName) {
          var this_ = this;
          this.$refs[formName].validate((valid) => {
            if (valid) {
             axios.post('http://localhost:8081/major/add',this.ruleForm).then(function (resp){
               // console.log(resp)
                 if (resp.data.success){
                   this_.$alert('该专业添加成功！', '添加成功', {
                     confirmButtonText: '确定',
                     callback: action => {
                       this_.$router.push('/major_list');
                     }
                   })
               }else {
                 this_.$message('添加失败');
               }
             })
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
  </script>
<style scoped>
#a{
  margin-top: 10px;
}
#b{
  margin-top: 50px;
  margin-left: 450px;

}
</style>