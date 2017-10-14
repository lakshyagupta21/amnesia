<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message Logs</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th
{
border:1px solid blue;
font-family: 'Oxygen', sans-serif;
}
td{
    margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 150px;
    margin-left: 80px;
}
th
{
background-color:blue;
color:white;
}
body
{
 text-align: center;
}
.container
{
 margin-left: auto;
 margin-right: auto;
 width: 40em;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
		$("#showTable").click(function(event){
		$.get('InputPage',function(responseJson) {
			if(responseJson!=null){
				$("#countrytable").find("tr:gt(0)").remove();
				var table1 = $("#countrytable");
				$.each(responseJson, function(key,value) { 
				var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
				rowNew.children().eq(0).text(value['receiver']); 
				rowNew.children().eq(1).text(value['body']); 
				rowNew.children().eq(2).text(value['status']); 
				rowNew.children().eq(3).text(value['time']); 
				rowNew.appendTo(table1);
		});
}
	});
	$("#tablediv").show();
	});
	$.get('GetRunningTime',function(responseJson){
		console.log("RUN : " + responseJson);
		if(responseJson != null){
			console.log("HELLO");
			document.getElementById("run-time").innerHTML += responseJson;
		}
	});
});
</script>
</head>
<body class="container">
<h1>Logs</h1>
<h1 id="run-time">Running time : </h1>
<input type="button" value="Show Table" id="showTable"/>
<div id="tablediv">
<table cellspacing="0" id="countrytable">
	<tr> 
	<th scope="col">Receiver</th>
<th scope="col">Message Body</th>
<th scope="col">Status</th>
<th scope="col">Time</th>
</tr> 
</table>
</div>
<form type="get" action="StopSending" method="POST">
    <input type="submit" value="Stop"/>
    </form>
</body>
</html>