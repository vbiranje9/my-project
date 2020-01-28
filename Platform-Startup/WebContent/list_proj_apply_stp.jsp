<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="com.cdac.StartupProject.model.Bidding"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Applied By Startup </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style type="text/css">

body {
  font-family: "Lato", sans-serif;
  
}

	#link { color: white; } 
	
	#link:hover {background-color:black;}
	
a:hover {
  background-color: green;
}

.vl {
  border-left: 6px solid green;
  height: 500px;
}

	.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display:white;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}



.AppyBid{
  background-color :red;
  color: white;
  padding: 10px 20px;
  border-radius: 4px;
  border-color: red;
}

#mybutton {
  position: fixed;
  bottom: 30px;
  right: 60px;
}


</style>
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">

<div class="container-fluid" >

	<div class="row bg-dark" style="height:50px; padding:10px; font-size:20px;">
	<div class="col-5"></div>
		<div class="col-5"><h4 class="text-light">Bidding List</h4> </div>
		<div class="col-1"><a href="home_startup.htm" class="text-light">HOME</a></div>
		 <div class="col-1"><a href="logout.htm" class="text-light"><h4>Logout</h4></a></div>
	</div>
	
</div>
<span class="row"> "" </span>
   <!-- <div class="container mt-4"> -->    
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
  			
  				<c:forEach items="${startupname}" var="temp1">
      				<tr class="table-info">
      				<th></th>
      				<th scope="row">${temp1}</th>
   				</c:forEach>
   			
   			</tbody>
   		</table>	
	</div>
	   
	   
	   
	   
	   <div class="col-4">
		
		<table class="table">
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
      				<th scope="col">Project Name</th>
  				</tr>
  			</thead>
  			<tbody>
  			
  				<c:forEach items="${projectname}" var="temp">
      				<tr class="table-info">
      				<th></th>
      				<th scope="row">${temp}</th>
   				</c:forEach>
   			
   			</tbody>
   		</table>	
	</div>
	   
	   
	   
	
  	<div class="col-5">
  	 
 		<table class="table">	 	
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
    				<th scope="col">Bid Amount</th>
       				<th scope="col">Bid Duration</th>
       				<th scope="col">Bid Status</th>
  				</tr>
  			</thead>
   			<tbody>
   				<c:forEach items="${lists}" var="copy">
   				<tr class="table-info">
   					<th scope="col"></th>
      				<td >${copy.bidAmount}</td>
      				<td>${copy.bidDuration}</td>
      				<td>${copy.bidStatus}</td>
       				<td class="bg-light" >
       					<form style="height: 20px;" action="selectProject.htm" method="get">
       						<input type="hidden" name="projetcId" value="${copy.projectId}"/>
        					<input type="submit" value="Select"/>
       					</form>
 					<tr>
 	 			 </c:forEach>
   			</tbody>   		
		</table>	
   </div>
</div> 	
</div>
</c:if>
</body>
</html>