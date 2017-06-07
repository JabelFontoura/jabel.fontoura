angular.module('app').factory('produtosService', function ($http) {

  const url = 'http://localhost:54771/api/produtos';

  return {
    listar: listar,
    listarDisponiveis: listarDisponiveis
  }

  function listar() {
    return $http.get(url);
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