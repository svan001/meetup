(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('listMeetupController', function($scope, $location, Meetup) {
		$scope.meetups = Meetup.query();

		$scope.selectMeetup = function(meetup) {
			console.log("Meetup selectd : " + meetup.id);
			$location.path("/meetup/" + meetup.id);
		}
	});

})();