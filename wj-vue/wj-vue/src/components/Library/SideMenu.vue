<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">文学</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">流行</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">文化</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">生活</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">经管</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-menu"></i>
      <span slot="title">科技</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
    export default {
        name: 'SideMenu',
        data () {
            return {
                cid: ''
            }
        },
        methods: {
            //触发 <el-menu> 组件的 @select 事件，执行 handleSelect 方法。
            //将key值，即<el-menu>组件中的index属性的值（分类码）赋给 data 中定义的属性。
            //emit：触发事件。触发父组件LibraryIndex中的indexSelect 事件
            //父组件收到指令，执行事件对应的方法，即 listByCategory 方法
            handleSelect (key, keyPath) {
                this.cid = key
                this.$emit('indexSelect')
            }
        }
    }
</script>

<style scoped>
  .categories {
    position: fixed;
    margin-left: 50%;
    left: -600px;
    top: 100px;
    width: 150px;
  }
</style>
