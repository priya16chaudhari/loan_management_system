
var newapp=angular.module('loginapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('logCtrl', ['$scope', 'loginService','$window','$location',function($scope,loginService,$window,$location) {



// app.controller("logCtrl",function($state,$scope,$http,$window,loginService){



$scope.backendLoginObj={};
$scope.loginObj={};

$scope.go=function(loginObj)
{
      loginService.insertLoginRecord(loginObj).then(function(response)
    {


        $scope.loginObj=response.data.result;
 
     if($scope.loginObj.username!=null && $scope.loginObj.password!=null)
    {
      
      alert("Login Successfully!");
        // $scope.loginObj=null;
           // $scope.loginObj=$scope.backendLoginObj;


$window.sessionStorage.setItem('username', response.data.result.username);
$window.sessionStorage.setItem('password', response.data.result.password);



console.log("username"+JSON.stringify($window.sessionStorage.getItem('username')));


console.log("password"+JSON.stringify($window.sessionStorage.getItem('password')));

   // $state.go('dashboard.html');

          var host = $window.location.host;
        var landingUrl = "dashboard.html";
       // alert(landingUrl);
        $window.location.href = landingUrl;
      }
      else
        {
      alert("Login Failed!");
        $scope.loginObj=null;
      }
  })
}

// $scope.forgotFun=function(forgotobj)
// {
//    loginService.insertNewPassword(forgotobj).then(function(response)
//     {
//       if(response.data.result==1)
//       {
//         alert("Password Changed Successfully!!!");
//         $scope.forgotobj=null;
//       }
//       else
//       {
//         alert("Password could not changed");
//         $scope.forgotobj=null;        
//       }
    
//     })
// }

//ctrl closing
// });
}]);


newapp.service("loginService",function($http){



//  this.insertRegisterRecord=function(registerObj)
// {
//       return $http.post(hostUrl+"insertRegister",registerObj);

// }
this.insertLoginRecord=function(loginObj)
{
      return $http.post("http://localhost:8082/"+"insertLogin",loginObj);

}
this.insertNewPassword=function(forgotobj)
{
      return $http.post("http://localhost:8082/"+"forgotPassword",forgotobj);

}

//  this.updateContactService=function(feeObj)
// {
//       return $http.post(hostUrl+"updateContact",feeObj);

// }


//  this.getContactService=function()
// {
//       return $http.get(hostUrl+"getContact");

// }

 })


