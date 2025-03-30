package com.radionica.servlets;


import com.radionica.dao.UsuarioDAO;
import com.radionica.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuarios")

public class UsuarioServlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contraseña = request.getParameter("contraseña");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario(nombre, contraseña, rol);
        usuarioDAO.guardarUsuario(usuario);

        response.getWriter().write("Usuario creado exitosamente");
    }
}
