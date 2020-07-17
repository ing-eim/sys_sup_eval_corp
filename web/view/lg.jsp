<%-- 
    Document   : lg
    Created on : 14/04/2020, 03:25:01 PM
    Author     : LALO-DOCIZ
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Reporte De Actividades</title>
        <script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="../js/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="../js/jquery-3.5.0.min.js"></script>
        <script src="../js/functions.js"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/styles.css"/>
        <link rel="stylesheet" href="../css/pbi_style.css"/>
    </head>
    <body>
        <div class="container title_lg">
            Sistema de Supervisión y Evaluación Corporativa<br/>      
            <small></small>
        </div>
        <div class="container col-sm-4">
            <center>
                <img src="../images/loginu.png"/>
            </center>
            <div>
            <form class="was-validated">
                <div class="form-group">
                    <input class="form-control form-rounded" type="text" id="txtempleado" placeholder="No Empleado" required/>
                </div>
                <div class="form-group">
                    <input class="form-control form-rounded" type="password" id="txtpassword" placeholder="Password" required/>
                </div> 
                <div class="form-group">
                    <input class="form-control btn btn-success" type="submit" id="btnIngresar" value="Ingresar"/>
                </div>
            </form>
            </div>
            <div class='msg' id='msg_sal'></div>
        </div>
        <div class="container footer_s">
            <small>Ver 1.0</small><br>
        </div>
    </body>
</html>