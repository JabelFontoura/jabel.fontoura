angular.module('app').controller('UsuarioController', function ($scope, $location, authService, usuarioService, toastr, $localStorage) {

  $scope.$on('$locationChangeStart', function(event) {
    init();
  });

  $scope.criar = (usuario) => {
    usuarioService.create(usuario)
      .then(response => {
        $scope.logar(usuario);
        usuarioService.getLogged()
          .then(response => console.log(response))
          .catch(error => console.log(error));
      })
      .catch(error => console.log());
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

  $scope.logout = () => {
    authService.logout();
    $scope.logado = false;
  }

  function init() {
    if($localStorage.usuarioLogado === null) {
      $scope.logado = false;
      $location.path('/login');
    } else {
      $scope.logado = true;
    }
  }
});