package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Endereco;

public class EnderecoRepository extends GenericRepository<Endereco, Integer> {

    public EnderecoRepository() {
        super(Endereco.class);
    }

}
