angular.module('app').controller('LivroController', function ($scope, $routeParams, livrosService) {
  
  init();

  function listar(isbn) {
    livrosService.findById(isbn)
      .then(response => $scope.livro = response.data.dados)
      .catch(error => console.log(errpr));
  }

  function init () {
    listar($routeParams.isbn)
  }
});