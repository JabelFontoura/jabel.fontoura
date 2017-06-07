angular.module('app').config(($routeProvider) => {
    $routeProvider
		.when('/', {
			templateUrl: 'partials/lista-produtos.html',
			controller: 'ProdutosController'
		})
    .when('/administrativo', {
			templateUrl: 'partials/administrativo.html',
			controller: 'ClientesController'
		})
		.otherwise({redirectTo: '/'});
});
