'use strict';

angular.module('proJurisApp').controller('proJurisController',
    ['proJurisService', '$scope',  function( ProJurisService, $scope) {

        var vm = this;
        vm.init = init;

        function init() {
            return ProJurisService.init()
        }
        init();
    }


    ]);