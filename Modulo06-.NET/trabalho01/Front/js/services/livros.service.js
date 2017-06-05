angular.module('app').factory('livrosService', function ($http) {

  const url = 'http://localhost:55166/api/livros';

  return {
    listar: listar,
    listarLancamentos: listarLancamentos,
    listarLivrosSemRevisao: listarLivrosSemRevisao,
    listarLivrosRevisados: listarLivrosRevisados,
    criar: criar,
    alterar: alterar,
    remover: remover,
    findById: obterPorId,
    getQuantidadeTotal: getQuantidadeTotal
  };

  function listar() {
    return $http.get(url);
  }

  function getQuantidadeTotal() {
    return $http.get(url + '/quantidadetotal');
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

  function listarLivrosSemRevisao() {
    return $http.get(url + '/revisao');
  }
  
  function listarLivrosRevisados() {
    return $http.get(url + '/revisados');
  }

  function criar(livro, headerAuth) {
    return $http({
      url: url,
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    });
  }

  function alterar(livro, headerAuth, operacao = '') {
    return $http({
      url: url + '/' + operacao + livro.Isbn,
      method: 'PUT',
      headers: {
        Authorization: headerAuth
      },
      data: livro
    });
  }

      function remover(isbn, headerAuth) {
      return $http({
        url: url + '/' + isbn,
        method: 'DELETE',
        headers: {
          Authorization: headerAuth
        }
      });
  }

  function obterPorId(id) {
    return $http.get(url + '/' + id);
  }
});