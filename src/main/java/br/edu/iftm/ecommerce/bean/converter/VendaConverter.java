package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.logic.VendaLogic;
import br.edu.iftm.ecommerce.model.Venda;
import br.edu.iftm.ecommerce.repository.VendaRepository;
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

@FacesConverter(forClass = Venda.class, value = "vendaConverter")
public class VendaConverter extends JSFUtil implements Converter<Venda>{

    @Inject
    private VendaLogic logic;
    
    @Override
    public Venda getAsObject(FacesContext fc, UIComponent uic, String idString) {
       Venda venda = 
                    (Venda)uic.getAttributes().get("venda_"+idString);
       return venda;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Venda venda) {
        if(venda != null){
            uic.getAttributes().put("venda_"+venda.getId(), venda);
            return venda.getId().toString();
        }
        return "";
    }
    
}
