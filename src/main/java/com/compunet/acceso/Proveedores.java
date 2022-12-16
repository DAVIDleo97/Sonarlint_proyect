package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Proveedores {

    private int idProv;
    private String rucProv;
    private String nombreProv;
    private String direccionProv;
    private String telefonoProv;
    private String buscar;
    private CBDD c;

    public Proveedores() {
        c = new CBDD();
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getDireccionProv() {
        return direccionProv;
    }

    public void setDireccionProv(String direccionProv) {
        this.direccionProv = direccionProv;
    }

    public String getTelefonoProv() {
        return telefonoProv;
    }

    public void setTelefonoProv(String telefonoProv) {
        this.telefonoProv = telefonoProv;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

   

    public boolean insertProveedores(String r, String n, String d, String t) {      
        setRucProv(r);
        setNombreProv(n);
        setDireccionProv(d);
        setTelefonoProv(t);
        String sql = "INSERT INTO `proveedores`"
                + "(`ruc_prov`, `nombre_prov`, `direccion_prov`, "
                + "`telefono_prov`) "
                + "VALUES "
                + "('" + getRucProv() + "',"
                + "'" + getNombreProv() + "',"
                + "'" + getDireccionProv() + "',"
                + "'" + getTelefonoProv() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteProveedores(int id) {
        setIdProv(id);
        String sql = "DELETE FROM `proveedores`\n"
                + "WHERE `id_prov` =" + getIdProv();
        return c.ejecutar(sql);
    }

    public boolean updateProveedores(int id, String r, String n, String d, String t) {
        setIdProv(id);
        setRucProv(r);
        setNombreProv(n);
        setDireccionProv(d);
        setTelefonoProv(t);
        String sql = "UPDATE `proveedores` SET `ruc_prov`='" + getRucProv() + "',\n"
                + "`nombre_prov`='" + getNombreProv() + "',\n"
                + "`direccion_prov`='" + getDireccionProv() + "',\n"
                + "`telefono_prov`='" + getTelefonoProv() + "'\n"
                + "WHERE `id_prov`=" + getIdProv();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProveedores(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `proveedores`\n"
                + "WHERE `nombre_prov` like '%" + getBuscar() + "%'\n"
                + "or `ruc_prov` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}
