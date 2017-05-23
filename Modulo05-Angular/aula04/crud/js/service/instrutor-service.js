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
    let nomeExiste = false;
    let emailExiste = false;
    instrutores.forEach(item => nomeExiste = item.nome === instrutor.nome);
    instrutores.forEach(item => emailExiste = item.email === instrutor.email);

      if(!nomeExiste){
        if(emailExiste) {
          toastr.error('Email já está sendo utilizado.');
          return;
        }

        if(!instrutor.foto) instrutor.foto = 'https://pbs.twimg.com/profile_images/799010304273371136/HNncmPwZ.jpg'

        if(instrutor.dandoAula) instrutor.dandoAula = 'Sim';
        else instrutor.dandoAula = 'Não';

        instrutor.aulas = aulasMarcadas;

        return $http.post(`${urlBase}/instrutor`, instrutor);
      } else {
        toastr.error('Instrutor já cadastrado.');
        return;
      }
  };

  function deletar(instrutor) {
    let dandoAula = false;
    instrutores.forEach(item => dandoAula = item.dandoAula === 'Sim');
    if(!dandoAula) {
      return $http.delete(`${urlBase}/instrutor/${instrutor.id}`, instrutor);
    }else {
      toastr.error('Não é possível excluir este instrutor. Está dando aula.');
    }
  };

  return {
    create: criar,
    update: atualizar,
    list: getTodosInstrutores,
    findById: getInstrutorPorId,
    delete: deletar
  };
});