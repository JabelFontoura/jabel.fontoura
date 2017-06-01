angular.module('app').controller('LivrosController', function ($scope, livrosService) {

  listar();

  function listar() {
    livrosService.listarLancamentos()
      .then(response => $scope.lancamentos = response.data.dados)
      .catch(error => console.log(error));
      
    livrosService.listar()
      .then(response => $scope.livros = response.data.dados)
      .catch(error => console.log(error));
  }
});