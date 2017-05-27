angular.module('app').factory('loginService', function ($http) {

  const url = 'http://localhost:57960/api/usuario';

  return {
    create: function(usuario) {
      return $http.post(url, usuario);
    }
  };
});