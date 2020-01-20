<template>
  <div class="test" >
    <el-form class="test-container" label-position="left" label-width="0px">
      <h3 class="test_title">test pub-sub</h3>
      <el-form-item class="test_item">
        <el-select  label-position="left" v-model="testvalue" placeholder="请选择type" @change="inputToDisabled">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-input v-model="label" placeholder="sub-label" v-bind:disabled="dis" >
          <template slot="prepend">标志</template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="text" v-model="testipaddress" auto-complete="off" placeholder="地址"></el-input>
      </el-form-item>
      <el-form-item>
      <el-input type="textarea" :rows="2" v-model="testjson" auto-complete="off" placeholder="手动抓拍"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 20%;background: #505458;border: none" v-on:click="test">发布命令</el-button>
      </el-form-item>
      <el-form-item>
        <div class="block"></div>
      </el-form-item>
      <el-form-item>
        <el-input
          type="textarea"
          :rows="8"
          placeholder="显示数据"
          v-model="textarea1">
        </el-input>
        <el-image v-bind:src="src"></el-image>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    import api from './common/api.js';

    export default {
        name: 'test',
        data() {
            return {
                testjson: '', //json
                textarea1: '',  //数显
                testipaddress: '', //ip地址
                label: 'gv_res',  //标志
                path: "ws://127.0.0.1:8099/websocket/1",
                socket: "",
                src: "",
                options: [{
                    value: '1',
                    label: 'PUB'
                }, {
                    value: '3',
                    label: 'REQ'
                }],
                testvalue: '',  //type
            }
        },
        mounted() {
            this.init()
        },
        methods: {
            test() {
                this.$axios
                    .post(api.test,
                        {
                            testjson: this.testjson,
                            testvalue: this.testvalue,
                            ipaddress: this.ipaddress,
                            label: this.label,
                        }
                    )
                    .then(response => {
                        console.log(response)
                        this.textarea1 = JSON.stringify(response.data)
                    })
                    .catch(err => {
                        console.log(err)
                    })
            }, inputToDisabled() {
                if (this.testvalue === '1') {
                    this.dis = false
                } else if (this.testvalue === '3') {
                    this.dis = true //true:不可用
                }
            },
            init: function () {
                if (typeof (WebSocket) === "undefined") {
                    alert("您的浏览器不支持socket")
                } else {
                    // 实例化socket
                    this.socket = new WebSocket(this.path)
                    // 监听socket连接
                    this.socket.onopen = this.open
                    // 监听socket错误信息
                    this.socket.onerror = this.error
                    // 监听socket消息
                    this.socket.onmessage = this.getMessage
                }
            },
            open: function () {
                console.log("socket连接成功")
            },
            error: function () {
                console.log("连接错误")
            },
            getMessage: function (msg) {
                this.textarea1 = msg.data
                var obj = JSON.parse(msg.data)
                this.src = obj["media_url"]
            },
            close: function () {
                console.log("socket已经关闭")
            }
        }
    }
</script>
<style>
  .test-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 1000px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .test_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

</style>
