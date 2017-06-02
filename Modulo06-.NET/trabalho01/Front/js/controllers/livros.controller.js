angular.module('app').controller('LivrosController', function ($scope, livrosService) {

  $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 5
    };

  listar();

  $scope.voltar = () => {
    $scope.parametros.quantidadePular -= 5;
    if($scope.parametros.quantidadePular < 0) $scope.parametros.quantidadePular = 0;

    listar();
  }

  $scope.avancar = () => {
    $scope.parametros.quantidadePular += 5;
    listar();
  }
  
  function listar() {
    livrosService.listarLancamentos($scope.parametros)
      .then(response => $scope.lancamentos = response.data.dados)
      .catch(error => console.log(error));

    livrosService.listar($scope.parametros)
      .then(response => $scope.livros = response.data.dados)
      .catch(error => console.log(error));
  }
});