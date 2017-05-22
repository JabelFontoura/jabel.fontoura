const app = angular.module('app', ['ngRoute']);

app.config(($routeProvider) => {
    $routeProvider
			.when('/', {
					templateUrl: '../pagina01.html',
					controller: 'Pagina01Controller'
			})
			.otherwise({redirecTo: '/pagina01'});
});

app.controller('Pagina01Controller', ($scope) => {
    
});

app.controller('Pagina02Controller', ($scope) => {

});