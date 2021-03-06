<%-- 
    Document   : menus-main
    Created on : 12 janv. 2021, 15:02:37
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="home">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
            <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
        </svg></a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">

            <li class="nav-item">
                <a class="nav-link" href="catalogue">Catalogue</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="detail-panier">Panier : ${requestScope.qte}</a>
            </li>

            <c:if test="${empty sessionScope.user}" >
                <li class="nav-item">
                    <a class="nav-link" href="vers-inscription">Inscription</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="vers-login">Se connecter </a>
                </li>
            </c:if>

            <c:if test="${not empty sessionScope.user}" >
                <li class="nav-item">
                    <a class="nav-link" href="#">Se deconnecter</a>
                </li>
            </c:if>

        </ul>
    </div>
</nav>