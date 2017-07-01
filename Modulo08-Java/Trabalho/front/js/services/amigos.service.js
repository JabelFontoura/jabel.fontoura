angular.module('app').factory('amigosService', function ($http) {

  const url = 'http://localhost:9090/api/amigos';

  return {
    countAceitos: countAceitos
  }

  function countAceitos(idUsuario, aceito) {
    return $http.get(`${url}/aceitos?idUsuario=${idUsuario}&aceito=${aceito}`);
  }

});