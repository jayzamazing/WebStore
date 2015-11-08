/**
 * Created by Adrian J Lopez on 11/2/15.
 */

'use strict';


    var storeServices = angular.module('storeServices', ['ngCookies', 'ngResource']);
    storeServices.factory('checkCreds',
        ['$cookies', function($cookies) {
        return function() {
            var notEmpty = false;
            var creds = $cookies.creds;
            if (creds !== undefined && creds != "")
                notEmpty = true;
            return notEmpty;
        }
    }]);

    storeServices.factory('getToken',
        ['$cookies', function($cookies) {
            return function(){
                var val = "";
                var creds = $cookies.creds;
                if (creds !== undefined && creds != "")
                    val = btoa(creds);
                return val;
            }
        }]);

    storeServices.factory('getUserName',
        ['$cookies', function($cookies) {
            return function(){
                var val = "";
                var userName = $cookies.userName;
                if (userName !== undefined && userName != "")
                    val = userName;
                return val;
            }
        }]);

    storeServices.factory('getUserType',
        ['$cookies', function($cookies) {
            return function(){
                var val = "";
                var userType = $cookies.userType;
                if (userType !== undefined && userType != "")
                    val = userType;
                return val;
            }
        }]);

    storeServices.factory('setCreds',
        ['$cookies', function($cookies) {
            return function(userName, password, userType){
                $cookies.creds = userName.concat(":", password);
                $cookies.userName = userName;
                $cookies.userType = userType;
            }
        }]);

    storeServices.factory('clearCreds',
        ['$cookies', function($cookies) {
            return function(){
                $cookies.creds = "";
                $cookies.userName = "";
                $cookies.userType = "";
            }
        }]);

    storeServices.factory('Login', ['$resource',
        function(rs){
          return rs('http://localhost:8080/userInfo',{},{
              auth: {method: 'POST', cache: false, isArray: false}
          });
        }]);


