angular.module('app').factory('usuarioService', function ($http) {

  const url = 'http://localhost:9090/api/usuario';

  return {
    findAll: listar,
    create: criar,
    getLogged: getLogged,
    findById: buscarPorId
  }

  function getLogged() {
    return $http.get(`${url}/logged`);
  }

  function listar() {
    return $http.get(url);
  }

  function buscarPorId(id) {
    return $http.get(`${url}/${id}`);
  }

  function criar(usuario) {
    return $http({
      url: url,
      method: 'POST',
      data: usuario
    });
  }
});