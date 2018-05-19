<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/plain; charset=UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
<script src="vendor/jquery/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
  
  <script  type="text/javascript" src="dist/tableExport.js"></script>
	<script type="text/javascript">
	
	function exportTo(type) {

		$('#firm_table').tableExport({
			filename: 'table_%DD%-%MM%-%YY%',
			format: type,
			cols: '2,3,4',
			
		});

	}

	</script>
	
	<script type="text/javascript">
	
	function exportAll(type) {
		alert("inside the exportAll");
			$('#firm_table').tableExport({
				filename: 'table_%DD%-%MM%-%YY%-month(%MM%)',
				format: type,
				
				onbefore: function() {
				    alert('The export of tables begins!');
				  },
				  onafter: function() {
				    alert('Export complete :)');
				  },
				
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
			
			<h1 align="center">hiiii welcome to the maven project </h1>
			
		<div class="clearfix"></div>
			</div>
			
				<div class="x_content">
			<form action="">			
			 <div class="container home">

    <div class="row">
    	<h1 class="sub-header">Export Table:</h1> <br><br>
  	<div class="top-panel">
      <div class="btn-group">
        <button type="button" class="btn btn-primary btn-lg dropdown-toggle" data-toggle="dropdown" >Export to <span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
          <li><a onclick="exportTo('csv');" href="javascript://">CSV</a></li>
          <li><a onclick="exportTo('txt');" href="javascript://">TXT</a></li>
          <li><a onclick="exportTo('xls');" href="javascript://">XLS</a></li>
          <li><a onclick="exportTo('sql');" href="javascript://">SQL</a></li>
          <li><a onclick="exportAll('json');" href="javascript://">JSON</a></li>
        </ul>
      </div>
  	</div>

  	<div class="table-responsive">
          <table id="firm_table" class="table table-striped table-bordered table-hover">
            <thead>
              <tr>
                <th>Slno</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-Mail</th>
                <th>Number</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>Delpha</td>
                <td>siliciophite</td>
                <td>circumflex@masterwork.net</td>
                <td>997300858</td>
              </tr>
              <tr>
                <td>2</td>
                <td>Paula</td>
                <td>Ausiello</td>
                <td>bemirrorment@moy.edu</td>
                <td>779213455</td>
              </tr>
              <tr>
                <td>3</td>
                <td>Gaynell</td>
                <td>Salguero</td>
                <td>smoothpate@podalgia.edu</td>
                <td>999908414</td>
              </tr>
              <tr>
                <td>4</td>
                <td>Otelia</td>
                <td>Nitta</td>
                <td>hispanophile@auditorship.edu</td>
                <td>947377435</td>
              </tr>
              <tr>
                <td>5</td>
                <td>Darren</td>
                <td>Maltez</td>
                <td>toxotidae@tut.net</td>
                <td>902590424</td>
              </tr>
              <tr>
                <td>6</td>
                <td>Larraine</td>
                <td>Zelasco</td>
                <td>lanciers@unpleasantish.co.uk</td>
                <td>668639791</td>
              </tr>
            </tbody>
          </table>
        </div>

    </div>

  </div>
			
			
		<!-- 	<a href="pdfgen.html"><input type="button" value="Pdf Generation"></a> -->
			</form>
			
			</div>
			</div>
			</div>
			</div>
</div>


</body>

</html>