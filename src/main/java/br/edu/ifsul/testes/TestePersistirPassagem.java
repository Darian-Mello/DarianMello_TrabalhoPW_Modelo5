/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirPassagem {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Passagem p = new Passagem();
        Passagem p2 = new Passagem();
        VooAgendado v = em.find(VooAgendado.class, 1);
        VooAgendado v2 = em.find(VooAgendado.class, 2);
        Pessoa pe = em.find(Pessoa.class, 1);
        Pessoa pe2 = em.find(Pessoa.class, 2);
        Classe c = em.find(Classe.class, 1);
        Classe c2 = em.find(Classe.class, 2);
        p.setDataCompra(Calendar.getInstance());
        p.setBagagem(3);
        p.setVooAgendado(v);
        p.setPessoa(pe);
        p.setClasse(c);
        p2.setDataCompra(Calendar.getInstance());
        p2.setBagagem(2);
        p2.setVooAgendado(v2);
        p2.setPessoa(pe2);
        p2.setClasse(c2);
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
