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

    function init() {
      usuarioService
        .getLogged()
        .then(response => {
          $scope.usuario = response.data.dados;

          amigosService
            .findAllByIdUsuario($scope.usuario.id, "A")
            .then(response => $scope.amigos = response.data)
            .then(error => console.log(error));
        })
        .catch(error => $location.path("/login"));

      if ($routeParams.id) {
        usuarioService
          .findById($routeParams.id)
          .then(response => {
            $scope.usuario = response.data;

            loadQtoSolicitacoes($scope.usuario.id, "P");
            loadPosts($scope.usuario.id);
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

    function loadPosts(id) {
      postService
        .findAllByIdUsuario(id)
        .then(response => {
          $scope.posts = response.data;

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
            if (e.idUsuario.id === $scope.usuario.id) item.isLiked = true;
          });
        })
        .catch(error => console.log(error));
    }
  });
