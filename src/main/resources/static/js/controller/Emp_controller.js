/**
 * 
 */
'use strict';
angular.module('myApp').controller(
		'emplController',
		[
				'$scope',
				'empService',
				function($scope, empService) {

					var self = this;

					self.empl = {
						id : null,
						e_Id : null,
						job : '',
						salary : '',
						fname : '',
						lname : '',
						dob : '',
						gender : '',
						quali : '',
						isfresher:''
					};
					self.empls = [];

					self.submit = submit;
					self.edit = edit;
					self.reset = reset;

					$scope.Qualifications = [];

					// $scope.Qualifications = [ {
					// Id : 1,
					// Name : 'ME'
					// }, {
					// Id : 2,
					// Name : 'BE'
					// }, {
					// Id : 3,
					// Name : 'Diploma'
					// } ];

					$scope.selectQuali = function(val) {
						self.empl.quali = val.Name;

					}
					fetchAllQuali()
					fetchAllEmpl();

					function updateEmpl(empl, id) {
						empService.updateEmpl(empl, id).then(fetchAllEmpl,
								function(errResponse) {
									console.error('Error while updating User');
								});
					}
					function fetchAllQuali() {

						empService.fetchAllQuali().then(function(d) {
							debugger
							console.log(JSON.stringify(d));
							$scope.Qualifications = d;

						}, function(errResponse) {
							console.error('Error while fetching Users');
						});
					}

					function fetchAllEmpl() {

						empService.fetchAllEmpl().then(function(d) {

							console.log("On Front view--"+JSON.stringify(d));
							self.empls = d;

						}, function(errResponse) {
							console.error('Error while fetching Users');
						});
					}

					function submit() {
						if (self.empl.id === null) {
							console.log('Saving New Employee', self.empl);
							AddEmpl(self.empl);

						} else {
							updateEmpl(self.empl, self.empl.id);
							console.log('User updated with id ', self.empl.id);
						}
						reset();
					}
					function edit(id) {
					

						for (var i = 0; i < self.empls.length; i++) {
							if (self.empls[i].id === id) {
								self.empl = angular.copy(self.empls[i]);
								break;
							}
						}
						// wait...

					}

					function reset() {
						self.empl = {
							id : null,
							jod : '',
							salary : '',
							fname : '',
							lname : '',
							birthdate : '',
							gender : '',
							quali : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

					function AddEmpl(empl) {

						empService.AddEmpl(empl).then(fetchAllEmpl,
								function(errResponse) {
									console.error('Error while creating empl');
								});
					}

				} ]);