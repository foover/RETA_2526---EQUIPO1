/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joaquin
 */
public class MaterialDAO {
    
    
    private static Connection getConexion(){
        
        return AccesoBaseDatos.getInstance().getConn();
                
    }
    
    private static Material crearMaterial (final ResultSet rs) throws SQLException {
        
        LocalDate fecha = rs.getDate("fecha_alta").toLocalDate();
        
        
        return new Material(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("id_categoria"),rs.getInt("id_subcategoria"), rs.getInt("id_estado"), 
                rs.getInt("cantidad"), rs.getInt("id_ubicacion"), fecha, rs.getString("observaciones"));

    }
    
    public static List<Material> verInventario(){

        String sql = "SELECT id_material, nombre, descripcion, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material";
        
        List<Material> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearMaterial(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;
        
        
    }
    
    public static List<Material> filtrarPorNombre(String nombre){

        String sql = "SELECT id_material, nombre, descripcion, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE nombre =?";
        
        List<Material> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            ps.setString(1, nombre);
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearMaterial(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;
         
    }
    
    public static List<Material> filtrarPorCategoria(String categoria){

        String sql = "SELECT id_material, nombre, descripcion, categoria, subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE categoria=?";
        
        List<Material> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            ps.setString(1, categoria);
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearMaterial(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;
         
    }
    
    public static List<Material> filtrarPorEstado(String estado){

        String sql = "SELECT id_material, nombre, descripcion, categoria, subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE estado =?";
        
        List<Material> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            ps.setString(1, estado);
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearMaterial(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;
         
    }
    
    public static List<Material> filtrarPorCodigo(int id){

        String sql = "SELECT id_material, nombre, descripcion, categoria, subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE id_material=?";
        
        List<Material> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearMaterial(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;
         
    }
    
    
    
    
    
    
    
    
    
    
}
