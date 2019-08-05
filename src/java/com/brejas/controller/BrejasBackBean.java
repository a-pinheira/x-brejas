/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brejas.controller;

import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Locale;
//mport javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.RowEditEvent;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.brejas.model.Brejas;
import com.brejas.model.BrejasDAO;
import javax.persistence.Id;

/**
 *
 * @authora Mony
 */
@Entity
@SessionScoped
public class BrejasBackBean implements Serializable {
    
    private Brejas brejas = new Brejas();
    @Id
    private List<Brejas> estilos = new ArrayList<>();
    private boolean desabilitar = true;

    public BrejasBackBean() {
    }
    
    public Brejas getBrejas() {
        return brejas;
    }

    public void setBrejas(Brejas brejas) {
        this.brejas = brejas;
    }

    public List<Brejas> getEstilos() {
        return estilos;
    }

    public void setEstilos(List<Brejas> estilos) {
        this.estilos = estilos;
    }

       
    public boolean isDesabilitar() {
        return desabilitar;
    }

    public void setDesabilitar(boolean desabilitar) {
        this.desabilitar = desabilitar;
    }

    public String adicionar() throws SQLException {
        BrejasDAO cvja = new BrejasDAO();
        cvja.adicionar(brejas);
        brejas = new Brejas();
        return null;
    }

    public String listar() throws SQLException {
        BrejasDAO cvja = new BrejasDAO();
        estilos = cvja.listar();
        return "/lista";
    }
    public String pag_cadastrar() throws SQLException {
        brejas = new Brejas();
        return "/cadastra";
    }
    
    public String pag_consultar() throws SQLException {
        estilos = new ArrayList<>();
        brejas.setEstilo("nomeEstilo");
        return "/consulta";
    }
    
    
    public String pag_alterar() {
        return "/altera";
    }

    public String alterar() {
        BrejasDAO cvja = new BrejasDAO();
        if (cvja == null) {
            cvja = new BrejasDAO();
        //    cvja.adicionar(brejas.setEstilo());
            //Por ID brejas.setId("Não há nenhum estilo com esse Estilo / ID");
            desabilitar = true;
        } else {
            desabilitar = false;
        }
      //  cvja.alterar(cvja);
        desabilitar = false;
        return "/Altera";
    }
    

    public String consultarPorEstilo() throws SQLException {
        BrejasDAO cvja = new BrejasDAO();
        brejas = cvja.consultar(brejas.getId()); // consultar(contato.getId());
        if (brejas == null) {
            brejas = new Brejas();
            brejas.setEstilo("Não há nenhum estilo com esse Estilo / ID");
            //Por ID brejas.setId("Não há nenhum estilo com esse Estilo / ID");
            desabilitar = true;
        } else {
            desabilitar = false;
        }
      
        return null;
    }
    
  public String pag_excluir() throws SQLException {
        brejas = new Brejas();
        desabilitar = true;
        return "/deleta";
        
    }
    
    public String excluir() throws SQLException {
        BrejasDAO cvja = new BrejasDAO();
        cvja.excluir(brejas.getId());
        brejas = new Brejas();
        desabilitar = true;
        return null;
    }

    public String consultar() throws SQLException {
       BrejasDAO cvja = new BrejasDAO();
        estilos = cvja.consultar(brejas.getEstilo());
        return null;
    }

}
