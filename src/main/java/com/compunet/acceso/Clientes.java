package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Clientes {

    private int id_cli;
    private String ci_cli;
    private String numeroDeCuenta_cli;
    private String saldo_cli;
    private String nombre_cli;
    private String apellido_cli;
    private String direccion_cli;
    private String telefono_cli;
    private String buscar;
    private CBDD c;

    public Clientes() {
        c = new CBDD();
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getCi_cli() {
        return ci_cli;
    }

    public void setCi_cli(String ci_cli) {
        this.ci_cli = ci_cli;
    }

    public String getNumeroDeCuenta_cli() {
        return numeroDeCuenta_cli;
    }

    public void setNumeroDeCuenta_cli(String numeroDeCuenta_cli) {
        this.numeroDeCuenta_cli = numeroDeCuenta_cli;
    }

    public String getSaldo_cli() {
        return saldo_cli;
    }

    public void setSaldo_cli(String saldo_cli) {
        this.saldo_cli = saldo_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApellido_cli() {
        return apellido_cli;
    }

    public void setApellido_cli(String apellido_cli) {
        this.apellido_cli = apellido_cli;
    }

    public String getDireccion_cli() {
        return direccion_cli;
    }

    public void setDireccion_cli(String direccion_cli) {
        this.direccion_cli = direccion_cli;
    }

    public String getTelefono_cli() {
        return telefono_cli;
    }

    public void setTelefono_cli(String telefono_cli) {
        this.telefono_cli = telefono_cli;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public boolean insertClientes(String ci, String nc, String s, String n, String a, String d, String t) { // nnombre, ruc, contacto, direccion
        setCi_cli(ci);
        setNumeroDeCuenta_cli(nc);
        setSaldo_cli(s);
        setNombre_cli(n);
        setApellido_cli(a);
        setDireccion_cli(d);
        setTelefono_cli(t);
        String sql = "INSERT INTO `clientes`"
                + "(`ci_cli`, `numeroDeCuenta_cli`, `saldo_cli`, `nombre_cli`, "
                + "`apellido_cli`, `direccion_cli`, `telefono_cli`) "
                + "VALUES "
                + "('" + getCi_cli() + "',"
                + "'" + getNumeroDeCuenta_cli() + "',"
                + "'" + getSaldo_cli() + "',"
                + "'" + getNombre_cli() + "',"
                + "'" + getApellido_cli() + "',"
                + "'" + getDireccion_cli() + "',"
                + "'" + getTelefono_cli() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteClientes(int id) {
        setId_cli(id);
        String sql = "DELETE FROM `clientes`\n"
                + "WHERE `id_cli` =" + getId_cli();
        return c.ejecutar(sql);
    }

    public boolean updateClientes(int id, String ci, String nc, String s, String n, String a, String d, String t) {
        setId_cli(id);
        setCi_cli(ci);
        setNumeroDeCuenta_cli(nc);
        setSaldo_cli(s);
        setNombre_cli(n);
        setApellido_cli(a);
        setDireccion_cli(d);
        setTelefono_cli(t);
        String sql = "UPDATE `clientes` SET `ci_cli`='" + getCi_cli() + "',\n"
                + "`numeroDeCuenta_cli`='" + getNumeroDeCuenta_cli() + "',\n"
                + "`saldo_cli`='" + getSaldo_cli() + "',\n"
                  + "`nombre_cli`='" + getNombre_cli() + "',\n"
                  + "`apellido_cli`='" + getApellido_cli() + "',\n"
                  + "`direccion_cli`='" + getDireccion_cli() + "',\n"
                + "`telefono_cli`='" + getTelefono_cli() + "'\n"
                + "WHERE `id_cli`=" + getId_cli();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectClientes(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `clientes`\n"
                + "WHERE `nombre_cli` like '%" + getBuscar() + "%'\n"
                + "or `ci_cli` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}
