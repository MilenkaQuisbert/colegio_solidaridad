package com.emergentes.controlador;

import com.emergentes.dao.AsignaturaDAO;
import com.emergentes.dao.AsignaturaDAOimpl;
import com.emergentes.modelo.Asignatura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsignaturaControlador", urlPatterns = {"/AsignaturaControlador"})
public class AsignaturaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AsignaturaDAO dao = new AsignaturaDAOimpl();
            int id;
            Asignatura es = new Asignatura();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //
                    request.setAttribute("Asignatura", es);
                    request.getRequestDispatcher("frmAsignaturas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    es = dao.getById(id);
                    request.setAttribute("Asignatura", es);
                    request.getRequestDispatcher("frmAsignaturas.jsp").forward(request, response);
                    break;
                case "view":
                    List<Asignatura> lista = new ArrayList<Asignatura>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Asignatura", lista);
                    request.getRequestDispatcher("docentes.jsp").forward(request, response);
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
        String materia =  request.getParameter("asignatura");
        
        Asignatura usu = new Asignatura();
        
        usu.setId_asignatura(id);
        usu.setMateria(materia);
        
        AsignaturaDAO dao = new AsignaturaDAOimpl();
        
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
        response.sendRedirect("AsignaturaControlador");
    }

}
