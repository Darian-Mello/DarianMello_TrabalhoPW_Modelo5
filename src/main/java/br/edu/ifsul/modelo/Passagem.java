/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Dariãn
 */
@Entity
@Table(name = "passagem")
public class Passagem implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_passagem", sequenceName = "seq_passagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passagem", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da compra deve ser informada")
    @Column(name = "data_compra", nullable = false)
    private Calendar dataCompra;
    
    @Min(value = 0, message = "A bagagem não pode ser negativa")
    @NotNull(message = "A bagagem deve ser informada")
    @Column(name = "bagagem", nullable = false, columnDefinition = "integer")
    private Integer bagagem;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @NotNull(message = "A classe deve ser informada")
    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id", nullable = false)
    private Classe classe;
    
    @NotNull(message = "O voo agendado deve ser informado")
    @ManyToOne
    @JoinColumn(name = "voo_agendado_id", referencedColumnName = "id", nullable = false)    
    private VooAgendado vooAgendado;
    
    public Passagem () {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public VooAgendado getVooAgendado() {
        return vooAgendado;
    }

    public void setVooAgendado(VooAgendado vooAgendado) {
        this.vooAgendado = vooAgendado;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passagem other = (Passagem) obj;
        return Objects.equals(this.id, other.id);
    }
}
