<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Alumno, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Lista de alumnos</h1>

		<div ng-app="alumnosApp" ng-controller="alumnosController">
			<div class="input-group" style="width: 30%">
				<label>Seleccione curso:</label><select class="form-control"
					ng-model="cursoSel">
					<c:forEach var="c" items="${requestScope.cursos}">
						<option value="${c.idCurso}">${c.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<br>
			<button type="button" ng-click="buscarAlumnos();"
				class="btn btn-default btn-primary" style="width: 20%">Consultar</button>

			<div class="container" ng-show="matriculas">
				<br>
				<table border="1" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Nick</th>
							<th>Nombre</th>
							<th>Email</th>
							<th>Edad</th>
						</tr>
					</thead>
					<tr ng-repeat="a in matriculas">
                        <td>{{a.alumno.usuario}}</td>
                        <td>{{a.alumno.nombre}}</td>
                        <td>{{a.alumno.email}}</td>
                        <td>{{a.alumno.edad}}</td>
                    </tr>
<!--  	 				<tr ng-repeat="m in matriculas">
						<td>{{m.alumno.usuario}}</td>
						<td>{{m.alumno.nombre}}</td>
						<td>{{m.alumno.email}}</td>
						<td>{{m.alumno.edad}}</td> 
 						<tr ng-repeat="a in matriculas.alumno">
						<td>{{a.usuario}}</td>
						<td>{{a.nombre}}</td>
						<td>{{a.email}}</td>
						<td>{{a.edad}}</td> -->
					</tr>
				</table>

			</div>
		</div>
	</div>
	<script>
		var app = angular.module("alumnosApp", []);
		app.controller("alumnosController", function($scope, $http) {
			var url = "recuperarAlumnosxCurso";

			$scope.buscarAlumnos = function() {
				console.log("Paso ..... " + $scope.cursoSel);
				$http.get(url, {
					params : {
						idCurso : $scope.cursoSel
					}
				}).then(function(res) {
					$scope.matriculas = res.data;
				});
			};

		});
	</script>
	<a href="toMenu">Volver al menú</a>
</body>
</html>