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
      $scope.livro = {};

      $scope.showAdicionarComponent = true
      $scope.showAlterarComponent = false;
      $scope.showRemoverComponent = false;
      $scope.showPublicarComponent = false;
      $scope.showRevisarComponent = false;
      $scope.showEditarForm = false;
          
      $scope.salvar = (livro) => {

        if($scope.IdAutor === 'novo') $scope.IdAutor = null;
        else $scope.Autor = null;

        livrosService.create(livro, $localStorage.headerAuth)
        .then(response => toastr.success('Livro cadastrado com sucesso'))
        .catch(error => console.log(error));

        livro = {};
        $scope.showAdicionarComponent = false;
      }

    };
    $scope.showAlterar = () => {
      $scope.showAlterarComponent = true;
      $scope.showAdicionarComponent = false
      $scope.showRemoverComponent = false;
      $scope.showRevisarComponent = false;
      $scope.showPublicarComponent = false;
      $scope.showEditarForm = false;
      
      $scope.nomeOperacao = 'editar';

      $scope.executar = (isbn) => {
        livrosService.findById(isbn)
          .then(response => $scope.livro = response.data.dados)
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
      $scope.showRemoverComponent = true;
      $scope.showAdicionarComponent = false;
      $scope.showAlterarComponent = false;
      $scope.showRevisarComponent = false;
      $scope.showPublicarComponent = false;

      $scope.nomeOperacao = 'remover';
      

      $scope.executar = (isbn) => {

      }
    };
    $scope.showRevisar = () => {
      $scope.showRevisarComponent = true;
      $scope.showAdicionarComponent = false;
      $scope.showAlterarComponent = false;
      $scope.showRemoverComponent = false;
      $scope.showPublicarComponent = false;
    }; 
    $scope.showPublicar = () => {
      $scope.showPublicarComponent = true;
      $scope.showAdicionarComponent = false
      $scope.showAlterarComponent = false;
      $scope.showRemoverComponent = false;
      $scope.showRevisarComponent = false;
    };  
});