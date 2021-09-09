
let OrgList = angular.module('OrgList', []) // создаем обьект Angular
// $scope - это как бд, в него будет сохран€ть все что нам будет нужно. » мы будем получать к нему доступ в вью через скобки {{}}
OrgList.controller('orgListController', function ($scope, $http) {
    $http.get('http://localhost:8080/api/organization').then(resp => {
        $scope.listOrg = resp.data;
        console.log($scope.listOrg)
    }, resp => {
        console.error(resp)
    })

    $scope.getDepartByIdOrg = function (idOrganization) {
        $http.get('http://localhost:8080/api/department?idOrganization='+idOrganization).then(resp => {
            // нужно пройти циклом, найти  html по айдишкам и заполнить их от сюда
            $scope.listDepartment = resp.data
            $scope.listButtonOrganization($scope.listDepartment,idOrganization)
            console.log($scope.listDepartment)
        }, resp => {
            console.error(resp)
        })
    }

    $scope.getListEmployee = function (idDepartment){
        $http.get('http://localhost:8080/api/employee?IdDepartment='+idDepartment).then(resp=>{
            $scope.lestEmployee = resp.data
            console.log($scope.lestEmployee)
        },resp =>{
            console.error(resp)
        })
    }

    $scope.listButtonOrganization = function (listDepart,idOrg) {
        const container = $('#idDepart'+idOrg);
        console.log(container)
        let html = ''
        listDepart.forEach(deport => {
            let buttonHtml = ` <button class="btn btn-primary" id="textNameOrg1" data-bs-toggle="collapse" data-bs-target="#ListEmpoloyee${deport.id}">
                                    ${deport.nameDepartment}</button>
                        <div class="collapse" id="ListEmpoloyee${deport.id}">
                              <p>TEST</p>
                         </div>
`

            html += buttonHtml;
            container.html(html);
        })
        $scope.getListEmployee(2) //тест
        console.log(html)
    }
})


