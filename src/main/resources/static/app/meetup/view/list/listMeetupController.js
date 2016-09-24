(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('listMeetupController', function($scope, $location, $log, Meetup) {

		var init = function() {
			$scope.refreshMeetupList();
		}

		$scope.refreshMeetupList = function() {
			$scope.meetups = Meetup.query();
		};

		$scope.selectMeetup = function(meetup) {
			console.log("Meetup selectd : " + meetup.id);
			$location.path("/meetup/" + meetup.id);
		}

		init();

	});

})();