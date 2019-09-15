/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson4_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class DbUtil {
    String strHost, strDbName, strUser, strPass;
    int port;
    String strConnURL, strClassName;
    Connection conn;

    public DbUtil() {
        this.strHost = "localhost";
        this.strDbName = "northwind";
        this.strUser = "sa";
        this.strPass = "abc123";
        this.port = 1433; // SQL server
        this.strClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.strConnURL = "jdbc:sqlserver://"+ strHost 
                +":"+port+";DatabaseName=" + strDbName + ";integratedSecurity=true";
    }

    public DbUtil(String strHost, String strDbName, String strUser, String strPass, int port, String strConnURL, String strClassName) {
        this.strHost = strHost;
        this.strDbName = strDbName;
        this.strUser = strUser;
        this.strPass = strPass;
        this.port = port;
        this.strConnURL = strConnURL;
        this.strClassName = strClassName;
    }
    
    public void openConnection(){
        try {
            Class.forName(strClassName);
            conn = DriverManager.getConnection(strConnURL, strUser, strPass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeConnection(){
        if(conn!=null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // excecuteNonQuery
    // excecuteQuery
    
}
