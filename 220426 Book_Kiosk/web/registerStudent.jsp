<%-- 
    Document   : registerStudent
    Created on : Apr 22, 2022, 9:53:28 PM
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
        <h1>Register Student Page</h1>
        <h1>Please enter required fields</h1>
        <form action="registerStudentAccountCTL" method="post">
<!--            <div id="StudentID">Student ID</div>
                <input type="text" name="StudentID">-->
            <div id="StudentEmail">Student Email</div>
                <input type="text" name="StudentEmail">
            <div id="StudentPassword">Student Password</div>
                <input type="text" name="StudentPassword">
            <div id="submit">
                <input type="submit" value="registerStudentAccount" id="submit">
            </div>
        </form>
        
        <div><a href="index.html">Back to Index<a/></div>
    </body>
</html>
