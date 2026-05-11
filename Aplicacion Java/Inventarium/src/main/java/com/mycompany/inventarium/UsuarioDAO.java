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
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW109
 */
public class UsuarioDAO {
    
    private static Connection getConexion(){
        
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    private static Usuario crearUsuario (final ResultSet rs) throws SQLException {
        
        String rol = rs.getString("rol");
        
        Roles rol1 = Roles.valueOf(rol);
        
        return new Usuario(rs.getString("nombre"), rs.getString("contrasena"),rol1);

    } 
    
    
    public static void anadirProfe(Usuario u){
        
        String sql = "INSERT INTO usuarios VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = getConexion().prepareStatement(sql)){
                        
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getContrasena());
            stmt.setString(3, u.getRol().toString());
            int salida = stmt.executeUpdate();

            if(salida != 1){
                throw new Exception("No se ha insertado un solo registro de pacientes");
            }else if(salida == 1){
                System.out.println("Se ha añadido un profesor correctamente");
            }else{
                System.out.println("Se han añadido varios profesores");
            }
                
            
            
        } catch (SQLException e){
            System.out.println("SQL -> " + e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
  
    }
    
    public static boolean existeUsuario(String nombre) throws SQLException {
        
        String sql = "SELECT nombre FROM usuario WHERE nombre = ?";
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)) {
            ps.setString(1, nombre);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
                
            }
        }
    }
    
    public static boolean eliminarProfe(String nombre) throws SQLException {
        
        String sql = ("DELETE FROM usuarios WHERE nombre =?");
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            ps.setString(1, nombre);
            
            return ps.executeUpdate() > 0; 

        }

    }
    
    public static List<Usuario> verJugadores(){
        
        String sql = "SELECT id, nombre, contrasena, rol FROM usuarios";
        
        List<Usuario> lista = new ArrayList<>();
        
        try (PreparedStatement ps = getConexion().prepareStatement(sql)){
            
            try(ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    lista.add(crearUsuario(rs));

                }
                
            }
                       
        } catch (SQLException ex) {
            System.out.println("SQL ERROR -> " + ex.getMessage());
        }
        
        return lista;

    }
    
    private static Material crearMaterial (final ResultSet rs) throws SQLException {
        
        LocalDate fecha = rs.getDate("fecha_alta").toLocalDate();
        
        
        return new Material(rs.getString("nombre"), rs.getString("descripcion"), rs.getString("categoria"),rs.getString("subcategoria"), rs.getString("estado"), 
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
