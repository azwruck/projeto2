package com.wwsistemas.cachacadigital.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|nome")
@Table(name = "CACHACA_CATEGORIA")
@Entity(name = "cachaca$Categoria")
public class Categoria extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -8664748611634180120L;

    @NotNull
    @Column(name = "NOME", nullable = false, length = 64)
    protected String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


}