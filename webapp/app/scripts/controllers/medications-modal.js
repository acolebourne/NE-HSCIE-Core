'use strict';

angular.module('rippleDemonstrator')
  .controller('MedicationsModalCtrl', function ($scope, $modalInstance, UserService, medication, patient, modal) {

    UserService.findCurrentUser().then(function (response) {
      $scope.currentUser = response.data;
    });

    $scope.medication = medication;
    $scope.patient = patient;
    $scope.modal = modal;

    $scope.routes = [
      'Po Per Oral',
      'IV Intra Venous',
      'PN Per Nasal',
      'PR Per Rectum',
      'SL Sub Lingual',
      'SC Sub Cutaneous',
      'IM Intra Muscular'
    ];

    if (modal.title === 'Edit Medication'){
      $scope.medication.startTime = new Date($scope.medication.startTime);
      $scope.medication.startDate = new Date($scope.medication.startDate).toISOString().slice(0, 10);
      $scope.medication.dateCreated = new Date($scope.medication.dateCreated).toISOString().slice(0, 10);
    }else {
      $scope.medication.terminologyCode = '12393890';
      $scope.medication.dateCreated = new Date().toISOString().slice(0, 10);
    }

    $scope.ok = function (medicationForm, medication) {
      $scope.formSubmitted = true;

      if (medicationForm.$valid) {
        $modalInstance.close(medication);
      }
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };

    $scope.openDatepicker = function ($event, name) {
      $event.preventDefault();
      $event.stopPropagation();

      $scope[name] = true;
    };

  });
