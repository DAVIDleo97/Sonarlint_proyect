package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Usuarios {

    private int id_u;
    private String usuario_u;
    private String clave_u;
    private String rol_u;
    private String buscar_u;
    private CBDD c;

    public Usuarios() {
        c = new CBDD();
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getUsuario_u() {
        return usuario_u;
    }

    public void setUsuario_u(String usuario_u) {
        this.usuario_u = usuario_u;
    }

    public String getClave_u() {
        return clave_u;
    }

    public void setClave_u(String clave_u) {
        this.clave_u = clave_u;
    }

    public String getRol_u() {
        return rol_u;
    }

    public void setRol_u(String rol_u) {
        this.rol_u = rol_u;
    }

    public String getBuscar_u() {
        return buscar_u;
    }

    public void setBuscar_u(String buscar_u) {
        this.buscar_u = buscar_u;
    }

    public ResultSet verificarUsuario(String usuario, String clave) {
        setUsuario_u(usuario);
        setClave_u(clave);
        String sql = "SELECT * FROM `usuario`\n"
                + "WHERE `usuario_u` = '" + getUsuario_u() + "'\n"
                + "and `clave_u` = SHA1('" + getClave_u() + "')";
        return c.consulta(sql);
    }
}
