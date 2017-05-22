angular.module('crud').controller('InstrutorController', ($scope, toastr) => {

$scope.adicionarInstrutor = () => {
    if($scope.createInstrutor.$valid) {
      $scope.instrutores.forEach(item => $scope.nomeInstrutorExiste = item.nome === $scope.novoInstrutor.nome);
      $scope.instrutores.forEach(item => $scope.emailInstrutorExiste = item.email === $scope.novoInstrutor.email);

      if(!$scope.nomeInstrutorExiste){
        if($scope.emailInstrutorExiste) {
          toastr.error('Email já está sendo utilizado.');
          return;
        }

        if(!$scope.novoInstrutor.foto) $scope.novoInstrutor.foto = 'https://pbs.twimg.com/profile_images/799010304273371136/HNncmPwZ.jpg'

        if($scope.novoInstrutor.dandoAula) $scope.novoInstrutor.dandoAula = 'Sim';
        else $scope.novoInstrutor.dandoAula = 'Não';

        $scope.novoInstrutor.id = idInstrutor++;
        $scope.novoInstrutor.aulas = getValorCheckbox('checkbox-aula');
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));

        toastr.success('Instrutor inserido com sucesso.');
      } else {
        toastr.error('Instrutor já cadastrado.');
        return;
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
      //$scope.instrutores.forEach(item => $scope.editInstrutorExiste = item.nome === $scope.editInstrutor.nome);
      $scope.instrutores.forEach((item) => {
        if(item.id === Number($scope.idInstrutorUpdate)) {
          item.nome = $scope.editInstrutor.nome;
          item.foto = $scope.editInstrutor.foto;
          item.sobrenome = $scope.editInstrutor.sobrenome;
          item.idade = $scope.editInstrutor.idade;
          item.email = $scope.editInstrutor.email;
          item.aulas = getValorCheckbox('checkbox-edit-aula');
          if($scope.editDandoAula) item.dandoAula = 'Sim';
          else item.dandoAula = 'Não';
        }
      });
      $scope.editInstrutor = {};
      $scope.showEditInstrutor = false;
      $scope.editInstrutorExiste = false;
    }
  }

  $scope.deletarInstrutor = (id) => {
    $scope.instrutores.forEach(item => $scope.editDandoAula = item.dandoAula === 'Sim');
    if(!$scope.editDandoAula) {
      $scope.instrutores.splice(getIdIndex(id, $scope.instrutores), 1);
      $scope.showEditInstrutor = false;
    }else {
      toastr.error('Não é possível excluir este instrutor. Está dando aula.');
    }
  }
});