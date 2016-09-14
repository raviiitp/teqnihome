angular.module('teqnihome')
    .controller('teqnihomeCtrl',
    function ($rootScope, $scope, $window, $timeout, $state, $q, localStorageService, $location, teqnihomeFactory, teams) {

        $scope.teams = {};
        var processTeamInfo = function(){
            angular.forEach(teams, function(team) {
                if ($scope.teams[team.teamName] == undefined) {
                    $scope.teams[team.teamName] = {};
                    //$scope.teams[team.teamName]["students"] = {};

                }
                if ($scope.teams[team.teamName][team.studentName] = undefined) {
                    $scope.teams[team.teamName][team.studentName] = {};
                }
                $scope.teams[team.teamName][team.studentName] = {
                    'studentId': team.teamStructurePK.studentId,
                    'teamId': team.teamStructurePK.teamId
                }
            });
        };
        processTeamInfo();

        var updatedStudentInfo = {};

        $scope.onDropComplete=function(student, evt, teamName){
            $scope.teams[teamName][student[0]] = student[1];
            if(updatedStudentInfo[student[0]] == undefined){
                updatedStudentInfo[student[0]] = {};
            }
            updatedStudentInfo[student[0]] = student[1];
            updatedStudentInfo[student[0]]["teamName"] = teamName;
        };

        $scope.onDragSuccess=function(student, evt, teamName){
            delete $scope.teams[teamName][student[0]];
        };

        $scope.updateTeamStructure = function() {
            if(updatedStudentInfo !== {}){
                var deferredObject = $q.defer();
                teqnihomeFactory.updateTeamStructure().updateTeamStructure({}, updatedStudentInfo).
                    $promise.
                    then(function (result) {
                        deferredObject.resolve(result);



                    }, function (errorMsg) {
                        deferredObject.reject(errorMsg);
                    });
            }

        };
    })
;

