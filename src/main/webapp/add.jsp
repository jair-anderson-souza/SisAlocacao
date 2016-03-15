<%-- 
    Document   : add
    Created on : 12-Feb-2016, 21:33:41
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
        <link rel="icon" type="image/png" href="logo.ico" />
        <title>Sisloc - Pagina Inicial</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div id="cadastro" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content - Modal do Cadastro -->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Cadastro de Usuario</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="front?action=cadastrarusuario" method="post">
                            <div class="form-group">
                                <label for="username">Nome de usuário</label>
                                <input type="text" name="username" class="form-control" id="usern" title="Three letter country code">
                            </div>
                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input type="text" name="nome" class="form-control" id="nome" title="Three letter country code">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password</label>
                                <input type="password" name="password" class="form-control" id="pwd" title="Three letter country code">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" name="email" class="form-control" id="email" title="Three letter country code">
                            </div>
                            <div class="form-group">
                                <label for="matricula">Matrícula</label>
                                <input type="text" name="matricula" class="form-control" id="matricula">
                            </div>
                            <div class="form-group">
                                <label for="sel1">Papel</label>
                                <select class="form-control" name="papel" id="sel1">
                                    <option value="Aluno">Aluno</option>
                                    <option value="Monitor">Monitor</option>
                                    <option value="Assistente de Aluno">Assistente de Sala</option>
                                    <option value="Professor">Professor</option>
                                </select>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox">Lembrar</label>
                            </div>
                            <button type="submit" class="btn btn-default">Cadastrar</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
        
        
        
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <a href="" data-toggle="modal" data-target="#cadastro"><span class="glyphicon glyphicon-plus"></span></a>
                    
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <input type="text" alt="table" class="busca form-control" placeholder="Busque aqui">
                    </div>
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Script to Activate the Carousel -->
    </body>
</html>
