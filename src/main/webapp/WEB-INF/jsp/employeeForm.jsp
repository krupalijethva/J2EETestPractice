<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<head>
<title>AngularJS $http Example</title>

<style>
.fname.ng-dirty.ng-invalid-required {
	background-color: red;
}

.lname.ng-dirty.ng-invalid-required {
	background-color: red;
}

.bdate.ng-dirty.ng-invalid-required {
	background-color: red;
}

.jdate.ng-dirty.ng-invalid-required {
	background-color: red;
}

.Qualifications.ng-dirty.ng-invalid-required {
	background-color: red;
}

.salary.ng-dirty.ng-invalid-required {
	background-color: red;
}

.rdgender.ng-dirty.ng-invalid-required {
	background-color: red;
}

$(
function () { $( ".datepicker " ).datepicker();
	alert();
}
);
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="emplController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Employee Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.empl.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">First
								Name:</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empl.fname"
									class="fname form-control input-sm"
									name-"fname"
									placeholder="Enter your fname" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.fname.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Last
								Name:</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empl.lname"
									class="lname form-control input-sm" name=lname
									placeholder="Enter your lname" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.lname.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Joining
								Date:</label>
							<div class="col-md-7">
								<input type="date" ng-model="ctrl.empl.jod" class="datepicker"
									class="jdate form-control input-sm" name="jdate" 
									value="{{ctrl.empl.jod}}" placeholder="Enter your Joining Date"
									required />

								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.jdate.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Birth
								Date:</label>
							<div class="col-md-7">
								<input type="date" ng-model="ctrl.empl.dob" class="datepicker"
									class="bdate form-control input-sm" name="bdate"
									value="{{ctrl.empl.dob}}" placeholder="Enter your Birth Date"
									required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.bdate.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Qualification:</label>
							<div class="col-md-7">

								<!--ng-change="selectQuali(ctrl.empl.quali)"  -->
								<select
									ng-options="quali.qualification for quali in Qualifications"
									ng-model="ctrl.empl.quali"
									class="Qualifications form-control input-sm">
									<option value=""
										selected='ctrl.empl.quali==ctrl.empl.quali? "selected" : false'
										required>--Select--</option>
								</select>
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Salary:</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empl.salary"
									class="salary form-control input-sm" name="salary"
									placeholder="Enter your Salary" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.salary.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Gender:</label>
							<div class="col-md-7">
								<input type="radio" ng-model="ctrl.empl.gender" value="Male"
									name="gender" required checked="checked">Male <input
									type="radio" ng-model="ctrl.empl.gender" value="Female"
									name="gender">Female
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.gender.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Is
								Fresher Employee:</label>
							<div class="col-md-7">
								<input type="radio" ng-model="ctrl.empl.isfresher" value="Yes"
									name="isFresher" required checked="checked">Yes <input
									type="radio" ng-model="ctrl.empl.isfresher" value="No"
									name="isFresher">No
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.isFresher.$error.required">This is
										a required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.empl.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Employee </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>Name</th>
							<th>Birth Date</th>
							<th>Joining Date</th>
							<th>Salary</th>
							<th>Is Fresher Employee</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.empls">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.fname +' '+u.lname"></span></td>
							<td><span ng-bind="u.dob"></span></td>
							<td><span ng-bind="u.jod"></span></td>
							<td><span ng-bind="u.salary"></span></td>
							<td><span ng-bind="u.isfrehser"></span></td>
							<td></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Edit</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="js/app.js"></script>
	<script src="js/service/Emp_service.js"></script>
	<script type="text/javascript" src="js/controller/Emp_controller.js"></script>
</body>
</html>