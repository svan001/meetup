(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('meetupController', function($scope, $routeParams, Meetup) {
		var ctrl = this;
		var meetupId = $routeParams.id;

		var init = function() {
			$scope.refreshMeetup();
		};

		function refreshMeetupStats() {

		}

		// Maj le scope avec le meetup et genere les stats
		$scope.refreshMeetup = function() {
			$scope.meetup = Meetup.get({
				id : meetupId
			}, function(meetup) {
				$scope.meetupStats = Meetup.generateMeetupStats(meetup);
			})
		};

		init();
	});

})();