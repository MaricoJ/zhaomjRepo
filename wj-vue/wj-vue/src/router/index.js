import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '../components/home/AppIndex'
import Login from '../components/Login'
import Register from "../components/Register";
import hhe from '../components/hhe'
import Home from '../components/Home'
import test from '../components/test'
import selftest from '../components/selftest'
import LibraryIndex from "../components/Library/LibraryIndex";
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },{
          path:'/library',
          name:'AppLibrary',
          component: LibraryIndex,
          meta: {
            requireAuth:true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },{
      path:'/hhe',
      name:'hhe',
      component:hhe
    },{
      path:'/test',
      name:'test',
      component:test
    },{
      path:'/selftest',
      name:'/selftest',
      component: selftest
    },{
      path: '/',
      name: 'index',
      redirect: '/index',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    }
  ]
})
