<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/css/custom.min.css"
	rel="stylesheet">


<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.1.4.1.js"></script>	

	
<script type="text/javascript">
$(function(){
	

	//Your code Here
	
//Chart.js scripts
//-- Set new default font family and font color to mimic Bootstrap's default styling
/* Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c'; */
//-- Area Chart Example
var ctx = document.getElementById("myAreaChart1");

var data1=${data1};
var data2=${data2};
var data3=${data3};
var data4=${data4};
var data5=${data5};
var data6=${data6};
/* var data7=${data7};
var data8=${data8};

var data9=${data9};
var data10=${data10};
var data11=${data11};
var data12=${data12};
var data13=${data13};
var data14=${data14};
var data15=${data15};
 */

var myLineChart = new Chart(ctx, {
type: 'line',
data: {
 labels: ["FEB 1", "FEB 2", "FEB 3", "FEB 4", "FEB 5", "FEB 6"/*,  "FEB 7", "FEB 8", "FEB 9", "FEB 10", "FEB 11", "FEB 12", "FEB 13", "FEB 14", "FEB 15" */],
 datasets: [{
   label: "Sessions",
   lineTension: 0.3,
   backgroundColor: "rgba(2,117,216,0.2)",
   borderColor: "rgba(2,117,216,1)",
   pointRadius: 5,
   pointBackgroundColor: "rgba(2,117,216,1)",
   pointBorderColor: "rgba(255,255,255,0.8)",
   pointHoverRadius: 5,
   pointHoverBackgroundColor: "rgba(2,117,216,1)",
   pointHitRadius: 20,
   pointBorderWidth: 2,
   data: [data1, data2, data3, data4, data5, data6/* , data7, data8, data9, data10, data11, data12, data13,data14,data15 */],
 }],
},
options: {
 scales: {
   xAxes: [{
     time: {
       unit: 'date'
     },
     gridLines: {
       display: false
     },
     ticks: {
       maxTicksLimit: 7
     }
   }],
   yAxes: [{
     ticks: {
       min: 70000,
       max: 150000,
       maxTicksLimit: 5
     },
     gridLines: {
       color: "rgba(0, 0, 0, .125)",
     }
   }],
 },
 legend: {
   display: false
 }
}
});

 //////////////line chart//////////////////////////
 
 var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
	type: 'bar',
	data: {
	 labels: ["FEB 1", "FEB 2", "FEB 3", "FEB 4", "FEB 5", "FEB 6"/*,  "FEB 7", "FEB 8", "FEB 9", "FEB 10", "FEB 11", "FEB 12", "FEB 13", "FEB 14", "FEB 15" */],
	 datasets: [{
	   label: "Sessions",
	   lineTension: 0.3,
	   backgroundColor: "rgba(2,117,216,0.2)",
	   borderColor: "rgba(2,117,216,1)",
	   pointRadius: 5,
	   pointBackgroundColor: "rgba(2,117,216,1)",
	   pointBorderColor: "rgba(255,255,255,0.8)",
	   pointHoverRadius: 5,
	   pointHoverBackgroundColor: "rgba(2,117,216,1)",
	   pointHitRadius: 20,
	   pointBorderWidth: 2,
	   data: [data1, data2, data3, data4, data5, data6/* , data7, data8, data9, data10, data11, data12, data13,data14,data15 */],
	 }],
	},
	options: {
	 scales: {
	   xAxes: [{
	     time: {
	       unit: 'date'
	     },
	     gridLines: {
	       display: false
	     },
	     ticks: {
	       maxTicksLimit: 7
	     }
	   }],
	   yAxes: [{
	     ticks: {
	       min: 70000,
	       max: 150000,
	       maxTicksLimit: 5
	     },
	     gridLines: {
	       color: "rgba(0, 0, 0, .125)",
	     }
	   }],
	 },
	 legend: {
	   display: false
	 }
	}
	});
 
 
//-- Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["FEB 1", "FEB 2", "FEB 3", "FEB 4", "FEB 5", "FEB 6"],
    datasets: [{
      data: [data1, data2, data3, data4, data5, data6],
      backgroundColor: ['#FF00FF', '#00FF00', '#0000FF', '#FF334C','#FFC30F','#9400D3'],
    }],
  },
});
 		
});
</script>
	
</head>

<body>


<div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-comments"></i>
              </div>
              <div class="mr-5">26 New Messages!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">11 New Tasks!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-shopping-cart"></i>
              </div>
              <div class="mr-5">123 New Orders!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-danger o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-support"></i>
              </div>
              <div class="mr-5">13 New Tickets!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>
      <!-- Area Chart Example-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-area-chart"></i> Area Chart Example</div>
        <div class="card-body">
          <canvas id="myAreaChart1" width="100%" height="30"></canvas>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
      <div class="row">
        <div class="col-lg-8">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-bar-chart"></i> Bar Chart Example</div>
            <div class="card-body">
              <div class="row">
                <div class="col-sm-8 my-auto">
                  <canvas id="myBarChart" width="100" height="50"></canvas>
                </div>
                <div class="col-sm-4 text-center my-auto">
                  <div class="h4 mb-0 text-primary">RS.908035.00</div>
                  <div class="small text-muted">Feb 1</div>
                  <hr>
                  <div class="h4 mb-0 text-warning">Rs.2080063.00</div>
                  <div class="small text-muted">Feb 2</div>
                  <hr>
                  <div class="h4 mb-0 text-success">Rs.1901521.00</div>
                  <div class="small text-muted">Feb 3</div>
                   <hr>
                  <div class="h4 mb-0 text-primary">Rs.2183194.00</div>
                  <div class="small text-muted">Feb 4</div>
                   <hr>
                  <div class="h4 mb-0 text-warning">Rs.1691972.00</div>
                  <div class="small text-muted">Feb 5</div>
                   <hr>
                  <div class="h4 mb-0 text-success">Rs.79248.00</div>
                  <div class="small text-muted">Feb 6</div>
                  
                </div>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          
        </div>
        <div class="col-lg-4">
          <!-- Example Pie Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-pie-chart"></i> Pie Chart Example</div>
            <div class="card-body">
              <canvas id="myPieChart" width="100%" height="100"></canvas>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          


      </div>
     



    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>



</body> 
</html>