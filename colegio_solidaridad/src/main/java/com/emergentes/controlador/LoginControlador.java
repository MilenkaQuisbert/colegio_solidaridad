package com.emergentes.controlador;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.utiles.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect("login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            System.out.print("Datos.. " +usuario+" "+password);
        
        Validate v = new Validate();
        
        if(v.checkUser(usuario, password)){
            HttpSession ses = request.getSession();
            ses.setAttribute("Login","OK");
            response.sendRedirect("EstudiantesControlador");
        }else{
            response.sendRedirect("login.jsp");
        }
    }

}
