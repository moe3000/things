import Vue from 'vue';
import getData from './util/util'
import './style/common.scss';

var app = new Vue({
  el: '#app',
  data: {
    message: 'hello world'
  },
  methods: {
    async fetchData(){
      const data = await getData();
    }  
  },
  created() {
    this.fetchData();
  }
})