var newapp=angular.module('pettyCashapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('pettyCashCtrl', ['$scope', 'pettyService','$window','$location',function($scope,pettyService,$window,$location) {

//alert("pettyCashCtrl");


//app.controller("pettyCashCtrl",function($state,$scope,$window,pettyService){

$scope.pettyObj2={};

$scope.pettyObj={};

// alert("hi")

    var username=($window.sessionStorage.getItem('username'));

$scope.pettyObj.adminName=username;
// alert("username sidebar="+JSON.stringify($scope.pettyObj.username));

// $scope.pettyObj=angular.copy($stateParams.obj3);//obj is object of 1st html file
// alert("alla"+JSON.stringify($scope.pettyObj));




// //for notification
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

//     pettyService.getBusinessnew().then(function(response)
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


//     pettyService.getBusinessnewwwww().then(function(response)
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



$scope.cashList=['withdraw','pay'];

// $scope.pettyObj1.username=$scope.pettyObj.username;

// alert("username"+JSON.stringify($scope.pettyObj1.username));

$scope.clear=function(pettyObj)
{
	$scope.pettyObj=null;
}



$scope.init=function(){
	//alert("hi")
	$scope.savebutton=true;
	$scope.updatebutton=false;
}



$scope.cheackStatus=function(pettyObj){
  //alert("hi")
 if ($scope.pettyObj.status=='withdraw') {
  $scope.showReason=true;
 }
 else{
 	$scope.showReason=false;
 }
}


$scope.cheackamt=function(pettyObj)
{

if ($scope.pettyObj.cash<=$scope.pettyObj.finalAmount) 
{

}
else
{
	alert("You Can't withdraw Amount");
	$scope.pettyObj.cash=null;
}

}

$scope.updateFinalAmtonStatus=function(pettyObj)
{
	if($scope.pettyObj.status=='withdraw')
	{
		
		$scope.pettyObj.finalAmount=$scope.pettyObj.finalAmount-$scope.pettyObj.cash;

		// alert("withdraw "+JSON.stringify($scope.pettyObj.finalAmount));

pettyService.updatePettyDetailCashAmount($scope.pettyObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert("Final Petty Cash Updated");
        //$scope.getBorrower();
        // $scope.adminObj=null;
      }
      else
      {
        // alert("Final Petty Cash not Updated");
      }
    
    })

	
	}

	if($scope.pettyObj.status=='pay')
	{

		$scope.pettyObj.reason='pay';
		$scope.pettyObj.finalAmount=parseInt($scope.pettyObj.finalAmount)+parseInt($scope.pettyObj.cash);
	// alert("pay "+JSON.stringify($scope.pettyObj.finalAmount));
pettyService.updatePettyDetailCashAmount($scope.pettyObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert("Final Petty Cash Updated");
        //$scope.getBorrower();
        // $scope.adminObj=null;
      }
      else
      {
        // alert("Final Petty Cash not Updated");
      }
    
    })
	}
}


$scope.showReason=false;
$scope.init();
$scope.editbtn=function(){
	$scope.savebutton=false;
	$scope.updatebutton=true;

}

$scope.getFinalAmount=function()
{
	pettyService.getFinalAmount().then(function(response)
    {

      $scope.pettyObj1=response.data.result;
      // alert("$scope.pettyObj.Total="+JSON.stringify($scope.pettyObj1));


      $scope.pettyObj.finalAmount=$scope.pettyObj1.finalAmount;
  })
}
$scope.getFinalAmount();






$scope.insertData=function(pettyObj)
{

	

  pettyService.insertFinalAmt(pettyObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {


        alert(" Record Inserted successfully");


$scope.getAllDetails();

        // $scope.getBorrower();
        $scope.pettyObj.reason=null;


         $scope.pettyObj.status=null;


         // $scope.pettyObj.finalAmount=null;


         $scope.pettyObj.cash=null;


         
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert(" Record not Inserted");
      }
    
    })
}


$scope.alldata=[];
$scope.getAllDetails=function()
   {

    pettyService.getAllDetailslist().then(function(response)
    {

      $scope.alldata=response.data.result;
      // alert("borrowerList"+JSON.stringify($scope.borrowerList));
    })

   }

$scope.getAllDetails();

//ctrl closing
// });
}]);


newapp.service("pettyService",function($http){


 //for Notification
this.getBusinessnewwwww=function()
 {
      return $http.get("http://localhost:8082/"+"getBusinessnewwwww");

 }
this.getBusinessnew=function()
{
      return $http.get("http://localhost:8082/"+"getBusinessnew");

}
 

 this.getFinalAmount=function()
 {
      return $http.get("http://localhost:8082/"+"getFinalAmount");

 }
this.updatePettyDetailCashAmount=function(pettyObj)
{
   return $http.post("http://localhost:8082/"+"updatePettyDetailCashAmount",pettyObj);

}

 this.insertFinalAmt=function(pettyObj)
{
      return $http.post("http://localhost:8082/"+"insertFinalAmt",pettyObj);

}

 this.getAllDetailslist=function()
{
      return $http.get("http://localhost:8082/"+"getAllDetailslist");

}

//  this.insertDatesDeatails=function(pettyObj)
// {
//       return $http.post(hostUrl+"insertDatesDeatails",pettyObj);

// }


//  this.insertDetails=function(adminCustomer)
// {
//       return $http.post(hostUrl+"insertDetails",adminCustomer);

// }


// this.editBorrowerRecord=function(borrowerId)
//   {
//     return $http.post(hostUrl+"editBorrowerDetails/"+borrowerId);
//   }
// this.updateBorrowerDetails=function(pettyObj)
// {
//       return $http.post(hostUrl+"updateBorrower",pettyObj);

// }
// this.deleteBorrowerDetails=function(borrowerId)
// {
//       return $http.delete(hostUrl+"deleteBorrower/"+borrowerId);

// }


})