angular.module('app').controller('AdministrativoController', function($scope, $localStorage, $location, clientesService, locacaoService, produtosService, extrasService, authService, toastr) {

  init();

  $scope.avancarCliente = (cliente) => {
      limpar();
      $scope.escolherProduto = true;
      cliente.DataNascimento = new Date(cliente.DataNascimento).toLocaleDateString();
      if(cliente.Id === 'novo') {
        cliente.Id = null;
        clientesService.criar(cliente, $localStorage.headerAuth)
        .then(response => {
          toastr.success('Cliente inserido com sucesso.');
          $scope.cliente = response.data.dados.Id;
        })
        .catch(error => { 
          console.log(error);
          $scope.escolherCliente = false;
          $scope.escolherProduto = true;
        });
      } else {
        $scope.cliente = cliente.Id;
      }
  }

  $scope.voltarCliente = () => {
    limpar();
    $scope.escolherCliente = true;
  }

  $scope.avancarProduto = (produto) => {
    limpar();

    $scope.produto = produto;    
    $scope.valor += Number(produto.Valor);
    $scope.escolherPacote = true;
  }

  $scope.voltarProduto = () => {
    limpar();

    $scope.produto = null;
    $scope.escolherCliente = true;
    $scope.valor = 0;
  }

  $scope.avancarPacote = (pacote) => {
    limpar();
    if(typeof pacote !== 'undefined') {
      $scope.pacote = pacote;
      console.log(pacote);
      $scope.valor += Number(pacote.ValorTotal);
    } else {
      $scope.comData = true;
    }
    $scope.escolherExtras = true;
  }

  $scope.voltarPacote = () => {
    limpar();
    //$scope.valor -= $scope.pacote.Valor;
    $scope.escolherProduto = true;
  }

  $scope.avancarExtras = (extra) => {
    limpar();
    $scope.extrasSelecionados = extra;
    if(typeof extra !== 'undefined') {
      Object.getOwnPropertyNames(extra).forEach(item => {
        $scope.extras.forEach(e => {
          if(Number(item) === Number(e.Id)) $scope.valor += e.Valor * extra[item];
        });
      });
    }

    $scope.escolherExtras = false;

    if(typeof $scope.pacote !== 'undefined') {
      $scope.final = true;
      $scope.comData = false;
    } 
  }

  $scope.voltarExtras = () => {
    limpar();
    $scope.extrasSelecionados = extra;
    $scope.escolherExtras = true;
  }

  $scope.avancarData = data => {
    limpar();
    $scope.data = data;
    $scope.final = true;
    $scope.comData = false;
  }

  $scope.finalizar = () => {
    let data = new Date();
    if(typeof $scope.pacote !== 'undefined'){
      console.log(data);
      console.log($scope.pacote.DiasDuracao);
       data = data.setDate(data.getDate() + $scope.pacote.DiasDuracao); 
       console.log(data);
       data = data.toLocaleString();
    }
    else data.setDate($scope.data).toLocaleString();

    let locacao = {
      EmailUsuario: authService.getUsuario().Email,
      IdCliente: Number($scope.cliente),
      Produto: $scope.produto,
      IdExtra: 1,
      IdPacote: $scope.pacote.IdPacote,
      ExtraPacote: $scope.pacote,
      DataEntrega : new Date().toLocaleString(),
      DataPedido: data
    };
    
    console.log(locacao);

    locacaoService.criar(locacao, $localStorage.headerAuth)
  }

  function init() {
    listar();

    limpar();
    $scope.escolherCliente = true;
    $scope.valor = 0.00;
  }

  function limpar() {
    $scope.escolherCliente = false;
    $scope.escolherProduto = false;
    $scope.escolherPacote = false;
    $scope.escolherOpcionais = false;
    $scope.escolherExtras = false;
  }

  function listar() {
    clientesService.listar($localStorage.headerAuth)
      .then(response => $scope.clientes = response.data.dados)
      .catch(error => console.log(error));

      produtosService.listarDisponiveis($localStorage.headerAuth)
        .then(response => $scope.produtos = response.data.dados)
        .catch(error => console.log(error));

      extrasService.listarDisponiveis($localStorage.headerAuth)
        .then(response => $scope.extras = response.data.dados)
        .catch(error => console.log(error));

      locacaoService.listarPacotes($localStorage.headerAuth)
        .then(response => {
          $scope.pacotes = response.data.dados;

          let valor = 0;
          $scope.pacotes.forEach(item => {
            item.Extra.forEach(e => valor += (e.Valor * e.Quantidade));
            item.ValorTotal = valor.toFixed(2);
          });
        })
        .catch(error => console.log(error));
  }

}); 