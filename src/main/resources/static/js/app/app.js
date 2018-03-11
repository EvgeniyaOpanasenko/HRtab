var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp/api',
    EMPLOYEE_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/employees/',
    EMPLOYEE_SERVICE_API_BASE : 'http://localhost:8080/SpringBootCRUDApp/api/employee/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'EmployeeController',
                controllerAs:'ctrl',
                resolve: {
                    employees: function ($q, EmployeeService) {
                        console.log('Load all employees');
                        var deferred = $q.defer();
                        EmployeeService.loadAllEmployees().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

