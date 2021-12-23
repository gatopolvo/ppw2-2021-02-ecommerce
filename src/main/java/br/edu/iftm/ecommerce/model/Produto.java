/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
=======
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.ecommerce.model;

import java.sql.Date;
import java.time.LocalDate;
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author wanderson
 */
@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
=======
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
    
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
    private Integer id;
    private String nome;
    private String descricao;
    private String detalhes;
<<<<<<< HEAD
    private Float valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_desativacao")
    private Date dataDesativacao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

}
=======
    private float valor;
    private LocalDate data_criacao;
    private LocalDate data_desativacao;
    private Categoria categoria_id;
    private Marca marca_id;
}
>>>>>>> 377347832cdcb91d79afaad660d07b9e191160c0
