<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="scripts/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/tyyli.css">
<title>Veneen lis��minen</title>
</head>
<body>
	<form id="tiedot">
		<table>
			<thead>
				<tr>
					<th colspan="5"><span id="ilmo"></span></th>
					<th colspan="2" class="oikealle"><span id="takaisin">Takaisin listaukseen</span></th>
				</tr>
				<tr>
					<th>Tunnus</th>
					<th>Nimi</th>
					<th>Merkki ja malli</th>
					<th>Pituus</th>
					<th>Leveys</th>
					<th>Hinta</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="tunnus" id="tunnus"></td>
					<td><input type="text" name="nimi" id="nimi"></td>
					<td><input type="text" name="merkkimalli" id="merkkimalli"></td>
					<td><input type="text" name="pituus" id="pituus"></td> 
					<td><input type="text" name="leveys" id="leveys"></td>
					<td><input type="text" name="hinta" id="hinta"></td>
					<td><input type="submit" id="tallenna" value="Lis��"></td>
				</tr>
			</tbody>		
		</table>
	</form>
</body>
<script>
$(document).ready(function(){
	$("#takaisin").click(function(){
		document.location="listaaveneet.jsp";
	});
	$("#tiedot").validate({						
		rules: {
			tunnus:  {
				required: true,
				number: true,
				minlength: 1				
			},	
			nimi:  {
				required: true,
				minlength: 2				
			},
			merkkimalli:  {
				required: true,
				minlength: 2
			},	
			pituus:  {
				required: true,
				number: true,
				minlength: 1
			},
			leveys: {
				required: true,
				number: true,
				minlength: 1
			},
			hinta: {
				required: true,
				number: true,
				minlength: 1
			}
		},
		messages: {
			tunnus: {     
				required: "Puuttuu",
				number: "Ei kelpaa",
				minlength: "Liian lyhyt"			
			},
			nimi: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			merkkimalli: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			pituus: {
				required: "Puuttuu",
				number: "Ei kelpaa",
				minlength: "Liian lyhyt"
			},
			leveys: {
				required: "Puuttuu",
				number: "Ei kelpaa",
				minlength: "Liian lyhyt"
			},
			hinta: {
				required: "Puuttuu",
				number: "Ei kelpaa",
				minlength: "Liian lyhyt"
			}
		},
		submitHandler: function(form) {	
			lisaaTiedot();
		}
	});
	
	$("#tunnus").focus();
	
});
	
	function lisaaTiedot(){	
		var formJsonStr = formDataJsonStr($("#tiedot").serializeArray()); //muutetaan lomakkeen tiedot json-stringiksi
		console.log(formJsonStr);
		$.ajax({url:"veneet", data:formJsonStr, type:"POST", dataType:"json", success:function(result) { //result on joko {"response:1"} tai {"response:0"}       
			if(result.response==0){
	      	$("#ilmo").html("Veneen lis��minen ep�onnistui.");
	      }else if(result.response==1){			
	      	$("#ilmo").html("Veneen lis��minen onnistui.");
	      	$("#tunnus", "#nimi", "#merkkimalli", "#pituus", "#leveys", "#hinta").val("");
			}
	  }});	
	}

</script>
</html>