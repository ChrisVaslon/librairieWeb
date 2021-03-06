<%-- 
    Document   : inscription-form
    Created on : 12 janv. 2021, 14:40:10
    Author     : Win 7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inscription</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <c:import url="/menu-main" />

        <div class="container mt-4">
            <h1>Formulaire d'inscription</h1>

            <c:if test="${not empty requestScope.msg}">
                <p class ="erreur">${requestScope.msg}</p>              
            </c:if>

            <form action="inscription" method="POST">

                <div class="form-group">
                    <label for="id_nom">Nom :</label>
                    <input type="text" name="nom" value='<c:out value ="${requestScope.Nom}"/>' class="form-control" placeholder="Votre nom" id="id_nom">
                
             
                
                </div>

                <div class="form-group">
                    <label for="id_prenom">Prenom :</label>
                    <input type="text" value = "${requestScope.prenom}" value='<c:out value ="${requestScope.prenom}"/>' name="prenom" class="form-control" placeholder="Votre prenom" id="id_nom">
                </div>


                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" name = "pwd" class="form-control" placeholder="Enter password" id="pwd">
                  
                    <c:if test="${not empty requestScope.errPwd}">
                        <p class ="erreur">${requestScope.errPwd}</p>              
                    </c:if>

                </div>

                <div class="form-group">
                    <label for="pwd2">Confirmer le mdp : </label>
                    <input type="password" name = "pwd2" class="form-control" placeholder="Enter password" id="pwd2">
                   
                </div>


                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name = "email" value='<c:out value ="${requestScope.email}"/>' class="form-control" placeholder="Enter mail" id="email">
                
                   <c:if test="${not empty requestScope.errMail}">
                        <p class ="erreur">${requestScope.errMail}</p>              
                    </c:if>
                
                </div>
                

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
