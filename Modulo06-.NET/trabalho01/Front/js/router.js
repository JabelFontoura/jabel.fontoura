angular.module('app').config(($routeProvider) => {
    $routeProvider
		.when('/', {
			templateUrl: 'partials/lista-livros.html',
			controller: 'LivrosController'
		})
		.when('/detalhe-livro/:isbn', {
			templateUrl: 'partials/detalhe-livro.html',
      controller: 'LivroController'
		})
		.otherwise({redirectTo: '/'});
});
