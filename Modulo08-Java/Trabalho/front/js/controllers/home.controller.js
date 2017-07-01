angular.module('app').controller('HomeController', function ($scope, $location, authService, usuarioService, amigosService, toastr, $localStorage) {

    init();

  function init() {
    usuarioService.getLogged()
      .then(response => {
        $scope.usuario = response.data.dados;

        amigosService.countAceitos($scope.usuario.id, 'P')
          .then(response => $scope.usuario.qtoSolicitacoes = response.data)
          .catch(error => console.log(error));

      })
      .catch(error => console.log(error));

    
  }
});