var app = angular.module('proJurisApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/home'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                controller:'ProJurisController',
                controllerAs:'ctrl'


            });
        $urlRouterProvider.otherwise('/');
    }]);

