/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarium;

/**
 *
 * @author daw114
 */
public class Validador {
    public boolean leerNombre(String nombre){
        String regex = ("^[a-zA-Z0-9_.-]{3,20}$");
        if(nombre.matches(regex)){
            return true;
        }
        return false;
    }
    
    public boolean leerContraseña(String contrasena){
        String regex = ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$");
        
        if (contrasena.matches(regex)){
            return true;
        }
        return false;
    }
    
    public boolean leerMaterial(String material){
        String regex = ("^.{3,}$");
        
        if (material.matches(regex)){
            return true;
        }
        return false;
    }
    
    public boolean leerDescripcion(String descripcion){
        String regex = ("^[\\s\\S]{3,500}$");
        
        if (descripcion.mateches(regex)){
            
        }
    }
}
