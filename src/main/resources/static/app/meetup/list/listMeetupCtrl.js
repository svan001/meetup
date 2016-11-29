(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('listMeetupCtrl', function($scope, $location, $log, Meetup) {

		var init = function() {
			$scope.refreshMeetupList();
		}

		$scope.refreshMeetupList = function() {
			$scope.meetups = Meetup.query();
		};

		$scope.selectMeetup = function(meetup) {
			$location.path("/meetup/" + meetup.id);
		}

		init();

	});

})();