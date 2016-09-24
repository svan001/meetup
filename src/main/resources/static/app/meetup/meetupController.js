(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('meetupController', function($scope, $routeParams, Meetup) {
		var ctrl = this;

		var meetupId = $routeParams.id;

		var init = function() {
			$scope.refreshMeetup();
		};

		$scope.refreshMeetup = function() {
			$scope.meetup = Meetup.get({
				id : meetupId
			});
		};

		init();
	});

})();