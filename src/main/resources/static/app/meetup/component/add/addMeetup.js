(function () {
    "use strict";

    var module = angular.module('meetup');

    var controller = function () {
        var ctrl = this;

        function resetForm() {
            ctrl.datePickerOptions = {
                minDate: new Date(),
                showWeeks: true
            };

            ctrl.meetupForm = {};
        }

        ctrl.isFormValid = function () {
            return ctrl.meetupForm.title && ctrl.meetupForm.date ?
                true : false;
        };

        ctrl.addMeetup = function () {
            ctrl.onAdd({
                "meetup": ctrl.meetupForm
            });

            resetForm();
        };

        ctrl.$onInit = function () {
            resetForm();
        };
    };

    module.component('addMeetup', {
        templateUrl: '/app/meetup/component/add/addMeetup.html',
        controller: controller,
        bindings: {
            onAdd: "&"
        }
    });

})();