
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
            <h1 position="center" >Insertar Tutor</h1>
            <form>
                <div class="form-row">
                    
                    <div class="form-group col-md-4">
                        <label for="inputCI">Cédula de Identidad</label>
                        <input type="text" class="form-control" id="inputCI" placeholder="CI">
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputNombre">Nombre Completo</label>
                    <input type="text" class="form-control" id="inputNombre" placeholder="Nombres y Apellidos">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputOficio">Oficio</label>
                    <input type="text" class="form-control" id="inputOficio" placeholder="Profesión u Ofico del Tutor">
                </div>
                
                <div class="form-group">
                    <label for="inputCumple">Fecha Nacimiento  </label>
                    <input type="date" id="start" name="trip-start" class="calendario"
                           value="2018-07-22"
                           min="1940-01-01" max="2022-12-31">
                </div>
                <div class="form-group col-md-2">
                        <label for="inputEdad">Edad</label>
                        <input type="number" class="form-control" id="inputEdad" placeholder="">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="inputDireccion">Dirección</label>
                        <input type="text" class="form-control" id="inputDireccion">
                    </div>
                <div class="form-group col-md-4">
                        <label for="inputCelular">Celular</label>
                        <input type="number" class="form-control" id="inputCelular" placeholder="Número de celular">
                    </div>
                    
          
                </div>
                <br>
                
                <button type="submit" class="btn btn-primary">Registrar</button>
                <button type="" class="btn btn-danger">Cancelar</button>

            </form>
        </div>
    </body>
</html>


