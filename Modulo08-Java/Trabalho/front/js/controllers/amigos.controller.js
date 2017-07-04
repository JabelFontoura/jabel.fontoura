angular
  .module("app")
  .controller("AmigosController", function(
    $scope,
    $routeParams,
    $location,
    authService,
    usuarioService,
    amigosService,
    postService,
    comentarioService,
    curtidaService,
    toastr,
    $localStorage
  ) {

    init();

    $scope.comentar = (comentario, idPost) => {
    comentario.idUsuario = { id: $scope.usuarioLogado.id };
    comentario.idPost = { id: idPost };

    comentarioService.create(comentario)
      .then(response => loadPosts($scope.usuarioLogado.id, $scope.pagina))
      .catch(error => console.log(error));

    post = {};
  }

  $scope.showComentarPost = (id) => {
    $scope.showComentar = true;
    $scope.postComentar = id;
  }

  $scope.curtir = (idPost) => {
    curtidaService.create({
      idPost: { id: idPost },
      idUsuario: { id: $scope.usuarioLogado.id }
    })
      .then(response => loadPosts($scope.usuario.id, $scope.pagina))
      .catch(error => console.log(error));
  }

  $scope.descurtir = (curtidas) => {
    let idCurtida;
    curtidas.forEach(item => {
      if(item.idUsuario.id === $scope.usuarioLogado.id) idCurtida = item.id;
    });

    curtidaService.delete(idCurtida)
      .then(response => loadPosts($scope.usuario.id, $scope.pagina))
      .catch(error => console.log(error));
  }

    $scope.avancar = () => {
      loadPosts($scope.usuario.id, ++$scope.pagina);
    }

    function init() {
      $scope.pagina = 0;

      usuarioService
        .getLogged()
        .then(response => {
          $scope.usuarioLogado = response.data.dados;

          amigosService
            .findAllByIdUsuario($scope.usuarioLogado.id, "A")
            .then(response => $scope.amigos = response.data)
            .catch(error => console.log(error));
        })
        .catch(error => $location.path("/login"));

      if ($routeParams.id) {
        usuarioService
          .findById($routeParams.id)
          .then(response => {
            $scope.usuario = response.data;

            loadQtoSolicitacoes($scope.usuario.id, "P");
            loadPosts($scope.usuario.id, $scope.pagina);
          })
          .catch(error => console.log(error));
      }
    }

    function loadQtoSolicitacoes(id, aceito) {
      amigosService
        .countAceitos(id, aceito)
        .then(response => $scope.usuario.qtoSolicitacoes = response.data)
        .catch(error => console.log(error));
    }

    function loadPosts(id, pagina) {
      postService.findAllByIdUsuario(id, pagina)
        .then(response => {
        $scope.postsPages = response.data;
        $scope.posts = $scope.postsPages.content;

          $scope.posts.forEach(item => {
            loadCountCommentsPost(item);
            loadCountLikesPost(item);
            loadPostComments(item);
            loadLikedPosts(item);
          });
        })
        .catch(error => console.log(error));
    }

    function loadCountCommentsPost(item) {
      comentarioService
        .countByIdPost(item.id)
        .then(response => item.qtoComentarios = response.data)
        .catch(error => console.log(error));
    }

    function loadPostComments(item) {
      comentarioService
        .findAll(item.id)
        .then(response => item.comentarios = response.data)
        .catch(error => console.log(error));
    }

    function loadCountLikesPost(item) {
      curtidaService
        .countByIdPost(item.id)
        .then(response => item.qtoCurtidas = response.data)
        .catch(error => console.log(error));
    }
    function loadLikedPosts(item) {
      curtidaService
        .findByIdPost(item.id)
        .then(response => {
          item.curtidas = response.data;
          item.curtidas.forEach(e => {
            if (e.idUsuario.id === $scope.usuarioLogado.id) item.isLiked = true;
          });
        })
        .catch(error => console.log(error));
    }
  });
