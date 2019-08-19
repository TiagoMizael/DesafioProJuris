app.controller("ProJurisController",function ($scope,$http) {

    $scope.registra = false;
    $scope.edit = false;
    $scope.cargo = true;
    $scope.select = false;
    $scope.search={};
    $scope.funcionario={};
    $scope.funcionarios = [];
    $scope.despesasCargos = [];
    $scope.despesasDepartamento = [];
    $scope.myChar = {};
    $scope.myArray = {};
    $scope.myArray.array = [];
    $scope.myArray.subArray = [];
    $scope.convert = {};
    $scope.callMyChar = false;
    $scope.callMyArray = false;

    $scope.getFuncionarios = function(){
        $http({method : 'GET', url : 'http://localhost:8080/funcionarios'})
            .then(function sucessCallBack(response) {
            $scope.funcionarios = response.data;
        }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao buscar funcionários!')
        });
    }
    $scope.getFuncionarios();

    $scope.registraFuncionario = function() {
        $http({method : 'POST', url : 'http://localhost:8080/novoFuncionario',data: $scope.funcionario})
            .then(function sucessCallBack(response) {
                alert('Funcionário criado com sucesso!')
                $scope.getFuncionarios();
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao registrar funcionário!')
            });
    }

    $scope.deletaFuncionario = function (id) {
        $http({method : 'DELETE', url : 'http://localhost:8080/deletaFuncionario/'+id})
            .then(function sucessCallBack(response) {
                alert('Funcionário deletado com sucesso!')
                $scope.getFuncionarios();
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao deletar funcionário!')
            });
    }
    
    $scope.editaFuncionario = function (funcionario,edit) {
        $http({method : 'PUT', url : 'http://localhost:8080/atualizaFuncionario/'+funcionario.id,data: funcionario})
            .then(function sucessCallBack(response) {
                alert('Funcionário editado com sucesso!')
                edit= !edit;
                $scope.getFuncionarios();
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao editar funcionário!')
            });
    }

    $scope.getCargos = function () {
        $http({method : 'GET', url : 'http://localhost:8080/calculaCargos'})
            .then(function sucessCallBack(response) {
                $scope.cargo = true;
                $scope.select = true;
                $scope.despesasCargos = response.data;
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao buscar despesas!')
            });
    }

    $scope.getDepartamentos = function () {
        $http({method : 'GET', url : 'http://localhost:8080/calculaDepartamentos'})
            .then(function sucessCallBack(response) {
                $scope.cargo = false;
                $scope.despesasDepartamento = response.data;
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao buscar despesas!')
            });
    }

    $scope.getMyChar = function(){
        $http({method : 'GET', url : 'http://localhost:8080/findMyChar/'+$scope.myChar.string})
            .then(function sucessCallBack(response) {
                $scope.resultChar = response.data;
                $scope.callMyChar = true;
                if($scope.resultChar.result == ""){
                    $scope.resultChar.result = "\" \""
                }
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao buscar Resultado MyChar!')
            });
    }

    $scope.getMyArray = function(){
        var stringA = $scope.convert.stringA.trim().split(",");
        var stringB = $scope.convert.stringB.trim().split(",");
        for(var i= 0; i < stringA.length;i++ ){
            var int = parseInt(stringA[i], 10)
            $scope.myArray.array.push(int);
        }
        for(var j= 0; j < stringB.length;j++ ){
            var int = parseInt(stringB[j], 10)
            $scope.myArray.subArray.push(int);
        }
        $scope.getMyArrayRest()
    }

    $scope.getMyArrayRest = function () {
        $http({method : 'POST', url : 'http://localhost:8080/findArray/',data:$scope.myArray})
            .then(function sucessCallBack(response) {
                $scope.myArray.result = response.data;
                $scope.callMyArray = true;
                $scope.myArray.array = [];
                $scope.myArray.subArray = [];
            }, function errorCallBack(response) {
                console.log('Error:  ' + response)
                alert('Erro ao buscar Resultado MyArray!')
            });
    }
})