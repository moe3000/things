<template>
  <div id="app">
    <h1>{{msg}}</h1>
    <img id="logo" src="./image/logo.png">
    <input type="text" v-model="msg">

  </div>
</template>

<script>
import getData from './util/util'
export default {
  name:'app',
  data(){
    return {
      msg:'hello world'
    }
  },
  created() {
    this.fetchData()
    console.log('init');
  },
  methods: {
     async fetchData() {
      const data = await getData();
      this.msg = data;
    }
  }
}
</script>

<style lang="scss">
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;

  h1 {
    color: green;
  }

  #logo {
    height: 32px;
  }
}
</style>
