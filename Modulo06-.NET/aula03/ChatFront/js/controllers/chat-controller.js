angular.module('app').controller('ChatController', function($scope, $window, chatService, loginService, toastr) {

  const usuario = JSON.parse(localStorage.getItem("Usuario"));
  console.log(usuario);
  if(usuario === null) {
    $window.location.href = '#!/';
  }
  else {
    loginService.findById(usuario.Id).then(response => {
        console.log(response.data);
        if(response.data.length < 1) $window.location.href = '#!/';
      });
  }

  $scope.usuarioAtual = JSON.parse(localStorage.getItem("Usuario"));
  $scope.mensagens = {};

  setInterval(() => listar(), 2000);

  $scope.addMensagem = (mensagem) => {
    mensagem.Usuario = $scope.usuarioAtual;

    chatService.create(mensagem)
      .then(listar())
      .catch(error => {
        console.log(error);
        toastr.error("Ocorreu um erro ao enviar a mensagem.")
      });

      $scope.mensagem = {};
  }

$scope.sair = () => {
  localStorage.clear();
  $window.location.href = '#!/';  
}

  function listar() {
    chatService.list()
      .then(response => {
        if($scope.mensagens.length !== response.data.length) {
          $scope.mensagens = response.data;
        }
      });
  }
});