/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarium;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DAW109
 */
public class Material {
    
    
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String subcategoria;
    private String estado;
    private int cantidad;
    private int id_ubicacion;
    private LocalDate fecha_alta;
    private String observaciones;

    public Material(String nombre, String descripcion, String categoria, String subcategoria, String estado, int cantidad, int id_ubicacion, LocalDate fecha_alta, String observaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.estado = estado;
        this.cantidad = cantidad;
        this.id_ubicacion = id_ubicacion;
        this.fecha_alta = fecha_alta;
        this.observaciones = observaciones;
    }


    public int getId() {return id;}

    public String getNombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

    public String getCategoria() {return categoria;}

    public String getSubcategoria() {return subcategoria;}
    
    public String getEstado() {return estado;}

    public int getCantidad() {return cantidad;}

    public int getId_ubicacion() {return id_ubicacion;}

    public LocalDate getFecha_alta() {return fecha_alta;}

    public String getObservaciones() {return observaciones;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Material -> ");
        sb.append("Id: ").append(id);
        sb.append(", Nombre: ").append(nombre);
        sb.append(", Descripcion: ").append(descripcion);
        sb.append(", Categoria: ").append(categoria);
        sb.append(", Subcategoria: ").append(subcategoria);
        sb.append(", Estado: ").append(estado);
        sb.append(", Cantidad: ").append(cantidad);
        sb.append(", Id ubicacion: ").append(id_ubicacion);
        sb.append(", Fecha alta: ").append(fecha_alta);
        sb.append(", Observaciones: ").append(observaciones);
        return sb.toString();
    }
    
    
    
    
    
}
