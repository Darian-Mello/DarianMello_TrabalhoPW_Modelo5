/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirVooAgendado {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        VooAgendado va = new VooAgendado();
        VooAgendado va2 = new VooAgendado();
        Voo v = em.find(Voo.class, 1);
        Voo v2 = em.find(Voo.class, 2);
        va2.setAeronave("Brasileira");
        va2.setData(Calendar.getInstance());
        va2.setTotalPassageiros(300);
        va2.setVoo(v2);
        va.setAeronave("Americana");
        va.setData(Calendar.getInstance());
        va.setTotalPassageiros(400);
        va.setVoo(v);
        em.getTransaction().begin();
        em.persist(va);
        em.persist(va2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
