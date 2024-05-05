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
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Cliente buscar(String dni){
        String sql = "select * from cliente where Dni = "+dni;
        Cliente cl = new Cliente();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt("IdCliente"));
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setEstado(rs.getString("Estado"));
                cl.setAdress(rs.getString("Direccion"));
            }
        } catch (Exception e) {
        }
        return cl;
    }
    //CRUD
    public List listar(){
        List<Cliente> list = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("IdCliente"));
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setEstado(rs.getString("Estado"));
                cl.setAdress(rs.getString("Direccion"));
                list.add(cl);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int agregar(Cliente cl){
        String sql = "insert into cliente (Dni, Nombres, Direccion, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getAdress());
            ps.setString(4, cl.getEstado());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public Cliente listarId(int id){
        Cliente cl = new Cliente();
        String sql = "select * from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt("IdCliente"));
                cl.setAdress(rs.getString("Direccion"));
                cl.setDni(rs.getString("Dni"));
                cl.setNom(rs.getString("Nombres"));
                cl.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return cl;
    }
    public int actualizar(Cliente cl){
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getAdress());
            ps.setString(4, cl.getEstado());
            ps.setInt(6, cl.getId());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
