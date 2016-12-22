(function () {
    "use strict";

    var module = angular.module('meetup');

    module.component('memberTab', {
        templateUrl: '/app/meetup/component/member/memberTab.html',
        bindings: {
            meetup: "<",
            edit: "<",
            onRemoveMember: "&"
        }
    });

})();