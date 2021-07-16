import Vue from 'vue'
import VueRouter from 'vue-router'
import major_add from "../views/major_add";
import college_list from "../views/college_list";
import major_list from "../views/major_list";
import shouye from "../views/shouye";
import login from "../views/login";
import major_modify from "../views/major_modify";
import college_add from "../views/college_add";
import major_view from "../views/major_view";


Vue.use(VueRouter)
const routes = [
  {
    path: "/",
    name:'登录',
    component: login
  },
  {
    path: "/shouye",
    name: "导航",
    component: shouye,
    redirect: '/college_list',
    children:[
      {
        path: "/major_add",
        name: "添加专业",
        component: major_add
      },
      {
        path: "/major_modify",
        name: "修改专业",
        component: major_modify
      },
      {
        path: "/major_view",
        name: "查看专业",
        component: major_view
      },
      {
        path: "/college_add",
        name: "添加学院",
        component: college_add
      },
      {
        path: "/college_list",
        name: "学院列表",
        component: college_list
      },
      {
        path: "/major_list",
        name: "专业列表",
        component: major_list
      }
    ]
  }


  //
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
