angular.module('app').factory('loginService', function ($http) {
  return {
    create: function(usuario) {
      return $http.post();
    }
  };
});