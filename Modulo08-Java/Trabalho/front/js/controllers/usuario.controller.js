angular.module('app').controller('UsuarioController', function ($scope, $location, authService, usuarioService, toastr, $localStorage) {

    init();

  $scope.criar = (usuario) => {
    usuarioService.create(usuario)
      .then(response => {
        $scope.logar(usuario);
      })
      .catch(error => {
        console.log();
        toastr.error('Ocorreu um erro ao criar essa conta');
    });
  }

  $scope.logar = function (usuario) {
    authService.login(usuario)
      .then(
        function (response) {
          $scope.logado = true;
          $location.path('/');
        },
        function (response) {
          $scope.logado = false;
          console.log('resp', response);
          toastr.error('Ocorreu um error ao fazer seu login.');
        });
  };

  function init() {
  if($location.path() !== '/login' && $location.path() !== '/cadastro') {
    usuarioService.getLogged()
      .then(response => {
        $scope.usuario = response.data.dados;
        $scope.usuario.dataNascimento = new Date($scope.usuario.dataNascimento);
        $scope.usuario.senha = '';
      })
      .catch(error => console.log(error));
  }

    if($localStorage.usuarioLogado === null) {
      $scope.logado = false;
      $location.path('/login');
    } else {
      $scope.logado = true;
    }
  }
});