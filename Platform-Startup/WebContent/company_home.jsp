<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Home</title>
<link rel="stylesheet" href="sample.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body >

 <c:if test="${sessionScope.uname == null}">
	<%= "user is not available" %>
	<c:redirect url="login.jsp"></c:redirect>
</c:if>

<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">


<div id="mySidenav" class="sidenav">
  
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
  <a href="comp_add_project.jsp">Add project</a>
  <a href="list_stp_comp_cntr.htm">Funds List</a><br>
 <a href="list_stp_apply_bidding.htm">Bid Details</a>
 
</div>


<div class=" row bg-dark sticky-top " >
		<div class="col-2"></div>
		<div class="col-1">
			<span style="font-size:30px;cursor:pointer;color: red;" onclick="openNav()">&#9776; Menu</span>
		</div>
		<div class="col-6"></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="home_startup.htm">Home</a></h5></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="logout.htm">Logout</a></h5></div>
		<div class="col-1"></div>
</div>



<div class="container" >
	
	<div class="row">
		<div class="LeftSideBar"></div>
	</div>
	
	

<div class="row" style="padding:10px;"></div>
<h2 style="background-color:lightgreen;  height:50px; text-align: center; padding:10px;">List of Startup</h2>




<!-- ----------------------------------------------------------------------------------------------------------------- -->





<div class="container mt-2">
<div class="row">
	<div class="col-3">
		
		<table class="table">
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
      				<th scope="col">Startup Name</th>
  				</tr>
  			</thead>
  			<tbody>
  			
  				<c:forEach items="${startupname}" var="temp">
      				<tr class="table-info">
      				<th></th>
      				<th scope="row">${temp}</th>
   				</c:forEach>
   			
   			</tbody>
   		</table>	
	</div>
	   
  	<div class="col-9">
  	 
 		<table class="table">	 	
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
    				<th scope="col">Employee</th>
      				<th scope="col">Email</th>
      				<th scope="col">Description</th>
      
  				</tr>
  			</thead>
   			<tbody>
   				<c:forEach items="${lists}" var="temp">
   				<tr class="table-info">
   					<th scope="col"></th>
      				<td>${temp.noOfEmployee}</td>
      				<td>${temp.email}</td>
       				<td>${temp.discription}</td>
 					<tr>
 	 			 </c:forEach>
   			</tbody>   		
		</table>	
   </div>
</div> 	

		
<!-- ------------------------------------------------------------------------------------------------------------------ -->

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
	
</div>
</c:if>
</body>
</html>