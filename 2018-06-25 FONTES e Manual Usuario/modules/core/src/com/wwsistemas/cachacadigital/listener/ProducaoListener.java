package com.wwsistemas.cachacadigital.listener;

import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeDeleteEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.wwsistemas.cachacadigital.entity.Producao;
import com.wwsistemas.cachacadigital.entity.Produto;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import com.haulmont.cuba.core.listener.AfterDeleteEntityListener;
import java.sql.Connection;
import com.haulmont.cuba.core.listener.AfterInsertEntityListener;
import com.haulmont.cuba.core.listener.AfterUpdateEntityListener;
import com.haulmont.cuba.core.listener.BeforeAttachEntityListener;
import com.haulmont.cuba.core.sys.listener.EntityListenerManager;

@Component("cachaca_ProducaoListener")
public class ProducaoListener implements BeforeInsertEntityListener<Producao>, BeforeUpdateEntityListener<Producao>{//, BeforeAttachEntityListener<Producao>{



    @Override
    public void onBeforeInsert(Producao entity, EntityManager entityManager) {
    	calculaEstoque(entity, entity.getProduto(), entityManager);

    }


    @Override
    public void onBeforeUpdate(Producao entity, EntityManager entityManager) {
    	calculaEstoque(entity, entity.getProduto(), entityManager);

    }


    private void calculaEstoque(Producao pd, Produto p, EntityManager entity){
        if (p == null)
            return;
        if(p.getQuantidade() == null){
        	p.setQuantidade(0);
        }
        
        Integer estoque = pd.getQuant() + p.getQuantidade();
        
        Produto pro = entity.merge(p);
        
        pro.setQuantidade(estoque);
    }



//    @Override
//    public void onBeforeAttach(Producao entity) {
//    	Integer estoque = entity.getQuant() + entity.getProduto().getQuantidade();
//    	Producao p = entityManager.merge(entity);
//    	p.getProduto().setQuantidade(estoque);
//    }


}