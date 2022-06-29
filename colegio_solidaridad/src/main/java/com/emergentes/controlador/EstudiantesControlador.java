package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudiantesControlador", urlPatterns = {"/EstudiantesControlador"})
public class EstudiantesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            PersonaDAO per = new PersonaDAOimpl();
            int id;
            List<Persona> lista_persona = null;
            Estudiantes es = new Estudiantes();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //
                    lista_persona = per.getAll();
                    request.setAttribute("lista_persona", lista_persona);
                    request.setAttribute("Estudiantes", es);
                    request.getRequestDispatcher("frmEstudiantes.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    es = dao.getById(id);
                    lista_persona = per.getAll();
                    request.setAttribute("lista_persona", lista_persona);
                    request.setAttribute("Estudiantes", es);
                    request.getRequestDispatcher("frmEstudiantes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EstudiantesControlador");
                    break;
                case "actualizar":
                    List<Estudiantes> lis = new ArrayList<Estudiantes>();
                    try {
                        lis = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Estudiantes", lis);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                    break;
                case "buscar":
                    response.sendRedirect("ListaControlador");
                    break;
                case "view":
                    List<Estudiantes> lista = new ArrayList<Estudiantes>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Estudiantes", lista);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
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
    
    }

}
