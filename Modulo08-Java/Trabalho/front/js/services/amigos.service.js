angular.module('app').factory('amigosService', function ($http) {

  const url = 'http://localhost:9090/api/amigos';

  return {
    countAceitos: countAceitos,
    findAllByIdUsuario: buscarPorIdUsuario
  }

   function buscarPorIdUsuario(idUsuario, aceito) {
    return $http.get(`${url}/lista?idUsuario=${idUsuario}&aceito=A`);
  }

  function countAceitos(idUsuario, aceito) {
    return $http.get(`${url}/aceitos?idUsuario=${idUsuario}&aceito=${aceito}`);
  }

});