

angular.module('teqnihome')
    .config(function ($stateProvider) {
        $stateProvider
            .state('teqnihomeHome', {
                parent: 'teqnihome',
                url: '/',
                data: {
                    roles: []
                },
                views: {
                    'bodyContent@': {
                        templateUrl: 'scripts/app/partials/teqnihome/teqnihome.html?v=1',
                        controller: 'teqnihomeCtrl'
                    }
                },
                resolve: {
                    dummy: function(){
                        $('body,html').animate({
                            scrollTop: 0
                        }, 10);
                    },
                    teqnihomeFactory: 'teqnihomeFactory',
                    teams: function(teqnihomeFactory, $q){
                        var deferredObject = $q.defer();
                        teqnihomeFactory.getTeamInfo().query({
                        })
                            .$promise
                            .then(function (result) {
                                deferredObject.resolve(result);
                            }, function (errorMsg) {
                                deferredObject.reject(errorMsg);
                            });
                        return deferredObject.promise;
                    }
                }
            });
    })

;