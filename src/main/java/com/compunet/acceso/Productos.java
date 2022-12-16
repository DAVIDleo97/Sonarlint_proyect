package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Productos {

    private int idProd;
    private int idProveedoresProd;
    private String nombreProd;
    private String descripcionProd;
    private double valorRefCompProd;
    private double valorRefVentaProd;
    private int stockProd;
    private String tieneIvaProd;
    private String tipoProd;
    private String buscar;
    private CBDD c;

    public Productos() {
        c = new CBDD();
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdProveedoresProd() {
        return idProveedoresProd;
    }

    public void setIdProveedoresProd(int idProveedoresProd) {
        this.idProveedoresProd = idProveedoresProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public double getValorRefCompProd() {
        return valorRefCompProd;
    }

    public void setValorRefCompProd(double valorRefCompProd) {
        this.valorRefCompProd = valorRefCompProd;
    }

    public double getValorRefVentaProd() {
        return valorRefVentaProd;
    }

    public void setValorRefVentaProd(double valorRefVentaProd) {
        this.valorRefVentaProd = valorRefVentaProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    public String getTieneIvaProd() {
        return tieneIvaProd;
    }

    public void setTieneIvaProd(String tieneIvaProd) {
        this.tieneIvaProd = tieneIvaProd;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
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

    public boolean insertProductos(int ip, String n, String d, double vc, double vv, int s, String ti, String tp) {

        setIdProveedoresProd(ip);
        setNombreProd(n);
        setDescripcionProd(d);
        setValorRefCompProd(vc);
        setValorRefVentaProd(vv);
        setStockProd(s);
        setTieneIvaProd(ti);
        setTipoProd(tp);
        String sql = "INSERT INTO `productos`"
                + "(`IdProveedores_prod`, `nombre_prod`, `descripcion_prod`, `valorRefComp_prod`, "
                + "`valorRefVenta_prod`, `stock_prod`, `tieneIva_prod`, tipo_prod) "
                + "VALUES "
                + "('" + getIdProveedoresProd() + "',"
                + "'" + getNombreProd() + "',"
                + "'" + getDescripcionProd() + "',"
                + "'" + getValorRefCompProd() + "',"
                + "'" + getValorRefVentaProd() + "',"
                + "'" + getStockProd() + "',"
                + "'" + getTieneIvaProd() + "',"
                + "'" + getTipoProd() + "')";

        return this.c.ejecutar(sql);
    }

    public boolean deleteProductos(int id) {
        setIdProd(id);
        String sql = "DELETE FROM `productos`\n"
                + "WHERE `id_prod` =" + getIdProd();
        return c.ejecutar(sql);
    }

    public boolean updateProductos(int id, int ip, String n, String d, double vc, double vv, int s, String ti, String tp) {
        setIdProd(id);
        setIdProveedoresProd(ip);
        setNombreProd(n);
        setDescripcionProd(d);
        setValorRefCompProd(vc);
        setValorRefVentaProd(vv);
        setStockProd(s);
        setTieneIvaProd(ti);
        setTipoProd(tp);
        String sql = "UPDATE `productos` SET `idProveedores_prod`='" + getIdProveedoresProd() + "',\n"
                + "`idProveedores_prod`='" + getIdProveedoresProd() + "',\n"
                + "`descripcion_prod`='" + getDescripcionProd() + "',\n"
                + "`valorRefComp_prod`=" + getValorRefCompProd() + ",\n"
                + "`valorRefVenta_prod`=" + getValorRefVentaProd() + ",\n"
                + "`stock_prod`=" + getStockProd() + ",\n"
                + "`tieneIva_prod`='" + getTieneIvaProd() + "',\n"
                + "`tipo_prod`='" + getTipoProd() + "'\n"
                + "WHERE `id_prod`=" + getIdProd();
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
