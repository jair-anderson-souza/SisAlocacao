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
        <link rel="icon" type="image/png" href="../logo.ico" />
        <title>Home - Administrador</title>

        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/modern-business.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <!-- Navigation -->
        <nav style="background: white" class="navbar navbar-default navbar-fixed-top" role="navigation">
            <img src="../img/logo.png" style="width: 250px; margin-top: 30px;margin-left: 100px;">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<img src="../img/logo.png" style="width:20px;">-->
                    <br>
                    <h4 class="navbar-form">Sistema Sisloc</a><br><br>
                    <h4 class="navbar-form">Logado como ${sessionScope.user.role}</h4>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->

                <ul class="nav navbar-nav dropdown" style="margin-top: -40px;margin-left: 600px;">
                    <li>
                        <a class="dropdown-toggle" style="font-size: 20px; color: black" data-toggle="dropdown" href="">${sessionScope.user.name}
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Editar Perfil</a></li>
                            <li><a href="../front?command=logout">Sair</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <hr>
        <br>
        <br>
        <br>
        <br>
        <!--Page Content--> 
        <div class="container">
            <!--Page Heading/Breadcrumbs--> 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Administração
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="home.jsp">Home</a></li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <img src="../img/manager.png" style="width:200px;"> 
                        </div>
                        <div class="panel-body">
                            <h3><b>Gerenciar Usuarios</b></h3>
                            <p>Adicionar, Editar, Excluir e Visualizar</p>
                            <a href="../front?action=listUsers" class="btn btn-primary">Abrir</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <img src="../img/feriado.png" style="width: 140px;">
                        </div>
                        <div class="panel-body">
                            <h3><b>Gerenciar Feriados</b></h3>
                            <p>Adicionar, Editar, Excluir e Visualizar</p>
                            <a href="../front?action=listHolidays" class="btn btn-primary">Abrir</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <img src="../img/escolar.jpg" style="width: 140px;">
                        </div>
                        <div class="panel-body">
                            <h3><b>Gerenciar Material</b></h3>
                            <p>Adicionar, Editar, Excluir e Visualizar</p>
                            <a href="../front?action=listMaterials" class="btn btn-primary">Abrir</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <hr>


        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Sisloc 2016</p>
                </div>
            </div>
        </div>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </body>
</body>

</html>
