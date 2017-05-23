angular.module('crud').controller('InstrutorController', ($scope, toastr, aulaService, instrutorService) => {

  list();

$scope.adicionarInstrutor = () => {
    if($scope.createInstrutor.$valid) {
      instrutorService.create($scope.novoInstrutor, getValorCheckbox('checkbox-aula'));
      $scope.novoInstrutor = {};
    }
  }

  $scope.mostrarInstrutor = (item) => {
    $scope.editInstrutor = {};
    $scope.showEditInstrutor = true;
    $scope.editInstrutor = Object.assign({}, item);
    $scope.editInstrutor.id = item.id;
  }


  $scope.editarInstrutor = () => {
    if($scope.updateInstrutor.$valid) {
      $scope.editInstrutor.aulas = getValorCheckbox('checkbox-edit-aula');
      instrutorService.update($scope.editInstrutor);
      $scope.editInstrutor = {};
      $scope.showEditInstrutor = false;
    }
  }

  $scope.deletarInstrutor = (instrutor) => {
    instrutorService.delete(instrutor);
  }

  $scope.getCheckedAula = (id) => {
    if(!angular.isUndefined($scope.editInstrutor) && Object.keys($scope.editInstrutor).length > 0) {
      for(aula of $scope.editInstrutor.aulas) 
        if(aula.id === id) return true;
    }
      return false;
  }

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
		instrutorService.list().then(function (response) {
      $scope.instrutores = response.data;
    });
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

});