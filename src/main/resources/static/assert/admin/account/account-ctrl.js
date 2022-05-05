app.controller("account-ctrl", function ($scope, $http) {


  $scope.items = [];
  $scope.form = {};

  $scope.initialize = function () {

    //load account	
    $http.get("/rest/accounts").then(resp => {

      $scope.items = resp.data;
      $scope.items.forEach(item => {

        item.createDate = new Date(item.createDate)

      })

    });
    
    $scope.form = {
      createDate: new Date(),
      image: 'cloud-upload.jpg',

    };
  }
 
  $scope.initialize();


  $scope.readload = function(){
    $http.get("/rest/accounts").then(resp => {
  
      $scope.items = resp.data;
      $scope.items.forEach(item => {
  
        item.createDate = new Date(item.createDate)
  
      })
  
    });
  }
  $scope.edit = function(item) {
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab('show')
  }


  

  $scope.update = function() {
    var item = angular.copy($scope.form);
    $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
      var index = $scope.items.findIndex(p => p.username == item.username);
      $scope.items[index] = item;
      alert("cap nhap tai khoan thanh cong !");
      $scope.readload();
      $scope.reset();
    }).catch(error => {
      alert("loi cap nhap tai khoan");
      console.log("Error", error);
    });
  }



  $scope.delete = function(item) {
   
    $http.delete(`/rest/accounts/${item.username}`).then(resp => {
      var index = $scope.items.findIndex(p => p.username == item.username);
      $scope.items.splice(index, 1);
      $scope.reset();
      alert("xoa san tai khoan thanh cong !");
    }).catch(error => {
      alert("loi xoa tai khoan");
      console.log("Error", error);
    });
  }

  $scope.create = function () {
      var item = angular.copy($scope.form);
      $http.post('/rest/accounts', item).then(resp => {
        resp.data.createDate = new Date(resp.data.createDate)
        $scope.items.push(resp.data);
        $scope.reset();
        alert("dang ky thanh cong !");

      }).catch(error => {
        alert(" dang ky that bai");
        console.log("Error", error);
      });
    }

  $scope.imageChanged = function (files) {

    var data = new FormData();
    data.append('file', files[0]);
    $http.post('/rest/upload/images', data, {
      transformRequest: angular.identity,
      headers: { 'Content-Type': undefined }

    }).then(resp => {
      $scope.form.image = resp.data.name;
    }).catch(error => {
      alert("Loi upload hinh anh");
      console.log("Error", error);
    })
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
  size: 9,
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
/*
 AngularJS v1.4.8
 (c) 2010-2015 Google, Inc. http://angularjs.org
 License: MIT
*/

});
