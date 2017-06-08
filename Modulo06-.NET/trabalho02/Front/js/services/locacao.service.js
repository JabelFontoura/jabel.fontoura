angular.module('app').factory('locacaoService', function ($http) {

  const url = 'http://localhost:54771/api/locacao';
  let cliente;

  return {
    listar: listar,
    listarPacotes: listarPacotes,
    obter: obter
  }

  function listarPacotes(headerAuth) {
    return $http({
      url: url + '/pacotes',
      method: 'GET',
      headers: {
        Authorization: headerAuth
      }
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