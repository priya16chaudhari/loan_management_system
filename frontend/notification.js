var newapp=angular.module('notificationapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('notificationCtrl', ['$scope', 'notificationService','$window','$location',function($scope,notificationService,$window,$location) {

//alert("notificationCtrl");
//app.controller("notificationCtrl",function($state,$scope,notificationService){

//alert("notification js");


// $scope.alertshow=function()
// {
//   $state.go('notification');

  
// }

// //Notification cnt using API

$scope.newupdatedlist=[];
$scope.businessList2=[];
$scope.newobj={};
$scope.getData=function()
   {

    notificationService.getBusinessnew().then(function(response)
    {
        
      $scope.businessList2=response.data.result;
      // alert("updated alert List"+JSON.stringify($scope.businessList2));

      $scope.newupdatedlist.push($scope.businessList2);
      $scope.contnotify=$scope.businessList2.length;

      
      $scope.notificationFun($scope.newupdatedlist);

   //alert("newupdatedlist inner alert List"+JSON.stringify($scope.newupdatedlist));

  
    })
  }


  $scope.newListNotification=[];
$scope.notificationFun=function(newupdatedlist)
{
 // alert("notiii");
  $scope.newListNotification=$scope.newupdatedlist;
  //console.log("shr");
 // console.log("notificationFun newupdatedlist="+JSON.stringify($scope.newListNotification));
  //alert("after newListNotification print");
}

$scope.businessList=[];
$scope.getBusinessRecord=function()
   {


    notificationService.getBusinessnewwwww().then(function(response)
    {
           $scope.businessList=response.data.result;


        $scope.CurrentDate1=new Date();   
      for (var i = 0; i <$scope.businessList.length; i++) {
          

            $scope.d1=$scope.businessList[i].alertdate;
             

              var currr=$scope.CurrentDate1;

              var dateTime = moment(currr).format('YYYY-MM-DD');
              $scope.d3=dateTime;

         if($scope.d3==$scope.businessList[i].alertdate)
         {

            $scope.getData();


         }
      }
    })
  }

  $scope.getBusinessRecord();


//ctrl closing
// });
}]);

newapp.service("notificationService",function($http){


//Notification
 this.getBusinessnewwwww=function()
 {
      return $http.get("http://localhost:8082/"+"getBusinessnewwwww");

 }

 
this.getBusinessnew=function()
{
      return $http.get("http://localhost:8082/"+"getBusinessnew");

}



})