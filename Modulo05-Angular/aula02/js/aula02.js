const module = angular.module('aula02', []);

module.controller('Exercicio2', ($scope) => {
    $scope.imprime = () => {
        if(angular.isUndefined($scope.data)) return;

        const partesData = $scope.data.split("/");
        $scope.resultadoData = new Date(partesData[2], partesData[1] - 1, partesData[0]);
    }
});

module.controller('Exercicio3', ($scope, $filter) => {
    $scope.instrutores = instrutores;
});

module.controller('Tema1', ($scope, $filter) => {
	$scope.aulasInstrutor = carregaListaAulaInstrutor();
});

//FILTERS
module.filter('mascada', () => (nome) => nome.replace(/(nunes)/i, '$ $1 $'));


function carregaListaAulaInstrutor() {
	let aulas = [];

	instrutores.forEach(item => {
		item.aula.forEach(e => aulas.push({numero: e.numero, aula: e.nome, instrutor: item.nome }));
	});

	return aulas;
}