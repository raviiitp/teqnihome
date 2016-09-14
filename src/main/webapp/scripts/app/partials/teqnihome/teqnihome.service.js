
angular.module('teqnihome')
    // get api call to server
    .factory('teqnihomeFactory', function ($resource) {

            return {
                getTeamInfo: function () {
                    return $resource('getTeamInfo/');
                },

                runTestQueries: function() {
                    return $resource('runTestQueries/', {},
                        {
                            runTestQueries: {
                                method: 'GET',
                                transformResponse: function (data) {
                                    return {testQueryResult: angular.fromJson(data)}
                                }
                            }
                        })
                },

                updateTeamStructure: function() {
                    return $resource('updateTeamStructure/', {},
                        {
                            updateTeamStructure: {
                                method: 'POST',
                                transformResponse: function (data) {
                                    return data;
                                }
                            }
                        })
                }
            };

    })
;
