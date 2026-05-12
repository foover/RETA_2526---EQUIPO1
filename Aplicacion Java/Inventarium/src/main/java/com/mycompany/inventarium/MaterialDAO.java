/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarium;

import java.sql.Connection;
import java.sql.Date;
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
    
    public static boolean insertarMaterial(Material m){
        
        try {
            
            String comprobarSql = ("SELECT id_material, cantidad FROM materiales WHERE nombre = ? AND id_subcategoria = ?");
            
            PreparedStatement ps = getConexion().prepareStatement(comprobarSql);
            
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getId_subcategoria());

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                int idMaterial = rs.getInt("id_material");
                int cantidadActual = rs.getInt("cantidad");

                int nuevaCantidad = cantidadActual + m.getCantidad();

                String actualizarSql = ("UPDATE materiales SET cantidad = ? WHERE id_material = ?");

                PreparedStatement psActualizar = getConexion().prepareStatement(actualizarSql);

                psActualizar.setInt(1, nuevaCantidad);
                psActualizar.setInt(2, idMaterial);

                psActualizar.executeUpdate();

                return true;

            }
            
            String insertSql = ("INSERT INTO materiales(nombre, descripcion, id_categoria,id_subcategoria, id_estado,id_ubicacion, cantidad, fecha_alta,observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    

            PreparedStatement psInsertar = getConexion().prepareStatement(insertSql);

            psInsertar.setString(1, m.getNombre());
            psInsertar.setString(2, m.getDescripcion());
            psInsertar.setInt(3, m.getId_categoria());
            psInsertar.setInt(4, m.getId_subcategoria());
            psInsertar.setInt(5, m.getId_estado());
            psInsertar.setInt(6, m.getId_ubicacion());

            psInsertar.setInt(7, m.getCantidad());

            psInsertar.setDate(8,Date.valueOf(m.getFecha_alta()));

            ps.setString(9,m.getObservaciones());

            ps.executeUpdate();

            return true;
            
        } catch (SQLException e) {
            System.out.println("SQL ERROR -> " + e.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("Surgio un error inesperado...");
            return false;
        }
        
    }
    
    
    
    
    public static List<Material> verInventario(){

        String sql = "SELECT id_material, nombre, descripcion, id_categoria, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material";
        
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

        String sql = "SELECT id_material, nombre, descripcion, id_categoria, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE nombre =?";
        
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

        String sql = "SELECT id_material, nombre, descripcion, id_categoria, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE categoria=?";
        
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

        String sql = "SELECT id_material, nombre, descripcion, id_categoria, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE estado =?";
        
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

        String sql = "SELECT id_material, nombre, descripcion, id_categoria, id_subcategoria, estado, cantidad, id_ubicacion, fecha_alta, observaciones FROM material WHERE id_material=?";
        
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
