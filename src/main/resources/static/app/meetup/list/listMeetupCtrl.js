(function () {
    "use strict";

    var module = angular.module("meetup");

    module.controller('listMeetupCtrl', function ($scope, $log, Meetup, AppLocation) {
        $scope.isMeetupOpen = Meetup.isOpen;

        var init = function () {
            refreshMeetupList();
        };

        function refreshMeetupList() {
            $scope.meetups = Meetup.query();
        };

        $scope.addMeetup = function (meetup) {
            Meetup.save(meetup).$promise.then(
                AppLocation.goToMeetup
                , function (error) {
                    $log.error("création de meetup en erreur " + error)
                });
        };

        $scope.selectMeetup = function (meetup) {
            AppLocation.goToMeetup(meetup);
        };

        init();

    });

})();