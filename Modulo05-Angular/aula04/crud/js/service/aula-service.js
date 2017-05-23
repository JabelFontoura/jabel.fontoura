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
    
      if(!aulaExiste){

        aulas.forEach((item) => {
          if(item.id === Number(aula.id)) {
              $http.put(urlBase + '/aula' + '/' + aula.id, aula)
              .then(response => toastr.success('Aula alterada com sucesso.'))
              .catch(error => toastr.error('Ocorreu um erro ao alterar essa aula'));
          }
        });
      } else {
        toastr.error('Aula já cadastrada.');
      }
  };

  function criar(aula) {
    let aulaExiste;
    aulas.forEach(item => aulaExiste = item.nome === aula.nome);
      if(!aulaExiste){
        $http.post(`${urlBase}/aula`, aula)
        .then(response => toastr.success('Aula inserida com sucesso.'))
        .catch(error => toastr.error('Ocorreu um erro ao inserir essa aula.'));
      } else {
        toastr.error('Aula já cadastrada.');
      }
  };

  function deletar(aula) {
    $http.delete(`${urlBase}/aula/${aula.id}`, aula)
    .then(response => toastr.success('Aula deletada com sucesso.')
    .catch(error => toastr.error('Ocorreu um erro ao deletar a aula.')));
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
});