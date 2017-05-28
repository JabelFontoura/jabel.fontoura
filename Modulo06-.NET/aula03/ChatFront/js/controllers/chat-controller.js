angular.module('app').controller('ChatController', function($scope, $window, chatService, loginService, toastr) {

  if(localStorage.getItem("Usuario") === null) sair();

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

$scope.sair = sair;

function sair() {
  localStorage.clear();
  $window.location.href = '#!/';
}

  function listar() {
    chatService.list()
      .then(response => {
        if($scope.mensagens.length !== response.data.length) {
          $scope.mensagens = response.data
        }
      });
  }
});