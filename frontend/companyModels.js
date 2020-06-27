var newapp=angular.module('companyModelsapp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller('companyCtrl1', ['$scope', 'pieService','$window','$location',function($scope,pieService,$window,$location) {

//app.controller("companyCtrl1",function($state,$scope,pieService){

//alert("hiiiiiiiiiiiiiiii");

$scope.closeLists=[];
 
$scope.pieObj={};



$scope.getPieDetailsCnt=function()
   {

    pieService.getPieDetails().then(function(response)
    {

      $scope.pieObj=response.data.result;

      $scope.pieObj.per=((($scope.pieObj.targetCnt-$scope.pieObj.loanCnt)*100)/($scope.pieObj.loanCnt));

       $scope.pieObj.peramt=((($scope.pieObj.targetCnt-$scope.pieObj.loanCnt)));
       // alert("pieObj  per="+JSON.stringify($scope.pieObj));
       //        alert("borrowerList1  per="+JSON.stringify($scope.pieObj.borrowerModelList1));

              $scope.closeLists=$scope.pieObj.borrowerModelList1;

      // alert("loan cnt"+JSON.stringify($scope.pieObj.loanCnt));
      //  alert("targetCnt cnt"+JSON.stringify($scope.pieObj.targetCnt));

google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);

        
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
    
          ['Total Loan Amount Send',  $scope.pieObj.loanCnt],
         
          ['Total Target Amount Received', $scope.pieObj.targetCnt],



        ]);

        var options = {
          title: 'Company Balance Sheet',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }



google.charts.setOnLoadCallback(drawChart1);
      function drawChart1() {
        var data1 = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
    
          ['Total Loan Amount Send',  $scope.pieObj.per]
          
        ]);

        var options1 = {
          title: 'Profit Percentage',
          is3D: true,
        };

        var chart1 = new google.visualization.PieChart(document.getElementById('piechart_3d1'));
        chart1.draw(data1, options1);
      }


  
    })

   }


$scope.getPieDetailsCnt();



//ctrl closing
// });
}]);

newapp.service("pieService",function($http){

// //for Notification
// this.getBusinessnewwwww=function()
//  {
//       return $http.get(hostUrl+"getBusinessnewwwww");

//  }
// this.getBusinessnew=function()
// {
//       return $http.get(hostUrl+"getBusinessnew");

// }


 this.getPieDetails=function()
{
      return $http.get("http://localhost:8082/"+"getPieDetails");

}
this.getCloseDetails=function()
{
      return $http.get("http://localhost:8082/"+"getCloseDetails");

}

})


