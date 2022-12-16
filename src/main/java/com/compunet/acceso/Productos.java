package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Productos {

    private int id_prod;
    private int idProveedores_prod;
    private String nombre_prod;
    private String descripcion_prod;
    private double valorRefComp_prod;
    private double valorRefVenta_prod;
    private int stock_prod;
    private String tieneIva_prod;
    private String tipo_prod;
    private String buscar;
    private CBDD c;

    public Productos() {
        c = new CBDD();
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getIdProveedores_prod() {
        return idProveedores_prod;
    }

    public void setIdProveedores_prod(int idProveedores_prod) {
        this.idProveedores_prod = idProveedores_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public double getValorRefComp_prod() {
        return valorRefComp_prod;
    }

    public void setValorRefComp_prod(double valorRefComp_prod) {
        this.valorRefComp_prod = valorRefComp_prod;
    }

    public double getValorRefVenta_prod() {
        return valorRefVenta_prod;
    }

    public void setValorRefVenta_prod(double valorRefVenta_prod) {
        this.valorRefVenta_prod = valorRefVenta_prod;
    }

    public int getStock_prod() {
        return stock_prod;
    }

    public void setStock_prod(int stock_prod) {
        this.stock_prod = stock_prod;
    }

    public String getTieneIva_prod() {
        return tieneIva_prod;
    }

    public void setTieneIva_prod(String tieneIva_prod) {
        this.tieneIva_prod = tieneIva_prod;
    }

    public String getTipo_prod() {
        return tipo_prod;
    }

    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public CBDD getC() {
        return c;
    }

    public void setC(CBDD c) {
        this.c = c;
    }

    public boolean insertProductos(int ip, String n, String d, double vc, double vv, int s, String ti, String tp) { // nnombre, ruc, contacto, dir3eccion

        setIdProveedores_prod(ip);
        setNombre_prod(n);
        setDescripcion_prod(d);
        setValorRefComp_prod(vc);
        setValorRefVenta_prod(vv);
        setStock_prod(s);
        setTieneIva_prod(ti);
        setTipo_prod(tp);
        String sql = "INSERT INTO `productos`"
                + "(`IdProveedores_prod`, `nombre_prod`, `descripcion_prod`, `valorRefComp_prod`, "
                + "`valorRefVenta_prod`, `stock_prod`, `tieneIva_prod`, tipo_prod) "
                + "VALUES "
                + "('" + getIdProveedores_prod() + "',"
                + "'" + getNombre_prod() + "',"
                + "'" + getDescripcion_prod() + "',"
                + "'" + getValorRefComp_prod() + "',"
                + "'" + getValorRefVenta_prod() + "',"
                + "'" + getStock_prod() + "',"
                + "'" + getTieneIva_prod() + "',"
                + "'" + getTipo_prod() + "')";

        return this.c.ejecutar(sql);
    }

    public boolean deleteProductos(int id) {
        setId_prod(id);
        String sql = "DELETE FROM `productos`\n"
                + "WHERE `id_prod` =" + getId_prod();
        return c.ejecutar(sql);
    }

    public boolean updateProductos(int id, int ip, String n, String d, double vc, double vv, int s, String ti, String tp) {
        setId_prod(id);
        setIdProveedores_prod(ip);
        setNombre_prod(n);
        setDescripcion_prod(d);
        setValorRefComp_prod(vc);
        setValorRefVenta_prod(vv);
        setStock_prod(s);
        setTieneIva_prod(ti);
        setTipo_prod(tp);
        String sql = "UPDATE `productos` SET `idProveedores_prod`='" + getIdProveedores_prod() + "',\n"
                + "`idProveedores_prod`='" + getIdProveedores_prod() + "',\n"
                + "`descripcion_prod`='" + getDescripcion_prod() + "',\n"
                + "`valorRefComp_prod`=" + getValorRefComp_prod() + ",\n"
                + "`valorRefVenta_prod`=" + getValorRefVenta_prod() + ",\n"
                + "`stock_prod`=" + getStock_prod() + ",\n"
                + "`tieneIva_prod`='" + getTieneIva_prod() + "',\n"
                + "`tipo_prod`='" + getTipo_prod() + "'\n"
                + "WHERE `id_prod`=" + getId_prod();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProductos(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `productos`\n"
                + "WHERE `nombre_prod` like '%" + getBuscar() + "%'\n"
                + "or `descripcion_prod` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}
