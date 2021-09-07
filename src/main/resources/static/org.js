let OrgList = angular.module('OrgList', []) // создаем обьект Angular
// $scope - это как бд, в него будет сохран€ть все что нам будет нужно. » мы будем получать к нему доступ в вью через скобки {{}}
OrgList.controller('orgListController', function ($scope, $http) {
    $http.get('http://localhost:8080/api/organization').then(resp => {
        $scope.listOrg = resp.data;
        console.log($scope.listOrg)
    }, resp => {
        console.error(resp)
    })

    $scope.getDepartByIdOrg = function (id) {
        $http.get('http://localhost:8080/api/organization/' + id + '/department/').then(resp => {
            // нужно пройти циклом, найти  html по айдишкам и заполнить их от сюда
            $scope.listDepartment = resp.data
            $scope.listButtonOrganization($scope.listDepartment,id)
            console.log($scope.listDepartment)
        }, resp => {
            console.error(resp)
        })
    }



    $scope.listButtonOrganization = function (listDepart,idOrg) {
        const container = $('#idDepart'+idOrg);
        console.log(container)
        let html = ''
        listDepart.forEach(deport => {
            let buttonHtml = ` <p id="textNameOrg1">${deport.nameDepartment}</p>`
            html += buttonHtml;
            container.html(html);
        })
        console.log(html)
    }
})



