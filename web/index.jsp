<%-- 
    Document   : index
    Created on : 14/07/2020, 10:35:19 AM
    Author     : depdes10
--%>
<%@page import="java.awt.Dimension"%>
<%@page import="java.awt.Toolkit;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Toolkit t = Toolkit.getDefaultToolkit();
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //int ancho = screenSize.width;//java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    //int alto = screenSize.height;//java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
%>
<html>
    <head>
        <title>SUP_EVAL_CORP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            html, body, div, iframe { margin:0; padding:0; height:100%; }
            iframe { display:block; width:100%; border:none; }
        </style>
    </head>
    <body>
        <div class="container">
        <div class="embed-container">
            <iframe src="./view/lg.jsp" width="100%" height="100%" frameborder="0" allowfullscreen></iframe>
        </div>
        </div>
    </body>
</html>