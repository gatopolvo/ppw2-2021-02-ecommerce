package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Cliente;

public class ClienteRepository  extends GenericRepository<Cliente, Integer>{

    public ClienteRepository() {
        super(Cliente.class);
    }
}
