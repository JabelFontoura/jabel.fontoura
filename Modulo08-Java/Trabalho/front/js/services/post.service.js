angular.module('app').factory('postService', function ($http) {

  const url = 'http://localhost:9090/api/post';

  return {
    findAll: listar,
    findAllByIdUsuario: listarPorIdUsuario,
    create: criar,
    findById: buscarPorId
  }

  function listar() {
    return $http.get(url);
  }

   function listarPorIdUsuario(id) {
    return $http.get(`${url}/lista/${id}`);
  }

  function buscarPorId(id) {
    return $http.get(`${url}/${id}`);
  }

  function criar(post) {
    return $http({
      url: url,
      method: 'POST',
      data: post
    });
  }
});