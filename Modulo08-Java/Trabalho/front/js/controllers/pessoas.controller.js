angular.module('app').controller('PessoasController', function ($scope, $location, authService, usuarioService, amigosService, toastr, $localStorage) {

  init();

  $scope.adicionar = (idSolicitado) => {
    amigosService.create({
      idUsuario : { id: $scope.usuario.id },
      idAmigo: { id: idSolicitado },
      aceito: "P"
    }).then(response => console.log(response))
    .catch(error => console.log(error));

    location.reload();
  }

  function init() {
    if ($localStorage.usuarioLogado === null) {
      $scope.logado = false;
      $location.path('/login');
    } else {
      $scope.logado = true;
    }

    usuarioService.getLogged()
      .then(response => {
        $scope.usuario = response.data.dados;

        usuarioService.findByNaoAmigo($scope.usuario.id)
          .then(response => $scope.pessoas = response.data)
          .catch(error => console.log(error));

      })
      .catch(error => console.log(error));
  }
});