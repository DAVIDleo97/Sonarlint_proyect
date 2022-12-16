package com.compunet.modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CBDD {

    private Statement st;
    private String driver;
    private String user;
    private String clave;
    private String cadena;
    private Connection cnx;

    public CBDD() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.user = "root";
        this.clave = "leo2Z1997";
        this.cadena = "jdbc:mysql://localhost/compunet?useSSL=false";
        this.cnx = this.crearConexion();
    }

    public Statement getSt() {
        return st;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getClave() {
        return clave;
    }

    public String getCadena() {
        return cadena;
    }

    public Connection getCnx() {
        return cnx;
    }

    private Connection crearConexion() {
        try {
            Class.forName(getDriver()).newInstance();
            Connection con = DriverManager.getConnection(getCadena(), getUser(), getClave());
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Insert, Update, Delete
    public boolean ejecutar(String sql) {

        try {
            st = getCnx().createStatement();
            int r = st.executeUpdate(sql);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Select
    public ResultSet consulta(String sql) {
        ResultSet rs = null;
        try {
            st = getCnx().createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
