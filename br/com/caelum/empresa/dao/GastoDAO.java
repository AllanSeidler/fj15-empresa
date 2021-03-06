package br.com.caelum.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.empresa.modelo.Gasto;

public class GastoDAO {

    private final EntityManager entityManager = new JPAUtil().getEntityManager();
    private Class<Gasto> classe = Gasto.class;

    public void adiciona(Gasto entity) {
        entityManager.persist(entity);
    }

    public Gasto atualiza(Gasto entity) {
        return entityManager.merge(entity);
    }

    
    
    public void remove(Gasto entity) {
        entityManager.remove(entity);
    }

    public Gasto buscaPorId(Long id) {
        return entityManager.find(classe, id);
    }

    public List<Gasto> buscaTodos() {
        Query query = entityManager
                .createQuery("from " + classe.getName());
        return query.getResultList();
    }

}

