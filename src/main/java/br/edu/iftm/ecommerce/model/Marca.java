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
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marca")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Marca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @NonNull
    private Integer id;
    private String nome;

=======
import lombok.Setter;


@Entity
@Table(name="marca")
@Getter @Setter //
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
public class Marca {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @EqualsAndHashCode.Include //
    
    private Integer id;
    private String nome;
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
}
