/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author jodon
 */
public class VentaDAO {
    Connection con;
    Conexion  cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public String GenerarSerie(){
        String nSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                nSerie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return nSerie;
    }
}
