app.controller("statistic-ctrl", function ($scope, $http) {



  $scope.items = [];
  $scope.sl = [];
  $scope.ss = [];




$scope.initialize = function () {

  //load product theo loại
  $http.get("/rest/report").then(resp => {

    $scope.items = resp.data;
   


  });
  //load doanh thu
  $http.get("/rest/report/a").then(resp => {

    $scope.sl = resp.data;

  });
  //load doanh thu theo sp
  $http.get("/rest/report/b").then(resp => {

    $scope.ss = resp.data;

  });
  
}
$scope.pager = {
  page: 0,
  size: 11,
  get ss(){
    var start = this.page * this.size;
    return $scope.ss.slice(start,start + this.size);
  },
  get count(){
    return Math.ceil(1.0 * $scope.ss.length / this.size);
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
$scope.initialize();
});