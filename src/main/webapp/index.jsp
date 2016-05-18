<%-- 
    Document   : index
    Created on : Jan 19, 2016, 4:20:36 PM
    Author     : Anderson Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sisloc - Pagina Inicial</title>

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style type="text/css">

            body{

                background: url('img/background.jpeg');
            }

            .panel{
                opacity: 1 !important;
            }
            .panel:hover{
                box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
            }

            .vertical-offset-100{
                padding-top: 20%;
            }

        </style>
    </style>
</head>

<body>
    <div class="container">
        <div class="row vertical-offset-100">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Efetue Login</h3>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" action="front?command=login" method="post" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="login" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                    </label>
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> 

    <!--        <header id="myCarousel" class="carousel slide">
                <div class="carousel-inner">
                    <div class="item active">
                        <div class="fill">
                            <img src="img/logo.png" style="margin-left: 500px; margin-top: 100px;width: 400px;">
                        </div> 
                    </div>
                </div>
            </header>-->
    <!--        <div class="container">
                <div class="row">
                    <div class="col-sm-4"></div>
    
                    <div class="col-sm-4">-->
    <!--                    <label style="color: #d43f3a">${sessionScope.error}</label>
                        <form class="form-horizontal" action="front?command=login" method="post" role="form">
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="email" style="color: #181EC7;">Email:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="login" class="form-control" id="email" style="border-color: graytext" placeholder="Enter email">
                                </div>
                            </div>
    
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="pwd" style="color: #181EC7;">Password:</label>-->
    <!--                            <div class="col-sm-9">          
                                    <input type="password" name="password" class="form-control" style="border-color: graytext" id="pwd" placeholder="Enter password">
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-3 col-sm-9">
                                    <div class="checkbox">
                                        <label style="color: #181EC7;"><input type="checkbox">Lembrar</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">        -->
    <!--                            <div class="col-sm-offset-3 col-sm-9">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-4"></div>
    
                </div>
            </div>
            <br>
            <br>-->
    <!--        <br>
            <hr>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Sisloc 2016</p>
                    </div>
                </div>
            </div>
             /.container -->

    <!-- jQuery -->
    <!--<script src="js/jquery.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
    <!--<script src="js/bootstrap.min.js"></script>-->
    <!-- Script to Activate the Carousel -->

    <c:remove var="error" scope="session"/>
</body>

</html>
