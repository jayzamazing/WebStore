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
})();