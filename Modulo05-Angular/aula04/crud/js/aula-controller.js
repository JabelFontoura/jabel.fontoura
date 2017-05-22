angular.module('crud').controller('AulaController', ($scope, toastr) => {

  $scope.adicionarAula = () => {
    if($scope.createAula.$valid) {
      $scope.aulas.forEach(item => $scope.createAulaExiste = item.nome === $scope.novaAula.nome);
      if(!$scope.createAulaExiste){
        $scope.novaAula.id = idAula++;
        $scope.aulas.push(angular.copy($scope.novaAula));

        toastr.success('Aula inserida com sucesso.');
      } else {
        toastr.error('Aula já cadastrada.');
      }
      $scope.novaAula = {};
    }
  }

  $scope.mostrarAula = (item) => {
    $scope.editAula = {};
    $scope.showEditAula = true;
    $scope.idAulaUpdate = item.id;
    $scope.editAula.nome = item.nome;
  }

  $scope.editarAula = () => {
    if($scope.updateAula.$valid) {
      $scope.aulas.forEach(item => $scope.editAulaExiste = item.nome === $scope.editAula.nome);
      if(!$scope.editAulaExiste){
        $scope.aulas.forEach((item) => {
          if(item.id === Number($scope.idAulaUpdate)) 
            item.nome = $scope.editAula.nome;
        });
      }
      $scope.editAula = {};
      $scope.showEditAula = false;
    }
  }

  $scope.deletarAula = (id) => {
       $scope.aulaUsada = aulaSendoUsada(id);
       if(!$scope.aulaUsada){
        $scope.aulas.splice(getIdIndex(id, $scope.aulas), 1);
       } else {
         toastr.error('Não é possível excluir esta aula. Está sendo utilizada.');
       }
  }

});