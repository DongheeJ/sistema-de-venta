/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jodon
 */
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user,String dni){
        Empleado em = new Empleado();
        String sql = "select * from empleado where User = ? and Dni = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("idEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    //CRUD
    public List listar(){
        List<Empleado> list = new ArrayList<>();
        String sql = "select * from empleado";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt("idEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                em.setEstado(rs.getString("Estado"));
                em.setTel(rs.getString("Telefono"));
                list.add(em);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int agregar(Empleado em){
        String sql = "insert into empleado (Dni, Nombres, Telefono, Estado, User) values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public Empleado listarId(int id){
        Empleado em = new Empleado();
        String sql = "select * from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("idEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                em.setEstado(rs.getString("Estado"));
                em.setTel(rs.getString("Telefono"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    public int actualizar(Empleado em){
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where idEmpleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
