package com.compunet.servlet;

import com.compunet.acceso.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductosS", urlPatterns = "/ProductosS")
public class ProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("crud");
        if (menu.equals("sel")) {
            //read
            readProductos(request, response);
        } else if (menu.equals("up")) {
            //update
            updateProductos(request, response);
        } else if (menu.equals("in")) {
            //Insert 
            insertProductos(request, response);
        } else if (menu.equals("del")) {
            //delete
            deleteProductos(request, response);
        }
    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    	//document why this method is empty
    }

    //CRUD
    private void deleteProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("numId"));
            Productos p = new Productos();
            boolean r = p.deleteProductos(id);
            pw.println(r);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void readProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String buscar = request.getParameter("txtBuscar");
            Productos c = new Productos();
            ResultSet r = c.selectProductos(buscar);
            String tabla = "<table class='table table-hover'>";
            tabla += "<thead class='thead-dark' style='text-align: center'>";
            tabla += "<tr>";
            tabla += "<th>ID PRODUCTO";
            tabla += "</th>";
            tabla += "<th>ID PROVEEDOR";
            tabla += "</th>";
            tabla += "<th>NOMBRE";
            tabla += "</th>";
            tabla += "<th>DESCRIPCIÓN";
            tabla += "</th>";
            tabla += "<th>VALOR COMPRA";
            tabla += "</th>";
            tabla += "<th>VALOR VENTA";
            tabla += "</th>";
            tabla += "<th>STOCK";
            tabla += "</th>";
            tabla += "<th>IVA";
            tabla += "</th>";
            tabla += "<th>TIPO";
            tabla += "</th>";
            tabla += "<th>ACCIÓN";
            tabla += "</th>";
            tabla += "</tr>";
            tabla += "</thead>";
            tabla += "<tbody>";

            while (r.next()) {
                tabla += "<tr>";
                tabla += "<td>" + r.getInt("idProd");
                tabla += "</td>";
                tabla += "<td>" + r.getString("idProveedoresProd");
                tabla += "</td>";
                tabla += "<td>" + r.getString("nombreProd");
                tabla += "</td>";
                tabla += "<td>" + r.getString("descripcionPProd");
                tabla += "</td>";
                tabla += "<td>" + r.getDouble("valorRefCompProd");
                tabla += "</td>";
                tabla += "<td>" + r.getDouble("valorRefVentaProd");
                tabla += "</td>";
                tabla += "<td>" + r.getInt("stockProd");
                tabla += "</td>";
                tabla += "<td>" + r.getString("tieneIvaProd");
                tabla += "</td>";
                tabla += "<td>" + r.getString("tipoProd");
                tabla += "</td>";
                tabla += "<td>";
                tabla += "<button type='button' class='btn btn-dark' data-toggle='modal' data-target='#actualizarProducto' onclick=\"cargarDatosActualizar('" + r.getInt("id_prod") + "','" + r.getInt("idProveedores_prod") + "','" + r.getString("nombre_prod") + "','" + r.getString("descripcion_prod") + "','" + r.getDouble("valorRefComp_prod") + "','" + r.getDouble("valorRefVenta_prod") + "','" + r.getInt("stock_prod") + "','" + r.getString("tieneIva_prod") + "','" + r.getString("tipo_prod") + "')\">Actualizar</button>";
                tabla += "<button type='button' class='btn btn-info'data-toggle='modal' data-target='#eliminarProducto' onclick=\"cargarDatosEliminar('" + r.getInt("id_prod") + "')\" >Eliminar</button>";
                tabla += "</td>";
                tabla += "</tr>";
            }
            tabla += "</tbody>";
            tabla += "</tabla>";
            pw.println(tabla);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int ip = Integer.parseInt(request.getParameter("numIp"));
            String n = request.getParameter("txtN");
            String d = request.getParameter("txtD");
            double vc = Double.parseDouble(request.getParameter("decVc"));
            double vv = Double.parseDouble(request.getParameter("decVv"));
            int s = Integer.parseInt(request.getParameter("numS"));
            String ti = request.getParameter("txtTi");
            String tp = request.getParameter("txtTp");
            Productos p = new Productos();
            boolean r = p.insertProductos(ip, n, d, vc, vv, s, ti, tp);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProductos(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("numId"));
            int ip = Integer.parseInt(request.getParameter("numIp"));
            String n = request.getParameter("txtN");
            String d = request.getParameter("txtD");
            double vc = Double.parseDouble(request.getParameter("decVc"));
            double vv = Double.parseDouble(request.getParameter("decVv"));
            int s = Integer.parseInt(request.getParameter("numS"));
            String ti = request.getParameter("txtTi");
            String tp = request.getParameter("txtTp");
            Productos p = new Productos();
            boolean r = p.updateProductos(id, ip, n, d, vc, vv, s, ti, tp);
            pw.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
