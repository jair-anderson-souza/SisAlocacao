<%-- 
    Document   : gerenciarferiado
    Created on : Jan 29, 2016, 12:57:37 AM
    Author     : Anderson Souza
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento de Feriados</title>
        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="../logo.ico" />
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

                <ul class="nav navbar-nav dropdown" style="margin-top: -40px;margin-left: 600px;">
                    <li>
                        <a class="dropdown-toggle" style="font-size: 20px; color: black" data-toggle="dropdown" href="">${sessionScope.user.name}
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

        <div id="uploadCsv" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Importar arquivo</h4>
                    </div>
                    <form action="../csv" enctype="multipart/form-data" method="post">
                        <div class="modal-body">
                            <input id="input-1" type="file" accept=".csv" value="Formato do arquivo requerido: .csv" name="file" class="file" required>
                        </div>
                        <div class="modal-body">
                            <button type="submit" class="btn btn-default">Importar</button>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
        <!--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>-->

        <!-- Modal -->
        <div id="cadastro" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Cadastrar Feriado</h4>
                    </div>
                    <div class="modal-body">
                        <form action="front?action=cadastrarferiado" method="post">
                            <div class="form-group">
                                <label for="descricao">Descriçao</label>
                                <input type="text" name="descricao" class="form-control" id="descricao" title="Three letter country code">
                            </div>
                            <div class="form-group">
                                <label for="data">Data</label>
                                <input type="text" name="data" class="form-control" id="data" title="Three letter country code">
                            </div>
                            <button type="submit" class="glyphicon glyphicon-trash btn btn-default"  data-toggle="modal" data-target="#exclusaferiado"></button>


                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>

                </div>

            </div>
        </div>

        <div class="container">
            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12"><h1 class="page-header">Lista de Feriados</h1>
                    <!--<small>AdministraÃ§Ã£o</small>-->
                    <ol class="breadcrumb">
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="../front?action=listHolidays">Gerenciamento de Feriado</a></li>
                    </ol>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="form-group">
                        <a href="#" data-toggle="modal" data-target="#cadastro"><span class="glyphicon glyphicon-plus"></span></a>
                        <a href="" data-toggle="modal" data-target="#uploadCsv"><span class="glyphicon glyphicon-file"></span></a>
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
        <div class="container">
            <div class="table-responsive">
                <table class="table table-responsive" id="table">
                    <thead>
                        <tr>
                            <th>Descrição</th>
                            <th>Data</th>
                            <th>Editar</th>
                            <th>Apagar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.listHolidays}" var="holiday">
                            <tr>
                                <td>${holiday.description}</td>
                                <td>${holiday.date}</td>
                                <td>
                                    <form action="../front?action=loadHoliday&idHoliday=${holiday.idHoliday}" method="post">
                                        <button type="submit" class="glyphicon glyphicon-plus btn btn-pencil"></button>
                                    </form>
                                </td>
                                <td>
                                    <form action="../front?action=deleteHoliday&idHoliday=${holiday.idHoliday}" method="post">
                                        <button type="submit" class="glyphicon glyphicon-pencil btn btn-trash"></button>
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
