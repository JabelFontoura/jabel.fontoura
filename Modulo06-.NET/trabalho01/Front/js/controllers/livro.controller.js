angular.module('app').controller('LivroController', function ($scope, $routeParams, livrosService) {
  
  listar($routeParams.isbn)

  function listar(isbn) {
    livrosService.findById(isbn)
      .then(response => $scope.livro = response.data.dados)
      .catch(error => console.log(errpr));
  }
});