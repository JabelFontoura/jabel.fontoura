angular.module('app').config(($routeProvider) => {
    $routeProvider
		.when('/', {
			templateUrl: 'partials/lista-livros.html',
			controller: 'LivrosController'
		})
		.when('/detalhe-livro', {
			templateUrl: 'partials/detalhe-livro.html',
      // controller: 'ChatController'
		})
		.otherwise({redirectTo: '/'});
});
