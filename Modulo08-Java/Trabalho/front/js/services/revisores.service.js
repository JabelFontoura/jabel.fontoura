angular.module('app').factory('revisoresService', function ($http) {

  const url = 'http://localhost:55166/api/revisores';

  return {
    listar: listar,
    criar: criar
  };

  function listar() {
    return $http.get(url);
  }

  function criar(revisor, headerAuth) {
    return $http({
      url: url,
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: revisor
    });
  }

});