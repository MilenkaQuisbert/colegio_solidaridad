<%@page import="com.emergentes.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Usuario producto = (Usuario) request.getAttribute("Usuario");
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
            <h1 position="center" >Insertar usuario</h1>
            <form action="UsuariosControlador" method="post">
                <input type="hidden" name="id" value="${Usuario.id}" />
                <div class="form-row">
                    <div class="form-group col-md-6">                       
                        <label for="">Nombre Completo</label>
                        <input type="text" class="form-control" name="nombre" value="${Usuario.nombres}" placeholder="Nombres y Apellidos">
                    </div>
                </div>
                <div class="form-group col-md-4">
                    <label for="">Usuario</label>
                    <input type="text" class="form-control" name="usuario" value="${Usuario.usuario}" placeholder="Nombre de usuario">
                </div>
                <div class="form-group col-md-4">
                    <label for="">Contraseña</label>
                    <input type="password" class="form-control" name="contrasena" value="${Usuario.contraseña}" placeholder="Contraseña">
                </div>

                <div class="form-row ">
                    <div class="form-group col-md-4">
                        <label for="">Rol</label>
                        <input type="text" class="form-control" name="rol" value="${Usuario.rol}" placeholder="Admin">
                    </div>



                </div>
                <br>
                <button type="submit" class="btn btn-primary">Registrar</button>

            </form>
        </div>
    </body>
</html>

