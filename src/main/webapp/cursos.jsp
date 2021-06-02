<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Listado de cursos</h1>

		<div ng-app="cursosApp" ng-controller="cursosController">

			<label>Seleccione el curso:</label><select class="form-control"
				ng-model="cursoSel">
				<c:forEach var="c" items="${requestScope.cursos}">
					<option value="${c.idCurso}">${c.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<br> <br>
		<button type="button" ng-click="buscarCurso();"
			class="btn btn-default btn-primary" style="width: 20%">Consultar</button>




		<div class="container" ng-show="alumnos">
			<p>Nombre: {{alumnos[0].alumno.usuario}}</p>
			<p>Fecha Inicio: {{alumnos[0].alumno.email}}</p>
			<p>Fecha Inicio: {{alumnos[0].alumno.nombre}}</p>
			<br>
			<table border="1" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Fecha Inicio</th>
					</tr>
				</thead>
				<tr ng-repeat="alumno in alumnos">
					<td>{{alumno.usuario}}</td>
					<td>{{alumno.email}}</td>
					<td>{{alumno.nombre}}</td>
				</tr>
			</table>

		</div>
	</div>

	<script>
		var app = angular.module("cursosApp", []);
		app.controller("cursosController", function($scope, $http) {
			var url = "recuperarAlumnosPorCurso";

			$scope.buscarCurso = function() {
				$http.get(url, {
					params : {
						matricula : $scope.cursoSel
					}
				}).then(function(res) {
					$scope.alumnos = res.data;
				});
			};

		});
	</script>

</body>
</html>