/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Voo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirEscalas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Voo v = em.find(Voo.class, 1);
        Voo v2 = em.find(Voo.class, 2);
        Aeroporto a = em.find(Aeroporto.class, 5);
        Aeroporto a2 = em.find(Aeroporto.class, 6);
        v.getAeroportos().add(a);
        v2.getAeroportos().add(a2);
        em.getTransaction().begin();
        em.persist(v);
        em.persist(v2);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
