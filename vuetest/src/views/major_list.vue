<template>
  <div id="d1">
    <el-breadcrumb separator-class="el-icon-arrow-right" id="a">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>专业列表</el-breadcrumb-item>
    </el-breadcrumb>
        <el-table

          :data="arr"
          style="width: 100%"
          :row-style="{
            height: '90px'}"
          >
        <el-table-column
            prop="mid"
            label="专业编号"
            width="200"
        >
        </el-table-column>
        <el-table-column
            prop="mname"
            label="专业名称"
            width="200">
        </el-table-column>
        <el-table-column
            prop="LifeYear"
            label="学制"
            width="200">
        </el-table-column>
        <el-table-column
            prop="credit"
            label="学分"
            width="200">
        </el-table-column>
        <el-table-column  label="操作" width="300">
          <template slot-scope="scope">
            <el-button
                size="mini"  @click="cha(scope.row.mid)" >查看</el-button>
            <el-button
                size="mini"
                @click="shan(scope.row.mid)"
                >删除<i class="el-icon-delete"></i></el-button>
            <el-button
                size="mini"
                @click="gai(scope.row.mid)"
                >修改<i class="el-icon-setting"></i></el-button>
          </template>
        </el-table-column>
      </el-table>
        <el-pagination
            background
            layout="prev, pager, next"
            page-size="5"
            @current-change="page"
            :total="total">
        </el-pagination>

</div>
<!--  <div id="box" style="width:800px; margin:0px auto" >-->
<!--    <h3 style="text-align:center">专业信息列表</h3>-->
<!--    <div style="width:780px; margin:0px auto; padding-right:20px; text-align:right; height:30px; line-height:30px">-->
<!--      <a href="major_add.html">添加专业</a>-->
<!--      <a href="college_list.html">查看学院列表</a>-->
<!--    </div>-->
<!--    <div style="width:800px; margin:0px auto; text-align:center; line-height:40px; height:40px;">-->
<!--      <label>学院名称-->
<!--        <select name="cname2" id="cname2">-->
<!--          <option value="0" selected="selected">全部</option>-->
<!--          <option value="1">计算机学院</option>-->
<!--          <option value="2">商学院</option>-->
<!--        </select>-->
<!--      </label>-->
<!--      <label style="display: inline-block; width: 200px"></label>-->
<!--      <label>-->
<!--        &nbsp;<input type="submit" name="btnSearch" id="btnSearch" value="查  询"/>-->
<!--      </label>-->
<!--    </div>-->
<!--    <table width="800" border="1" >-->
<!--      <tr>-->
<!--        <td>专业编号</td>-->
<!--        <td>专业名称</td>-->
<!--        <td>学制</td>-->
<!--        <td>学分</td>-->
<!--        <td>删除</td>-->
<!--        <td>修改</td>-->
<!--      </tr>-->
<!--      <tr v-for="(item,index) in arr">-->
<!--        <td>{{item.mid}}</td>-->
<!--        <td>{{item.mname}}</td>-->
<!--        <td>{{item.LifeYear}}</td>-->
<!--        <td>{{item.credit}}</td>-->
<!--        <td><a href="" @click="del(index)">删除</a></td>-->
<!--        <td><a href="major_modify.html">修改</a></td>-->
<!--      </tr>-->

<!--    </table>-->

<!--  </div>-->

</template>

<script>
export default {
  inject:['reload'],
  data() {
    return {
      baseUrl : "http://localhost:8081/",
      arr:{},
      total:null
    }
  },

    methods:{//方法
      gai:function (mid){
        // console.log(mid)
        this.$router.push({
          path:'/major_modify',
          query:{
            id:mid
          }
        })
      },
      shan:function (mid){
        var this_ = this;
        // console.log(mid)
        axios.get(this_.baseUrl+"major/delete?id="+mid).then(function (response) {
          // console.log(response)
          if (response.data.success){
            this_.$message('删除成功');
            // this_.$router.push('redirect:/major_list')
            location.reload()
            // this_.reload()
          }else {
            this_.$message('删除失败');
          }
        })
      },
      cha:function (mid){
        // console.log(mid)
        this.$router.push({
          path:'/major_view',
          query:{
            id:mid
          }
        })
      },
      page(pageNo){
        var this_ = this;
        axios.get(this_.baseUrl+"major/page?pageNo="+pageNo).then(function (response) {
          // console.log(response.data.data)
          this_.arr=response.data.data.list;
          // this_.total=response.data.data.total;
          // console.log(this_.arr)
        })
      }
    },
    mounted: function () {//钩子函数
      var this_ = this;
      // 挂载元素之后，通过ajax获取数据
      axios.get(this.baseUrl+"major/page").then(function (response) {
        // console.log(response.data.data)
        this_.arr=response.data.data.list;
        this_.total=response.data.data.total;
        // console.log(this_.arr)
      })

    }

}
</script>

<style scoped>
 #d1{
   margin-top: 30px;
 }
 #a{
   margin-bottom: 20px;
 }
</style>