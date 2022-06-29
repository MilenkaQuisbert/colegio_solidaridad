<%
    if(session.getAttribute("Login") !="OK"){
        response.sendRedirect("login.jsp");
    }
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Estudiantes"%>
<%
    List<Estudiantes> es = (List<Estudiantes>)request.getAttribute("Estudiantes");
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
            <jsp:param name="opcion" value="estudiantes"/>
        </jsp:include>
        <!--Tabla para datos de estudiantes-->

        <h1>ESTUDIANTES</h1>


        <p>Introduzca el Nombre del Estudiante</p>
        <form action="EstudiantesControlador" method="post">
        <div class="namecajatext"><label for="" class="form-label">Nombre(s):</label></div> 
        <div class="cajatext">
            <input type="text" name="nombre" value="" placeholder="Escriba su nombre(s)">
        </div>
        <button href="ListaControlador" class=" btn-primary">Buscar</button>
        <button href="EstudiantesControlador?action=actualizar" class=" btn-secondary">Actualizar</button>
        </form>
        <div class="tabla">
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">ID Curso</th>
                        <th scope="col">Grado</th>
                        <th scope="col">Paralelo</th>
                        <th scope="col">Asesor</th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${Estudiantes}">
                    <tr>
                        <td>${item.id_curso}</td>
                        <td>${item.curso}</td>
                        <td>${item.paralelo}</td>
                        <td>${item.asesor}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <button <button onclick="location.href='ListaControlador'" class=" btn-primary">Buscar</button> 
        <button href="EstudiantesControlador?action=actualizar" class=" btn-secondary">Actualizar</button>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
