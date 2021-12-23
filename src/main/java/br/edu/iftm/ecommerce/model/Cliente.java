package br.edu.iftm.ecommerce.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String cpf;
    private String rg;
    @Column(name="orgao_expedidor")
    private String orgaoExpeditor;
    private String email;
    private String senha;
    
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
}