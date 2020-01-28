<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
  <style>

.body{
   background-image:url('Startup-India-Scheme.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
    background-color:aliceblue;
    height: 100vh;
    background-size: cover;
    background-position: center;
}

.login-page{
    
  width: 360px;
  padding:10% 0 0 ;
  margin: auto;  
}

.form{

    position: relative;
    z-index: 1;
    background:lightgrey;
    max-width: 360px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 10px 10px 5px grey;
}

.form input{

    font-family: "Roboto",sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
}

.form button{
    font-family: "Roboto",sans-serif;
    text-transform: uppercase;
    outline: 0;
    background: #4CAF50;
    width: 100%;
    border: 0;
    padding: 15px;
    color: #FFFFFF;
    font-size: 14px;
    cursor: pointer;
}

.form button:hover,.form button:active{
    background: #43A047;

}

.form .message{
   margin: 15px 0 0;
   color: aliceblue;
   font-size: 12px;

}
</style>      
        
        
</head>
<body>
      <div class="login-page">
         <div class="form">
            <div class="col-3"></div>
            <div class="col-6" style="font-size:20px;">Login Form</div> 
            <div class="col-3"><br></div> 
           
             <form class="Login-form"   action="compStpLog.htm" method="post">
                 
                 <input  type="text" id ="uname" name ="username"  placeholder="Username"/>
                 <input type="password" id="pass" name="password" placeholder="Password"/>
                 <button  type="submit" class="bg-success">Login</button>
             </form>    
            
            <div class="row  mt-4" >
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light" href="registerComp.jsp"> Company  </a> </div> 
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light"  href="registerStp.jsp">  Startup </a></div>
            </div>
        </div>   
      </div>

     <script type="text/javascript">
     
function validate()
{
var username = document.getElementById("uname");
var password = document.getElementById("pass");

	if(username.value.trim() =="" && password.value.trim() == "")
		{
		document.getElementById("ures").innerHTML="Username cannot blank";
		return false;
		}
	else if(username.value.trim() =="")
		{
		alert("Username Cannot be blank");
		return false;
		
		}
	else if(password.value.trim() == "")
		{
		alert("Password Cannot be blank");		
		return false;
		}
	else{
		return true;
	}
}
</script>

</body>
</html>