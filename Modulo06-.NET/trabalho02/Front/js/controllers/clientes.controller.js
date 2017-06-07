angular.module('app').controller('ClientesController', function($scope, $localStorage, clientesService) {

  init();

  $scope.avancar = (cliente) => {
    $scope.escolherCliente = false;

    if(cliente.Id === 'novo') cliente.Id = null;
    else cliente.Nome = null;

    console.log(cliente);
  }

  function init() {
    listar();

    $scope.escolherCliente = true;
    $scope.escolherPacote = false;
    $scope.escolherOpcionais = false;
  }

  function listar() {
    clientesService.listar($localStorage.headerAuth)
      .then(response => $scope.clientes = response.data.dados)
      .catch(error => console.log(error));
  }

}); 