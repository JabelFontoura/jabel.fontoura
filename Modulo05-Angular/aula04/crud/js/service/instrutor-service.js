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

  function criar(instrutor) {

  };

  function deletar(instrutor) {
    $http.delete(`${urlBase}/instrutor/${instrutor.id}`, instrutor);
  };

  return {
    list: getTodosInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    create: criar
  };
});