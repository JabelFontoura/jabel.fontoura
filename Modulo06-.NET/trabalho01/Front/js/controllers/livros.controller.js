angular.module('app').controller('LivrosController', function ($scope, livrosService) {
  let paginaAtual = 1;

  livrosService.listar()
    .then(response => gerarQuantidadePaginas(response.data.dados.length / 5))
    .catch(error => console.log(error));

  $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 5
    };

  listar();

  $scope.irParaPagina = (num) => {
    let result = 0;

    if(num > paginaAtual) 
      $scope.parametros.quantidadePular += (num - 1) * 5;
    else if(num < paginaAtual)
      $scope.parametros.quantidadePular -= (num) * 5
    
    console.log('pular',$scope.parametros.quantidadePular);
    console.log('num', num);
    console.log('pagina', paginaAtual);
    listar();
    paginaAtual = num;
  }

  $scope.avancar = () => {
    $scope.parametros.quantidadePular += 5;
    listar();
  }

  $scope.voltar = () => {
    $scope.parametros.quantidadePular -= 5;
    if($scope.parametros.quantidadePular < 0) $scope.parametros.quantidadePular = 0;
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
});