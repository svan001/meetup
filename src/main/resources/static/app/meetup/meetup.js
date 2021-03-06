(function () {
    'use strict';

    var module = angular.module('meetup', ['ngResource']);

    module.factory('Meetup', function ($resource, $http) {
        var baseUrl = 'api/meetup';
        var resourceUrl = baseUrl + '/:id';
        var memberFragmentUrl = "/member";

        var service = $resource(resourceUrl,
            {
                id: '@id'
            },
            {
                addMember: {
                    url: resourceUrl + memberFragmentUrl,
                    method: "POST"
                }
            });

        service.removeMember = function (meetup, member) {
            var url = baseUrl + "/" + meetup.id + memberFragmentUrl + "/" + member.name;
            return $http.delete(url);
        }

        service.generateMeetupStats = function (meetup) {
            return meetup.members
                .reduce(function (value, member) {
                    member.status == 'GOING' && value.going++;
                    member.status == 'MAYBE' && value.maybe++;
                    member.status == 'NOT_GOING' && value.notGoing++;

                    return value;
                }, {
                    going: 0,
                    maybe: 0,
                    notGoing: 0
                });
        };

        service.isOpen = function (meetup) {
            return new Date(meetup.date) > Date.now();
        };

        return service;
    });

})();