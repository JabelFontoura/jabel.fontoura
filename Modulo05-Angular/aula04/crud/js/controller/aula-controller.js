angular.module('crud').controller('AulaController', ($scope, $routeParams, toastr, aulaService, instrutorService) => {

  list();

  $scope.adicionarAula = () => {
    if($scope.createAula.$valid) {
      aulaService.create($scope.novaAula)
        .then(response => {
          toastr.success('Aula inserida com sucesso.')
          list();
        }).catch(error => toastr.error('Ocorreu um erro ao inserir essa aula.'));
    }
  }

  $scope.mostrarAula = (item) => {
    $scope.editAula = {};
    $scope.showEditAula = true;
    $scope.idAulaUpdate = item.id;
    $scope.editAula.id = item.id;
    $scope.editAula.nome = item.nome;
  }

  $scope.editarAula = () => {
    if($scope.updateAula.$valid) {
			aulaService.update($scope.editAula)
        .then(response => { 
          toastr.info('Aula alterada com sucesso.');
          list();
        }).catch(error => toastr.error('Ocorreu um erro ao alterar essa aula'));

      $scope.editAula = {};
      $scope.showEditAula = false;
    }
  }

  $scope.deletarAula = (aula) => {
    aulaService.delete(aula)
    .then(response => {
        toastr.info('Aula deletada com sucesso.')
        list();
    }).catch(error => toastr.error('Ocorreu um erro ao deletar a aula.'));
  }

  function list() {
    aulaService.list().then((response) => $scope.aulas = response.data);
		instrutorService.list().then((response) => $scope.instrutores = response.data);
  }

});

