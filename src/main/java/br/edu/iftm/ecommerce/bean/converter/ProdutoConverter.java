package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.ProdutoLogic;
import br.edu.iftm.ecommerce.model.Produto;
import br.edu.iftm.ecommerce.repository.ProdutoRepository;
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

@FacesConverter(forClass = Produto.class, value = "produtoConverter")
public class ProdutoConverter extends JSFUtil implements Converter<Produto>{

    @Override
    public Produto getAsObject(FacesContext fc, UIComponent uic, String idString) {
       Produto produto = 
                    (Produto)uic.getAttributes().get("produto_"+idString);
       return produto;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Produto produto) {
        if(produto != null && produto.getId() != null){
            uic.getAttributes().put("produto_"+produto.getId(), produto);
            return produto.getId().toString();
        }
        return "";
    }
    
}
