<%-- 
    Document   : loginAgain
    Created on : Apr 26, 2022, 2:15:13 PM
    Author     : bootcamp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>XXX it didn't work</h1>
        <h1>Login valid. Try Again.</h1>
        <form action="loginStudentAccountCTL" method="post">
            <div id="StudentEmail">Email</div>
            <input type="text" name="StudentEmail"/><br/>
            <div id="StudentPassword">Password</div>
            <input type="text" name="StudentPassword"/><br/>
            <input type="submit" value="Login" id="submit"/>
        </form>
        <div><a href="index.html">Back to Index<a/></div>
    </body>
</html>
