angular.module('app').controller('OperacoesLivroController', function ($scope, $localStorage, livrosService, autoresService, authService, toastr) {
  
  init();
  function init() {

    autoresService.listar()
      .then(response => $scope.autores = response.data.dados)
      .catch(error => console.log(error));

    $scope.isRevisor = authService.possuiPermissao("Revisor");
    $scope.isPublicador = authService.possuiPermissao("Publicador");
    
    livrosService.listar()
      .then(response => $scope.livros = response.data.dados)
      .catch(error => console.log(error));

  }

  $scope.showAdicionar = () => {
      limparTudo()
      $scope.livro = {};
      $scope.showAdicionarComponent = true
          
      $scope.salvar = (livro) => {

        if($scope.IdAutor === 'novo') $scope.IdAutor = null;
        else $scope.Autor = null;

        livrosService.criar(livro, $localStorage.headerAuth)
        .then(response => toastr.success('Livro cadastrado com sucesso'))
        .catch(error => console.log(error));

        livro = {};
        $scope.showAdicionarComponent = false;
      }

    };
    $scope.showAlterar = () => {
      limparTudo()
      $scope.showAlterarComponent = true;
      
      $scope.nomeOperacao = 'editar';

      $scope.executar = (isbn) => {
        livrosService.findById(isbn)
          .then(response => $scope.livro = response.data.dados.mensagens)
          .catch(error => console.log(error));
          
          $scope.showEditarForm = true;
          $scope.showAlterarComponent = false;
      }

      $scope.salvar =  (livro) => {
        if($scope.IdAutor === 'novo') $scope.IdAutor = null;
        else $scope.Autor = null;

        livrosService.alterar(livro, $localStorage.headerAuth)
        .then(response => toastr.success('Livro Editado com sucesso'))
        .catch(error => console.log(error));

        $scope.showEditarForm = true;
        livro = {};
      }
    }; 
    $scope.showRemover = () => {
      limparTudo()
      $scope.showRemoverComponent = true;
      $scope.nomeOperacao = 'remover';
      

      $scope.executar = (isbn) => {
        livrosService.findById(isbn)
          .then(response => $scope.livro = response.data.dados)
          .catch(error => console.log(error));

        $scope.showRemoverComponent = false;
        $scope.showConfirmacaoRemover = true;
      }

      $scope.salvar = (isbn) => {
        livrosService.remover(isbn)
          .then(response => toastr.info(response.data.dados))
          .catch(error => console.log(error));

        $scope.showConfirmacaoRemover = false;
        $scope.livro = {};
      }

      $scope.sair = () => {
        oastr.info('Operação cancelada.');
        $scope.showConfirmacaoRemover = false;
        $scope.livro = {};
      }
      
    };
    $scope.showRevisar = () => {
      limparTudo()
      $scope.showRevisarComponent = true;
    }; 
    $scope.showPublicar = () => {
      limparTudo()
      $scope.showPublicarComponent = true;
    };

    function limparTudo() {
      $scope.showPublicarComponent = false;
      $scope.showAdicionarComponent = false
      $scope.showAlterarComponent = false;
      $scope.showRemoverComponent = false;
      $scope.showRevisarComponent = false;
      $scope.showEditarForm = false;
      $scope.showConfirmacaoRemover = false;
    }  
});