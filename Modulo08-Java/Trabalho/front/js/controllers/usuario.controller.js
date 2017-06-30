angular.module('app').controller('UsuarioController', function ($scope, $location, authService, toastr, $localStorage) {

  $scope.$on('$locationChangeStart', function(event) {
    init();
  });

  $scope.logar = function (usuario) {
    authService.login(usuario)
      .then(
        function (response) {
          $scope.logado = true;
          toastr.success(`Bem vindo ${response.nome}`);
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
      console.log('lala');
      $location.path('/login');
    } else {
      $scope.logado = true;
    }
  }
});