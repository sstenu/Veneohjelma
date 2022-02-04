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
<title>Veneen muuttaminen</title>
</head>
<body>
	<form id="tiedot">
		<table>
			<thead>
				<tr>
					<th colspan="4"><span id="ilmo"></span></th>
					<th colspan="2" class="oikealle"><span id="takaisin">Takaisin listaukseen</span></th>
				</tr>
				<tr>
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
					<td><input type="text" name="nimi" id="nimi"></td>
					<td><input type="text" name="merkkimalli" id="merkkimalli"></td>
					<td><input type="text" name="pituus" id="pituus"></td> 
					<td><input type="text" name="leveys" id="leveys"></td>
					<td><input type="text" name="hinta" id="hinta"></td>
					<td><input type="submit" id="tallenna" value="Hyv�ksy"></td>
				</tr>
			</tbody>		
		</table>
		<input type="hidden" name="tunnus" id="tunnus">
	</form>
</body>

<script>
$(document).ready(function(){
	$("#takaisin").click(function(){
		document.location="listaaveneet.jsp";
	});
	
	var tunnus = requestURLParam("tunnus"); //Funktio l�ytyy scripts/main.js 	
	$.ajax({url:"veneet/haeyksi/"+tunnus, type:"GET", dataType:"json", success:function(result){
		$("#tunnus").val(result.tunnus);
		$("#nimi").val(result.nimi);
		$("#merkkimalli").val(result.merkkimalli);
		$("#pituus").val(result.pituus);
		$("#leveys").val(result.leveys);
		$("#hinta").val(result.hinta);
	}});
	
	
	$("#tiedot").validate({						
		rules: {	
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
			leveys:{
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
			paivitaTiedot();
		}
	});
	
});
	
	function paivitaTiedot(){	
		var formJsonStr = formDataJsonStr($("#tiedot").serializeArray()); //muutetaan lomakkeen tiedot json-stringiksi
		$.ajax({url:"veneet", data:formJsonStr, type:"PUT", dataType:"json", success:function(result) { //result on joko {"response:1"} tai {"response:0"}       
			if(result.response==0){
	      	$("#ilmo").html("Veneen p�ivitt�minen ep�onnistui.");
	      }else if(result.response==1){			
	      	$("#ilmo").html("Veneen p�ivitt�minen onnistui.");
	      	$("#nimi", "#merkkimalli", "#pituus", "#leveys", "#hinta").val("");
			}
	  }});	
	}
	
</script>
</html>