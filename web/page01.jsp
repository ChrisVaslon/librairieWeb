<%-- 
    Document   : page1
    Created on : 12 janv. 2021, 10:59:10
    Author     : chris
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style01.css" rel="stylesheet" type="text/css"/>
        <title>page01</title>
    </head>
    <body>
        <h1>page01</h1>
        <%  
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy HH:MM:SS");
        String nowStr = sdf.format(now);
        %>
        <p>Bienvenue, nous sommes le <%= nowStr %></p>
        <img  src="images/téléchargement.jfif"/>
        
        
         <p>aller à la <a href="index.jsp"> index</a></p>
    </body>
</html>
