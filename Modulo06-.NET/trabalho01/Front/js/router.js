angular.module('app').config(($routeProvider) => {
    $routeProvider
		.when('/', {
			templateUrl: 'partials/login.html',
			controller: 'LoginController'
		})
		.when('/chat', {
			templateUrl: 'partials/chat.html',
      controller: 'ChatController'
		})
		.otherwise({redirectTo: '/'});
});
