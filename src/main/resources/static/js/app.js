/**
 * Created by Adrian J Lopez on 9/22/15.
 */

'use strict';

(function () {
    var storeApp = angular.module('pageView', ['ngRoute', 'storeServices']);

    storeApp.config(function($routeProvider){
        $routeProvider
            .when("/", {
                templateUrl: "main.html",
                controller: "MainController"
            })
            .when("/admin", {
                templateUrl: "admin.html",
                controller: "AdminController"
            })
            .otherwise({redirectTo:"/"});
    });


    storeApp.controller('UserInfo', ['$scope', '$http', '$sce', function ($scope, $http, $sce) {
        var res = $http.get('http://localhost:8080/userInfo');
        res.success(function(data) {
            $scope.navItems = $sce.trustAsHtml(data);
        });
    }]);
})();