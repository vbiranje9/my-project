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
</head>
<body>
<div class="login-page">
    <div class="form">
    <form class="register-form" action="comProjectAdd.htm" method="post">
        <div class="col-3"></div>
        <div class="col-6" style="font-size:20px;">Project Details</div> 
        <div class="col-3"><br></div> 
       
        <input type="text" name="projectName" placeholder="Project-Name"/>
        <input type="text" name="projectTechnology" placeholder="Project-technology"/>
        <input type="text" name="projectDuration" placeholder="Project-Duration"/>
        <input type="text" name="projectDescription" placeholder="Project-Description"/>
        <input type="text" name="projectBidAmount" placeholder="Project-Bid-amount"/>
         
        
        <input type="submit" value="Add Project">
        
    </form>
    </div>
    </div>
</body>
</html>
