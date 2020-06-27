var newapp=angular.module('adminapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('adminCtrl', ['$scope', 'adminBorrowerService','$window','$location',function($scope,adminBorrowerService,$window,$location) {


//app.controller("adminCtrl",function($state,$scope,$window,adminBorrowerService){

$scope.adminObj={};
$scope.borrowerList=[];
 $scope.detailObj={};


// notification count using window session
//  var contnotify=($window.sessionStorage.getItem('contnotify'));

// $scope.count=contnotify;
// alert("count="+JSON.stringify($scope.count));


//Notification cnt using API

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

//     adminBorrowerService.getBusinessnew().then(function(response)
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


//     adminBorrowerService.getBusinessnewwwww().then(function(response)
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




$scope.clear=function(adminObj)
{
  $scope.adminObj=null;
}

$scope.init=function(){
  //alert("hi")
  $scope.savebutton=true;
  $scope.updatebutton=false;
}

$scope.init();
$scope.editbtn=function(){
  $scope.savebutton=false;
  $scope.updatebutton=true;

}

$scope.save=function(adminObj)
{
  adminBorrowerService.insertBorrower(adminObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Borrower Record Inserted successfully");
        $scope.getBorrower();

        $scope.adminObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert("Borrower Record not Inserted");
      }
    
    })
}

$scope.getBorrower=function()
   {

    adminBorrowerService.getBorrowerDetails().then(function(response)
    {

      $scope.borrowerList=response.data.result;



      // alert("borrowerList"+JSON.stringify($scope.borrowerList));
    })

   }

$scope.getBorrower();


$scope.alldata=[];
$scope.getAllDataAdminBorrower=function()
   {

    adminBorrowerService.getAllDetails().then(function(response)
    {

      $scope.alldata=response.data.result;
      // alert("borrowerList"+JSON.stringify($scope.alldata));
    })

   }
$scope.newreturnDate={};

$scope.getAllDataAdminBorrower();

  
$scope.getDetilsCustomer=function(names)
   {

    
    adminBorrowerService.getDetilsCustomers($scope.detailObj.names).then(function(response)
    {

      $scope.adminObj=response.data.result;

      
      $scope.adminObj.dailyAmt=$scope.adminObj.emi;

$scope.getAllDataAdminBorrower();
        if ($scope.adminObj.status=='close') 
        {
          alert("Borrower is Already Closed");

         $scope.sumb=true;
        // $scope.sumb1=true;
        //   $scope.sumb2=true;
        }

         // $scope.sumb=false;

    })

   }



$scope.calRemainingAmt=function()
{
 


        if ($scope.adminObj.remainAmt>0) {
          // $scope.adminObj.status='close';
          $scope.adminObj.remainAmt=$scope.adminObj.remainAmt-$scope.adminObj.totaldailyAmt;
        }else{
          // alert("elseeeeee");
          $scope.adminObj.remainAmt=0;
        }


        if ($scope.adminObj.remainAmt==0) 
        {
          $scope.adminObj.status='close';
        // $scope.adminObj.remainAmt=0;
        }


}


// $scope.calRemainingAmt();



// $scope.cnt=$scope.adminObj.dailyAmtCnt;
$scope.enterDate=function(adminObj)
{
  $scope.adminObj.dailyAmtCnt=($scope.adminObj.totaldailyAmt)/($scope.adminObj.emi);
  // alert("$scope.adminObj.dailyAmt"+JSON.stringify($scope.adminObj.dailyAmtCnt));



}

$scope.dates=function(adminObj)
{


if($scope.adminObj.curDate!=null)
{

if ($scope.adminObj.remainAmt>0) 
{


var GivenDate = $scope.adminObj.returnDate;
var CurrentDate = $scope.adminObj.curDate;
GivenDate = new Date(GivenDate);
CurrentDate = new Date(CurrentDate);
if(GivenDate < CurrentDate)
{
    // alert('if');

     $scope.adminObj.status='overdue';


}else if(GivenDate==CurrentDate)
{

    // alert('else');
    $scope.adminObj.status='pending';
}
else
{
   $scope.adminObj.status='pending';
}


 
}




if ($scope.adminObj.status=='overdue') {


 $scope.adminObj.newStatus='paid';



  adminBorrowerService.insertBorrowerDateNew(adminObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Inserted successfully");
        // $scope.getBorrower();
        // $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert(" not Inserted");
      }
    
    })


}
else{



  // $scope.adminObj.dailyAmtCnt=($scope.adminObj.totaldailyAmt)/($scope.adminObj.emi);
  // alert("$scope.adminObj.dailyAmt"+JSON.stringify($scope.adminObj.dailyAmtCnt));
  if(($scope.adminObj.dailyAmtCnt-1)!=0)
  {
    $scope.adminObj.newStatus='paid';
// $scope.
    adminBorrowerService.updateBorrowerDatesDetails(adminObj).then(function(response)
    {
      // alert("date update function");
      if(response.data.statusCode==200)
      {
        alert("Status Updated To Paid");
        //$scope.getBorrower();
        // $scope.adminObj=null;
      }
      else
      {
        alert("Status Is Unpaid");
      }
    
    })

    alert("Enter date");
    $scope.adminObj.dailyAmtCnt=$scope.adminObj.dailyAmtCnt-1;
    // $scope.sumb=true;




  }
  else if ($scope.adminObj.dailyAmtCnt==1) {
    $scope.adminObj.newStatus='paid';



    adminBorrowerService.updateBorrowerDatesDetails(adminObj).then(function(response)
    {
      // alert("date update function");
      if(response.data.statusCode==200)
      {
        alert("Status Updated To Paid");
        //$scope.getBorrower();
        // $scope.adminObj=null;
      }
      else
      {
        alert("Status Is Unpaid");
      }
    
    })

      $scope.sumb=false;

  }


}



}


$scope.update=function(adminObj)
{

// alert("adminObj"+JSON.stringify($scope.adminObj));

$scope.adminObj.dailyAmt=$scope.adminObj.totaldailyAmt;


 // $scope.adminObj.returnDate=$scope.newreturnDate;


  adminBorrowerService.updateCustoemrDetails(adminObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert(" Record Inserted successfully");

         $scope.adminObj=null;
        // $scope.getBorrower();
        // $scope.adminObj=null;
      }
      else
      {
        alert(" Record not Inserted");
      }
    
    })
}




$scope.inserttopetty=function(adminObj)
{


  adminBorrowerService.insertPettyCash(adminObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert("Borrower Record Inserted successfully");
        $scope.getBorrower();
        // $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        // alert("Borrower Record not Inserted");
      }
    
    })
}

$scope.updateFinalAmt=function(adminObj)
{

  // alert("sxdcfvgbhjkl");
  adminBorrowerService.updatePettyAmountDetails(adminObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        // alert("Amount updated successfully");
       // $scope.getBorrower();
       // $scope.borrowerObj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        // alert("Amount updated not Inserted");
      }
    
    })
}
}

//ctrl closing
// });
}]);


newapp.service("adminBorrowerService",function($http){

// //for Notification
// this.getBusinessnewwwww=function()
//  {
//       return $http.get(hostUrl+"getBusinessnewwwww");

//  }
// this.getBusinessnew=function()
// {
//       return $http.get(hostUrl+"getBusinessnew");

// }

 this.insertBorrower=function(adminObj)
{
      return $http.post("http://localhost:8082/"+"insertBorrowerDetails",adminObj);

}


 this.insertPettyCash=function(adminObj)
{
      return $http.post("http://localhost:8082/"+"insertPettyCash",adminObj);

}
 this.insertBorrowerDateNew=function(adminObj)
{
      return $http.post("http://localhost:8082/"+"insertBorrowerDateNew",adminObj);

}


 this.getBorrowerDetails=function()
{
      return $http.get("http://localhost:8082/"+"getBorrower");

}


this.getAllDetails=function()
{
      return $http.get("http://localhost:8082/"+"getAllDetails");

}





this.getDetilsCustomers=function(adminObj){
return $http.post("http://localhost:8082/" + "getDetilsCustomers",adminObj); 
}


this.updateCustoemrDetails=function(adminObj)
{
   return $http.post("http://localhost:8082/"+"updateCustoemrDetails",adminObj);

}

this.updateBorrowerDatesDetails=function(adminObj)
{
      return $http.post("http://localhost:8082/"+"updateBorrowerDatesDetails",adminObj);

}

this.updatePettyAmountDetails=function(adminObj)
{
      return $http.post("http://localhost:8082/"+"updatePettyAmount",adminObj);

}

})