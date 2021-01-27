<%-- 
    Document   : home
    Created on : 21 janv. 2021, 10:17:19
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>
        
<c:import url="/menu-main" />
        <div class="container mt-4">
            <h1>VotrePanier</h1>
            <table>
                <thead>
                    <tr>
                        <th>EAN</th>
                        <th>titre</th>
                        <th>prix TTC / unité</th>
                        <th>qte</th>
                    </tr>
                </thead>
                
                
                <tbody>
                    <c:forEach items="${requestScope.lignes}" var="ligne">
                        <tr>
                            <td><c:out value ="${ligne.livre.ean}" /></td>
                            <td><c:out value ="${ligne.livre.titre}" /></td>
                            <td><c:out value ="${ligne.livre.prixHT}" /></td>
                            <td><c:out value ="${ligne.qte}" /></td>
                        </tr>
                         </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
