
<!DOCTYPE html>
<%@page import="web.CreditModel"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>crédit</title>
</head>
<body>
 credit page
 
 <%@page import="web.CreditModel"%>
 <%
 	CreditModel creditModel = (CreditModel) request.getAttribute("model");
 %>
 
 <form action="/Credit" method="post">
 	<table>
 		<tr>
 			<td>Montant</td>
 			<td><input type="text" name="montant" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td>durée</td>
 			<td><input type="text" name="duree" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td>taux</td>
 			<td><input type="text"  name="taux"/></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><input type="submit" value="calculer" /></td>
 			<td></td>
 			<td></td>
 		</tr>
 	</table>
 </form>
  	<table>
 		<tr>
 			<td>Mensualite</td>
 			<td><%= creditModel.getMensualite() %></td>
 		</tr>
 	</table>
</body>
</html>