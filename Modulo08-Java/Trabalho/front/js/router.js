angular.module('app').config(($routeProvider) => {
	$routeProvider
	.when('/', {
		templateUrl: 'partials/home.html',
		controller: 'UsuarioController'
	})
	.when('/login', {
		templateUrl: 'partials/login.html',
		controller: 'UsuarioController'
	})
	.when('/cadastro', {
		templateUrl: 'partials/cadastro.html',
		controller: 'UsuarioController'
	})
	.when('/404', {
		templateUrl: 'partials/404.html'
	})
	.otherwise({redirectTo: '/404'});
});
