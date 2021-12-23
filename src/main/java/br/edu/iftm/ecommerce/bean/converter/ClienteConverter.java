package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.CategoriaLogic;
import br.edu.iftm.ecommerce.model.Cliente;
import br.edu.iftm.ecommerce.repository.CategoriaRepository;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Cliente.class, value = "clienteConverter")
public class ClienteConverter extends JSFUtil implements Converter<Cliente>{

    
    @Override
    public Cliente getAsObject(FacesContext fc, UIComponent uic, String idString) {
       Cliente cliente = 
                    (Cliente)uic.getAttributes().get("cliente_"+idString);
       return cliente;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cliente cliente) {
        if(cliente != null && cliente.getId() != null){
            uic.getAttributes().put("cliente_"+cliente.getId(), cliente);
            return cliente.getId().toString();
        }
        return "";
    }
    
}
