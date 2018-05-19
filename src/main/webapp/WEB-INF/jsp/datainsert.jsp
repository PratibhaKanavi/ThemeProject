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
	<script src="vendor/jquery/jquery.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
$("#liteinsert").on("click",function(){
	alert("load function...")
	inseert();
});
});
	
	function inseert(){
		alert("calling.......");
		$.ajax({
			type : "GET",
		   url:"litetosqlserver.html",
		   
			success:function(msg)
			{
				alert("data is successfully stored");
				 console.log(msg);
				 alert(msg);
				
			},
			error : function(msg) {
				
				alert("failed"+msg);
			}
	});
	}
	
</script>
</head>
<body>

<div class="nav-md">
<div class="clearfix" style="min-height: 930px;">

			<div class="right_col" role="main" id="mainCont">
			<div class="clearfix"></div>
			<div class="x_panel">
			<div class="x_title">
			
			
		<div class="clearfix"></div>
			</div>
			
				<div class="x_content">
			<form action="">			
			
			<a href="xmltolitedb.html"><input type="button" value="XMLTOSQLLiteDB"></a>
			<button id="liteinsert">SQLliteDBtoSqlServerInsertion</button>
				<!-- <a href="litetosqlserver.html"><input type="button" value="SQLliteDBtoSqlServerInsertion" ></a> -->
				<a href="datainsertionfromjava.html"><input type="button" value="Mast_IN"></a> 
				
			</form>
			
			</div>
			</div>
			</div>
			</div>
</div>
</html>