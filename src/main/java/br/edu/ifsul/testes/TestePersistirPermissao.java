/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirPermissao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Permissao p = new Permissao();
        Permissao p2 = new Permissao();
        p.setNome("ADMINISTRADOR");
        p.setDescricao("Pode fazer qualquer ação dentro da aplicação.");
        p2.setNome("VISUALIZADOR");
        p2.setDescricao("Pode apenas visualizar os dados.");
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
