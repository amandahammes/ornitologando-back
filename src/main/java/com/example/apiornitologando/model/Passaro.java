package com.example.apiornitologando.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passaro")
public class Passaro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passaro")
    private Integer id;
    
    @Column(name = "nome_popular", length = 255)
    private String nomePopular;
    
    @Column(name = "nome_cientifico", length = 255, nullable = false)
    private String nomeCientifico;
    
    @Column(name = "coloracao")
    private String coloracao;
    
    @Column(name = "img")
    private String img;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomePopular() {
        return nomePopular;
    }
    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }
    public String getNomeCientifico() {
        return nomeCientifico;
    }
    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }
    public String getColoracao() {
        return coloracao;
    }
    public void setColoracao(String coloracao) {
        this.coloracao = coloracao;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
   
}
