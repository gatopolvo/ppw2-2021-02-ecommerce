/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 🍑
 */
@Entity
@Table(name="produto")
@Getter @Setter //
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
public class Produto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @EqualsAndHashCode.Include //
    
    private Integer id;
    private String nome;
    private String descricao;
    private String detalhes;
    private float valor;
    private LocalDate data_criacao;
    private LocalDate data_desativacao;
    private Categoria categoria_id;
    private Marca marca_id;
}