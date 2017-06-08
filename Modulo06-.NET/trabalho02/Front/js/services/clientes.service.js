angular.module('app').factory('clientesService', function ($http) {

  const url = 'http://localhost:54771/api/clientes';

  return {
    listar: listar,
    obter: obter,
    criar: criar
  }

  function criar(cliente, headerAuth) {
    return $http({
      url: url + '/registar',
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: cliente
    });
  }

  function listar(headerAuth) {
    return $http({
      url: url,
      method: 'GET',
      headers: {
        Authorization: headerAuth
      }
    });
  }

  function obter(id, headerAuth) {
    return $http({
      url: url,
      method: 'GET',
      params: id,
      headers: {
        Authorization: headerAuth
      }
    });
  }

});