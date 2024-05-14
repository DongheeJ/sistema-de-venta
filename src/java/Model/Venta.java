/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jodon
 */
public class Venta {
    Integer id;
    Integer item;
    Integer idCliente;
    Integer idEmpleado;
    Integer idProducto;
    String Nserie;
    String DescripcionP;
    String fecha;
    Double precio;
    Integer cantidad;
    Double subtotal;
    Double monto;
    String estado;

    public Venta() {
    }

    public Venta(Integer id, Integer item, Integer idCliente, Integer idEmpleado, Integer idProducto, String Nserie, String DescripcionP, String fecha, Double precio, Integer cantidad, Double subtotal, Double monto, String estado) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.Nserie = Nserie;
        this.DescripcionP = DescripcionP;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNserie() {
        return Nserie;
    }

    public void setNserie(String Nserie) {
        this.Nserie = Nserie;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
