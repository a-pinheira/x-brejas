/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brejas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.brejas.model.BrejasDAO;
import java.util.List;
import javax.persistence.OneToMany;

/**
 * Classe antigo POJO - Gets e Sets
 * @authora Mony
 */ 
@Entity
//Está listando todas a variaveis no novo objeto brew
@NamedQueries ({
  @NamedQuery(name = "Cerveja.listarTodas", query = "select b from Brejas b order by b.estilo")  
})

public class Brejas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estilo;
    @Enumerated(EnumType.STRING)
    private String temperatura;
    
    /*private String musica; */
    public Long getId() {
        return id;
    }
    @OneToMany(mappedBy = "Brew")
    private List<Brejas> cerveja;

    public List<Brejas> getCerveja() {
        return cerveja;
    }

    public void setCerveja(List<Brejas> cerveja) {
        this.cerveja = cerveja;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
     // gerar os getters e setters de temperatura e musica

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    
    /*
                   break;
    
                }
            }
        
    }
    returno temperatura;
    
    Else if ("Ainda não exite !!")
    
    public List<SelectItem> getSelecionaIdiomas() {
        List<SelectItem> itens = new ArrayList<>();
        itens.add(new SelectItem("Ing", "Inglês"));
        itens.add(new SelectItem("Fra", "Fracês"));
        itens.add(new SelectItem("Esp", "Espanhol"));
        itens.add(new SelectItem("Ita", "Italiano"));
        return itens;
       }
    
     public SelectItem[] getCidades() {
        SelectItem[] cidades = {
            new SelectItem("Selecione a cidade")};
        if (!listaCidadesDesabilitada
                && estado != null) {
            for (EstadoInfo s
                    : EstadoInfo.getEstados()) {
                if (s.getSigla().equals(estado)) {
                    cidades = s.getCidades();
                    break;
                }
            }
        }
        return cidades;
    }
    */   
    
}
