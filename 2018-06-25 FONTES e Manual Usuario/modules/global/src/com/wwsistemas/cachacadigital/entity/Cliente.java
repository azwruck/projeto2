package com.wwsistemas.cachacadigital.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NamePattern("%s|nome")
@Table(name = "CACHACA_CLIENTE")
@Entity(name = "cachaca$Cliente")
public class Cliente extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 6652258313616578483L;

    @Column(name = "ESTADO2")
    protected String estado2;

    @NotNull
    @Column(name = "NOME", nullable = false, length = 128)
    protected String nome;

    @Email(message = "Email inválido!", regexp = ".*")
    @Column(name = "EMAIL", length = 128)
    protected String email;

    @Pattern(message = "Telefone inválido!", regexp = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$")
    @Column(name = "TELEFONE", length = 16)
    protected String telefone;

    @NotNull
    @Column(name = "ENDERECO", nullable = false)
    protected String endereco;

    @NotNull
    @Column(name = "CIDADE", nullable = false, length = 128)
    protected String cidade;

    @Pattern(regexp = "[1-9]")
    @NotNull
    @Column(name = "CEP", nullable = false)
    protected String cep;

    public EstadoT getEstado2() {
        return estado2 == null ? null : EstadoT.fromId(estado2);
    }

    public void setEstado2(EstadoT estado2) {
        this.estado2 = estado2 == null ? null : estado2.getId();
    }






    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }


}