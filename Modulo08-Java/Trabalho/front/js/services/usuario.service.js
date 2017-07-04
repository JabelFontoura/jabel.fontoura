angular.module('app').factory('usuarioService', function ($http) {

  const url = 'http://10.99.0.167:9090/api/usuario';

  return {
    findAll: listar,
    create: criar,
    getLogged: getLogged,
    findById: buscarPorId,
    findByNaoAmigo: listarPessoas
  }

  function getLogged() {
    return $http.get(`${url}/logged`);
  }

  function listar() {
    return $http.get(url);
  }

  function listarPessoas(id) {
    return $http.get(`${url}/pessoas/${id}`);
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