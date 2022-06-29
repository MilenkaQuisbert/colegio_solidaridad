<%@page import="com.emergentes.modelo.Tutor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%
    List<Tutor> pro = (List<Tutor>)request.getAttribute("Tutores");
%>
<%
    if (session.getAttribute("Login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>



        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

        <title>Colegio Solidaridad</title>
        <link href="css/estudent.css" rel="stylesheet">

        <style>
            .logo{
                position: absolute;
                height: 210px;
                width: 180px;
                top: 330px;
                left: 50px;
            }
        </style>

    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="tutores"/>
        </jsp:include>
        <!--Tabla para datos de estudiantes-->

        <h1>TUTORES</h1>


        <p>Introduzca el Nombre del Tutor</p>

        <div class="namecajatext">Nombre(s):</div> 
        <div class="cajatext">
            <input type="text">
        </div>

        <div class="tabla">
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">Cédula Identidad</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Oficio</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Celular</th>
                        <th scope="col"></th>
                        <th scope="col"></th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${Tutores}">
                        <tr>
                            <td>${item.ci}</td>
                            <td>${item.nombres}</td>
                            <td>${item.oficio}</td>
                            <td>${item.direccion}</td>
                            <td>${item.celular}</td>
                            <td><a href="TutorControlador?action=edit&id=${item.id_tutor}">Modificar</a></td>
                            <td><a href="TutorControlador?action=delete&id=${item.id_tutor}" onclick="return(confirm('¿Esta seguro?'))">Eliminar</a></td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
        <button type="button" class=" btn-primary">Buscar</button>
        <<a href="TutorControlador?action=add" class=" btn-secondary">Agregar</a>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>

