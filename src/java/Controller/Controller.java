/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Cliente;
import Model.ClienteDAO;
import Model.Empleado;
import Model.EmpleadoDAO;
import Model.Producto;
import Model.ProductoDAO;
import Model.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jodon
 */
public class Controller extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO eDao = new EmpleadoDAO();
    int idEmp;
    Cliente cl = new Cliente();
    ClienteDAO cDao = new ClienteDAO();
    int idCl;
    Producto pr = new Producto();
    ProductoDAO pDao = new ProductoDAO();
    int idPr;
    
    Venta v= new Venta();
    List<Venta> list = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        if (menu.equals("Main")) {
            request.getRequestDispatcher("Main.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List<Empleado> list = eDao.listar();
                    request.setAttribute("empleados", list);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNom");
                    String tel = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setEstado(estado);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setUser(user);
                    eDao.agregar(em);
                    request.getRequestDispatcher("Controller?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idEmp = Integer.parseInt(request.getParameter("id"));
                    Empleado temp = eDao.listarId(idEmp);
                    request.setAttribute("porAcutalizar", temp);
                    request.getRequestDispatcher("Controller?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNom");
                    String tel1 = request.getParameter("txtTel");
                    String estado1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setEstado(estado1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setUser(user1);
                    em.setId(idEmp);
                    eDao.actualizar(em);
                    request.getRequestDispatcher("Controller?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idEmp = Integer.parseInt(request.getParameter("id"));
                    eDao.delete(idEmp);
                    request.getRequestDispatcher("Controller?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            
            if(accion!=null){
                switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cl = cDao.buscar(dni);
                    request.setAttribute("c", cl);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = pDao.listarId(id);
                    request.setAttribute("pr", pr);
                    request.setAttribute("list", list);
                    break;
                case "Agregar":
                    totalPagar = 0.0;
                    item++;
                    cod = pr.getId();
                    descripcion = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setId(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    list.add(v);
                    for(Venta vnt : list){
                        totalPagar = totalPagar + vnt.getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("list", list);
                    break;
                default:
                    throw new AssertionError();
            }
            }
            request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
