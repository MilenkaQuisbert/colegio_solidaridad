package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuariosControlador", urlPatterns = {"/UsuariosControlador"})
public class UsuariosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO dao = new UsuarioDAOimpl();
            int id;
            Usuario es = new Usuario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("Usuario", es);
                    request.getRequestDispatcher("frmUsuarios.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        // obtener el objeto que corresponde al registro
                        es = dao.getById(id);
                    } catch (Exception ex) {
                        System.out.println("Eror al obtener registro " + ex.getMessage());
                    }
                    // Colocar como atributo
                    request.setAttribute("Usuario", es);
                    // Transferir el control a frmaviso.jsp
                    request.getRequestDispatcher("frmUsuarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.delete(id);
                    } catch (Exception ex) {
                        System.out.println("Error al eliminar: " + ex.getMessage());
                    }
                    response.sendRedirect("UsuariosControlador");
                    break;
                case "view":
                    List<Usuario> lista = new ArrayList<Usuario>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Usuario", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre =  request.getParameter("nombre");
        String usuario =  request.getParameter("usuario");
        String contrasena =  request.getParameter("contrasena");
        String rol =  request.getParameter("rol");
        
        Usuario usu = new Usuario();
        
        usu.setId(id);
        usu.setNombres(nombre);
        usu.setUsuario(usuario);
        usu.setContraseña(contrasena);
        usu.setRol(rol);
        
        UsuarioDAO dao = new UsuarioDAOimpl();
        
        if (id == 0){
            try {
                // Nuevo
                dao.insert(usu);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                dao.update(usu);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("UsuariosControlador");
    }

}
