angular.module('app').controller('ProdutosController', function($scope, produtosService) {

  listar();

  function listar() {
    produtosService.listar()
      .then(response => $scope.produtos = response.data.dados)
      .catch(error => console.log(error));
  }
}); 