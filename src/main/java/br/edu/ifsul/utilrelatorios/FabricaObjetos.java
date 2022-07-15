/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dariãn
 */
public class FabricaObjetos {
    public static List<Cidade> carregaCidades() {
        List<Cidade> lista = new ArrayList<>();
        Cidade c = new Cidade();
        c.setId(1);
        c.setPais("Brasil");
        c.setNome("Sarandi");
        lista.add(c);
        return lista;
    }
}
