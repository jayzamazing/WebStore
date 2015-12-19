/**
 * Created by Adrian J Lopez on 9/22/15.
 */

'use strict';

var pageView;
pageView = angular.module('pageView', ['ngRoute', 'storeControllers', 'storeServices']);
    pageView.config(['$routeProvider', '$locationProvider',
        function($routeProvider, $locationProvider){
        $routeProvider
            .when('/index', {
                templateUrl: 'main.html',
                controller: 'LoginCtrl'

            })
            .when('/admin', {
                templateUrl: 'admin.html'
                //controller: 'AdminController'
            })
            .otherwise({redirectTo:'/index'});

            $locationProvider.html5Mode({enabled:true, requireBase:false});
    }]);
pageView.run(function (sendHead){
    sendHead.init();
});
pageView.directive('dropzone', function () {
    return function (scope, element, attrs) {
        var config, dropzone;

        config = scope[attrs.dropzone];

        dropzone = new Dropzone(element[0], config.options);

        angular.forEach(config.eventHandlers, function (handler, event) {
            dropzone.on(event, handler);
        });
    };
});




