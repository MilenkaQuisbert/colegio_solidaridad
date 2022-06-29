<%@page import="com.emergentes.modelo.Profesor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Profesor docente = (Profesor) request.getAttribute("Docentes");
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
            <h1 position="center" >Insertar Docente</h1>
            <form action="DocentesControlador" method="post">
                <input type="hidden" name="id" value="${Docente.id_persona}" />
                <div class="form-row">                    
                    <div class="form-group col-md-4">
                        <label for="">Cédula de Identidad</label>
                        <input type="text" class="form-control" name="ci" value="${Docente.ci}" placeholder="CI">
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="">Nombres</label>
                    <input type="text" class="form-control" name="nombre" value="${Docente.nombres}" placeholder="Nombres">
                </div>
                <div class="form-group col-md-6">
                    <label for="">Apellidos</label>
                    <input type="text" class="form-control" name="apellido" value="${Docente.apellidos}" placeholder="Apellidos">
                </div>
                <div class="form-group">
                    <label for="">Fecha Nacimiento  </label>
                    <input type="text" class="form-control" name="fecha" value="${Docente.fecha_nacimiento}" placeholder="ejemplo: 2022-05-07">
                </div>
                <div class="form-group col-md-6">
                    <label for="">Edad</label>
                    <input type="number" class="form-control" name="edad" value="${Docente.edad}" placeholder="Edad">
                </div>
                <div class="form-group col-md-4">
                    <label for="">Celular</label>
                    <input type="number" class="form-control" name="celular" value="${Docente.celular}" placeholder="Número de celular">
                </div>
                <div class="form-group col-md-6">
                    <label for="">Dirección</label>
                    <input type="text" class="form-control" name="direccion" value="${Docente.direccion}" placeholder="escriba su dirrecion">
                </div>
                <input type="hidden" name="idpro" value="${Docente.id_profesor}" />
                <div class="form-group col-md-4">
                    <label for="" class="form-label">Asignatura</label>
                    <select name="asignatura" class="form-control">
                        <option value="">--Seleccione --</option>
                        <c:forEach var="item" items="${Asignatura}">
                            <option value="${item.id_asignatura}">
                                <c:if test="${Docente.id_asignatura == item.id_asignatura}">
                                    selected
                                </c:if>>${item.materia}>
                            </option>
                        </c:forEach>">
                    </select>
                </div>

        </div>
        <br>
        <a href="AsignaturaControlador?action=add" class="btn btn-primary btn-sm">En caso no se encuentre asignatura click aqui</a>
            <button type="submit" class="btn btn-primary">Registrar</button>

        </form>
    </div>
</body>
</html>

