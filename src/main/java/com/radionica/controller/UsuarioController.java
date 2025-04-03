package com.radionica.controller;

import com.radionica.model.Usuario;
import com.radionica.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    @POST
    public void crearUsuario(Usuario usuario) {
        usuarioService.crearUsuario(usuario);
    }

    @GET
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }
}