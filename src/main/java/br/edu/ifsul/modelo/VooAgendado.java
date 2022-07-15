/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Dariãn
 */
@Entity
@Table(name = "voo_agendado")
public class VooAgendado implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_voo_agendado", sequenceName = "seq_voo_agendado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo_agendado", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @NotBlank(message = "A aeronave não pode estar em branco")
    @Length(max = 40, message = "A aeronave não pode ter mais que {max} caracteres")
    @Column(name = "aeronave", length = 40, nullable = false)    
    private String aeronave;
    
    @Min(value = 0, message = "O total de passageiros não pode ser negativo")
    @NotNull(message = "O total de passageiros deve ser informado")
    @Column(name = "total_passageiros", nullable = false, columnDefinition = "integer")
    private Integer totalPassageiros;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @OneToMany(mappedBy = "vooAgendado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Passagem> passagens = new ArrayList<>();
    
    @NotNull(message = "O voo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "voo_id", referencedColumnName = "id", nullable = false)    
    private Voo voo;
    
    public VooAgendado () {
        
    }
    
    public void adicionarPassagem (Passagem obj) {
        obj.setVooAgendado(this);
        this.passagens.add(obj);
    }
    
    public void removerPassagem (int index) {
        this.passagens.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
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
        final VooAgendado other = (VooAgendado) obj;
        return Objects.equals(this.id, other.id);
    }
}
