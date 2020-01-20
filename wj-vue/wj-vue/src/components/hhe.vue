<template>
  <div>
    <p>{{ message1 }}</p>
    <p>{{ message2 }}</p>
    <p>{{ details() }}</p>
    <p>{{5+5}}</p>
    <p>{{ ok ? 'yes' : 'no' }}</p>
    <p> {{'翻转：'+ message3.split('').reverse().join('') }}</p>
    <p v-if="ok">ok为true</p>
    <a v-bind:href="url">百度一下</a>
    <p>{{message4}}</p>
    <p>{{counter}}</p>
    <button @click="say(hello)">hello</button><br>
    input元素:<input v-model="message5">,输入的消息是:{{message5}}<br>
    <button v-on:click="reverseMessage">翻转字串</button><br>
    <runoob id="runoob"></runoob>

  </div>
</template>
<script>
    export default {
        name: "hhe",
        data () {
            return {
                message1: '欢迎来到vue教程！',
                message2: 'Welcome！',
                message3:'vue',
                message4:'abcdefg',
                message5:'双向数据绑定',
                counter:0,
                hello:'你好',
                ok:true,
                url:'http://www.baidu.com'
            }
        },
        methods: {
            details:function() {
                return  this.message3 + " - 学的不仅是技术，更是梦想！";
            },
            reverseMessage:function(){
                this.message4=this.message4.split('').reverse().join('')
            },
            say:function(msg){
                alert(msg);
            }
        }
    }
</script>

<style scoped>

</style>
