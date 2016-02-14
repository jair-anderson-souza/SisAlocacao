<%-- 
    Document   : gerenciar
    Created on : Jan 19, 2016, 6:37:56 PM
    Author     : Anderson Souza
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="../logo.ico" />

        <title>Gerenciamento de Usuario</title>

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
        <script>

            $(function () {
                $(".busca").keyup(function () {
                    //pega o css da tabela 
                    var tabela = $(this).attr('alt');
                    if ($(this).val() !== "") {
                        $("." + tabela + " tbody > tr").hide();
                        $("." + tabela + " td:contains-ci('" + $(this).val() + "')").parent("tr").show();
                    } else {
                        $("." + tabela + " tbody>tr").show();
                    }
                });
            });
            $.extend($.expr[":"], {
                "contains-ci": function (elem, i, match, array) {
                    return (elem.textContent || elem.innerText || $(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
                }
            });
        </script>
    </head>
    <body style="background-color: white;">
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
        <hr>
        <br>
        <br>
        <br>
        <br>
        <!-- Modal -->
        <div id="cadastro" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content - Modal do Cadastro -->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Cadastro de Usuario</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="../front?command=registerUser" method="post">
                            <div class="form-group">
                                <label for="username">Nome de usuário</label>
                                <input type="text" name="username" class="form-control" id="username" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\\\[[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\\\-0-9]+\\\\.)+[a-zA-Z]{2,}))$" title="Insira seu username">
                            </div>
                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input type="text" name="name" class="form-control" id="nome">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password</label>
                                <input type="password" name="password" class="form-control" id="pwd" pattern="((?=.*[A-Z])(?=.*[@#$!%!]).{8,30})" title="A senha precisa pelo menos uma letra maiuscula e um caracterer especial.">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" name="email" class="form-control" id="email" pattern="[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]+.{1}[a-z]+" title="O email precisa estar no padrao requerido">
                            </div>
                            <div class="form-group">
                                <label for="matricula">Matrícula</label>
                                <input type="text" name="registry" class="form-control" id="matricula" pattern="[0-9]+.{5,30}" title="A matricula deve conter numero digitos numericos.">
                            </div>
                            <div class="form-group">
                                <label for="sel1">Papel</label>
                                <select class="form-control" name="role" id="sel1">
                                    <option value="aluno">Aluno</option>
                                    <option value="monitor">Monitor</option>
                                    <option value="assistente">Assistente de Sala</option>
                                    <option value=professor">Professor</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-success">Cadastrar</button>
                        </form>
                    </div>
                    <!--                    <div class="modal-footer">
                                            
                                        </div>-->
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row text-left">
                <c:if test="${sessionScope.crud} != null">
                    <div class="col-md-12">
                        <div class="alert alert-success">
                            ${sessionScope.crud}
                        </div>
                    </div>
                </c:if>
            </div>
        </div>


        <!-- Page Content -->
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12"><h1 class="page-header">Lista de Usuarios</h1>
                    <!--<small>AdministraÃ§Ã£o</small>-->
                    <ol class="breadcrumb">
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="gerenciarusuario.jsp">Gerenciamento de Usuario</li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="form-group">
                        <a href="" data-toggle="modal" data-target="#cadastro"><span class="glyphicon glyphicon-plus"></span></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <div class="form-group">
                        <input type="text" alt="table" class="busca form-control" placeholder="Busque aqui">
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="container">
            <div class="table-responsive">
                <table class="table table-responsive" id="table">
                    <tr style="">
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Papel</th>
                        <th>Status</th>
                        <th>IdUser</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                    </tr>
                    <tbody>
                        <c:forEach items="${sessionScope.listUsers}" var="userList">
                            <tr>
                                <td>${userList.name}</td>
                                <td>${userList.email}</td>
                                <td>${userList.role}</td>
                                <td>${userList.status eq 'true'  ? 'Ativo' : 'Inativo'}</td>
                                <td>${userList.idUser}</td>
                                <td>
                                    <form action="../front?command=loadUser&idUser=${userList.idUser}" method="post">
                                        <button type="submit" class="glyphicon glyphicon-pencil btn btn-default"></button>
                                        <!--<button type="submit" class="btn btn-info"></button>-->
                                    </form>
                                </td>
                                <td>
                                    <form action="../front?command=deleteUser&idUser=${userList.idUser}" method="post">
                                        <button type="submit" class="glyphicon glyphicon-pencil btn btn-default"></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>

        <hr>
        <!-- Footer 
        -->
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>
    </body>
</html>
