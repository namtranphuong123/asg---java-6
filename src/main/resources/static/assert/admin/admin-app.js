app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider){
    $routeProvider
    .when("/product", {
        templateUrl: "/assert/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/category", {
        templateUrl: "/assert/admin/category/index.html",
        controller: "category-ctrl"
    }).when("/authorize", {
        templateUrl: "/assert/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("/order", {
        templateUrl: "/assert/admin/order/index.html",
        controller: "order-ctrl"
    })
    .when("/unauthorized", {
        templateUrl: "/assert/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .when("/statistic", {
        templateUrl: "/assert/admin/report/index.html",
        controller: "statistic-ctrl"
    })
    .when("/account", {
        templateUrl: "/assert/admin/account/index.html",
        controller: "account-ctrl"
    })
    
    .otherwise({
       redirectTo:"/product"
    })
    
    
})