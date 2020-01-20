<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <books class="books-area" ref="booksArea"></books>
    </el-main>
  </el-container>
</template>

<script>
    import SideMenu from './SideMenu'
    import Books from './Books'

    export default {
        name: 'AppLibrary',
        components: {Books, SideMenu},
        methods: {
            //组件之间的通信
            //父组件收到指令，执行事件对应的方法，即 listByCategory 方法
            //发送请求，后端执行查询代码，返回数据，再通过 refs 修改 Books组件的 data 以动态渲染页面。
            listByCategory () {
                var _this = this
                var cid = this.$refs.sideMenu.cid
                var url = 'categories/' + cid + '/books'
                this.$axios.get(url)
                    .then(resp => {
                    if (resp && resp.status === 200) {
                        _this.$refs.booksArea.books = resp.data
                    }
                })
            }
        }
    }
</script>

<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
