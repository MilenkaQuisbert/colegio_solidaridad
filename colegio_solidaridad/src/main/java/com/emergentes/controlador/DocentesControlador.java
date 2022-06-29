package com.emergentes.controlador;

import com.emergentes.dao.AsignaturaDAO;
import com.emergentes.dao.AsignaturaDAOimpl;
import com.emergentes.dao.DocentesDAO;
import com.emergentes.dao.DocentesDAOimpl;
import com.emergentes.dao.PersonaDAO;
import com.emergentes.dao.PersonaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Asignatura;
import com.emergentes.modelo.Persona;
import com.emergentes.modelo.Profesor;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DocentesControlador", urlPatterns = {"/DocentesControlador"})
public class DocentesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DocentesDAO dao = new DocentesDAOimpl();
            UsuarioDAO per = new UsuarioDAOimpl();
            AsignaturaDAO asi = new AsignaturaDAOimpl();
            int id;
            List<Usuario> lista_persona = null;
            List<Asignatura> lista_asi = null;
            Persona pe =new Persona();
            Profesor es = new Profesor();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //
                    lista_persona = per.getAll();
                    lista_asi = asi.getAll();
                    request.setAttribute("lista_persona", lista_persona);
                    request.setAttribute("Asignatura", lista_asi);
                    request.setAttribute("Persona", pe);
                    request.setAttribute("Docente", es);
                    request.getRequestDispatcher("frmDocentes.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    es = dao.getById(id);
                    lista_persona = per.getAll();
                    lista_asi = asi.getAll();
                    request.setAttribute("lista_persona", lista_persona);
                    request.setAttribute("Asignatura", lista_asi);
                    request.setAttribute("Persona", pe);
                    request.setAttribute("Docente", es);
                    request.getRequestDispatcher("frmDocentes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("DocentesControlador");
                    break;
                case "view":
                    List<Profesor> lista = new ArrayList<Profesor>();
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        System.out.println("Error al listar " + ex.getMessage());
                    }
                    request.setAttribute("Profesores", lista);
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
        int id_per = Integer.parseInt(request.getParameter("id"));
        int ci =  Integer.parseInt(request.getParameter("ci"));
        String nombre =  request.getParameter("nombre");
        String apellido =  request.getParameter("apellido");
        String fecha = request.getParameter("fecha");
        int edad =  Integer.parseInt(request.getParameter("edad"));
        int celular =  Integer.parseInt(request.getParameter("celular"));
        String direccion =  request.getParameter("direccion");
        int id_usu = 1;
        int id_pro = Integer.parseInt(request.getParameter("idpro"));
        int id_persona=id_per;
        int id_asi =  Integer.parseInt(request.getParameter("asignatura"));
        
        Persona per = new Persona();
        Profesor usu = new Profesor();
        
        per.setId_persona(id_per);
        per.setCi(ci);
        per.setNombres(nombre);
        per.setApellidos(apellido);
        per.setFecha_nacimiento(convierteFecha(fecha));
        per.setEdad(edad);
        per.setCelular(celular);
        per.setDireccion(direccion);
        per.setId_usuario(id_usu);
        usu.setId_profesor(id_pro);
        usu.setId_asignatura(id_asi);
        usu.setId_persona(id_persona);
        
        DocentesDAO dao = new DocentesDAOimpl();
        PersonaDAO daoper = new PersonaDAOimpl();
        
        if (id_per == 0){
            try {
                // Nuevo
                
                daoper.insert(per);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                daoper.update(per);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        if (id_pro == 0){
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
        response.sendRedirect("DocentesControlador");
    }
    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DocentesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaBD;
    }
}



