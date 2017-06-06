angular.module('app').controller('UsuarioController', function ($scope, $location, authService, toastr, $localStorage) {

  $scope.$on('$locationChangeStart', function(event) {
    init();
  });

  $scope.login = function (usuario) {
    authService.login(usuario)
      .then(
        function (response) {
          $scope.logado = true;
          $location.path('/administrativo');
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

  function init() {
    if($localStorage.usuarioLogado == null) {
      $scope.logado = false;

      if($location.path() === '/administrativo')
        toastr.info('Você precisa se autenticar para entrar aqui.');
      
      visitasAdministrativo = 0;

      $location.path('/');
    } else {
      $scope.logado = true;
    }
  }
});