<%@page import="com.emergentes.modelo.Profesor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%
    List<Profesor> pro = (List<Profesor>)request.getAttribute("Profesores");
%>
<%
    if(session.getAttribute("Login") !="OK"){
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
            <jsp:param name="opcion" value="docentes"/>
        </jsp:include>
        <!--Tabla para datos de estudiantes-->

        <h1>DOCENTES</h1>

        <a href="DocentesControlador?action=add" class="btn btn-primary btn-sm">Agregar</a>

        <div class="tabla">
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">Cédula Identidad</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Asignatura</th>
                        <th scope="col">Curso</th>
                        <th scope="col"></th>
                        <th scope="col"></th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${Profesores}">
                    <tr>
                        <td>${item.ci}</td>
                        <td>${item.nombres}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.celular}</td>
                        <td>${item.direccion}</td>
                        <td>${item.asignatura}</td>
                        <td>${item.curso}</td>
                        <td><a href="DocentesControlador?action=edit&id=${item.id_profesor}">Modificar</a></td>
                        <td><a href="DocentesControlador?action=delete&id=${item.id_profesor}" onclick="return(confirm('¿Esta seguro?'))">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>


