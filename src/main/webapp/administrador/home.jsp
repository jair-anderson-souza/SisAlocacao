<%-- 
    Document   : home
    Created on : Jan 19, 2016, 4:20:36 PM
    Author     : Anderson Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home - Administrador</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Sistema Sisloc</a><br>
                <a class="navbar-brand">Logado como ${sessionScope.usuario.papel}</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->

            <br>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.usuario.nome}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="front?action=editar&iduser=${sessionScope.usuario.id}">Editar Perfil</a>
                            </li>
                            <li>
                                <a href="front?action=logout">Sair</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.container -->
    </nav>
    <br>
    <br>
<!--    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <div class="row text-left">
            <div class="col-md-12">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <c:choose>
                    
                    <c:when test="${requestScope.insercao != null}">
                        <div class="alert alert-success">
                            ${requestScope.insercao}
                        </div>
                    </c:when>
                    <c:when test="${requestScope.error != null}">
                        <div class="alert alert-danger">
                            ${requestScope.error}
                        </div>
                    </c:when>
                    <c:when test="${requestScope.exclusao != null}">
                        <div class="alert alert-success">
                            ${requestScope.exclusao}
                        </div>
                    </c:when>
                    <c:when test="${requestScope.edicao != null}">
                        <div class="alert alert-success">
                            ${requestScope.edicao}
                        </div>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>

     Page Content 
    <div class="container">
         Page Heading/Breadcrumbs 
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Administração
                <small>AdministraÃ§Ã£o</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <img src="img/manager.png" style="width:200px;"> 
                    </div>
                    <div class="panel-body">
                        <h3><b>Gerenciar Usuarios</b></h3>
                        <p>Adicionar, Editar, Excluir e Visualização</p>
                        <a href="front?action=listarusuarios" class="btn btn-primary">Abrir</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <img src="img/feriado.png" style="width: 140px;">
                    </div>
                    <div class="panel-body">
                        <h3><b>Gerenciar Feriados</b></h3>
                        <p>Adicionar, Editar, Excluir e Visualização</p>
                        <a href="front?action=listarferiados" class="btn btn-primary">Abrir</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
      

<hr>
         Footer 
    
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>-->

    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

</body>

</html>
