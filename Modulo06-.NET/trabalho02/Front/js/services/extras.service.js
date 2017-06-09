angular.module('app').factory('extrasService', function ($http) {

  const url = 'http://localhost:54771/api/extras';

  return {
    listar: listar,
    listarDisponiveis: listarDisponiveis,
    obter: obter
  }

  function obter(id, headerAuth) {
    return $http({
      url: url + '/' + id,
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

  function listarDisponiveis(headerAuth) {
    return $http({
      url: url + '/disponiveis',
      method: 'GET',
      headers: {
        Authorization: headerAuth
      }
    });
  }
  
});