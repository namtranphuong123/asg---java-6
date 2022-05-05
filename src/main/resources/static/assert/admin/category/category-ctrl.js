app.controller("category-ctrl", function ($scope, $http) {


  $scope.items = [];

  $scope.form = {};

  $scope.initialize = function () {

    //load product
    $http.get("/rest/categories").then(resp => {

      $scope.items = resp.data;
      $scope.items.forEach(item => {

        item.createDate = new Date(item.createDate)

      })

    });
    
  }
  $scope.initialize();



  $scope.edit = function(item) {
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab('show')
  }


  $scope.update = function() {
    var item = angular.copy($scope.form);
    $http.put(`/rest/categories/${item.id}`, item).then(resp => {
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items[index] = item;
      alert("cap nhap loai thanh cong !");
    }).catch(error => {
      alert("loi cap nhap loai");
      console.log("Error", error);
    });
  }
  $scope.delete = function(item) {
   
    $http.delete(`/rest/categories/${item.id}`).then(resp => {
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items.splice(index, 1);
      $scope.reset();
      alert("xoa loai thanh cong !");
    }).catch(error => {
      alert("loi xoa loai");
      console.log("Error", error);
    });
  }

  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http.post('/rest/categories', item).then(resp => {
      resp.data.createDate = new Date(resp.data.createDate)
      $scope.items.push(resp.data);
      $scope.reset();
      alert("them loai moi thanh cong !");
    }).catch(error => {
      alert("loi them moi loai");
      console.log("Error", error);
    });
  }


  $scope.reset = function () {
    $scope.form = {
      createDate: new Date(),
      image: 'cloud-upload.jpg',
      available: true,

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