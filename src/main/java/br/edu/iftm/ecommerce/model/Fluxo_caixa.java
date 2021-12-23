/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fluxo_caixa")
@Getter @Setter //
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
public class Fluxo_caixa {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @EqualsAndHashCode.Include //
    
    private Integer id;
    private String descricao;
    private String tipo_movimento;
    private float valor;
    private String data_movimento;
   
}