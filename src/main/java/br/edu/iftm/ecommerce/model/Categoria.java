<<<<<<< HEAD
package br.edu.iftm.ecommerce.model;

import java.io.Serializable;
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @NonNull
    private Integer id;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
=======
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 🍑
 */

@Entity
@Table(name = "categoria")
@Data
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @EqualsAndHashCode.Include //
    @Id
    private Integer id;
    private String nome;
    
    

>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
}
