(function () {
    "use strict";

    var module = angular.module("meetup");

    module.controller('listMeetupCtrl', function ($scope, $location, $log, Meetup) {
        $scope.isMeetupOpen = Meetup.isOpen;

        var init = function () {
            refreshMeetupList();
        };

        function refreshMeetupList() {
            $scope.meetups = Meetup.query();
        };

        $scope.addMeetup = function (meetup) {
            Meetup.save(meetup).$promise.then(
                refreshMeetupList
                , function (error) {
                    $log.error("création de meetup en erreur " + error)
                });
        };

        $scope.selectMeetup = function (meetup) {
            $location.path("/meetup/" + meetup.id);
        };

        init();

    });

})();