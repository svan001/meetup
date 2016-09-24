(function() {

	"use strict";

	var module = angular.module('meetup');

	var controller = function(Meetup) {
		var ctrl = this;

		function resetForm() {
			ctrl.meetupForm = {};
		}

		ctrl.addMeetup = function() {
			var meetup = new Meetup(ctrl.meetupForm);

			meetup.$save().then(function() {
				resetForm();
				// $scope.meetups = Meetup.query();
				ctrl.onSuccess();
			}, function(error) {
				$log.error("création de meetup en erreur " + error)
			});
		}

	};

	module.component('addMeetup', {
		templateUrl : '/app/meetup/add/add.html',
		controller : controller,
		bindings : {
			onSuccess : "&"
		}
	});

})();