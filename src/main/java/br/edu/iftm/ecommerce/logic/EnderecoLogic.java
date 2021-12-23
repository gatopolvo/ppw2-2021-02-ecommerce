package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Endereco;
import br.edu.iftm.ecommerce.repository.EnderecoRepository;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class EnderecoLogic implements CrudLogic<Endereco>{

    @Inject
    private EnderecoRepository repository;
    
    @Override
    public Endereco salvar(Endereco entidade) throws ErroSistemaException, ErroNegocioException{
       
        entidade = this.repository.save(entidade);
        return entidade;
    }

    @Override
    public void remover(Endereco entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Endereco buscarPorId(Endereco entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }
    
    @Override
    public List<Endereco> buscar(Endereco entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }

    
}
