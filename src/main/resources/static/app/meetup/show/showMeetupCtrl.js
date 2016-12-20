(function () {
    "use strict";

    var module = angular.module("meetup");

    module.controller('showMeetupCtrl', function ($scope, $routeParams, Meetup) {
        var meetupId = $routeParams.id;

        var init = function () {
            $scope.datePickerOptions = {
                showWeeks: true
            };

            refreshMeetup();
        };

        // Maj le scope avec le meetup et genere les stats
        function refreshMeetup() {
            $scope.meetup = Meetup.get({
                id: meetupId
            }, function (meetup) {
                $scope.meetupStats = Meetup.generateMeetupStats(meetup);
                $scope.isMeetupOpen = Meetup.isOpen(meetup);
            })
        };

        $scope.addMember = function (member) {
            Meetup.addMember({
                    id: meetupId
                }, member,
                refreshMeetup,
                function (error) {
                    $log.error("Error creation user : " + error)
                });

        }

        $scope.removeMember = function (member) {
            Meetup.removeMember($scope.meetup, member)
                .then(refreshMeetup);
        };

        init();
    });

})();