
package br.edu.iftm.ecommerce.repository;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaId implements Serializable {
    @Column(name = "produto_id")
    private Integer produtoId;
    @Column(name = "venda_id")
    private Integer vendaId;
}
