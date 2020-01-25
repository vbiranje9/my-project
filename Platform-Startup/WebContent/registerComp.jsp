<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
    <form class="register-form" action="compReg.htm" method="post">
        <div class="col-3"></div>
        <div class="col-6" style="font-size:20px;">Registration Form For Company</div> 
        <div class="col-3"><br></div>
     
        <input type="text" name="companyId" placeholder="Company-Id"/>
        <input type="text" name="compName" placeholder=" Company Name"/>
        <input type="text" name="gstId" placeholder="gst-Id"/>
        <input type="text" name="contactNo" placeholder="Phone No"/>
        <input type="text" name="email" placeholder="Email-Id"/>
        <input type="text" name="pan" placeholder="Pancard No"/>
        <input type="text" name="description" placeholder="Description"/>
        <input type="password" name="password" placeholder="Password"/>
        
        <input type="submit" value="Submit">
        
        <p class="message">Already Registered ?<a href="login.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
</html>