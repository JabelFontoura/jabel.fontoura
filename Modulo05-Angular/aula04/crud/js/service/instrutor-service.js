angular.module('crud').factory('instrutorService', function ($http, toastr) {

  let urlBase = 'http://localhost:3000';
  let instrutores;

  getTodosInstrutores().then(response => instrutores = response.data);

  function getTodosInstrutores() {
    return $http.get(urlBase + '/instrutor');
  };

  function getInstrutorPorId(id) {
    return $http.get(urlBase + '/instrutor' + '/' + id);
  };

  function atualizar(instrutor) {
    return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
  };

  function criar(instrutor, aulasMarcadas) {
    if(!instrutor.foto) instrutor.foto = 'https://pbs.twimg.com/profile_images/799010304273371136/HNncmPwZ.jpg'

    instrutor.aulas = aulasMarcadas;

    return $http.post(`${urlBase}/instrutor`, instrutor);
  };

  function deletar(instrutor) {
    return $http.delete(`${urlBase}/instrutor/${instrutor.id}`, instrutor);
  };

  return {
    create: criar,
    update: atualizar,
    list: getTodosInstrutores,
    findById: getInstrutorPorId,
    delete: deletar
  };
});