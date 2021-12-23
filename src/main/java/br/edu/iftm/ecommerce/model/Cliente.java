package br.edu.iftm.ecommerce.model;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
=======
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
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
=======
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "cliente")
@Data
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
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