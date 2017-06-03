angular.module('app').controller('UsuarioController', function ($scope, authService, toastr) {
  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          $scope.logado = true;
          toastr.success(`Bem vindo ${response.data.dados.Nome}`);
        },
        function (response) {
          $scope.logado = false;
          toastr.error('Ocorreu um error ao fazer seu login.');
        });
  };

  $scope.logout = () => {
    authService.logout();
    $scope.logado = false;
  }
});