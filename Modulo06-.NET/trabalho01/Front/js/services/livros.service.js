angular.module('app').factory('livrosService', function ($http) {

  const url = 'http://localhost:55166/api/livros';

  return {
    listar: listar,
    listarLancamentos: listarLancamentos,
    create: criar,
    findById: obterPorId
  };

  function listar() {
    return $http.get(url);
  }

  function listar(parametros) {
    return $http({
          url: url,
          method: 'GET',
          params: parametros
        });
  }

  function listarLancamentos(parametros) {
    return $http({
          url: url + '/lancamentos',
          method: 'GET',
          params: parametros
        });
  }

  function criar(livro) {
    return $http.post(url, livro);
  }

  function obterPorId(id) {
    return $http.get(url + '/' + id);
  }
});