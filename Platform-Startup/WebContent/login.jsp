<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
      <div class="login-page">
         <div class="form">
            <div class="col-3"></div>
            <div class="col-6" style="font-size:20px;">Login Form</div> 
            <div class="col-3"><br></div> 
           
             <form class="Login-form" action="compStpLog.htm" method="post">
                 <input type="text" name="username" placeholder="username"/>
                 <input type="password" name="password" placeholder="Password"/>
                 
                 <input style="color: red;font-size: medium;" type="submit" value="Login" >
                 
            <div class="row  mt-4" >
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light" href="registerComp.jsp"> Company  </a> </div> 
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light"  href="registerStp.jsp">  Startup </a></div>
                    
			
            </div>
             </form>
            
            
             
         </div>

     </div></div>></div>></div>>


    </body>
</html>