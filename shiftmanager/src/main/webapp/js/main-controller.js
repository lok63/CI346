'use strict';

appControllers.controller('MainController', ['$rootScope', '$scope', '$http', 'authorization',
    function($rootScope, $scope, $http, authorization) {
        $scope.status = 'running...';
        $scope.emp = {};
        $scope.profile = authorization.profile;
        $scope.isAdmin = authorization.hasRealmRole('admin')
        $scope.isManager = authorization.hasRealmRole('manager')

        
        $scope.init = function(){
        	$http.get("http://localhost:8333/api/employees/all").success(function(data) {
        		$scope.employees = data;
                $scope.myvalue = false;

            });
        }

		$scope.remove = function(id){
				$http.post("http://localhost:8333/api/employees/delete/" + id).success(function(data) {
	        		$scope.employees = data;
				});
		} 
		
        $scope.createEmployee = function(){
        	$http.post("http://localhost:8333/api/employees/create", $scope.emp).success(function(data) {
        		if($scope.emp.firstname != null 
        				&& $scope.emp.lastname!= null
        				&& $scope.emp.days!= null
        				&& $scope.emp.shiftTime!= null){
 
            		$scope.employees=($scope.emp);
            		$scope.init();
	        		console.log($scope.emp);

        		}else{
        			alert("Please add valid data");
        			return;
        			}
            });
        }
        
//        $scope.updateEmployee = function(id){
//        	$http.put("http://localhost:8333/api/employees/update/"+id, $scope.emp).success(function(data) {
//        		
//        		
//        	});
//        }
        
        $scope.showForm = function(){
        	 $scope.myvalue = true;
        }
        
        $scope.cancelbtn = function(){
       	 	$scope.myvalue = false;
       	 	console.log("he");
       }
        
        
        
        

        $scope.logout = function() {
        	authorization.logout();
        }
        
        $scope.init();
        
    }
]);