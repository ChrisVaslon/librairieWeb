<%-- 
    Document   : home
    Created on : 12 janv. 2021, 10:17:19
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <c:import url="/menu-main" />

        <div class ="container mt-4">

            <h1>Log in</h1>
            <form action="login" method= "POST">
                <c:if test ="${not empty requestScope.errLogin}">
                    <p><c:out value="${requestScope.errLogin}" /></p>
                </c:if>

                <div class="form-group">
                    <label for="email">Email address:</label>
                    <input type="email" name = "email" class="form-control" value='<c:out value ="${requestScope.emailFourni}"/>' placeholder="Enter email" id="email">

                    <c:if test ="${not empty requestScope.errMail}">
                        <p><c:out value="${requestScope.errMail}" /></p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" name ="password" class="form-control" placeholder="Enter password" id="pwd">
                    
                    <c:if test ="${not empty requestScope.errPassword}">
                        <p><c:out value="${requestScope.errPassword}" /></p>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Se connecter ! Yeah !</button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
