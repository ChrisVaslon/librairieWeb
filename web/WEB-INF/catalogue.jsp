<%-- 
    Document   : catalogue
    Created on : 19 janv. 2021, 10:36:22
    Author     : Win 7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>catalogue</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:import url="WEB-INF/menus/menus-main.jsp" />
        <div class="container-fluid mt-4">
            <h1>Notre catalogue</h1>
            <div class="card-deck justify-content-center mt-5">
                <c:forEach items="${requestScope.catalogue}" var="livre">
                <div class="card mb-4" style="min-width:18rem; max-width:18rem;">
                   <a href ='livre?ean=<c:out value="${livre.ean}" />'> <img style ="width: 300px;" class="card-img-top" src ='images/<c:out value="${livre.image}" /> ' alt="couvertureDeLivre"></a> 
                    <div class="card-body text-center">
                        
                        <h1 class = "h3" <a href="livre?ean=<c:out value="${livre.ean}" />' </a>> <c:out value="${livre.titre}" /></h1>
                                            
                                            
                        <p class="card-text">prix HT : <fmt:formatNumber value="${livre.prixHT}" minFractionDigits="2" maxFractionDigits="2" currencySymbol="$"/> euros </p>
                       
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</html>
