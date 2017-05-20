const module = angular.module('crud', []);

module.controller('MainController', ($scope) => {
  let id = 0;
  $scope.aulas = [];
  $scope.instrutores = [];

  $scope.adicionar = () => {
    if($scope.create.$valid) {
      $scope.novaAula.id = id++;
      $scope.aulas.push(angular.copy($scope.novaAula));
      $scope.novaAula = {};
    }
  }

  $scope.editar = () => {
    if($scope.update.$valid) {
      $scope.aulas.forEach((item) => {
        if(item.id === Number($scope.idUpdate)) 
          item.nome = $scope.edit.nome;
      });
    }
  }

  $scope.deletar = () => {
    if($scope.delete.$valid) {
      $scope.aulas.forEach((item) => {
        if(item.id === Number($scope.idDelete)) {
          $scope.aulas.splice(item.id, 1);
        }
      });
    }
  }
});