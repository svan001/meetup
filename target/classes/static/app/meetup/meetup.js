(function() {
	'use strict';

	var module = angular.module('meetup', [ 'ngResource' ]);

	module.factory('Meetup', function($resource, $http) {
		var baseUrl = 'api/meetup/:id';

		var resource = $resource(baseUrl, {
			id : '@id'
		}, {
			addMember : {
				url : baseUrl + "/member",
				method : "POST"
			}
		});

		/*
		 * resource.addMember = function(member) { return $http.post() };
		 */

		return resource;
	});

})();