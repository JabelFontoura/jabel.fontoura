angular.module('app').controller('LoginController', function ($scope, $window, loginService, toastr) {

  $scope.addUsuario = (usuario) => {
    if($scope.novoUsuario.$valid){
      loginService.create(usuario)
        .then(response => {
          $window.location.href = '#!/chat';
          toastr.success(`${usuario.Nome} entrou no chat.`)
        })
        .catch(error => toastr.error('Ocorreu um erro ao entrar no chat.'));
    }
  }
});