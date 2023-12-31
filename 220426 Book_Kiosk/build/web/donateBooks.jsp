<%-- 
    Document   : donateBooks
    Created on : Apr 22, 2022, 9:12:48 PM
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
        <h1>This is Donate Books!</h1>
        
        <form action="donateBooksHistoryCTL" method="post">
            <div id="StudentEmail">Email</div>
            <input type="text" name="StudentEmail"/><br/>
            <div id="BookID">BookID</div>
            <input type="text" name="BookID"/><br/>
            <!--<div id="BookCopies">How many copies?</div>
            <input type="text" name="BookCopies"/><br/>-->
            <div id="donationDate">Date (YYYY-MM-DD)</div>
            <input type="text" name="donationDate"/><br/>
            
            
            <input type="submit" value="Donate" id="submit"/>
        </form>
        
        <div><a href="index.html">Back to Index<a/></div>
    </body>
</html>
