const module = angular.module('aula02', []);

module.controller('Exercicio2', ($scope) => {
    $scope.imprime = () => {
        if(angular.isUndefined($scope.data)) return;

        const partesData = $scope.data.split("/");
        $scope.resultadoData = new Date(partesData[2], partesData[1] - 1, partesData[0]);
    }
});

module.controller('Exercicio3', ($scope, $filter) => {

    const instrutores = [{
        nome: 'Bernardo',
        aula: [{
            numero: 1,
            nome: 'OO'
        },
        {
            numero: 4,
            nome: 'Javascript'
        }
        ]
    },
    {
        nome: 'Nunes',
        aula: [{
        numero: 2,
        nome: 'Banco de Dados I'
        }]
    },
    {
        nome: 'Pedro (PHP)',
        aula: [{
        numero: 3,
        nome: 'HTML e CSS'
        }]
    },
    {
        nome: 'Zanatta',
        aula: [{
        numero: 5,
        nome: 'AngularJS'
        }]
    }
    ];
    
    $scope.instrutores = instrutores;
});

module.filter('mascada', () => (nome) => nome.replace(/(nunes)/i, '$ $1 $'));
