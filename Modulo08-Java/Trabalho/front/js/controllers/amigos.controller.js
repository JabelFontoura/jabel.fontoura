angular.module('app').controller('AmigosController', function ($scope, $routeParams, $location, authService, usuarioService, amigosService, toastr, $localStorage) {

  init();

  function init() {
    usuarioService.findById($routeParams.id)
      .then(response => {
        $scope.usuario = response.data;

        amigosService.countAceitos($scope.usuario.id, 'P')
          .then(response => $scope.usuario.qtoSolicitacoes = response.data)
          .catch(error => console.log(error));

      })
      .catch(error => console.log(error));
  }
});