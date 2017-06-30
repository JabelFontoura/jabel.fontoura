angular.module('app').factory('usuarioService', function ($http) {

  const url = 'http://localhost:9090/api/usuario';

  return {
    listar: listar,
    criar: criar
  }

  function listar() {
    return $http.get(url);
  }

  function criar(usuario) {
    return $http({
      url: url,
      method: 'POST',
      data: usuario
    });
  }
});