angular.module('app').factory('produtosService', function ($http) {

  const url = 'http://localhost:54771/api/produtos';

  return {
    listar: listar
  }

  function listar() {
    return $http.get(url);
  }
  
});