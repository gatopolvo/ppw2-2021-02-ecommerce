/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    

}
