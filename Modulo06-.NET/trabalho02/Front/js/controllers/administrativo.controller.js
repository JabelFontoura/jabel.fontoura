angular.module('app').controller('AdministrativoController', function($scope, $localStorage, $location, clientesService, locacaoService, produtosService) {

  init();

  $scope.avancarCliente = (cliente) => {
      $scope.escolherCliente = false;
      $scope.escolherProduto = true;

      if(cliente.Id === 'novo') cliente.Id = null;
  }

  $scope.voltarCliente = () => {
    $scope.escolherCliente = true;
    $scope.escolherProduto = false;
  }

  $scope.avancarProduto = () => {
    
  }

  function init() {
    listar();

    $scope.escolherCliente = true;
    $scope.escolherPacote = false;
    $scope.escolherProduto = false;
    $scope.escolherOpcionais = false;
  }

  function listar() {
    clientesService.listar($localStorage.headerAuth)
      .then(response => $scope.clientes = response.data.dados)
      .catch(error => console.log(error));

      produtosService.listarDisponiveis($localStorage.headerAuth)
        .then(response => $scope.produtos = response.data.dados)
        .catch(error => console.log(error));
  }

}); 