const module = angular.module('crud', []);

module.controller('MainController', ($scope) => {
  let id = 0;
  $scope.aulas = [];
  $scope.instrutores = [];

  $scope.adicionarAula = () => {
    if($scope.createAula.$valid) {
      $scope.aulas.forEach(item => $scope.createAulaExiste = item.nome === $scope.novaAula.nome);
      if(!$scope.createAulaExiste){
        $scope.novaAula.id = id++;
        $scope.aulas.push(angular.copy($scope.novaAula));
      }
      $scope.novaAula = {};
    }
  }

  $scope.editarAula = () => {
    if($scope.updateAula.$valid) {
      $scope.aulas.forEach(item => $scope.editAulaExiste = item.nome === $scope.editAula.nome);
      if(!$scope.editAulaExiste){
        $scope.aulas.forEach((item) => {
          if(item.id === Number($scope.idUpdate)) 
            item.nome = $scope.editAula.nome;
        });
      }
      $scope.editAula = {};
      $scope.showEdit = false;
    }
  }

  $scope.deletarAula = (id) => {
    console.log(getIdIndex(id));
      $scope.aulas.splice(getIdIndex(id), 1);
  }

  $scope.mostrarAula = (item) => {
    $scope.editAula = {};
    $scope.showEdit = true;
    $scope.idUpdate = item.id;
    $scope.editAula.nome = item.nome;
  }

  $scope.adicionarInstrutor = () => {
    if($scope.createInstrutor.$valid) {
      $scope.aulas.forEach(item => $scope.createInstrutorExiste = item.nome === $scope.novoInstrutor.nome);
      if(!$scope.createInstrutorExiste){
        $scope.novoInstrutor.id = id++;
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));
      }
      $scope.novoInstrutor = {};
    }
  }

  $scope.editarInstrutor = () => {

  }

  function getIdIndex(id) {
    for(let i = 0; i < $scope.aulas.length; i++) 
        if($scope.aulas[i].id === id) return i;
      
      return -1;
  }
});