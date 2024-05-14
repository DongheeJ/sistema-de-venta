/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jodon
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Producto buscarId(int id){
        String sql = "select * from producto where idProducto = "+id;
        Producto p = new Producto();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    public int actualizarStock(int id,int stock){
        String sql = 
                "update producto set Stock = ? where idProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public List listar(){
        List<Producto> list = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt("IdProducto"));
                pr.setNom(rs.getString("Nombres"));
                pr.setPrecio(rs.getDouble("Precio"));
                pr.setEstado(rs.getString("Estado"));
                pr.setStock(rs.getInt("Stock"));
                list.add(pr);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int agregar(Producto cl){
        String sql = "insert into producto (Nombres, Precio, Stock, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNom());
            ps.setDouble(2, cl.getPrecio());
            ps.setInt(3, cl.getStock());
            ps.setString(4, cl.getEstado());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public Producto listarId(int id){
        Producto pr = new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt("IdProducto"));
                pr.setPrecio(rs.getDouble("Precio"));
                pr.setStock(rs.getInt("Stock"));
                pr.setNom(rs.getString("Nombres"));
                pr.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Producto pr){
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
