const module = angular.module('crud', ['ngAnimate', 'toastr']);

module.controller('MainController', ($scope, toastr) => {
  let idAula = 0;
  let idInstrutor = 0;
  $scope.aulas = [{id: idAula++, nome: 'HTML & CSS'}, {id: idAula++, nome: 'Javascript'}, {id: idAula++, nome: 'Angular'}];
  $scope.instrutores = [{id: idInstrutor++, nome:'teste', foto: 'https://pbs.twimg.com/profile_images/799010304273371136/HNncmPwZ.jpg', aulas: [ {id: 0, nome: 'HTML & CSS'}, {id: 1, nome: 'Javascript'}]}];


  $scope.adicionarAula = () => {
    if($scope.createAula.$valid) {
      $scope.aulas.forEach(item => $scope.createAulaExiste = item.nome === $scope.novaAula.nome);
      if(!$scope.createAulaExiste){
        $scope.novaAula.id = idAula++;
        $scope.aulas.push(angular.copy($scope.novaAula));
      } else {
        toastr.error('Aula já cadastrada.');
      }
      $scope.novaAula = {};
    }
  }

  $scope.mostrarAula = (item) => {
    $scope.editAula = {};
    $scope.showEditAula = true;
    $scope.idAulaUpdate = item.id;
    $scope.editAula.nome = item.nome;
  }

  $scope.editarAula = () => {
    if($scope.updateAula.$valid) {
      $scope.aulas.forEach(item => $scope.editAulaExiste = item.nome === $scope.editAula.nome);
      if(!$scope.editAulaExiste){
        $scope.aulas.forEach((item) => {
          if(item.id === Number($scope.idAulaUpdate)) 
            item.nome = $scope.editAula.nome;
        });
      }
      $scope.editAula = {};
      $scope.showEditAula = false;
    }
  }

  $scope.deletarAula = (id) => {
       $scope.aulaUsada = aulaSendoUsada(id);
       if(!$scope.aulaUsada){
        $scope.aulas.splice(getIdIndex(id, $scope.aulas), 1);
       } else {
         toastr.error('Não é possível excluir esta aula. Está sendo utilizada.');
       }
  }

  $scope.adicionarInstrutor = () => {
    if($scope.createInstrutor.$valid) {
      $scope.instrutores.forEach(item => $scope.createInstrutorExiste = item.nome === $scope.novoInstrutor.nome);
      if(!$scope.createInstrutorExiste){
        // if(!$scope.novoInstrutor.deuAula) {
        //   $scope.novoInstrutor.dandoAula = 'Não';
        // } else {
        //   $scope.novoInstrutor.dandoAula = 'Sim';
        // } 

        $scope.novoInstrutor.id = idInstrutor++;
        $scope.novoInstrutor.aulas = getValorCheckbox('checkbox-aula');
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));
      }
      $scope.novoInstrutor = {};
    }
  }

  $scope.mostrarInstrutor = (item) => {
    $scope.editInstrutor = {};
    $scope.showEditInstrutor = true;
    $scope.idInstrutorUpdate = item.id;
    $scope.editInstrutor = Object.assign({}, item);
  }


  $scope.editarInstrutor = () => {
    if($scope.updateInstrutor.$valid) {
      $scope.instrutores.forEach(item => $scope.editInstrutorExiste = item.nome === $scope.editInstrutor.nome);

      if(!$scope.editInstrutorExiste){
        $scope.instrutores.forEach((item) => {
          if(item.id === Number($scope.idInstrutorUpdate)) {
            item.nome = $scope.editInstrutor.nome;
            item.foto = $scope.editInstrutor.foto;
            item.sobrenome = $scope.editInstrutor.sobrenome;
            item.idade = $scope.editInstrutor.idade;
            item.email = $scope.editInstrutor.email;
            item.dandoAula = $scope.editInstrutor.dandoAula;
            console.log('aulas',item.aulas);
            item.aulas = getValorCheckbox('checkbox-edit-aula');
            console.log('aulas',item.aulas);
          }
        });
      }
      $scope.editInstrutor = {};
      $scope.showEditInstrutor = false;
    }
  }

  $scope.deletarInstrutor = (id) => {
    $scope.instrutores.splice(getIdIndex(id, $scope.instrutores), 1);
    $scope.showEditInstrutor = false;
  }

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