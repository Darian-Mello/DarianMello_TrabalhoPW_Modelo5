/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirAeroporto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Aeroporto a = new Aeroporto();
        Aeroporto a2 = new Aeroporto();
        Cidade c = em.find(Cidade.class, 1);
        Cidade c2 = em.find(Cidade.class, 2);
        a.setNome("Aeroporto gaúcho");
        a2.setNome("Aeroporto do Rio Grande");
        a.setOperacaoNoturna(true);
        a2.setOperacaoNoturna(false);
        a.setCidade(c);
        a2.setCidade(c2);
        em.getTransaction().begin();
        em.persist(a);
        em.persist(a2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
