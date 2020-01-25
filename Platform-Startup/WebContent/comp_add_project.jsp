<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<div class="">

<div class="row bg-dark sticky-top " >
		<div class="col-5"></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="company_home.jsp">Home</a></h5></div>
		<div class="col-2" ><h5 style="height:60px; text-align: center; padding:15px"><a href="list_stp_comp.jsp">Fund List</a></h5></div>
		<div class="col-2"><h5 style="height:65px; text-align: center; padding:15px"><a href="comp_project_list.jsp">Bid Details</a></h5></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="logout.htm">Logout</a></h5></div>
		<div class="col-1"></div>
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
</body>
</html>
