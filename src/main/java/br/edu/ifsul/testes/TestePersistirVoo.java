/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Voo;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirVoo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Voo v = new Voo ();
        Voo v2 = new Voo ();
        v.setDescricao("Voo tranquilo");
        v2.setDescricao("Voo tubulento");
        v.setPeriodicidade("Não sei");
        v2.setPeriodicidade("Não sei");
        v.setAtivo(true);
        v2.setAtivo(true);
        v.setTempoEstimado(1.0);
        v2.setTempoEstimado(2.0);
        em.getTransaction().begin();
        em.persist(v);
        em.persist(v2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
