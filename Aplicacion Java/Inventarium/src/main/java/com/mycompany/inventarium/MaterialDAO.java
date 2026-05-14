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
    
    public static boolean actualizarMaterial(Material m){
        
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
            
            return true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR -> " + e.getMessage());
            return false;
        } catch (Exception e){
            System.out.println("Surgio un error inesperado...");
            return false;
        }
        
    }
    
    public static void insertarMaterial (Material m) {
        
            String insertSql = ("INSERT INTO materiales(nombre, descripcion, id_categoria,id_subcategoria, id_estado,id_ubicacion, cantidad, fecha_alta,observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    

            try (PreparedStatement ps = getConexion().prepareStatement(insertSql)){
                
                ps.setString(1, m.getNombre());
                ps.setString(2, m.getDescripcion());
                ps.setInt(3, m.getId_categoria());
                ps.setInt(4, m.getId_subcategoria());
                ps.setInt(5, m.getId_estado());
                ps.setInt(6, m.getId_ubicacion());

                ps.setInt(7, m.getCantidad());

                ps.setDate(8,Date.valueOf(m.getFecha_alta()));

                ps.setString(9,m.getObservaciones());
                
                int salida = ps.executeUpdate();
                
                if(salida < 1){
                    System.out.println("No se ha añadido el material correctamente");
                }else if(salida == 1){
                    System.out.println("Se ha añadido un material correctamente");
                }else {
                    System.out.println("Se han añadido varios materiales");
                }
                
                
            } catch (SQLException e) {
                System.out.println("SQL -> " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Surgio un error inesperado");
            }

    }
    
    public static List<Material> verInventario(){

        String sql = "SELECT m.id_material, m.nombre, c.nombre as categoria, e.nombre as estado, cantidad, id_ubicacion FROM material m "
                + "JOIN categorias c ON c.id_categoria = m.id_categoria JOIN estado e ON e.id_estado = m.id_estado";
        
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

        String sql = "SELECT m.id_material, m.nombre, c.nombre as categoria, e.nombre as estado, cantidad, id_ubicacion FROM material m JOIN categorias c ON c.id_categoria = m.id_categoria " +
                    "JOIN estado e ON e.id_estado = m.id_estado WHERE m.nombre=?";
        
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

        String sql = "SELECT m.id_material, m.nombre, c.nombre as categoria, e.nombre as estado, cantidad, id_ubicacion FROM material m JOIN categorias c ON c.id_categoria = m.id_categoria " +
                    "JOIN estado e ON e.id_estado = m.id_estado WHERE c.nombre =?";
        
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

        String sql = "SELECT m.id_material, m.nombre, c.nombre as categoria, e.nombre as estado, cantidad, id_ubicacion FROM material m JOIN categorias c ON c.id_categoria = m.id_categoria " +
                    "JOIN estado e ON e.id_estado = m.id_estado WHERE e.nombre=?";
        
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

        String sql = "SELECT m.id_material, m.nombre, c.nombre as categoria, e.nombre as estado, cantidad, id_ubicacion FROM material m JOIN categorias c ON c.id_categoria = m.id_categoria " +
                    "JOIN estado e ON e.id_estado = m.id_estado WHERE m.id_material=?";
        
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
