'use strict';
angular
		.module('myApp')
		.factory(
				'empService',
				[
						'$http',
						'$q',
						function($http, $q) {
							// var REST_SERVICE_URI =
							// 'http://localhost:8080/Rect/';
							var factory = {

								fetchAllEmpl : fetchAllEmpl,
								// fetchAllQuali:fetchAllQuali,
								// fetchAllPerson : fetchAllPerson,
								updateEmpl:updateEmpl,
								fetchAllQuali:fetchAllQuali,
								AddEmpl : AddEmpl

							};
							return factory;

							function fetchAllQuali() {
								var deferred = $q.defer();
								$http
										.get('http://localhost:8080/AllQuali/')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching fetchAllQuali');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpl() {
								var deferred = $q.defer();
								$http
										.get('http://localhost:8080/AllEmpl/')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching AllEmpl');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function AddEmpl(empl) {
								var deferred = $q.defer();
								$http
										.post('http://localhost:8080/AddEmpl/',
												empl)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating AddEmpl');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							function updateEmpl(empl,id) {
								var deferred = $q.defer();
								$http
										.post('http://localhost:8080/updateEmpl/'+id,
												empl)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating AddEmpl');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							

						} ]);