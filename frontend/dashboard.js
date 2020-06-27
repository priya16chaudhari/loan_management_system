var newapp=angular.module('dashboardapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('dashboardCtrl', ['$scope', 'dashboardService','$window','$location',function($scope,dashboardService,$window,$location) {

// alert("dashboard");
//app.controller("dashboardCtrl",function($state,$scope,$window,dashboardService){

$scope.dashboardObj={};
$scope.allLists=[];
$scope.pendingLists=[];
$scope.overdueLists=[];
$scope.closeLists=[];

$scope.Lists=['all','pending','overdue','close'];
$scope.allList=true;
$scope.contnotify;

// $scope.flag=0;
  


$scope.alertshow=function()
{
  //alert("img click function");
  //$state.go('notification');

var host = $window.location.host;
        var landingUrl = "notification.html";
       // alert(landingUrl);
        $window.location.href = landingUrl;

  // alert("hiiii alertshow function");
  // if ($scope.flag==0) 
  // {
  // $scope.alertbox=true;
  // $scope.flag=0;
  // }
}
// $scope.hide=function()
// {
//   $scope.alertbox=false;
// }



$scope.showList=function(list)
{
 
  if ($scope.dashboardObj.list=='all') 
  {
    $scope.allList=true;

     $scope.pendingList=false;
 
    $scope.overdueList=false;
    $scope.closeList=false;
    $scope.onViewBtnShow=false;
  }
  if ($scope.dashboardObj.list=='pending') 
  {
    $scope.pendingList=true;
    $scope.allList=false;
    $scope.overdueList=false;
    $scope.closeList=false;
     $scope.onViewBtnShow=false;
  }
  if ($scope.dashboardObj.list=='overdue') 
  {
     $scope.onViewBtnShow=false;
    $scope.overdueList=true;
    $scope.allList=false;
    $scope.pendingList=false;
    $scope.closeList=false;

  }
  if ($scope.dashboardObj.list=='close') 
  {
    $scope.closeList=true;
    $scope.overdueList=false;
    $scope.allList=false;
    $scope.pendingList=false;
     $scope.onViewBtnShow=false;

  }
}

$scope.getAllList=function()
   {

    dashboardService.getAllDetails().then(function(response)
    {

      $scope.allLists=response.data.result;
       // alert("allLists"+JSON.stringify($scope.allLists));
    })

   }
$scope.getAllList();

$scope.getPendingList=function()
   {

    dashboardService.getPendingDetails().then(function(response)
    {

      $scope.pendingLists=response.data.result;
       //alert("pendingLists"+JSON.stringify($scope.pendingLists));
    })

   }
$scope.getPendingList();

$scope.getOverdueList=function()
   {

    dashboardService.getOverdueDetails().then(function(response)
    {

      $scope.overdueLists=response.data.result;
      // alert("overdueLists"+JSON.stringify($scope.overdueLists));
    })

   }
$scope.getOverdueList();

$scope.getCloseList=function()
   {

    dashboardService.getCloseDetails().then(function(response)
    {

      $scope.closeLists=response.data.result;
       // alert("closeLists"+JSON.stringify($scope.closeLists));
    })

   }
$scope.getCloseList();

$scope.lists=[];
  $scope.onViewBtnShow=false;

$scope.view=function(name)
{
  $scope.onViewBtnShow=true;
  $scope.pendingList=false;


$scope.closeList=false;
    $scope.overdueList=false;
    $scope.allList=false;
  
   $scope.obj=name;
      // alert("obj="+JSON.stringify($scope.obj));
   dashboardService.getPendingViewDetails(name).then(function(response)
    {




  $scope.pendingViewListdate=response.data.result;

  // alert("pendingViewList"+JSON.stringify($scope.pendingViewListdate));

})


    dashboardService.getPendingViewDetailsAmt(name).then(function(response)
    {

  $scope.pendingViewListAmt=response.data.result;

  // alert("pendingViewListAmt"+JSON.stringify($scope.pendingViewListAmt));

})

     dashboardService.getPendingViewDetailsStatus(name).then(function(response)
    {

  $scope.pendingViewListStatus=response.data.result;

  // alert("pendingViewListStatus"+JSON.stringify($scope.pendingViewListStatus));

})

}

//Notification Function

$scope.newupdatedlist=[];
$scope.businessList2=[];
$scope.newobj={};
$scope.getData=function()
   {

    dashboardService.getBusinessnew().then(function(response)
    {
        
      $scope.businessList2=response.data.result;
      // alert("updated alert List"+JSON.stringify($scope.businessList2));

      $scope.newupdatedlist.push($scope.businessList2);
      $scope.contnotify=$scope.businessList2.length;

      // $window.sessionStorage.setItem('contnotify', $scope.contnotify);

      // console.log("contnotify"+JSON.stringify($window.sessionStorage.getItem('contnotify')));


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


    dashboardService.getBusinessnewwwww().then(function(response)
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

$scope.ExportExcel= function () { //function define in html tag                          

                        //export to excel file
                        var tab_text = '<table border="1px" style="font-size:20px" ">';
                        var textRange;
                        var j = 0;
                        var tab = document.getElementById('example1'); // id of table
                        var lines = tab.rows.length;

                        // the first headline of the table
                        if (lines > 0) {
                            tab_text = tab_text + '<tr bgcolor="#DFDFDF">' + tab.rows[0].innerHTML + '</tr>';
                        }

                        // table data lines, loop starting from 1
                        for (j = 1 ; j < lines; j++) {
                            tab_text = tab_text + "<tr>" + tab.rows[j].innerHTML + "</tr>";                                
                        }

                        tab_text = tab_text + "</table>";
                        tab_text = tab_text.replace(/<A[^>]*>|<\/A>/g, "");          //remove if u want links in your table
                        tab_text = tab_text.replace(/<img[^>]*>/gi, "");             // remove if u want images in your table
                        tab_text = tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

                        // console.log(tab_text); // aktivate so see the result (press F12 in browser)               
                        var fileName = 'report.xls'                            
                        var exceldata = new Blob([tab_text], { type: "application/vnd.ms-excel;charset=utf-8" }) 

                        if (window.navigator.msSaveBlob) { // IE 10+
                            window.navigator.msSaveOrOpenBlob(exceldata, fileName);
                            //$scope.DataNullEventDetails = true;
                        } else {
                            var link = document.createElement('a'); //create link download file
                            link.href = window.URL.createObjectURL(exceldata); // set url for link download
                            link.setAttribute('download', fileName); //set attribute for link created
                            document.body.appendChild(link);
                            link.click();
                            document.body.removeChild(link);
                        }

                    }

        //html of button  
//ctrl closing
// });
}]);

newapp.service("dashboardService",function($http){


this.updateDetailsDatenew=function(newobj)
{
      return $http.post("http://localhost:8082/"+"updateDetailsDatenew",newobj);

}

 this.getBusinessnewwwww=function()
 {
      return $http.get("http://localhost:8082/"+"getBusinessnewwwww");

 }

  this.getAllDetails=function()
{
      return $http.get("http://localhost:8082/"+"getAllDetails");

}
 this.getPendingDetails=function()
{
      return $http.get("http://localhost:8082/"+"getPendingDetails");

}
 this.getOverdueDetails=function()
{
      return $http.get("http://localhost:8082/"+"getOverdueDetails");

}
this.getCloseDetails=function()
{
      return $http.get("http://localhost:8082/"+"getCloseDetails");

}

this.getBusinessnew=function()
{
      return $http.get("http://localhost:8082/"+"getBusinessnew");

}
this.getPendingViewDetails=function(borrowerNames)
{
      return $http.post("http://localhost:8082/"+"getPendingViewDetails/"+borrowerNames);

}




this.getPendingViewDetailsAmt=function(borrowerNames)
{
      return $http.post("http://localhost:8082/"+"getPendingViewDetailsAmt/"+borrowerNames);

}




this.getPendingViewDetailsStatus=function(borrowerNames)
{
      return $http.post("http://localhost:8082/"+"getPendingViewDetailsStatus/"+borrowerNames);

}



})