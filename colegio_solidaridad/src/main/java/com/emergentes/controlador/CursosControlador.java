package com.emergentes.controlador;

import com.emergentes.dao.CursoDAO;
import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.dao.DocentesDAO;
import com.emergentes.dao.DocentesDAOimpl;
import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.modelo.Curso;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CursosControlador", urlPatterns = {"/CursosControlador"})
public class CursosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CursoDAO dao = new CursoDAOimpl();
            DocentesDAO doc = new DocentesDAOimpl();
            int id;
            List<Profesor> lista_Profe = null;
            Curso es = new Curso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add": {
                    try {
                        lista_Profe = doc.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(CursosControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                request.setAttribute("lista_profesores", lista_Profe);
                request.setAttribute("Cursos", es);
                request.getRequestDispatcher("frmCursos.jsp").forward(request, response);
                break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    es = dao.getById(id);
                    lista_Profe = doc.getAll();
                    request.setAttribute("lista_profesores", lista_Profe);
                    request.setAttribute("Cursos", es);
                    request.getRequestDispatcher("frmCursos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("CursosControlador");
                    break;
                case "view":
                    List<Curso> lista = new ArrayList<Curso>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Curso", lista);
                    request.getRequestDispatcher("cursos.jsp").forward(request, response);
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
        String grado = request.getParameter("grado");
        String paralelo = request.getParameter("paralelo");
        int id_profesor = Integer.parseInt(request.getParameter("id_profesor"));

        Curso cur = new Curso();

        cur.setId_curso(id);
        cur.setGrado(grado);
        cur.setParalelo(paralelo);
        cur.setId_profesor(id_profesor);

        CursoDAO dao = new CursoDAOimpl();

        if (id == 0) {
            try {
                // Nuevo
                dao.insert(cur);
                response.sendRedirect("CursosControlador");
            } catch (Exception ex) {
                Logger.getLogger(CursosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                // Edición
                dao.update(cur);
                response.sendRedirect("CursosControlador");
            } catch (Exception ex) {
                Logger.getLogger(CursosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
