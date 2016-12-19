(function () {
    "use strict";

    var module = angular.module('meetup');

    var controller = function (Meetup) {
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
            var meetup = new Meetup(ctrl.meetupForm);

            meetup.$save().then(function () {
                resetForm();
                ctrl.onSuccess({
                    "meetup": meetup
                });
            }, function (error) {
                $log.error("création de meetup en erreur " + error)
            });
        }

        ctrl.$onInit = function () {
            resetForm();
        }

    };

    module.component('addMeetup', {
        templateUrl: '/app/meetup/component/add/addMeetup.html',
        controller: controller,
        bindings: {
            onSuccess: "&"
        }
    });

})();