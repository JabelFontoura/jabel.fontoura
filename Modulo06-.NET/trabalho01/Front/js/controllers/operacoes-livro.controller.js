angular.module('app').controller('OperacoesLivroController', function ($scope, $localStorage, livrosService, autoresService, revisoresService, authService, toastr) {
  
  init();
  function init() {

    autoresService.listar()
      .then(response => $scope.Autores = response.data.dados)
      .catch(error => console.log(error));

    $scope.isRevisor = authService.possuiPermissao("Revisor");
    $scope.isPublicador = authService.possuiPermissao("Publicador");
    
    listar();
  }

  $scope.showAdicionar = () => {
      limparTudo()
      $scope.livro = {};
      $scope.showAdicionarComponent = true
          
      $scope.salvar = (livro) => {

        if(livro.IdAutor === 'novo') livro.IdAutor = null;
        else livro.Autor = null;

        livrosService.criar(livro, $localStorage.headerAuth)
        .then(response => toastr.success('Livro cadastrado com sucesso'))
        .catch(error => console.log(error));

        livro = {};
        $scope.showAdicionarComponent = false;
      }

    };
    $scope.showAlterar = () => {
      listar();
      limparTudo()
      $scope.showAlterarComponent = true;
      
      $scope.nomeOperacao = 'editar';

      $scope.executar = (isbn) => {
        buscarPorIsbn(isbn);
          
          $scope.showEditarForm = true;
          $scope.showAlterarComponent = false;
      }

      $scope.salvar =  (livro) => {
        if(livro.IdAutor === 'novo') livro.IdAutor = null;
        else livro.Autor = null;

        livrosService.alterar(livro, $localStorage.headerAuth)
        .then(response => toastr.success('Livro Editado com sucesso'))
        .catch(error => console.log(error));

        $scope.showEditarForm = false;
        livro = {};
      }
    }; 

    $scope.showRemover = () => {
      listar();
      limparTudo()
      $scope.showRemoverComponent = true;
      $scope.nomeOperacao = 'remover';
      

      $scope.executar = (isbn) => {
        buscarPorIsbn(isbn);

        $scope.showRemoverComponent = false;
        $scope.showConfirmacaoRemover = true;
      }

      $scope.salvar = (livro) => {
        livrosService.remover(livro.Isbn)
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
      $scope.nomeOperacao = 'revisar';

      livrosService.listarLivrosSemRevisao()
        .then(response => $scope.livros = response.data.dados)
        .catch(error => console.log(error));

      $scope.executar = (isbn) => {
        buscarPorIsbn(isbn);

        revisoresService.listar(isbn)
          .then(response => $scope.revisores = response.data.dados)
          .catch(error => console.log(error));
          
        $scope.showRevisarComponent = false;
        $scope.showRevisarForm = true;
      }

      $scope.salvar = (livro) => {
        if(livro.IdRevisor === 'novo') livro.IdRevisor = null;
        else livro.Revisor = null;
        
        if(livro.Revisor !== null) {
          revisoresService.criar(livro.Revisor)
            .then(response => {
              livro.IdRevisor = response.data.dados.IdRevisor
              atualizarRevisor();
            })
            .catch(error => console.log(error));

          livro.Revisor = null;
        } else {
          atualizarRevisor()
        }

        livro.DataRevisao = new Date().toLocaleDateString();

        $scope.showEditarForm = false;
        livro = {};

        function atualizarRevisor() {
          livrosService.alterar(livro, $localStorage.headerAuth, 'revisar/')
          .then(response => toastr.success('Livro revisado com sucesso'))
          .catch(error => console.log(error));
        }
      }

    }; 
    $scope.showPublicar = () => {
      livrosService.listarLivrosRevisados()
        .then(response => $scope.livros = response.data.dados)
        .catch(error => console.log(error));

      limparTudo()
      $scope.showPublicarComponent = true;
      $scope.nomeOperacao = 'publicar';

      $scope.executar = (isbn) => {
        buscarPorIsbn(isbn);

        $scope.showPublicarComponent = false;
        $scope.showConfirmacaoPublicar = true;
      }

      $scope.salvar = (livro) => {
        livro.DataPublicacao = new Date().toLocaleDateString();

        livrosService.alterar(livro, $localStorage.headerAuth, 'publicar/')
          .then(response => toastr.success('Livro publicado com sucesso'))
          .catch(error => console.log(error));

        $scope.showConfirmacaoPublicar = false;
        $scope.livro = {};
      }

      $scope.sair = () => {
        toastr.info('Operação cancelada.');
        $scope.showConfirmacaoPublicar = false;
        $scope.livro = {};
      }

    };

    function listar() {
      livrosService.listar()
      .then(response => $scope.livros = response.data.dados)
      .catch(error => console.log(error));
    }

    function buscarPorIsbn(isbn) {
      livrosService.findById(isbn)
        .then(response => $scope.livro = response.data.dados)
        .catch(error => console.log(error));
    }

    function limparTudo() {
      $scope.showPublicarComponent = false;
      $scope.showAdicionarComponent = false
      $scope.showAlterarComponent = false;
      $scope.showRemoverComponent = false;
      $scope.showRevisarComponent = false;
      $scope.showEditarForm = false;
      $scope.showConfirmacaoRemover = false;
      $scope.showRevisarForm = false;
      $scope.showConfirmacaoPublicar = false;
    }  
});