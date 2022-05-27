/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Dariãn
 */
@Entity
@Table(name = "voo")
public class Voo implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_voo", sequenceName = "seq_voo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @NotBlank(message = "A descricao não pode estar em branco")
    @Length(max = 50, message = "A descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)    
    private String descricao;
    
    @Min(value = 0, message = "O tempo estimado não pode ser negativo")
    @NotNull(message = "O tempo estimado deve ser informado")
    @Column(name = "tempo_estimado", nullable = false, columnDefinition = "decimal(6,3)")
    private Double tempoEstimado;
    
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotBlank(message = "A periodicidade não pode estar em branco")
    @Length(max = 50, message = "A periodicidade não pode ter mais que {max} caracteres")
    @Column(name = "periodicidade", length = 50, nullable = false)    
    private String periodicidade;
    
    @OneToMany(mappedBy = "voo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VooAgendado> voo_agendado = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "escalas",
            joinColumns = 
                    @JoinColumn(name = "voo", referencedColumnName = "id", 
                            nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "aeroporto", referencedColumnName = "id", 
                            nullable = false)
            )     
    private Set<Aeroporto> aeroportos = new HashSet<>();
    
    public Voo () {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Set<Aeroporto> getAeroportos() {
        return aeroportos;
    }

    public void setAeroportos(Set<Aeroporto> aeroportos) {
        this.aeroportos = aeroportos;
    }

    public List<VooAgendado> getVoo_agendado() {
        return voo_agendado;
    }

    public void setVoo_agendado(List<VooAgendado> voo_agendado) {
        this.voo_agendado = voo_agendado;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Voo other = (Voo) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
