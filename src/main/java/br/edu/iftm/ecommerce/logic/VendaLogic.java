package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.ItemVenda;
import br.edu.iftm.ecommerce.model.Venda;
import br.edu.iftm.ecommerce.model.Venda;
import br.edu.iftm.ecommerce.repository.ItemVendaId;
import br.edu.iftm.ecommerce.repository.VendaRepository;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class VendaLogic implements CrudLogic<Venda>{

    @Inject
    private VendaRepository repository;
    
    @Override
    public Venda salvar(Venda entidade) throws ErroSistemaException, ErroNegocioException{
       
        if (entidade.getDataCriacao() == null) {
            entidade.setDataCriacao(new Date());
        }
        entidade = this.repository.save(entidade);
        return entidade;
    }

    @Override
    public void remover(Venda entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Venda buscarPorId(Venda entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }
    
    @Override
    public List<Venda> buscar(Venda entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }
    
 
    
}
