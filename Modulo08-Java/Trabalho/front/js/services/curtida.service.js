angular.module('app').factory('curtidaService', function ($http) {

  const url = 'http://localhost:9090/api/curtida';

  return {
    findByIdPost: listarPorIdPost,
    countByIdPost: contarPorIdPost,
    create: criar,
    delete: deletar
  }

  function listarPorIdPost(id) {
    return $http.get(`${url}/post/${id}`);
  }

  function contarPorIdPost(id) {
    return $http.get(`${url}/count/${id}`);
  }

  function deletar(id) {
    return $http.delete(`${url}/${id}`);
  }

  function criar(dados) {
    return $http({
      url: url,
      method: 'POST',
      data: dados
    });
  }
});