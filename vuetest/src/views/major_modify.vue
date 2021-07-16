<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="id" v-show="false">
      <el-input v-model="form.mid"></el-input>
    </el-form-item>
    <el-form-item label="专业名称">
      <el-input v-model="form.mname"></el-input>
    </el-form-item>
    <el-form-item label="学分">
      <el-input v-model="form.credit"></el-input>
    </el-form-item>
    <el-form-item label="学制">
      <el-input v-model="form.lifeyear"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">修改</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
  <script>
    export default {
      data() {
        return {
          form: {
            mid:'',
            mname:'',
            credit:'',
            lifeyear:''
          }

        }
      },
      methods: {
        onSubmit() {
          // console.log('submit!');
          var this_=this;
          axios.post('http://localhost:8081/major/update',this_.form).then(function (resp){
            // console.log(resp)
            if (resp.data.success){
              this_.$message('修改成功');
              this_.$router.push('/major_list')
            }else {
              this.$message('修改失败');
            }
          })
        }
      },
      created() {
        // alert(this.$route.query.id)
        var this_=this;
        var id = this.$route.query.id;
        axios.post('http://localhost:8081/major/getByid?id='+id).then(function (resp){
            // console.log(resp)
          this_.form=resp.data.data;
        })
      }
    }
  </script>