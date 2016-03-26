<%-- 
    Document   : editarperfil
    Created on : Jan 28, 2016, 11:03:13 AM
    Author     : Anderson Souza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="../logo.ico" />

        <title>Editar Usuario</title>

        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/modern-business.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">    
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
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

                <ul class="nav navbar-nav" style="margin-top: -40px;margin-left: 600px;">
                    <li class="dropdown">
                        <a class="dropdown-toggle" style="font-size: 20px; color: black" data-toggle="dropdown" href="#">${sessionScope.user.name}
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Editar Perfil</a></li>
                            <li><a href="../front?action=logout">Sair</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="container text-center">
            <div class="row">
                <div class="col-md-12">
                    <h1><b>Ediçao de Usuario</b></h1>
                </div>
            </div>
        </div>

        <br>
        <br>
        <br>
        <br>

        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form class="form-horizontal" action="../front?action=editUser&idUser=${sessionScope.userEditing.idUser}" method="post">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="username">Username</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="username" value="${sessionScope.userEditing.username}" id="username" pattern="[a-zA-Z\\.]+" title="O username não deve conter caracteres especiais">
                                <input type="hidden" name="id_usuario" value="${sessionScope.userEditing.idUser}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="password">Senha</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" value="${sessionScope.userEditing.password}" id="password" pattern="((?=.*[A-Z])(?=.*[@#$!%!]).{8,30})" title="A senha precisa conter pelo menos uma letra maiuscula e um caracterer especial.">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nome">Nome</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" value="${sessionScope.userEditing.name}" id="password" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Email</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="email" value="${sessionScope.userEditing.email}" id="email" pattern="[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]+.{1}[a-z]+" title="O email precisa estar no padrao requerido">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="matricula">Matricula</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="registry" value="${sessionScope.userEditing.registry}" id="matricula" pattern="[0-9]+.{5,30}" title="A matricula deve conter numero digitos numericos.">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="role">Papel</label>
                            <div class="col-sm-10">
                                <select class="form-control col-sm-12" name="role" id="papel">
                                    <option value="aluno">Aluno</option>
                                    <option value="monitor">Monitor</option>
                                    <option value="assistente">Assistente de Sala</option>
                                    <option value="professor">Professor</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Editar</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Sisloc 2016</p>
                </div>
            </div>
        </div>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </body>
</html>
