<%-- 
    Document   : index
    Created on : Jan 19, 2016, 4:20:36 PM
    Author     : Anderson Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

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
        <header id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
                <div class="item active">
                    <div class="fill">
                        <img src="img/logo.png" style="margin-left: 500px; margin-top: 100px;width: 400px;">
                    </div> 
                </div>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-sm-4"></div>

                <div class="col-sm-4">
                    <label style="color: #d43f3a">${sessionScope.error}</label>
                    <form class="form-horizontal" action="front?command=login" method="post" role="form">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="email" style="color: #181EC7;">Email:</label>
                            <div class="col-sm-9">
                                <input type="text" name="login" class="form-control" id="email" style="border-color: graytext" placeholder="Enter email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3" for="pwd" style="color: #181EC7;">Password:</label>
                            <div class="col-sm-9">          
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
                        <div class="form-group">        
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-4"></div>

            </div>
        </div>

        <br>
        <br>
        <br>


        <!-- Footer -->
        <hr><div class="container">
            <div class="row text-center">
                <div class="col-lg-12">
                    <p>Copyright &copy;  2016</p>
                </div>
            </div></div>
        <!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Script to Activate the Carousel -->


    </body>

</html>
