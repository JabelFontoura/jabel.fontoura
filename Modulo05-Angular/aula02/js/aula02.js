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

module.controller('Tema3', ($scope, $filter) => {
	$scope.lpad = function lpad(num) {
		let str = num.toString();
		const pad = "000"

		return pad.substring(0, pad.length - str.length) + str;
}

	$scope.aulasInstrutor = carregaListaAulaInstrutor();
});

module.filter('mascada', () => (nome) => nome.replace(/(nunes)/i, '$ $1 $'));
module.filter('toUpperCase', () => (exp) => exp.replace(/(banco de dados i)/gi, exp.toUpperCase()));

function carregaListaAulaInstrutor() {
	let aulas = [];

	instrutores.forEach(item => {
		item.aula.forEach(e => aulas.push({numero: e.numero, aula: e.nome, instrutor: item.nome }));
	});

	return aulas;
}