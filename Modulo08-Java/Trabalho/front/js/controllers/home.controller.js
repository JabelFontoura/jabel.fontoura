angular.module('app').controller('HomeController', function ($scope, $location, authService, usuarioService, toastr, $localStorage) {

    init();

  function init() {
    usuarioService.getLogged()
      .then(response => $scope.usuario = response.data.dados)
      .catch(error => console.log(error));
  }
});