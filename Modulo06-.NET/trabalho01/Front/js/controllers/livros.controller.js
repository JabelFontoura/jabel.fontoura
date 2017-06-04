angular.module('app').controller('LivrosController', function ($scope, livrosService, toastr) {
  
  let paginaAtual = 1;

  init();

  $scope.irParaPagina = (num) => {
    if(num > paginaAtual) 
      $scope.parametros.quantidadePular = (num - 1) * $scope.parametros.quantidadeTrazer;
    else if(num < paginaAtual)
      $scope.parametros.quantidadePular = (num - 1) * $scope.parametros.quantidadeTrazer;

    listar();
    paginaAtual = num;
  }

  $scope.avancar = () => {
    $scope.parametros.quantidadePular += $scope.parametros.quantidadeTrazer;
    paginaAtual++;    
    listar();
  }

  $scope.voltar = () => {
    $scope.parametros.quantidadePular -= $scope.parametros.quantidadeTrazer;
    paginaAtual--;    
    if($scope.parametros.quantidadePular < 0){
       $scope.parametros.quantidadePular = 0;
       paginaAtual = 1;
    }
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

  function gerarQuantidadePaginas(num) {
    $scope.totalLivros = [];
    for(var i = 1; i <= Math.ceil(num); i++) 
      $scope.totalLivros.push({indice: i}); 
  }

  function init() {
    livrosService.getQuantidadeTotal()
      .then(response => gerarQuantidadePaginas(response.data.dados / 5))
      .catch(error => console.log(error));

    $scope.parametros = {
        quantidadePular: 0,
        quantidadeTrazer: 5
      };

    listar();
  }
});