'use strict';

angular.module('proJurisApp').factory('ProJurisService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                init: init,
            };

            return factory;

            function init() {
                console.log('Buscando Funcionários');
                var deferred = $q.defer();
                $http.get("http://localhost:8080/home/funcionarios")
                    .then(
                        function (response) {
                            console.log('Busca realizada com sucesso');
                            $localStorage.data = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error durante busca dos funcionários');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);