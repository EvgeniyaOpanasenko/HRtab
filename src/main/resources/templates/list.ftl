<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Employee </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.employee.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="firstName">firstName</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.employee.firstName"
									   d="firstName"
									   class="username form-control input-sm"
									   placeholder="Enter your first name"
									   required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="lastName">lastName</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.lastName"
                                       d="lastName"
                                       class="username form-control input-sm"
                                       placeholder="Enter your lastName"
                                       required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="age">birthday</label>
                        <div class="col-md-7">
                            <input type="date" ng-model="ctrl.employee.birthday"
                                   id="birthday" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="gender">gender</label>
                            <div class="col-md-7">
                                <select type="text" ng-model="ctrl.employee.gender"
                                       id="gender" class="form-control input-sm"
										ng-options="x in gender">
                                    <option>FEMALE</option>
                                    <option>MALE</option>
								</select>
                            </div>
                        </div>
                    </div>

	                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="age">taxNumber</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.employee.taxNumber"
                                   id="taxNumber" class="form-control input-sm"
                                   placeholder="Enter your taxNumber"
                                   required ng-pattern="ctrl.onlyNumbers"/>
                        </div>
                    </div>
                </div>
	<#--TODO add dropBox for departments-->
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="department">department</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.department"
                                       d="department"
                                       class="username form-control input-sm"
                                       placeholder="Enter department name. From 1- 5"/>
                            </div>
                        </div>
                    </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.employee.id ? 'Add' : 'Update'}}"
								   class="btn btn-primary btn-sm" ng-disabled="myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
									ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Employees </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>id</th>
		                <th>firstName</th>
		                <th>lastName</th>
		                <th>birthday</th>
		                <th>gender</th>
		                <th>taxNumber</th>
		                <th>department</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllEmployees()">
		                <td>{{u.id}}</td>
		                <td>{{u.firstName}}</td>
		                <td>{{u.lastName}}</td>
		                <td>{{u.birthday}}</td>
		                <td>{{u.gender}}</td>
		                <td>{{u.taxNumber}}</td>
		                <td>{{u.department.name}}</td>
		                <td><button type="button" ng-click="ctrl.editEmployee(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeEmployee(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope) {
        $scope.names = ["Emil", "Tobias", "Linus"];
    });
</script>