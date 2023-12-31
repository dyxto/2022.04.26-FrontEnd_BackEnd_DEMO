<%-- 
    Document   : browseBooks
    Created on : Apr 22, 2022, 9:12:30 PM
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
        <h1>This is listDonatedBooks!</h1>
        <table border="1">
            <thead>
            <th>StudentEmail</th>
            <th>BookID</th>
            <th>donationDate</th>
            </thead>
            <tbody>
                <c:forEach items="${sts}" var="st">
                    <tr>
                        <td>
                            <c:out value="${st.StudentEmail}" />
                        </td>
                        <td>
                            <c:out value="${st.BookID}" />
                        </td>
                        <td>
                            <c:out value="${st.donationDate}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div><a href="index.html">Back to Index<a/></div>
    </body>
</html>
