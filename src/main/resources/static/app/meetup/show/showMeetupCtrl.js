(function () {
    "use strict";

    var module = angular.module("meetup");

    module.controller('showMeetupCtrl', function ($scope, $routeParams, Meetup) {
        var meetupId = $routeParams.id;

        var init = function () {
            $scope.datePickerOptions = {
                showWeeks: true
            };

            $scope.refreshMeetup();
        };

        // Maj le scope avec le meetup et genere les stats
        $scope.refreshMeetup = function () {
            $scope.meetup = Meetup.get({
                id: meetupId
            }, function (meetup) {
                $scope.meetupStats = Meetup.generateMeetupStats(meetup);
                $scope.isMeetupOpen = Meetup.isOpen(meetup);
            })
        };

        init();
    });

})();