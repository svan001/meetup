(function () {
    "use strict";

    var module = angular.module('meetup');

    var componentController = function ($log, Meetup) {
        var ctrl = this;

        function resetForm() {
            ctrl.memberForm = {};
        }

        ctrl.isMemberFormValid = function () {
            return ctrl.memberForm.name ?
                true : false;
        };

        // Add the member to the meeting
        ctrl.addMember = function (status) {
            ctrl.onAdd({
                member: {
                    name: ctrl.memberForm.name,
                    status: status
                }
            });
            resetForm();
        };

        ctrl.$onInit = function () {
            resetForm();
        };

    };

    module.component('addMember', {
        templateUrl: '/app/meetup/component/member/addMember.html',
        controller: componentController,
        bindings: {
            // Ajout de partipant
            onAdd: "&"
        }
    });

})();