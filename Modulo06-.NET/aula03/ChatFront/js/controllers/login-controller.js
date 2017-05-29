angular.module('app').controller('LoginController', function ($scope, $window, loginService, toastr) {

    if(localStorage.getItem("Usuario") !== null){
      entrar(JSON.parse(localStorage.getItem("Usuario")));
    }

  $scope.addUsuario = (usuario) => {
    if($scope.novoUsuario.$valid){
      criarUsuarioNoServidor(usuario);
    }
  }

  function criarUsuarioNoServidor(usuario) {
    loginService.create(usuario)
        .then(response => {
          localStorage.setItem("Usuario", JSON.stringify(response.data));
          entrar(JSON.parse(localStorage.getItem("Usuario")));
        })
        .catch(error => {
          toastr.error('Ocorreu um erro ao entrar no chat.');
          console.log(error);
        });
  }

  function entrar(usuario) {
    $window.location.href = '#!/chat';
    toastr.success(`${usuario.Nome} entrou no chat.`);
    loginService.findById(usuario.Id).then(response => {
      if(response.data.length < 1) criarUsuarioNoServidor(usuario);
    });
  }
});