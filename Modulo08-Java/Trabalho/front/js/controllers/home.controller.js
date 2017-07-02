angular.module('app').controller('HomeController', function ($scope, $location, authService, usuarioService, amigosService, postService, comentarioService, toastr, $localStorage) {

  init();

  $scope.postar = (post) => {
    post.idUsuario = { id: $scope.usuario.id };
    postService.create(post)
      .then(response => init())
      .catch(error => console.log(error));

    post = {};
  }

  $scope.comentar = (comentario, idPost) => {
    comentario.idUsuario = { id: $scope.usuario.id };
    comentario.idPost = { id: idPost };

    comentarioService.create(comentario)
      .then(response => init())
      .catch(error => console.log(error));

    post = {};
  }

  $scope.showComentarPost = (id) => {
    $scope.showComentar = true;
    $scope.postComentar = id;
  }

  function init() {
    $scope.showComentar = false;
    $scope.postComentar = null;

    usuarioService.getLogged()
      .then(response => {
        $scope.usuario = response.data.dados;

        loadQtoSolicitacoes($scope.usuario.id, 'P');
        loadPosts($scope.usuario.id);
      })
      .catch(error => {
        console.log(error);
        $location.path('/login');
      });
  }

  function loadQtoSolicitacoes(id, aceito) {
    amigosService.countAceitos(id, aceito)
      .then(response => $scope.usuario.qtoSolicitacoes = response.data)
      .catch(error => console.log(error));
  }

  function loadPosts(id) {
    postService.findAllByIdUsuario(id)
      .then(response => {
        $scope.posts = response.data;

        $scope.posts.forEach(item => {
          loadCountPost(item);
          
          loadPostComments(item);
        });
      })
      .catch(error => console.log(error));
  }

  function loadCountPost(item) {
    comentarioService.countByIdPost(item.id)
      .then(response => item.qtoComentarios = response.data)
      .catch(error => console.log(error));
  }

  function loadPostComments(item) {
    comentarioService.findAll(item.id)
      .then(response => item.comentarios = response.data)
      .catch(error => console.log(error));
  }

  function loadFriends(id) {
    amigosService.findAllByIdUsuario(id)
      .then(response => {

      })
  }

});