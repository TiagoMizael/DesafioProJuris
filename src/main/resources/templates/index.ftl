<!DOCTYPE html>
<script src="js/lib/angular.min.js"></script>
<script src="js/lib/angular-ui-router.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/lib/localforage.min.js"></script>
<script src="js/lib/ngStorage.min.js"></script>
<script src="js/app/app.js"></script>
<script src="js/app/ProJurisService.js"></script>
<script src="js/app/ProJurisController.js"></script>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/app.css" rel="stylesheet"/>
<link href="css/proJuris.css" rel="stylesheet">
<html lang="pt-br" ng-app="proJurisApp">
<head>
    <title>Desafio ProJuris</title>
</head>

<body>
<div class="panel-heading"><span class="lead" style="font-weight: bold">Desafio ProJuris</span></div>
<div class="panel-body" ng-controller="proJurisController">
    <div>
        <ul class="nav nav-tabs" style="font-weight: bold">
            <li class="active"><a href="#funcionario" data-toggle="tab">
                <span class="glyphicon glyphicon-user"></span>
                Registrar Novo Funcionário</a></li>
            <li><a href="#custos" data-toggle="tab">
                <span class="glyphicon glyphicon-usd"></span>
                Custos</a></li>
            <li><a href="#findChar" data-toggle="tab">
                <span class="glyphicon glyphicon-text-color"></span>
                MyFindChar</a></li>
            <li><a href="#findArray" data-toggle="tab">
                <span class="glyphicon glyphicon-th"></span>
                MyFindArray</a></li>
        </ul>
        <div class="tab-content col-sm-6">
            <div class="tab-pane fade in active" style="padding-top: 10px" id="funcionario">
                <div ng-if="false">
                    <div class="form-group">
                        <label for="cargo" class="control-label">Cargo</label>
                        <input id="cargo" class="form-control" placeholder="Digite o Cargo" type="text">
                    </div>
                    <div class="form-group">
                        <label for="departamento" class="control-label">Departamento</label>
                        <input id="departamento" class="form-control" placeholder="Digite o Departamento" type="text">
                    </div>
                    <div class="form-group">
                        <label for="salario" class="control-label">Salário</label>
                        <input id="salario" class="form-control" placeholder="Digite o Salário" type="number">
                    </div>
                    <button type="button" class="btn btn-primary">Cadastrar</button>
                </div>
                <div ng-if="false">
                    <label class="control-label">Buscar Funcionário</label>
                    <div class="input-group">
                        <input type="number" class="form-control" placeholder="Digite o ID do Funcionário">
                        <span class="input-group-btn">
                    <button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true">
                    </span>Buscar</button>
                    </span>
                    </div>
                </div>
                <div ng-if="true">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Cargo</th>
                            <th>Departamento</th>
                            <th>Salário</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                        </tr>
                        <tr>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                        </tr>
                        <tr>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                            <td>Cell</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade in active" id="custos">
                teste Custos
            </div>
            <div class="tab-pane fade in active" id="findChar">
                teste Char
            </div>
            <div class="tab-pane fade in active" id="findArray">
                teste Array
            </div>
        </div>
    </div>
</div>
</nav>
</body>
</html>