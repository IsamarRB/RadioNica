package com.radionica.dao;


import com.radionica.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UsuarioDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EvaluacionPU");

    public void guardarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        EntityManager em = emf.createEntityManager();
        List<Usuario> lista = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return lista;
    }
}
