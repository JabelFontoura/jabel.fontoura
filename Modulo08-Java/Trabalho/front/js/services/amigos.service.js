angular.module('app').factory('amigosService', function ($http) {

  const url = 'http://localhost:9090/api/amigos';

  return {
    create: criar,
    countAceitos: countAceitos,
    findAllByIdUsuario: buscarPorIdUsuario,
  }

  function criar(amizade) {
    return $http({
      url: url,
      method: 'POST',
      data: amizade
    });
  }

   function buscarPorIdUsuario(idUsuario, aceito) {
    return $http.get(`${url}/lista?idUsuario=${idUsuario}&aceito=${aceito}`);
  }
  function countAceitos(idUsuario, aceito) {
    return $http.get(`${url}/aceitos?idUsuario=${idUsuario}&aceito=${aceito}`);
  }

});