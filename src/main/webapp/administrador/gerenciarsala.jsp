<%-- 
    Document   : gerenciarsala
    Created on : Mar 19, 2016, 5:18:11 PM
    Author     : Anderson Souza
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="../logo.ico" />

        <title>Gerenciamento de Salas</title>

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
                        <form role="form" action="../front?action=registerRoom" method="post">
                            <div class="form-group">
                                <label for="floorName">Nome da Sala</label>
                                <input type="text" name="nameRoom" class="form-control" id="floorName" required="true">
                            </div>
                            <div class="form-group">
                                <label for="f">Bloco</label>
                                <select class="form-control" name="floor" id="f">
                                    <c:forEach items="${sessionScope.floors}" var="floor">
                                        <option value="${floor.idFloor}">${floor.description}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="floorName">Capacidade Física</label>
                                <input type="text" name="capacity" class="form-control" id="floorName" required="true">
                            </div>
                            <div class="form-group">
                                <label for="sel1">Tipo de Sala</label>
                                <select class="form-control" name="typeRoom" id="sel1">
                                    <option value="COMUM">Comum</option>
                                    <option value="LABORATORIO">Laboratório</option>
                                    <option value="OFICINA">Oficina</option>
                                    <option value="INTELIGENTE">Inteligente</option>
                                </select>
                            </div>  
                            <button type="submit" class="btn btn-success">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Page Content -->
        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12"><h1 class="page-header">Lista de Blocos</h1>
                    <div class="container">
                        <div class="row text-left">
                            <c:if test="${crud != null}">
                                <div class="col-md-12">
                                    <div class="alert alert-success">
                                        ${crud}
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <ol class="breadcrumb">
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="../front?action=listRooms">Gerenciamento de Sala</a></li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row text-left">
                <c:if test="${sessionScope.error != null}">
                    <div class="col-md-12">
                        <div class="alert alert-danger">
                            ${sessionScope.error}
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="form-group">
                        <a href="#" data-toggle="modal" data-target="#cadastro"><span class="glyphicon glyphicon-plus"></span></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
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
                <table class="table table-responsive">
                    <thead>
                        <tr>
                            <th>Sala</th>
                            <th>Bloco</th>
                            <th>Capacidade</th>
                            <th>Status</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody id="table">
                        <c:forEach items="${sessionScope.rooms}" var="room">
                            <tr>
                                <td>${room.nameRoom}</td>
                                <td>${room.idFloor}</td>
                                <td>${room.capacity}</td>
                                <td>${room.capacity}</td>
                                <td>
                                    <form action="../front?action=loadRoom&id=${room.idRoom}" method="post">
                                        <button type="submit" class="glyphicon glyphicon-pencil btn btn-default"></button>
                                        <!--<button type="submit" class="btn btn-info"></button>-->
                                    </form>
                                </td>
                                <td>
                                    <form action="../front?action=deleteFloor&idFloor=${floor.idFloor}" method="post">
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
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Sisloc 2016</p>
                </div>
            </div>
        </div>

    </body>
</html>
