<template>
  <el-container style="height:700px; border: 1px solid #eee">
    <!--        构建左侧菜单-->
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <!--        <el-menu :default-openeds="['1']":default-active="'1-1'">-->
      <!--          <el-submenu index="1">-->
      <!--            <template slot="title"><i class="el-icon-message"></i>导航一</template>-->
      <!--            <el-menu-item index="1-1">选项1</el-menu-item>-->
      <!--            <el-menu-item index="1-2">选项2</el-menu-item>-->
      <!--            <el-submenu index="1-3">-->
      <!--              <template slot="title"><i class="el-icon-set-up"></i>选项三</template>-->
      <!--              <el-menu-item index="1-3-1">1-3-1</el-menu-item>-->
      <!--              <el-menu-item index="1-3-2">1-3-2</el-menu-item>-->
      <!--            </el-submenu>-->
      <!--          </el-submenu>-->
      <!--        </el-menu>-->



      <el-menu router>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>导航</template>
          <el-menu-item index="/college_list">学院列表</el-menu-item>
          <el-menu-item index="/major_list">专业列表</el-menu-item>
          <el-menu-item index="/college_add">添加学院</el-menu-item>
          <el-menu-item index="/major_add">添加专业</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>




      <router-view/>
    </el-container>

</template>

<script>

</script>

<style scoped>

</style>