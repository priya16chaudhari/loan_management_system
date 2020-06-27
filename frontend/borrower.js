var newapp=angular.module('homeapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('homeCtrl', ['$scope', 'borrowerService','$window','$location',function($scope,borrowerService,$window,$location) {


//app.controller("homeCtrl",function($state,$scope,$filter,borrowerService){

$scope.borrowerObj={};
$scope.borrowerList=[];

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

//     borrowerService.getBusinessnew().then(function(response)
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


//     borrowerService.getBusinessnewwwww().then(function(response)
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



$scope.clear=function(borrowerObj)
{
	$scope.borrowerObj=null;
}

$scope.calAmtEMI=function()
{

	$scope.interest=($scope.borrowerObj.amount*2.4)/100;
    $scope.borrowerObj.emi=$scope.interest;

$scope.borrowerObj.loanDuration=50;

}

$scope.calDeductionAmt=function()
{

  
  $scope.deductionAmount=($scope.borrowerObj.amount*10)/100;
    $scope.borrowerObj.deductionAmount=$scope.deductionAmount;
  
}


$scope.calTarget=function(borrowerObj)
{

  $scope.target=($scope.borrowerObj.emi*$scope.borrowerObj.loanDuration);
   $scope.borrowerObj.targetAmt=$scope.target;
  
  // $scope.accountObj.amountinterest=parseInt($scope.accountObj.amount)+parseInt($scope.interest);

  // alert("target amt with interest 2.4%"+JSON.stringify($scope.borrowerObj.targetAmt));

}


$scope.calDate=function(borrowerObj)
{
$scope.CurrentDate = new Date();

$scope.returnDate = new Date();
$scope.numberOfDaysToAdd = 49;
  $scope.returnDate = $scope.CurrentDate.setDate($scope.CurrentDate.getDate() + $scope.numberOfDaysToAdd); 
$scope.borrowerObj.returnDate=$scope.returnDate;


}
$scope.borrowerObj.loanDuration=50;




$scope.init=function(){
	$scope.savebutton=true;
	$scope.updatebutton=false;
}

$scope.init();
$scope.editbtn=function(){
	$scope.savebutton=false;
	$scope.updatebutton=true;

}


$scope.adminCustomer={};
$scope.save=function(borrowerObj)
{
  $scope.adminCustomer.name=$scope.borrowerObj.name;
    $scope.adminCustomer.accNo=$scope.borrowerObj.accNo;
  $scope.adminCustomer.returnDate=$scope.borrowerObj.returnDate;
  $scope.adminCustomer.loanDuration=$scope.borrowerObj.loanDuration;
    $scope.adminCustomer.targetAmt=$scope.borrowerObj.targetAmt;
    $scope.adminCustomer.emi=$scope.borrowerObj.emi;


    $scope.adminCustomer.remainAmt=$scope.adminCustomer.targetAmt;
     $scope.adminCustomer.status='pending';
    $scope.adminCustomer.dailyAmt=0;
    $scope.adminCustomer.curDate=0;

     // alert("adminCustomer"+JSON.stringify($scope.adminCustomer));

      $scope.saveCustomer($scope.adminCustomer);
	borrowerService.insertBorrower(borrowerObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Borrower Record Inserted successfully");
        $scope.getBorrower();
        $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert("Borrower Record not Inserted");
      }
    
    })




   borrowerService.insertDatesDeatails(borrowerObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert("datesObj Record Inserted successfully");
        // $scope.getBorrower();
        // $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        // alert("datesObj Record not Inserted");
      }
    
    })


   
}


$scope.getBorrower=function()
   {

    borrowerService.getBorrowerDetails().then(function(response)
    {

      $scope.borrowerList=response.data.result;
    //  alert("borrowerList"+JSON.stringify($scope.borrowerList));
    })

   }
$scope.getBorrower();


$scope.saveCustomer=function(adminCustomer)
{
 
    
  borrowerService.insertDetails(adminCustomer).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert(" Record Inserted successfully");
        // $scope.getBorrower();
        // $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        // alert(" Record not Inserted");
      }
    
    })
}


$scope.edit=function(borrowerId)
{
  borrowerService.editBorrowerRecord(borrowerId).then(function(response)
  {
    $scope.borrowerObj=response.data.result;
  })
}

$scope.update=function(borrowerObj)
{
  borrowerService.updateBorrowerDetails(borrowerObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Borrower Record updated successfully");
        $scope.getBorrower();
        $scope.borrowerObj=null;
      }
      else
      {
        alert("Borrower Record not updated");
      }
    
    })
}
$scope.delete=function(borrowerId)
{
  borrowerService.deleteBorrowerDetails(borrowerId).then(function(response)
  {
     if(response.data.statusCode==200)
      {
        alert("Borrower Record deleted successfully");
        $scope.getBorrower();
        // $scope.profileobj=null;
      }
      else
      {
        alert("Borrower Record not deleted");
      }
  })
}


//ctrl closing
// });
}]);


newapp.service("borrowerService",function($http){

// //for Notification
// this.getBusinessnewwwww=function()
//  {
//       return $http.get(hostUrl+"getBusinessnewwwww");

//  }
// this.getBusinessnew=function()
// {
//       return $http.get(hostUrl+"getBusinessnew");

// }

 this.insertBorrower=function(borrowerObj)
{
      return $http.post("http://localhost:8082/"+"insertBorrowerDetails",borrowerObj);

}


 this.insertDatesDeatails=function(borrowerObj)
{
      return $http.post("http://localhost:8082/"+"insertDatesDeatails",borrowerObj);

}


 this.insertDetails=function(adminCustomer)
{
      return $http.post("http://localhost:8082/"+"insertDetails",adminCustomer);

}
 this.getBorrowerDetails=function()
{
      return $http.get("http://localhost:8082/"+"getBorrower");

}

this.editBorrowerRecord=function(borrowerId)
  {
    return $http.post("http://localhost:8082/"+"editBorrowerDetails/"+borrowerId);
  }
this.updateBorrowerDetails=function(borrowerObj)
{
      return $http.post("http://localhost:8082/"+"updateBorrower",borrowerObj);

}
this.deleteBorrowerDetails=function(borrowerId)
{
      return $http.delete("http://localhost:8082/"+"deleteBorrower/"+borrowerId);

}


})