const module = angular.module('aula03', []);

module.controller('MainController', ($scope) => {
    $scope.instrutores = [
        {
            nome: 'Bernardo',
            sobreNome: 'Rezende',
            idade: 30,
            email: 'bernarndo@cwi.com',
            deuAula: true,
            aula: 'OO'
        }
    ];

    $scope.aulas = [
        'OO',
        'HTML e CSS',
        'Javascript',
        'AngularJS',
        'Banco de Dados I'
    ];

    $scope.incluirInstruror = (instrutor) => {
        if($scope.formAula03.$invalid) return;  
         
        console.log($scope.instrutores);
        $scope.instrutores.push(instrutor);
    }
});

