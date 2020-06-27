var newapp=angular.module('businessLoanapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('businessLoanCtrl', ['$scope', 'businessService','$window','$location',function($scope,businessService,$window,$location) {

//alert("businessLoan");
//app.controller("businessCtrl",function($state,$scope,businessService){


$scope.bussinessObj={};
$scope.emiOneList=['EMI','Onetime'];
// alert("hi")


// //Notification cnt using API
// $scope.contnotify;
// $scope.alertshow=function()
// {
//   $state.go('notification');
  
// }
// $scope.newupdatedlist=[];
// $scope.businessList2=[];
// $scope.newobj={};
// $scope.getData=function()
//    {

//     businessService.getBusinessnew().then(function(response)
//     {
        
//       $scope.businessList2=response.data.result;
//       // alert("updated alert List"+JSON.stringify($scope.businessList2));

//       $scope.newupdatedlist.push($scope.businessList2);
//       $scope.contnotify=$scope.businessList2.length;

      
//       $scope.notificationFun($scope.newupdatedlist);

//    //alert("newupdatedlist inner alert List"+JSON.stringify($scope.newupdatedlist));

  
//     })
//   }
//  $scope.newListNotification=[];
// $scope.notificationFun=function(newupdatedlist)
// {
//  // alert("notiii");
//   $scope.newListNotification=$scope.newupdatedlist;
//   //console.log("shr");
//  // console.log("notificationFun newupdatedlist="+JSON.stringify($scope.newListNotification));
//   //alert("after newListNotification print");
// }

// $scope.businessList=[];
// $scope.getBusinessRecord=function()
//    {


//     businessService.getBusinessnewwwww().then(function(response)
//     {
//            $scope.businessList=response.data.result;


//         $scope.CurrentDate1=new Date();   
//       for (var i = 0; i <$scope.businessList.length; i++) {
          

//             $scope.d1=$scope.businessList[i].alertdate;
             

//               var currr=$scope.CurrentDate1;

//               var dateTime = moment(currr).format('YYYY-MM-DD');
//               $scope.d3=dateTime;

//          if($scope.d3==$scope.businessList[i].alertdate)
//          {

//             $scope.getData();


//          }
//       }
//     })
//   }

//   $scope.getBusinessRecord();


 $scope.percentShow=false;
$scope.showPercent=function(bussinessObj)
{
  if($scope.bussinessObj.status=='EMI')
  {
    $scope.percentShow=true;
  }
  else
  {
     $scope.percentShow=false;

  }

}
$scope.percentShow=false;

$scope.clear=function(businessObj)
{
	$scope.bussinessObj=null;
}



$scope.init=function(){
	//alert("hi")
	$scope.savebutton=true;
	$scope.updatebutton=false;
}


// 	if($scope.pettyObj.status=='pay')
// 	{
// 		$scope.pettyObj.finalAmount=parseInt($scope.pettyObj.finalAmount)+parseInt($scope.pettyObj.cash);
// 	alert("pay "+JSON.stringify($scope.pettyObj.finalAmount));
// pettyService.updatePettyDetailCashAmount($scope.pettyObj).then(function(response)
//     {
//       if(response.data.statusCode==200)
//       {
//         alert("Final Petty Cash Updated");
//         //$scope.getBorrower();
//         // $scope.adminObj=null;
//       }
//       else
//       {
//         alert("Final Petty Cash not Updated");
//       }
    
//     })
// 	}
// }


$scope.init();
$scope.editbtn=function(){
	$scope.savebutton=false;
	$scope.updatebutton=true;

}





$scope.insertData=function(bussinessObj)
{
  if($scope.bussinessObj.status=='Onetime')
  {
    $scope.bussinessObj.percent=0;
  }

  // $scope.day=3;
  // $scope.bussinessObj.returnDate = $scope.bussinessObj.returnDate;

   $scope.bussinessObj.alertdate;
   // = $scope.returnDate.setDate($scope.CurrentDate.getDate())-($scope.day);
  // alert("dates - 3"+JSON.stringify($scope.bussinessObj.alertdate));
  businessService.insertBusinessLoanDetails(bussinessObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("BusinessLoan Details Record Inserted successfully");
        // $scope.getBorrower();
        $scope.getBusinessRecordnew();

        $scope.bussinessObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert("BusinessLoan Record not Inserted");
      }
    
    })
}
$scope.list=[];
$scope.getBusinessRecordnew=function()
   {

    businessService.getBusinessnewwwww().then(function(response)
    {

      $scope.list=response.data.result;
      // alert("borrowerList====>"+JSON.stringify($scope.list));
    })

   }
$scope.getBusinessRecordnew();



//ctrl closing
// });
}]);


newapp.service("businessService",function($http){

// //for Notification
// this.getBusinessnewwwww=function()
//  {
//       return $http.get(hostUrl+"getBusinessnewwwww");

//  }
// this.getBusinessnew=function()
// {
//       return $http.get(hostUrl+"getBusinessnew");

// }

 this.insertBusinessLoanDetails=function(bussinessObj)
{
      return $http.post("http://localhost:8082/"+"insertBusinessLoanDetails",bussinessObj);

}
 this.getBusinessnewwwww=function()
 {
      return $http.get("http://localhost:8082/"+"getBusinessnewwwww");

 }


})