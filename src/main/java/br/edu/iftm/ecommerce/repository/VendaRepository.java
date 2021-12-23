package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.ItemVenda;
import br.edu.iftm.ecommerce.model.Venda;
import java.util.List;

public class VendaRepository  extends GenericRepository<Venda, Integer>{

    public VendaRepository() {
        super(Venda.class);
    }

    @Override
    public Venda save(Venda entidade) {
        List<ItemVenda> itensVenda = entidade.getItensVenda();
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entidade);
        
        for (ItemVenda itemVenda : itensVenda) {
            itemVenda.setVenda(entidade);
            itemVenda = getEntityManager().merge(itemVenda);
        }
        
        getEntityManager().getTransaction().commit();
        return entidade;
        
    }
    
    
}
