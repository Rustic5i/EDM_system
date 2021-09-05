let OrgList = angular.module('OrgList', []) // ������� ������ Angular
// $scope - ��� ��� ��, � ���� ����� ��������� ��� ��� ��� ����� �����. � �� ����� �������� � ���� ������ � ��� ����� ������ {{}}
OrgList.controller('orgListController', function ($scope, $http) {

    $http.get('http://localhost:8080/api/organization').then(resp => {
        $scope.listOrg = resp.data;
        console.log($scope.listOrg)
    }, resp => {
        console.error(resp)
    })
    $scope.getDepartByIdOrg = function (id) {
        $http.get('http://localhost:8080/api/organization/' + id + '/department/').then(resp => {
            // ����� ������ ������, �����  html �� �������� � ��������� �� �� ����
            $scope.listDepartment = resp.data
            // $scope.test($scope.listDepartment)
            console.log($scope.listDepartment)
        }, resp => {
            console.error(resp)
        })
    }
    // $scope.test = function (listDepart) {
    //     const container = $('#idDepart');
    //     let html = ''
    //     listDepart.forEach(deport => {
    //         let buttonHtml = ` <div id="idDepart1" class="card card-body">${deport.id}</div>`
    //         html += buttonHtml;
    //         container.html(html);
    //     })
    //     console.log(html)
    // }
})



