angular.module('app').controller('LoginController', function ($scope, $window, loginService, toastr) {

    if(localStorage.getItem("Usuario") !== null){
      console.log(localStorage.getItem("Usuario"));
      entrouComSucesso(JSON.parse(localStorage.getItem("Usuario")));
    }

  $scope.addUsuario = (usuario) => {
    if($scope.novoUsuario.$valid){
      loginService.create(usuario)
        .then(response => {
          localStorage.setItem("Usuario", JSON.stringify(response.data));
          entrouComSucesso(JSON.parse(localStorage.getItem("Usuario")));
        })
        .catch(error => {
          toastr.error('Ocorreu um erro ao entrar no chat.');
          console.log(error);
        });
    }
  }

  function entrouComSucesso(usuario) {
    $window.location.href = '#!/chat';
    toastr.success(`${usuario.Nome} entrou no chat.`);
  }
});