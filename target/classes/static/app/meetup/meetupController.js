(function() {
	"use strict";

	var module = angular.module("meetup");

	module.controller('meetupController', function($scope, $routeParams, Meetup) {

		var meetupId = $routeParams.id;

		var init = function() {
			$scope.memberForm = {
				name : ""
			};

			$scope.meetup = Meetup.get({
				id : meetupId
			});
		};

		/**
		 * Check si le fomulaire est valide
		 */
		$scope.validateMemberForm = function(memberForm) {
			return memberForm.name;
		}

		/**
		 * Add a member to the meeting
		 */
		$scope.addMember = function(member) {
			Meetup.addMember({
				id : meetupId
			}, member,
			// Maj du scope
			function() {
				$scope.memberForm = {};
				$scope.meetup.$get();
			});

		};

		init();
	});

})();