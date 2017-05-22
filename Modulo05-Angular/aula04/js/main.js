const app = angular.module('app', ['ngRoute']);

app.config(($routeProvider) => {
    $routeProvider
		.when('/pagina01', {
			templateUrl: 'pagina01.html',
			controller: 'Pagina01Controller'
		})
		.otherwise({redirectTo: '/pagina01'});
});

app.controller('Pagina01Controller', ($scope) => {
    
});

app.controller('Pagina02Controller', ($scope) => {

});