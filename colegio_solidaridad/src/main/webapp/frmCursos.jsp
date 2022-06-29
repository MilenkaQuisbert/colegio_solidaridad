<%@page import="com.emergentes.modelo.Curso"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Curso curso = (Curso) request.getAttribute("Curso");
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
            <h1 position="center" >Insertar Curso</h1>
            <form action="CursosControlador" method="post">
                <input type="hidden" name="id" value="${Cursos.id_curso}" />
                <div class="form-row">                    
                    <div class="form-group col-md-4">
                        <label for="">Grado</label>
                        <input type="text" class="form-control" name="grado" value="${Cursos.grado}" placeholder="De Primero a Sexto">
                    </div>
                </div>
                <div class="form-group col-md-2">
                    <label for="">Paralelo</label>
                    <input type="text" class="form-control" name="paralelo" value="${Cursos.paralelo}" placeholder="Del A al H">
                </div>
                <div class="form-group col-md-6">
                    <label for="" class="form-label">Asesor</label>
                    <select name="id_profesor" class="form-control">
                        <option value="">--Seleccione --</option>
                        <c:forEach var="item" items="${lista_profesores}">
                            <option value="${item.id_profesor}">
                                <c:if test="${Cursos.id_profesor == item.id_profesor}">
                                    selected
                                </c:if>>${item.nombres}>
                            </option>
                        </c:forEach>">
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
    </body>
</html>

