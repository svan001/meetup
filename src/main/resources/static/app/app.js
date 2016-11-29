(function () {
    'use strict';

    var app = angular.module('meetupApp', [
        // Angular
        'ngRoute',
        // Lib
        'ui.bootstrap',
        // App
        'meetup']);

    app.config(function ($routeProvider, $locationProvider) {

        $routeProvider.when('/meetup', {
            templateUrl: "app/meetup/list/listMeetup.html",
            controller: "listMeetupCtrl"
        }).when('/meetup/:id', {
            templateUrl: "app/meetup/show/showMeetup.html",
            controller: "showMeetupCtrl"
        }).otherwise({
            redirectTo: '/meetup'
        });

        $locationProvider.html5Mode(true);

    });

})();