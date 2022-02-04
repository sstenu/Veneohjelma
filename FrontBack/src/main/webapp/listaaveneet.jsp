<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/tyyli.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Venesovellus</title>
</head>
<body>
<table id="listaus">
	<thead>
		<tr>
			<th colspan="7" class="oikealle"><span id="uusiVene">Lisää vene</span></th>
		</tr>
		<tr>
			<th colspan="3">Hakusana:</th>
			<th colspan="3"><input type="text" id="hakusana"></th>
			<th><input type="button" value="HAE" id="hakunappi"></th>
		</tr>
		<tr>
			<th>Tunnus</th>
			<th>Nimi</th>
			<th>Merkki ja malli</th>
			<th>Pituus</th>
			<th>Leveys</th>
			<th>Hinta</th>
			<th>Muuta/Poista</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<script>
$(document).ready(function(){
	
	$("#uusiVene").click(function(){
		document.location="lisaavene.jsp";
	})
	
	haeVeneet();
	
	$("#hakunappi").click(function(){
		haeVeneet();
	});
	
	$(document.body).on("keydown", function(event){
		if(event.which==13){
			haeVeneet();
		}
	});
	
	$("#hakusana").focus();
	
});

function haeVeneet(){	
	$("#listaus tbody").empty();
	$.ajax({url:"veneet/"+$("#hakusana").val(), 
		type:"GET", 
		dataType:"json", 
		success:function(result){//Funktio palauttaa tiedot json-objektina		
			$.each(result.veneet, function(i, field){  
	        	var htmlStr;
	        	htmlStr+="<tr id='rivi_"+field.tunnus+"'>";
	        	htmlStr+="<td>"+field.tunnus+"</td>";
	        	htmlStr+="<td>"+field.nimi+"</td>";
	        	htmlStr+="<td>"+field.merkkimalli+"</td>";
	        	htmlStr+="<td>"+field.pituus+"</td>";  
	        	htmlStr+="<td>"+field.leveys+"</td>";
	        	htmlStr+="<td>"+field.hinta+"</td>";
	        	htmlStr+="<td><a href='muutavene.jsp?tunnus="+field.tunnus+"'>Muuta</a>&nbsp";
	        	htmlStr+="<span class='poista' onclick=poista("+field.tunnus+",'"+field.nimi+"')>Poista</span></td>";
	        	htmlStr+="</tr>";
	        	$("#listaus tbody").append(htmlStr);
	        });
		}
	});
};

function poista(tunnus, nimi){
	if(confirm("Poista vene " + nimi + "?")){
		$.ajax({url:"veneet/"+tunnus, type:"DELETE", dataType:"json", success:function(result) { //result on joko {"response:1"} tai {"response:0"}
	        if(result.response==0){
	        	$("#ilmo").html("Veneen poistaminen epäonnistui.");
	        }else if(result.response==1){
	        	$("#rivi_"+tunnus).css("background-color", "red"); //Värjätään poistetun asiakkaan rivi
	        	alert("Veneen " + nimi +" poistaminen onnistui.");
				haeVeneet();        	
			}
	    }});
	}
};

</script>
</body>
</html>