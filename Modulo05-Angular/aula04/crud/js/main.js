const app = angular.module('crud', ['ngRoute', 'ngAnimate', 'toastr']);

app.config(($routeProvider) => {
    $routeProvider
			.when('/aulas', {
					templateUrl: 'html/aulas.html'
					// controller: 'AulaController'
			})
      .when('/instrutores', {
					templateUrl: 'html/instrutores.html',
					controller: 'InstrutorController'
			})
			.otherwise({redirectTo: '/'});
});

app.controller('MainController', ($scope, toastr) => {
  let idInstrutor = 0;
  let idAula = 0;
  $scope.aulas = [{id: idAula++, nome: 'HTML & CSS'}, {id: idAula++, nome: 'Javascript'}, {id: idAula++, nome: 'Angular'}];
  $scope.instrutores = [];

  $scope.getCheckedAula = (id) => {
    if(!angular.isUndefined($scope.editInstrutor) && Object.keys($scope.editInstrutor).length > 0) {
      for(aula of $scope.editInstrutor.aulas) 
        if(aula.id === id) return true;
    }
      return false;
  }

  function aulaSendoUsada(id) {
    if(!angular.isUndefined($scope.instrutores) && Object.keys($scope.instrutores).length > 0) {
      for(instrutor of $scope.instrutores)
        for(aula of instrutor.aulas)
          if(aula.id === id) return true;
    }
      return false;
  }

  function getValorCheckbox(classe) {
    let result = [];
    let boxs = document.getElementsByClassName(classe);

    for(let i = 0; i< boxs.length; i++){ 
      if(boxs[i].checked) { 
        result.push(JSON.parse(boxs[i].value));
      }
      boxs[i].checked = false;
    }
      
    return result;
  }

  function getIdIndex(id, array) {
    for(let i = 0; i < array.length; i++) 
        if(array[i].id === id) return i;
      
      return -1;
  }
});