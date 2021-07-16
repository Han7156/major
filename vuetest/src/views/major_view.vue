<template>
    <div>
        <ul>
          <li>{{arr.mid}}</li>
          <li>{{arr.mname}}</li>
          <li>{{arr.credit}}</li>
          <li>{{arr.lifeyear}}</li>

        </ul>
    </div>
</template>

<script>
export default {
  name: "major_vivw",
  data(){
    return{
      arr:[

      ]
    }
  },
  created() {
    // alert(this.$route.query.id)
    var this_=this;
    var id = this.$route.query.id;
    axios.post('http://localhost:8081/major/getByid?id='+id).then(function (resp){
      // console.log(resp)
      this_.arr=resp.data.data;
    })
  }
}
</script>

<style scoped>

</style>