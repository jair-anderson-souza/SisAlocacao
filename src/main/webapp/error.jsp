<%-- 
    Document   : error
    Created on : 14-Feb-2016, 22:39:16
    Author     : Anderson Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="logo.ico" />
        <title>Erro na Página</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav style="background: white" class="navbar navbar-default navbar-fixed-top" role="navigation">
            <img src="img/logo.png" style="width: 250px; margin-top: 30px;margin-left: 100px;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <br>
                    <h4 class="navbar-form">Sistema Sisloc</a><br><br>
                        <h4 class="navbar-form">Logado como ${sessionScope.user.role}</h4>
                </div>
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
        <br>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="jumbotron">
                        <h1>Erro 404 Página não encontrada</h1>
                        <p>A pagina que você solicitou não pode ser encontrada.</p>
                        <p>${sessionScope.error}</p>
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

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </body>
</html>
