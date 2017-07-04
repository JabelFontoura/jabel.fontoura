angular.module('app').factory('comentarioService', function ($http) {

  const url = 'http://10.99.0.167:9090/api/comentario';

  return {
    findAll: listar,
    create: criar,
    findById: buscarPorId,
    countByIdPost: contarPorIdPost
  }

  function listar(id) {
    return $http.get(`${url}/${id}`);
  }

  function contarPorIdPost(id) {
    return $http.get(`${url}/count/${id}`);
  }

  function buscarPorId(id) {
    return $http.get(`${url}/${id}`);
  }

  function criar(comentario) {
    return $http({
      url: url,
      method: 'POST',
      data: comentario
    });
  }
});