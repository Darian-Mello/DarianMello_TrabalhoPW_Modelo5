/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Dariãn
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @NotBlank(message = "O nome do usuário deve ser informado")
    @Length(max = 30, message = "O nome do usuário não pode ter mais que {max} caracteres")
    @Column(name="nome_usuario", length = 30, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 40, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name="senha", length = 40, nullable = false)
    private String senha;
    
    @ManyToMany
    @JoinTable(name = "usuario_permissao",
            joinColumns =
                @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
            inverseJoinColumns =
                @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();
    
    public Usuario () {
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
