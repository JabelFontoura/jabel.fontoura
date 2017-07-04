angular.module('app').factory('postService', function ($http) {

  const url = 'http://10.99.0.167:9090/api/post';

  return {
    findAll: listar,
    findAllByIdUsuario: listarPorIdUsuario,
    create: criar,
    findById: buscarPorId
  }

  function listar() {
    return $http.get(url);
  }

   function listarPorIdUsuario(id, pagina) {
    return $http.get(`${url}/lista?id=${id}&pagina=${pagina}`);
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