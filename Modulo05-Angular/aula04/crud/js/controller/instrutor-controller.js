angular.module('crud').controller('InstrutorController', ($scope, toastr, aulaService, instrutorService) => {

  list();

$scope.adicionarInstrutor = () => {
    if($scope.createInstrutor.$valid) {
      instrutorService.create($scope.novoInstrutor, getValorCheckbox('checkbox-aula'))
        .then(response => {
           toastr.success('Instrutor inserido com sucesso.')
           list();
        }).catch(error => toastr.error('Ocorreu algum erro ao cadastrar esse instrutor.'));
      $scope.novoInstrutor = {};
    }
  }

  $scope.mostrarInstrutor = (item) => {
    $scope.editInstrutor = {};
    $scope.showEditInstrutor = true;
    $scope.editInstrutor = Object.assign({}, item);
    $scope.editInstrutor.id = item.id;
  }


  $scope.deletarInstrutor = (instrutor) => {
    instrutorService.delete(instrutor)
      .then(response => {
        toastr.info('Instrutor removido com sucesso.')
        list();
      }).catch(error => toastr.error('Ocorreu algum erro ao deletar esse instrutor.'));
  }

  $scope.editarInstrutor = () => {
    if($scope.updateInstrutor.$valid) {
      $scope.editInstrutor.aulas = getValorCheckbox('checkbox-edit-aula');

      instrutorService.update($scope.editInstrutor)
        .then(response => {
           toastr.success('Instrutor alterado com sucesso.');
           list();
      }).catch(error => toastr.error('Erro ao alterar esse instrutor.'));

      $scope.editInstrutor = {};
      $scope.showEditInstrutor = false;
    }
  }

  $scope.getCheckedAula = (id) => {
    if(!angular.isUndefined($scope.editInstrutor) && Object.keys($scope.editInstrutor).length > 0) {
      for(aula of $scope.editInstrutor.aulas) 
        if(aula.id === id) return true;
    }
      return false;
  }

  function list() {
    aulaService.list().then((response) => $scope.aulas = response.data);
		instrutorService.list().then((response) => $scope.instrutores = response.data);
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




angular.module('crud').filter('idToNome', (aulaService) => (id, scope) => {
  for(item of scope.$parent.$parent.aulas) 
    if(item.id === Number(id)) return item.nome;
});

