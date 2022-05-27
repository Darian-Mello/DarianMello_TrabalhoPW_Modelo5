/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirClasse {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Classe c = new Classe();
        Classe c2 = new Classe();
        c.setNome("primeira classe");
        c2.setNome("classe economica");
        c.setValor(1000.0);
        c2.setValor(500.0);
        em.getTransaction().begin();
        em.persist(c);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
