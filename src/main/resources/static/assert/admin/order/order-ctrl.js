app.controller("order-ctrl", function ($scope, $http) {


  $scope.items = [];
  $scope.status = [];
  $scope.form = {};

  $scope.initialize = function () {

    //load product
    $http.get("/rest/orders").then(resp => {

      $scope.items = resp.data;
      $scope.items.forEach(item => {

        item.createDate = new Date(item.createDate)

      })

    });
    //load loại
    $http.get("/rest/status").then(resp => {
      $scope.status = resp.data;
    });
    
  }
  $scope.initialize();



  $scope.edit = function(item) {
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab('show')
  }

$scope.readload = function(){
  $http.get("/rest/orders").then(resp => {

    $scope.items = resp.data;
    $scope.items.forEach(item => {

      item.createDate = new Date(item.createDate)

    })

  });
}
  $scope.update = function() {
    var item = angular.copy($scope.form);
    $http.put(`/rest/orders/${item.id}`, item).then(resp => {
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items[index] = item;
      alert("cap nhap trang thai thanh cong !");
      $scope.readload();
    }).catch(error => {
      alert("loi cap nhap trang thai");
      console.log("Error", error);
    });
  }
  
  $scope.delete = function(item) {
   
    $http.delete(`/rest/orders/${item.id}`).then(resp => {
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items.splice(index, 1);
      $scope.reset();
      alert("xoa order thanh cong !");
    }).catch(error => {
      alert("loi xoa order");
      console.log("Error", error);
    });
  }

  $scope.reset = function () {
    $scope.form = {
      

    };
  }

 
$scope.pager = {
  page: 0,
  size: 4,
  get items(){
    var start = this.page * this.size;
    return $scope.items.slice(start,start + this.size);
  },
  get count(){
    return Math.ceil(1.0 * $scope.items.length / this.size);
  },
  first(){
    this.page = 0;
  },
  prev(){
    this.page--;
    if(this.page < 0){
      this.last();
    }
  },
  next(){
    this.page++;
    if(this.page >= this.count){
      this.first();
    }
  },
  last(){
    this.page = this.count - 1;
  }
}
});