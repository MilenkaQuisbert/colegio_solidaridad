<%@page import="com.emergentes.modelo.Asignatura"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Asignatura asignatura = (Asignatura) request.getAttribute("Asignatura");
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
        <link href="css/formularios.css" rel="stylesheet">
    </head>
    <body>
        <div class="bd-example">
            <h1 position="center" >Insertar Asignatura</h1>
            <form action="AsignaturaControlador" method="post">
                <input type="hidden" name="id" value="${Asignatura.id_asignatura}" />
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="">Materia</label>
                        <input type="text" class="form-control" name="asignatura" placeholder="Nombre de la Asignatura">
                    </div>
                </div>
               
                    

                </div>
                <br>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
    </body>
</html>
