const module = angular.module('aula01', []);

module.controller('Exercicio1', $scope => {
    $scope.pokemon = {
        nome: 'Pikachu',
        tipo: 'Elétrico'
    }
});
module.controller('Exercicio2', $scope => {
    $scope.pokemons = [
        { 
					nome: 'Pikachu',
					tipo: 'Elétrico'
        }, 
        { 
					nome: 'Bulbasauro',
					tipo: 'Grama'
        },
        { 
					nome: 'Charmander',
					tipo: 'Fogo'
        },
        { 
					nome: 'Squirtle',
					tipo: 'Água'
        },
				{ 
					nome: 'Blastoise',
					tipo: 'Água'
        }
       ];
});