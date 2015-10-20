/**
 * Created by Adrian J Lopez on 9/22/15.
 */


(function () {
    var loadcontent = angular.module('loadContent', []);
    loadcontent.controller('UserInfo', ['$scope', '$http', '$sce', function ($scope, $http, $sce) {
        var res = $http.get('http://localhost:8080/userInfo');
        res.success(function(data) {
            $scope.navItems = $sce.trustAsHtml(data);
        });
    }]);
})();