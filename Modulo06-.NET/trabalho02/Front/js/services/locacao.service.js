angular.module('app').factory('locacaoService', function ($http) {

  const url = 'http://localhost:54771/api/locacao';
  let cliente;

  return {
    listar: listar,
    listarPacotes: listarPacotes,
    obter: obter,
    criar: criar
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

  function criar(locacao, headerAuth) {
    return $http({
      url: url + '/registrar',
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: locacao
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