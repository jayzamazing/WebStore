/**
 * Created by Adrian J Lopez on 11/2/15.
 */

'use strict';

var storeControllers = angular.module('storeControllers', []);
storeControllers.controller('LoginCtrl',
['$scope', '$location', 'Login', 'setCreds',
    function (sc, lc, Login, setCreds){

        sc.login = function(){
            sc.sub = true;
            var postData = {
                "username" : sc.username,
                "password" : sc.password
            };
            Login.auth({}, postData,
            function success(response){
                if(response.authenticated && response.userType == "admin"){
                    setCreds(sc.username, sc.password, sc.userType);
                    lc.path('/admin');
                }
                else if (response.authenticated && response.userType == "user"){
                    setCreds(sc.username, sc.password, sc.userType);
                    lc.path('/');
                } else {
                    sc.error = "Login Failed"
                }
            },
                function error(errorMessage) {
                    console.log("Error:" + JSON.stringify(errorMessage));
                }
            );
        }
    }]);
