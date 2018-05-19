<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- <script type="text/javascript">
$(window).on('load', function(){
	
	$("#resetpwd").hide();
	$("#checkemail").bind("click",verify);
});

</script>
 
  <script type="text/javascript">
   function verify(){
	   alert("inside verify")
	   
	   var v = $("#exampleInputEmail1").val();
	   if(v == null || v==''){
		   alert("please enter the email id??");
	   }
	   else{
	   
   $.ajax({
		type:"POST",
	   url:  "findemail.html?${_csrf.parameterName}=${_csrf.token}&email="+$("#exampleInputEmail1").val(),
			   
	   success: function(response) { 
	   	
		   $("#resetpwd").show();   
		   $("#emaildiv").hide();
	   },
			   
	   error : function(xhr, ajaxOptions, thrownError) {
			alert("error");
		},	   
			   
   });
	   }
   }
   </script> -->
 
  
 <!--  <script type="text/javascript">
	$(document).ready(function(){
		
		
		
		$(".reg").click(function(){
			
		$("#emaildiv").modal('show');
		});
		
		$("#resetpwd").bind("click",save);
	});
  
  </script> -->
  
   
  <script type="text/javascript">
    function Validate() {
        var password = document.getElementById("exampleInputPassword1").value;
        var confirmPassword = document.getElementById("exampleInputPassword2").value;
        if (password != confirmPassword) {
            alert("Passwords do not match!!!.");
            return false;
        }
        return true;
    }
</script>
  
</head>

<body style="background-image: url('img/Arcadia-Power-wind-farm-2.jpg');">
<div id="emaildiv">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">ForGot Password</div>
      <div class="card-body">
        <form action="resetpwd.html" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" name="email1" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" pattern="[^ @]*@[^ @]*" placeholder="Enter Your Registered Email">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" name="pwd" id="exampleInputPassword1" type="password" placeholder="Enter New Password">
            </div>
            <div class="form-group">
             <label for="exampleInputPassword2">Re-Enter Password</label>
            <input class="form-control" name="pwd2" id="exampleInputPassword2" type="password" placeholder="Re-Enter Password">
          </div> 
          <button type="submit" class="btn btn-primary btn-block" onclick="Validate()">ReSet</button>
        </form>
        </div>
      </div>
    </div>
  </div>
  
 <!--  </div> -->
  
 <!--  <div id="resetpwd">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Enter New Password</div>
      <div class="card-body">
        <form action="resetpwd.html" method="post">
          
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" name="pwd" id="exampleInputPassword1" type="password" placeholder="Password">
            
             <label for="exampleInputPassword2">Re-Enter Password</label>
            <input class="form-control" name="pwd2" id="exampleInputPassword2" type="password" placeholder="Password">
          </div> 
          <button type="submit" class="btn btn-primary btn-block" id="verify" >Reset</button>
        </form>
        </div>
      </div>
    </div>
  
  </div> -->
  
  
  
  
  
  
  
 
</body>

</html>
