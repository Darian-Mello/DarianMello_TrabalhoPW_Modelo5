/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Classe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dariãn
 */
public class TestePersistirCidade {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DarianMello_TrabalhoPW_Modelo5PU");
        EntityManager em = emf.createEntityManager();
        Cidade c = new Cidade();
        Cidade c2 = new Cidade();
        c.setNome("Passo Fundo");
        c2.setNome("Palmeira das Missões");
        c.setPais("Brasil");
        c2.setPais("Brasil");
        em.getTransaction().begin();
        em.persist(c);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
