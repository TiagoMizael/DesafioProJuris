<!DOCTYPE html>
<html ng-app="app">
<script src="js/lib/angular.min.js"></script>
<script src="js/lib/angular-ui-router.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/lib/localforage.min.js"></script>
<script src="js/lib/ngStorage.min.js"></script>
<script src="js/app/ProJuris.module.js"></script>
<script src="js/app/ProJuris.controller.js"></script>

<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/app.css" rel="stylesheet"/>
<link href="css/proJuris.css" rel="stylesheet">
<head>
    <meta charset="UTF-8">
    <title>ProJuris</title>
</head>

<body ng-controller="ProJurisController">
<div class="panel-heading"><span class="lead" style="font-weight: bold">Desafio ProJuris</span></div>
<div class="panel-body">

    <ul class="nav nav-tabs" style="font-weight: bold">
        <li><a ng-click="select = true" href="#funcionario" data-toggle="tab">
            <span class="glyphicon glyphicon-user"></span>
            Funcionários</a></li>
        <li><a ng-click="getCargos()" href="#custos" data-toggle="tab">
            <span class="glyphicon glyphicon-usd"></span>
            Custos</a></li>
        <li><a ng-click="select = true" href="#findChar" data-toggle="tab">
            <span class="glyphicon glyphicon-font"></span>
            MyFindChar</a></li>
        <li><a ng-click="select = true" href="#findArray" data-toggle="tab">
            <span class="glyphicon glyphicon-th"></span>
            MyFindArray</a></li>
    </ul>
    <div ng-show="!select" class="panel-heading">
        <span class="lead" style="font-weight: bold">Por Favor,Selecione uma das opções acima!</span>
    </div>
    <div ng-show="select" class="tab-content col-sm-6">
        <div class="tab-pane fade in active" style="padding-top: 10px" id="funcionario">
            <div class="btn-group bot" role="group">
                <button ng-click="registra=false" type="button" class="btn btn-default">Consultar Funcionários
                </button>
                <button ng-click="registra=true" type="button" class="btn btn-default">Registrar Funcionário
                </button>
            </div>
            <div ng-if="registra">
                <div class="form-group">
                    <label for="cargo" class="control-label">Cargo</label>
                    <input ng-model="funcionario.cargo" id="cargo" class="form-control" placeholder="Digite o Cargo"
                           type="text">
                </div>
                <div class="form-group">
                    <label for="departamento" class="control-label">Departamento</label>
                    <input ng-model="funcionario.departamento" id="departamento" class="form-control"
                           placeholder="Digite o Departamento" type="text">
                </div>
                <div class="form-group">
                    <label for="salario" class="control-label">Salário</label>
                    <input ng-model="funcionario.salario" id="salario" class="form-control"
                           placeholder="Digite o Salário" type="number">
                </div>
                <button ng-click="registraFuncionario()" type="button" class="btn btn-primary">Cadastrar</button>
            </div>
            <div class="bot" ng-if="!registra">
                <label class="control-label">Buscar Funcionário</label>
                <div class="input-group" style="width: 50%">
                    <input ng-model="search.filter" class="form-control"
                           placeholder="Digite um filtro para o funcionário">
                </div>
            </div>
            <div ng-if="!registra">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cargo</th>
                        <th>Departamento</th>
                        <th>Salário</th>
                        <th style="width: 69px;">#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="funcionario in funcionarios | filter:search.filter ">
                        <td>{{ funcionario.id }}</td>
                        <td ng-if="!edit">{{funcionario.cargo}}</td>
                        <td ng-if="!edit">{{funcionario.departamento}}</td>
                        <td ng-if="!edit">{{funcionario.salario}}</td>
                        <td ng-if="edit"><input ng-model="funcionario.cargo" id="cargo" type="text"></td>
                        <td ng-if="edit"><input ng-model="funcionario.departamento" id="departamento" type="text">
                        </td>
                        <td ng-if="edit"><input ng-model="funcionario.salario" id="salario" type="text"></td>
                        <td ng-show="!edit" style="width: 69px">
                            <button ng-click="deletaFuncionario(funcionario.id)" type="button"
                                    class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span>
                            </button>
                            <button ng-click="edit = !edit" type="button" class="btn btn-default btn-xs"><span
                                    class="glyphicon glyphicon-pencil"></span></button>
                        </td>
                        <td ng-show="edit" style="width: 69px">
                            <button ng-click="editaFuncionario(funcionario,edit)" type="button"
                                    class="btn btn-success btn-xs"><span class="glyphicon glyphicon-ok"></span>
                            </button>
                            <button ng-click="edit = !edit" type="button" class="btn btn-danger btn-xs"><span
                                    class="glyphicon glyphicon-remove"></span></button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="tab-pane fade in active" style="padding-top: 10px" id="custos">
            <div class="btn-group bot" role="group">
                <button ng-click="getCargos()" type="button" class="btn btn-default">Despesas Cargos
                </button>
                <button ng-click="getDepartamentos()" type="button" class="btn btn-default">Despesas Departamentos
                </button>
            </div>
            <div ng-if="cargo">
                <label class="control-label">Buscar Despesa</label>
                <div class="input-group bot" style="width: 50%">
                    <input ng-model="search.cargo" class="form-control"
                           placeholder="Digite um filtro de custo">
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th style="width: 70%;">Cargo</th>
                        <th>Custo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="despesa in despesasCargos | filter:search.cargo ">
                        <td>{{despesa.cargo}}</td>
                        <td>{{despesa.custo}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div ng-if="!cargo">
                <label class="control-label">Buscar Despesa</label>
                <div class="input-group bot" style="width: 50%">
                    <input ng-model="search.departamento" class="form-control"
                           placeholder="Digite um filtro de custo">
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th style="width: 70%;">Departamento</th>
                        <th>Custo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="despesa in despesasDepartamento | filter:search.departamento ">
                        <td>{{despesa.departamento}}</td>
                        <td>{{despesa.custo}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="tab-pane fade in active" id="findChar">
            <div class="input-group bot" style="padding-top: 15px">
                <input ng-model="myChar.string" class="form-control">
                <span class="input-group-btn">
                    <button ng-click="getMyChar()" class="btn btn-primary" type="button">Chamar Função</button>
                    </span></div>
            <label>Resultado:</label>
            <div class="font-result">{{resultChar.result}}</div>
        </div>
        <div class="tab-pane fade in active" id="findArray">
            <div style="padding-top: 15px" class="form-group">
                <label class="control-label">Array</label>
                <input ng-model="convert.stringA" class="form-control"
                       placeholder="Digite o Array no formato: 0,1,2,..."
                       type="text">
            </div>
            <div class="form-group bot">
                <label class="control-label">SubArray</label>
                <input ng-model="convert.stringB" class="form-control"
                       placeholder="Digite o SubArray no formato: 0,1,2,..."
                       type="text">
            </div>
            <button ng-click="getMyArray()" type="button"
                    class="btn btn-primary">Chamar Função</span></button>
            <div>
                <label style="padding-top: 10px">Resultado:</label>
                <div class="font-result">{{myArray.result}}</div>
            </div>
        </div>
    </div>
</div>
</nav>
</body>
</html>