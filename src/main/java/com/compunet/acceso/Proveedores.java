package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Proveedores {

    private int id_prov;
    private String ruc_prov;
    private String nombre_prov;
    private String direccion_prov;
    private String telefono_prov;
    private String buscar;
    private CBDD c;

    public Proveedores() {
        c = new CBDD();
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getRuc_prov() {
        return ruc_prov;
    }

    public void setRuc_prov(String ruc_prov) {
        this.ruc_prov = ruc_prov;
    }

    public String getNombre_prov() {
        return nombre_prov;
    }

    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }

    public String getDireccion_prov() {
        return direccion_prov;
    }

    public void setDireccion_prov(String direccion_prov) {
        this.direccion_prov = direccion_prov;
    }

    public String getTelefono_prov() {
        return telefono_prov;
    }

    public void setTelefono_prov(String telefono_prov) {
        this.telefono_prov = telefono_prov;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

   

    public boolean insertProveedores(String r, String n, String d, String t) { // nnombre, ruc, contacto, direccion       
        setRuc_prov(r);
        setNombre_prov(n);
        setDireccion_prov(d);
        setTelefono_prov(t);
        String sql = "INSERT INTO `proveedores`"
                + "(`ruc_prov`, `nombre_prov`, `direccion_prov`, "
                + "`telefono_prov`) "
                + "VALUES "
                + "('" + getRuc_prov() + "',"
                + "'" + getNombre_prov() + "',"
                + "'" + getDireccion_prov() + "',"
                + "'" + getTelefono_prov() + "')";
        return this.c.ejecutar(sql);
    }

    public boolean deleteProveedores(int id) {
        setId_prov(id);
        String sql = "DELETE FROM `proveedores`\n"
                + "WHERE `id_prov` =" + getId_prov();
        return c.ejecutar(sql);
    }

    public boolean updateProveedores(int id, String r, String n, String d, String t) {
        setId_prov(id);
        setRuc_prov(r);
        setNombre_prov(n);
        setDireccion_prov(d);
        setTelefono_prov(t);
        String sql = "UPDATE `proveedores` SET `ruc_prov`='" + getRuc_prov() + "',\n"
                + "`nombre_prov`='" + getNombre_prov() + "',\n"
                + "`direccion_prov`='" + getDireccion_prov() + "',\n"
                + "`telefono_prov`='" + getTelefono_prov() + "'\n"
                + "WHERE `id_prov`=" + getId_prov();
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
