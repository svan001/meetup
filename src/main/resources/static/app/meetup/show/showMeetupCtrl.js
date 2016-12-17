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
        //TODO a retirer une fois une meilleu gestion par composant et le retrait du component de participation
        $scope.refreshMeetup = refreshMeetup;

        $scope.removeMember = function (member) {
            Meetup.removeMember($scope.meetup, member)
                .then(refreshMeetup);
        };

        init();
    });

})();