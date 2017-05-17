const module = angular.module('aula01', []);

module.controller('Exemplo1', $scope => {
    $scope.pokemon = {
        nome: 'Pikachu',
        tipo: 'Elétrico'
    }
});