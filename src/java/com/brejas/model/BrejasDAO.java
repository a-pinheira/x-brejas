/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brejas.model;

/*import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; */

import com.brejas.controller.ConnectionFactory;
import com.brejas.controller.JPAEntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import jpa.
import com.brejas.controller.JPAEntityManager; //ultil.JPAEntityManager

/**
 *
 * @authora Mony
 */
//@Entity
public class BrejasDAO  {
    
    private static final String SQL_INSERIR_BREJAS
            = "insert into estilos (nome, temperatura, musica) values(?,?,?)";
    private static final String SQL_LISTAR_BREJAS            
            = "select * from estilos  order by nome";
    private static final String SQL_CONSULTAR_BREJAS 
            = "select * from estilos  where nome like ?";
    private static final String SQL_EXCLUIR_BREJAS
            = "delete from estilos where id=?";
    private static final String SQL_CARREGAR_BREJAS 
            = "select * from estilos where id=?";

    // a conexão com o banco de dados
    private Connection connection;
    
    private EntityManager manager;

    public void adicionar(Brejas estilos) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.
                        prepareStatement(SQL_INSERIR_BREJAS);
                // seta os valores
                stmt.setString(1, estilos.getEstilo());
                stmt.setString(2, estilos.getTemperatura());
                //stmt.setString(2, estilos.temperatura());
                // executa
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Brejas> listar() throws SQLException {
        List<Brejas> estilos = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.
                        prepareStatement(SQL_LISTAR_BREJAS);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Brejas b = new Brejas();
                    b.setId(rs.getLong("id"));
                    b.setEstilo(rs.getString("nomeEstilo"));
                    b.setTemperatura(rs.getString("temperatura"));
                   /* b.setTemperatura(rs.getString("temperatura"));
                    b.setMusica(rs.getString("musica")); */
                    estilos.add(b);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return estilos;
    }

    public List<Brejas> consultar(String nomeEstilos) throws SQLException {
        List<Brejas> estilos = new ArrayList<>();
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.
                        prepareStatement(SQL_CONSULTAR_BREJAS);
                stmt.setString(1, '%' + nomeEstilos + '%');
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Brejas b = new Brejas();
                    b.setId(rs.getLong("id"));
                    b.setEstilo(rs.getString("nome"));
                    b.setTemperatura(rs.getString("temperatura"));
                    /* 
                if (s.getTemperatura().equals(temperatura)) {
                    temperatura = s.getTemperatura();     
                    Pilsens	-2° a 4°            Weizenbier	-4° a 6°      
                    Red ale	-5° a 5°            India pale ale -6° a 7°
                    IPA	-7° a 10°                   Dunkel	-8° a 2°     
                    Imperial Stouts -10° a 13°      Brown ale	0° a 14°   
                if (estilo == "Wessbier" && temperatura <= "-1" && >= "3" ) 
                if ((b.setEstilo("nome") == "Wessbier") && (b.getTemperatura() <= "-1" && >= "3" ) )
                    b.setEstilo(rs.getString("nome"));
                    b.setTemperatura(rs.getString("temperatura"));
                    b.setEstilo(rs.getString("nome"));
                    b.setTemperatura(rs.getString("temperatura"));    
                    
                    */
                    
                    estilos.add(b);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return estilos;
    }
    
    /**
     *
     * @param estilo
     * @return
     * @throws SQLException
     */
    public Brejas consultar(Long id) throws SQLException {
        Brejas b = null;
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.
                        prepareStatement(SQL_CARREGAR_BREJAS);
                stmt.setLong(1, id);
                //stmt.setString(1, estilo);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    b = new Brejas();
                    b.setId(rs.getLong("id"));
                    b.setEstilo(rs.getString("nomeEstilo"));
                    b.setTemperatura(rs.getString("temperatura"));
                    /*b.setTemperatura(rs.getString("temperatura"));
                    b.setMusica(rs.getString("musica"));                     */
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return b;
    }
    
        public void alterar(Brejas brejas) {
            manager = JPAEntityManager.getEntityManager();
            manager.getTransaction().begin();
            manager.merge(brejas);
            manager.getTransaction().commit();
            manager.close();
    }


    public void excluir(Long id) throws SQLException {
        try {
            connection = new ConnectionFactory().getConnection();
            try {
                PreparedStatement stmt = connection.
                        prepareStatement(SQL_EXCLUIR_BREJAS);                
                stmt.setLong(1, id);
                // executa
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
