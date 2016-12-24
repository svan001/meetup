(function () {
    'use strict';

    var app = angular.module('meetupApp', [
        // Angular
        'ngRoute',
        // Lib
        'ui.bootstrap',
        // App
        'meetup']);

    // Config URL + route
    var meetupBaseUrl = '/meetup';

    app.config(function ($routeProvider, $locationProvider) {

        $routeProvider.when(meetupBaseUrl, {
            templateUrl: "app/meetup/list/listMeetupView.html",
            controller: "listMeetupCtrl"
        }).when(meetupBaseUrl + '/:id', {
            templateUrl: "app/meetup/show/showMeetupView.html",
            controller: "showMeetupCtrl"
        }).otherwise({
            redirectTo: meetupBaseUrl
        });

        $locationProvider.html5Mode(true);

    });

    app.factory('AppLocation', function ($location) {
        var service = {};

        service.goToMeetup = function(meetup){
            $location.path(meetupBaseUrl + '/' + meetup.id);
        }

        return service;
    });

})();