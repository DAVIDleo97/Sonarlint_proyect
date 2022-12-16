package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Clientes {

    private int idCli;
    private String ciCli;
    private String numeroDeCuentaCli;
    private String saldoCli;
    private String nombreCli;
    private String apellidoCli;
    private String direccionCli;
    private String telefonoCli;
    private String buscar;
    private CBDD c;

    public Clientes() {
        c = new CBDD();
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getCiCli() {
        return ciCli;
    }

    public void setCiCli(String ciCli) {
        this.ciCli = ciCli;
    }

    public String getNumeroDeCuentaCli() {
        return numeroDeCuentaCli;
    }

    public void setNumeroDeCuentaCli(String numeroDeCuentaCli) {
        this.numeroDeCuentaCli = numeroDeCuentaCli;
    }

    public String getSaldoCli() {
        return saldoCli;
    }

    public void setSaldoCli(String saldoCli) {
        this.saldoCli = saldoCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApellidoCli() {
        return apellidoCli;
    }

    public void setApellidoCli(String apellidoCli) {
        this.apellidoCli = apellidoCli;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public String getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(String telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public boolean insertClientes(String ci, String nc, String s, String n, String a, String d, String t) {
        setCiCli(ci);
        setNumeroDeCuentaCli(nc);
        setSaldoCli(s);
        setNombreCli(n);
        setApellidoCli(a);
        setDireccionCli(d);
        setTelefonoCli(t);
        String sql = "INSERT INTO `clientes`"
                + "(`ci_cli`, `numeroDeCuenta_cli`, `saldo_cli`, `nombre_cli`, "
                + "`apellido_cli`, `direccion_cli`, `telefono_cli`) "
                + "VALUES "
                + "('" + getCiCli() + "',"
                + "'" + getNumeroDeCuentaCli() + "',"
                + "'" + getSaldoCli() + "',"
                + "'" + getNombreCli() + "',"
                + "'" + getApellidoCli() + "',"
                + "'" + getDireccionCli() + "',"
                + "'" + getTelefonoCli() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteClientes(int id) {
        setIdCli(id);
        String sql = "DELETE FROM `clientes`\n"
                + "WHERE `id_cli` =" + getIdCli();
        return c.ejecutar(sql);
    }

    public boolean updateClientes(int id, String ci, String nc, String s, String n, String a, String d, String t) {
        setIdCli(id);
        setCiCli(ci);
        setNumeroDeCuentaCli(nc);
        setSaldoCli(s);
        setNombreCli(n);
        setApellidoCli(a);
        setDireccionCli(d);
        setTelefonoCli(t);
        String sql = "UPDATE `clientes` SET `ci_cli`='" + getCiCli() + "',\n"
                + "`numeroDeCuenta_cli`='" + getNumeroDeCuentaCli() + "',\n"
                + "`saldo_cli`='" + getSaldoCli() + "',\n"
                  + "`nombre_cli`='" + getNombreCli() + "',\n"
                  + "`apellido_cli`='" + getApellidoCli() + "',\n"
                  + "`direccion_cli`='" + getDireccionCli() + "',\n"
                + "`telefono_cli`='" + getTelefonoCli() + "'\n"
                + "WHERE `id_cli`=" + getIdCli();
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
