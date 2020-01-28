<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">

<div class="">

<div class="container-fluid sticky-top" >

	<div class="row bg-dark" style="height:60px; padding:15px; font-size:20px;">
	<div class="col-5"></div>
		<div class="col-5"><h4 class="text-light">Add Project</h4> </div>
		<div class="col-1"><a href="home_startup.htm" class="text-light">HOME</a></div>
		 <div class="col-1"><a href="logout.htm" class="text-light"><h4>Logout</h4></a></div>
	</div>
	
</div>

<div class="login-page">
		
    <div class="form">
    <form class="register-form" action="comProjectAdd.htm" method="post">
        <div class="col-1"></div>
        <div class="col-10" style="font-size:30px;text-align: center;">Project Details</div> 
        <div class="col-1"><br></div> 
       
        <input type="text" name="projectName" placeholder="Project-Name"/>
        <input type="text" name="projectTechnology" placeholder="Project-technology"/>
        <input type="text" name="projectDuration" placeholder="Project-Duration"/>
        <input type="text" name="projectDescription" placeholder="Project-Description"/>
        <input type="text" name="projectBidAmount" placeholder="Project-Bid-amount"/>
         
        
        <input type="submit" value="Add Project">
        
    </form>
    </div>
    </div>
    </div>
</c:if>    
</body>
</html>
