(function() {
	'use strict';

	var app = angular.module('meetupApp', [
	// Angular
	'ngRoute',
	// App
	'meetup' ]);

	app.config(function($routeProvider, $locationProvider) {

		$routeProvider.when('/meetup', {
			templateUrl : "app/meetup/list/listMeetup.html",
			controller : "listMeetupController"
		}).when('/meetup/:id', {
			templateUrl : "app/meetup/meetup.html",
			controller : "meetupController"
		}).otherwise({
			redirectTo : '/meetup'
		});

		$locationProvider.html5Mode(true);

	});

})();