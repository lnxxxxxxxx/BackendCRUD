package javaproject.javaproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javaproject.javaproject.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        //podriamos usar WHERE y traer mas cosas.
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }
}
