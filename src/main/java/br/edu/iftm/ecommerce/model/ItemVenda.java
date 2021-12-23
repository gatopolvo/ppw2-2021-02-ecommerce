package br.edu.iftm.ecommerce.model;

import br.edu.iftm.ecommerce.repository.ItemVendaId;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_venda")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ItemVenda implements Serializable {
    
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private ItemVendaId id;
    
    @ManyToOne
    @JoinColumn(name = "produto_id", updatable = false, insertable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "venda_id", updatable = false, insertable = false)
    private Venda venda;
    private Integer quantidade;
    private Float valor;
  
    public void setProduto(Produto produto){
        if(this.id == null){
            this.id = new ItemVendaId();
        }
        this.id.setProdutoId(produto.getId());
        this.produto = produto;
    }
    
    public void setVenda(Venda venda){
        if(this.id == null){
            this.id = new ItemVendaId();
        }
        this.id.setVendaId(venda.getId());
        this.venda = venda;
    }
            
    
}
