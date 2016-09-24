(function() {
	"use strict";

	var module = angular.module('meetup');

	var componentController = function($log, Meetup) {
		var ctrl = this;

		function resetForm() {
			ctrl.memberForm = {};
		}

		ctrl.isMemberFormValid = function() {
			return ctrl.memberForm.name;
		}

		// Add the member to the meeting
		ctrl.addMember = function() {
			Meetup.addMember({
				id : ctrl.meetup.id
			}, ctrl.memberForm,
			// Maj du scope
			function() {
				resetForm();
				ctrl.onSuccess();
			}, function(error) {
				$log.error("Error creation user : " + error)
			});
		};

		ctrl.$onInit = function() {
			resetForm();
		}

	};

	module.component('addMember', {
		templateUrl : '/app/meetup/member/add.html',
		controller : componentController,
		bindings : {
			// Meetup a maj avec le nouveau partipant
			meetup : '<',
			// Callback success d'ajout de partipant
			onSuccess : "&"
		}
	});

})();