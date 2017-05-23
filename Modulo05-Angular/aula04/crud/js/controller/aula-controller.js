angular.module('crud').controller('AulaController', ($scope, $routeParams, toastr, aulaService, instrutorService) => {

  list();

  $scope.adicionarAula = () => {
    if($scope.createAula.$valid) {
      aulaService.create($scope.novaAula);
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
			aulaService.update($scope.editAula);

      // $scope.aulas.forEach(item => $scope.editAulaExiste = item.nome === $scope.editAula.nome);
      // if(!$scope.editAulaExiste){
      //   $scope.aulas.forEach((item) => {
      //     if(item.id === Number($scope.idAulaUpdate)) 
      //       item.nome = $scope.editAula.nome;
      //   });
      // }
      $scope.editAula = {};
      $scope.showEditAula = false;
    }
  }

  $scope.deletarAula = (aula) => {
		if(!aulaSendoUsada(aula.id)){
    	aulaService.delete(aula);
			toastr.info('Aula deletada com sucesso.');
    } else {
      toastr.error('Não é possível excluir esta aula. Está sendo utilizada.');
    }
  }

  function aulaSendoUsada(id) {
    if(!angular.isUndefined($scope.instrutores) && Object.keys($scope.instrutores).length > 0) {
			console.log($scope.instrutores);
      for(instrutor of $scope.instrutores)
        for(aula of instrutor.aulas)
          if(aula === id) return true;
    }
		return false;
  }

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
		instrutorService.list().then(function (response) {
      $scope.instrutores = response.data;
    });
  }

});

