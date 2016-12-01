(function () {
    'use strict';

    var module = angular.module('meetup', ['ngResource']);

    module.factory('Meetup', function ($resource, $http) {
        var baseUrl = 'api/meetup/:id';

        var resource = $resource(baseUrl, {
            id: '@id'
        }, {
            addMember: {
                url: baseUrl + "/member",
                method: "POST"
            }
        });

        resource.generateMeetupStats = function (meetup) {
            var initialValue = {
                going: 0,
                maybe: 0,
                notGoing: 0
            };

            return meetup.members.reduce(function (value, member) {
                member.status == 'GOING' && value.going++;
                member.status == 'MAYBE' && value.maybe++;
                member.status == 'NOT_GOING' && value.notGoing++;

                return value;
            }, initialValue);
        };

        resource.isOpen = function (meetup) {
            return new Date(meetup.date) > Date.now();
        };

        return resource;
    });

})();