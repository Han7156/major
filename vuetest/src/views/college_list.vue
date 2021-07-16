<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right" id="a">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>学院列表</el-breadcrumb-item>
    </el-breadcrumb>
      <el-table
          :data="arr"
          :row-style="{height:'100px'}"
          :cell-style="{padding:'2px'}"
          style="width: 1000px">
        <el-table-column
            label="id"
           >
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.cid }}</span>
          </template>
        </el-table-column>
        <el-table-column
            label="学院名"
            >
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>简介：拉给</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.cname }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
            label="日期"
           >
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.createtime }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                type="danger"
                size="mini"

            >查看</el-button>
            <el-button
                size="mini"
                type="danger">删除</el-button>
            <el-button
                size="mini"
                type="danger">修改</el-button>
          </template>
        </el-table-column>
      </el-table>


<!--                    <table width="800" border="1">-->
<!--                      <tr>-->
<!--                        <td>学院编号</td>-->
<!--                        <td>学院名称</td>-->
<!--                        <td>创办时间</td>-->
<!--                      </tr>-->
<!--                      <tr v-for="(item,index) in arr">-->
<!--                        <td>{{item.cid}}</td>-->
<!--                        <td>{{item.cname}}</td>-->
<!--                        <td>{{item.createtime|format}}</td>-->
<!--                      </tr>-->
<!--                    </table>-->
  <el-pagination

      background
      layout="prev, pager, next"
      page-size="5"
      @current-change="page"
      :total="total">
  </el-pagination>
</div>
</template>

<script>
export default {
  data() {
    return {
      baseUrl : "http://localhost:8081/",
      arr:{},
      total:null
    }
  },
  methods:{
    page(pageNo){

      var this_ = this;
      axios.get(this_.baseUrl+"college/page?pageNo="+pageNo).then(function (response) {
        // console.log(response.data.data)
        this_.arr=response.data.data.list;
        // this_.total=response.data.data.total;
        // console.log(this_.arr)
      })
    }
  },
  created(){//钩子函数
    var this_ = this;
    // 挂载元素之后，通过ajax获取数据
    axios.get(this_.baseUrl+"college/page").then(function (response) {
      // console.log(response.data.data)
      this_.arr=response.data.data.list;
      this_.total=response.data.data.total;
      // console.log(this_.arr)
    })
  }
};
</script>

<style scoped>
#a{
  margin-top: 30px;
}
</style>