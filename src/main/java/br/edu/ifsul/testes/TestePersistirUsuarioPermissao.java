/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirUsuarioPermissao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "Pedro");
        Usuario u2 = em.find(Usuario.class, "Maria");
        Permissao p = em.find(Permissao.class, "ADMINISTRADOR");
        Permissao p2 = em.find(Permissao.class, "VISUALIZADOR");
        u.getPermissoes().add(p);
        u2.getPermissoes().add(p2);
        em.getTransaction().begin();
        em.persist(u);
        em.persist(u2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
