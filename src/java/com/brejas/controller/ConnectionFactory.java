/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brejas.controller;

/*import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


/**
 *
 * @authora Mony
 */
//@Entity

public class ConnectionFactory {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/bd_brejas";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "sql@123";
    
    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DATABASE_URL, 
                                               DATABASE_USER, 
                                               DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw e;
        }
        
    }
 }
