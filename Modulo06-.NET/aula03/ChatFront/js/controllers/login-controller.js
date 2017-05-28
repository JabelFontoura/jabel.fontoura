angular.module('app').controller('LoginController', function ($scope, $window, loginService, toastr) {

    if(localStorage.getItem("Usuario") !== null)
      entrouComSucesso(localStorage.getItem("Usuario"));

  $scope.addUsuario = (usuario) => {
    if($scope.novoUsuario.$valid){
      loginService.create(usuario)
        .then(response => {
          localStorage.setItem("Usuario", usuario);
          entrouComSucesso(usuario);
        })
        .catch(error => toastr.error('Ocorreu um erro ao entrar no chat.'));
    }
  }

  function entrouComSucesso(usuario) {
    $window.location.href = '#!/chat';
    toastr.success(`${usuario.Nome} entrou no chat.`);
  }
});