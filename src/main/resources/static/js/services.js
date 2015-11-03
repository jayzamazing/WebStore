/**
 * Created by Adrian J Lopez on 11/2/15.
 */

'use strict';

(function () {
    var storeServices = angular.module('storeServices', ['ngCookies']);
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

    storeServices.factory('setCreds',
        ['$cookies', function($cookies) {
            return function(userName, password){
                $cookies.creds = userName.concat(":", password);
                $cookies.userName = userName;
            }
        }]);

    storeServices.factory('clearCreds',
        ['$cookies', function() {
            return function($cookies){
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