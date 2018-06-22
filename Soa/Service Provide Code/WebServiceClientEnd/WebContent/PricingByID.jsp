<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="services.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body background ="E:/wallpapers/truck/truck15.jpg"> <center> <h1 ></h1> 
<h1 style="color:red;">Pricing By ID.... </h1>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 90%;
}
 th, td {
   border: 2px solid #dddddd;
    text-align: left;
    padding: 6px;
   
}
</style>




</head>

<body>
<table style="width:100%">
  <tr>
    <th>PriceiD</th>
    <th>Price</th>
    <th>LocationTO</th>
    <th>LocationFrom</th>
  </tr>

<% 
NewWebService_ServiceLocator p2 = new NewWebService_ServiceLocator();
		NewWebService_PortType p1 = p2.getNewWebServicePort();
		int ID = Integer.valueOf(request.getParameter("PricingID"));
String A =p1.pricingByID(ID);
String B=A.replace(A.charAt(0), ' ');
String C=B.replace(B.charAt(B.length()-1),' ');
String[] Array=C.split(",");



%>
<% for(int i=0;i<Array.length;i=i+4){ %>
	<tr>
		<td><% out.println(Array[i]); %></td>
		<td><% out.println(Array[i+1]); %></td>
		<td><% out.println(Array[i+2]); %></td>
		<td><% out.println(Array[i+3]); %></td>
	</tr>

<% } %>
</table>

</body>
</html>