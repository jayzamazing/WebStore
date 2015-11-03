/**
 * Created by Adrian J Lopez on 11/2/15.
 */

'use strict';

(function () {
    var storeServices = angular.module('storeServices', ['ngCookies']);
    storeServices.factory('checkCreds',
        ['$cookies', function($cookies) {
        return function() {
            if ($cookies.creds !== undefined && $cookies.creds != "")
                return true;
            else
                return false;
        }
    }]);

    storeServices.factory('getToken',
        ['$cookies', function($cookies) {
            return function(){
                if ($cookies.creds !== undefined && $cookies.creds != "")
                   return btoa($cookies.checkCreds);
                else
                    return "";
            }
        }]);

    storeServices.factory('getUserName',
        ['$cookies', function($cookies) {
            return function(){
                if ($cookies.userName !== undefined && $cookies.userName != "")
                    return $cookies.UserName;
                else
                    return "";
            }
        }]);

    storeServices.factory('setCreds',
        ['$cookies', function($cookies) {
            return function(userName, password){
                $cookies.creds = username.concat(":", password);
                $cookies.userName = userName;
            }
        }]);

    storeServices.factory('clearCreds',
        ['$cookies', function() {
            return function(){
                $cookies.creds = "";
                $cookies.userName = "";
            }
        }]);

    storeServices.factory('Login', ['$resource',
        function($resource){
          return $resource('http://localhost:8080/userInfo',{},{
              login: {method: 'POST', cache: false, isArray: false}
          });
        }]);
})();