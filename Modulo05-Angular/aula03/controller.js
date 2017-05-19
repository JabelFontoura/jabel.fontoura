const module = angular.module('aula03', []);

module.controller('MainController', ($scope) => {
    $scope.nomes = ['Teste', 'Jabel'];

    $scope.incluir = (novoNome) => {
        if($scope.formAula03.$invalid) return;
        
        $scope.nomes.push(novoNome);
    }
});

