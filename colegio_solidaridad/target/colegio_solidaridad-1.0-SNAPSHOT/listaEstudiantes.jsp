
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
        <link href="css/listaStudent.css" rel="stylesheet">

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
            <jsp:param name="opcion" value=""/>
        </jsp:include>
        <!--Tabla para datos de estudiantes-->

        <h1>LISTA DE ESTUDIANTES</h1>


        <div class="tabla">
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">RUDE</th>
                        <th scope="col">Cédula Identidad</th>
                        <th scope="col">Estudiante</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Tutor</th>
                        <th scope="col">Asesor</th>
                        <th scope="col"></th>
                        <th scope="col"></th>


                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">78945612345A</th>
                        <td>100451635</td>
                        <td>Estrella Belen Huanca Arcani</td>
                        <td>5° de sec</td>
                        <td>16</td>
                        <td>Av. Salvador 4578</td>
                        <td>Maxima Arcani Arcani</td>
                        <td>Deymar Huanca Arcani</td>
                        <td><a href="UsuariosControlador?action=edit&id=${item.id}">Modificar</a></td>
                        <td><a href="UsuariosControlador?action=delete&id=${item.id}" onclick="return(confirm('¿Esta seguro?'))">Eliminar</a></td>


                    </tr>
                    
            </table>
        </div>

        <a href="EstudiantesControlador?action=add" class="btn btn-primary btn-sm">Agregar</a>
        <button type="button" class=" btn-secondary">Actualizar</button>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
