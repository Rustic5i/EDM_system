const viewHtmlDelete = document.getElementById('idWindowOrganization')
viewHtmlDelete.style.display = "none" // закрыть окно
let OrgList = angular.module('OrgList', []) // создаем обьект Angular
// $scope - это как бд, в него будет сохранять все что нам будет нужно. И мы будем получать к нему доступ в вью через скобки {{}}
OrgList.controller('orgListController', function ($scope, $http) {
    $http.get('http://localhost:8080/api/organization').then(resp => {
        $scope.listOrg = resp.data;
        console.log($scope.listOrg)
    }, resp => {
        console.error(resp)
    })
/////////////////////////// Запросить список Department по id Organization ///////////////////////////
    $scope.getDepartByIdOrg = function (idOrganization) {
        $http.get('http://localhost:8080/api/organization/' + idOrganization + '/department').then(resp => {
            $scope.listDepartment = resp.data
            $scope.listButtonOrganization($scope.listDepartment, idOrganization)
            console.log($scope.listDepartment)
        }, resp => {
            console.error(resp)
        })
       $scope.windowsOrganization(idOrganization)
    }
    ///////////////                 ////////////////////
    $scope.windowsOrganization=function (idOrganization){
        $scope.listOrg.forEach(org=>{
            if (org.id===idOrganization){
                $scope.dataOrganization = org
            }
        })
        const viewHtmlDelete = document.getElementById('idWindowOrganization')
        viewHtmlDelete.style.display = "block" // открыть окно
    }
///////////////////////////////////// Вывести список Department//////////////////////////
    $scope.listButtonOrganization = function (listDepart, idOrg) {
        const container = $('#idDepart' + idOrg);
        console.log(container)
        let html = ''
        listDepart.forEach(deport => {
            let buttonHtml = ` <button onclick="getListEmployee(${deport.id})" class="btn btn-info" id="textNameOrg1" data-bs-toggle="collapse"data-bs-target="#ListEmpoloyee${deport.id}" style="margin-top: 10px">
                                    ${deport.nameDepartment}</button>
                                    <div class="container" id="ListEmpoloyee${deport.id}">
                                     
                                    </div>
`
            html += buttonHtml;
            container.html(html);
        })
        console.log(html)
    }

})

///////////////////////////// Получить список работников по id Department /////////////////////////////
function getListEmployee(idDepartment) {
    const urluserByid = 'http://localhost:8080/api/organization/department/' + idDepartment + '/employee'
    const method = {
        dataType: 'json',
        type: 'GET'
    }
    fetch(urluserByid, method).then(response => response.json()).then(users => {
        console.log(users)
        listButtonEmployee(users, idDepartment)
    })
}

/////////////////////////// Заполнить, вывести список работников ////////////////////////////////////
function listButtonEmployee(listEmployee, idDeportment) {
    const container = $('#ListEmpoloyee' + idDeportment);
    console.log(container)
    let html = ''
    listEmployee.forEach(employee => {
        let buttonHtml = `  <div class="gy-5" style="margin-top: 10px" id="Empoloyee${idDeportment}">
                                          <button class="cols-2 btn btn-success" >
                                                 ${employee.name}
                                           </button> 
                             </div>
`
        html += buttonHtml;
        container.html(html);
    })
    console.log(html)
}

/////////////////////////////


OrgList.controller('TaskListController',function ($scope, $http){
    ////////////////////// Список всех Task ////////////////////////////////////
    $http.get('http://localhost:8080/api/task').then(resp => {
        $scope.listTask = resp.data;
        console.log($scope.listTask)
    }, resp => {
        console.error(resp)
    })
    /////////////// Список всех Task по Author ////////////////////////////////////////

        $http.get('http://localhost:8080/api/task?author=1').then(resp => {
            $scope.listTaskByAuthor = resp.data
            console.log($scope.listTaskByAuthor)
        }, resp => {
            console.error(resp)
        })
    ////////////// Список Task по полю executorsTask ////////////////////////////////////
        $http.get('http://localhost:8080/api/task?executors=4').then(resp => {
            $scope.listTaskByExecutors = resp.data
            console.log($scope.listTaskByExecutors)
        }, resp => {
            console.error(resp)
        })
})
function fillModelDeletUserById(id){
    const urluserByid = '/api/admin/'+id
    const method = {
        dataType: 'json',
        type: 'GET'
    }
    fetch(urluserByid,method).then(response => response.json()).then(user => {
        console.log(user)
        $('#IdNameOrganization').val(`${user.id}`)
        $('#IdJuridicalAddress').val(`${user.firstName}`)
        $('#IdPhysicalAddress').val(`${user.lastName}`)
        $('#IdManager').val(`${user.age}`)

        viewOpenModalDeleteUser()
    })
}