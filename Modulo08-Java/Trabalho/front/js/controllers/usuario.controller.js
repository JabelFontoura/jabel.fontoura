angular.module('app').controller('UsuarioController', function ($scope, $location, authService, usuarioService, toastr, $localStorage) {

  $scope.$on('$locationChangeStart', function(event) {
    init();
  });

  $scope.criar = (usuario) => {
    usuario.id = 0;
    usuarioService.criar(usuario)
      .then(response => {
        toastr.success('Usuario criado com sucesso');
        $location.path('/');
      })
      .catch(error => console.log());
  }

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
      $location.path('/login');
    } else {
      $scope.logado = true;
    }
  }
});