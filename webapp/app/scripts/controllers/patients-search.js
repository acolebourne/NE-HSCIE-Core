'use strict';

angular.module('rippleDemonstrator')
  .controller('PatientsSearchCtrl', function ($scope, $stateParams, $window, $state, PatientSearchService, usSpinnerService, UserService) {

    $scope.searching = false;

    UserService.findCurrentUser().then(function (response) {
      $scope.currentUser = response.data;
      $stateParams.patientSource = $scope.currentUser.feature.patientSource;
    });

    $scope.dateOfBirthDatePicker = function ($event, name) {
      $event.preventDefault();
      $event.stopPropagation();

      $scope[name] = true;
    };

    $scope.searchPatients = function (search) {
      usSpinnerService.spin('patientSearch-spinner');

      $scope.formSubmitted = true;
      $scope.patientSearchForm.$valid = true;

      $scope.searching = true;

      if (search != undefined) {
        PatientSearchService.searchPatients(search, 'TIE').then(function (result) {
          $scope.patients = result.data;
        });
      }

      $scope.searching = false;
      usSpinnerService.stop('patientSearch-spinner');
    };

    $scope.sort = function () {
      if ($stateParams.orderType === 'ASC') {
        $stateParams.orderType = 'DESC';
      } else {
        $stateParams.orderType = 'ASC';
      }

      $stateParams.pageNumber = 1;
      getData();
    };

    $scope.go = function (patient) {
      $state.go('patients-landing', {
        patientId: patient.nhsNumber,
        reportType: $stateParams.reportType,
        searchString: $stateParams.searchString,
        queryType: $stateParams.queryType,
        patientSource: $stateParams.patientSource
      });
    }
  });
