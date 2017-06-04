angular.module('app').factory('autoresService', function ($http) {

  const url = 'http://localhost:55166/api/autores';

  return {
    listar: listar
  }

  function listar() {
    return $http.get(url);
  }
});