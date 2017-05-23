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
    let aulaExiste = false;

    aulas.forEach(item =>{
       if(item.nome.localeCompare(aula.nome) === 0 ) aulaExiste = true;
    });
    
    if(!aulaExiste)
      return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
    else 
      toastr.error('Aula já cadastrada.');
  };

  function criar(aula) {
    let aulaExiste;

    aulas.forEach(item => aulaExiste = item.nome === aula.nome);

    if(!aulaExiste)
      return $http.post(`${urlBase}/aula`, aula);
    else 
      toastr.error('Aula já cadastrada.');
  };

  function deletar(aula) {
    return $http.delete(`${urlBase}/aula/${aula.id}`, aula);
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
});