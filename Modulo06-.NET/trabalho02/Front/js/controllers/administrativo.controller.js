angular.module('app').controller('AdministrativoController', function($scope, $localStorage, $location, clientesService, locacaoService, produtosService, toastr) {

  init();

  $scope.avancarCliente = (cliente) => {
      $scope.escolherCliente = false;
      $scope.escolherProduto = true;

      if(cliente.Id === 'novo') {
        cliente.Id = null;
        clientesService.criar(cliente, $localStorage.headerAuth)
        .then(response => toast.success('Cliente inserido com sucesso.'))
        .catch(error => { 
          console.log(error);
          $scope.escolherCliente = false;
          $scope.escolherProduto = true;
        });
      }
  }

  $scope.voltarCliente = () => {
    $scope.escolherCliente = true;
    $scope.escolherProduto = false;
  }

  $scope.avancarProduto = () => {
    $scope.escolherProduto = false;
    $scope.escolherPacote = true;
  }

  $scope.voltarProduto = () => {
    $scope.escolherCliente = true;
    $scope.escolherProduto = false;
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

      locacaoService.listarPacotes($localStorage.headerAuth)
        .then(response => $scope.pacotes = response.data.dados)
        .catch(error => console.log(error));
  }

}); 