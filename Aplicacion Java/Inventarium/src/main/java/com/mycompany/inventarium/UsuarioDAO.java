/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    
    
    
    
    
    
    
    
    
}
