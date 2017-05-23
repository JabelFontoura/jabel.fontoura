angular.module('crud').factory('aulaService', function ($http, toastr) {

  let urlBase = 'http://localhost:3000';
  let aulas;

  getTodasAsAulas().then(response => aulas = response.data);

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aula) {
    return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
    let aulaExiste;
    aulas.forEach(item => aulaExiste = item.nome === aula.nome);
      if(!aulaExiste){
        $http.post(`${urlBase}/aula`, aula);
        toastr.success('Aula inserida com sucesso.');
      } else {
        toastr.error('Aula já cadastrada.');
      }
      getTodasAsAulas().then(response => aulas = response.data);
  };

  function deletar(aula) {
    $http.delete(`${urlBase}/aula/${aula.id}`, aula);
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
});