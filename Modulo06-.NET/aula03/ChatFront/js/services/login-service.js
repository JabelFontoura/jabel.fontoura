angular.module('app').factory('loginService', function ($http) {

  const url = 'http://localhost:57960/api/usuario';
  let usuarioAtual;

  return {
    create: function(usuario) {
      usuarioAtual = usuario;
      return $http.post(url, usuario);
    }
  };
});