package com.wwsistemas.cachacadigital.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.chile.core.annotations.NamePattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.MetaProperty;
import javax.persistence.Transient;

@NamePattern("%s|id")
@Table(name = "CACHACA_BARRICA")
@Entity(name = "cachaca$Barrica")
public class Barrica extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -5134373288386287168L;
    
    
    @NotNull
    @Column(name = "CAPACIDADE", nullable = false)
    protected Double capacidade;


    @Column(name = "QUANTIDADE")
    protected Integer quantidade;

    @Column(name = "MADEIRA")
    protected String madeira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUTO_ID")
    protected Produto produto;

    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ENTRADA")
    protected Date data_entrada;

    @Transient
    @MetaProperty(related = "data_entrada")
    protected String tempo_armazenado;

    public String getTempo_armazenado() {
    	
        LocalDate l = LocalDate.now();
        
        LocalDate n = LocalDate.of(data_entrada.getYear(), data_entrada.getMonth()+1, data_entrada.getDate());

        Period pe = Period.between(n, l);
        
        
        tempo_armazenado = pe.getMonths()+ "meses"+ pe.getDays()+"dias";
        return tempo_armazenado;
    }
    


    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_entrada() {
        return data_entrada;
    }


    public void setMadeira(String madeira) {
        this.madeira = madeira;
    }

    public String getMadeira() {
        return madeira;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }



    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }

    public Double getCapacidade() {
        return capacidade;
    }


}