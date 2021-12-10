/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.coti.tools.Rutas;
import java.text.NumberFormat;
import java.util.Locale;
import java.io.File;
import java.nio.file.Files;
import java.nio.charset.Charset;
import modelo.Filmoteca;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Arrays;
import java.io.Serializable;

/**
 *
 * @author uni
 */
public class Director implements Serializable {

    Filmoteca m = new Filmoteca();
    final int MAX = 90;
    String nombre, nacionalidad, ocupacion, fechan;
    ArrayList<String> peliculas = new ArrayList<>();

    public Director(String nombre, String nacionalidad, String ocupacion, String fechan, ArrayList<String> peliculas) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.fechan = fechan;
        this.peliculas = peliculas;
    }

    public static Director factory(String[] tokens) {
        if (5 != tokens.length) {
            return null;
        }
        String t_nombre, t_nacionalidad, t_ocupacion, t_fechan;
        ArrayList<String> t_peliculas = new ArrayList<>();

        t_nombre = tokens[0];
        t_nacionalidad = tokens[1];
        t_ocupacion = tokens[2];
        t_fechan = tokens[3];

        String[] peliculas = tokens[4].split("\t");
        t_peliculas.addAll(Arrays.asList(peliculas));
        return new Director(t_nombre, t_nacionalidad, t_ocupacion, t_fechan, t_peliculas);
    }

     
    public String[] state() {

        String t_peliculas = String.join("/t", this.peliculas);
        String[] rd = {this.nombre, this.nacionalidad, this.ocupacion, this.fechan, t_peliculas};
        return rd;
    }
    public String getNombre(){
        return nombre;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }
    public String getOcupacion(){
        return ocupacion;
    }
    public String getFechan(){
        return fechan;
    }
    public ArrayList<String> getPeliculas(){
        return peliculas;
    }
    public String tablaO() {
        return String.format("| %25s | %12s | %15s | %20s |", this.nombre, this.fechan, this.nacionalidad, this.ocupacion);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechan(String fechan) {
        this.fechan = fechan;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setPeliculas(ArrayList<String> peliculas) {
        this.peliculas = peliculas;
    }
  
                    
}
