/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Usuario c = new Usuario();
        Usuario c2 = new Usuario();
        c.setNomeUsuario("Pedro");
        c.setSenha("123456");
        c2.setNomeUsuario("Maria");
        c2.setSenha("123456");
        em.getTransaction().begin();
        em.persist(c);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
