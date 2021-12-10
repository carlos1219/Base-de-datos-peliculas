/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author uni
 */
public class Actores implements Serializable{
    final int MAX=90;
    String nombre,fechan,nacionalidad;
    int anod;
    ArrayList<String> peliculas=new ArrayList<>();
    
    
public Actores(String nombre,String fechan, String nacionalidad,int anod, ArrayList<String> peliculas){
    this.nombre=nombre;
    this.fechan=fechan;
    this.nacionalidad=nacionalidad;
    this.anod=anod;
    this.peliculas=peliculas;
                
}
    
  
public static Actores factory(String[] tokens){
    if(5!=tokens.length){
        return null;
    }
    String t_nombre,t_fechan,t_nacionalidad;
    int t_anod;
    ArrayList<String> t_peliculas=new ArrayList<>();
    t_nombre=tokens[0];
    t_fechan= tokens[1];
    t_nacionalidad=tokens[2];
    try{
        t_anod=Integer.parseInt(tokens[3]);
    }catch(Exception ex){
        t_anod=1;
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    String[] peliculas=tokens[4].split("\t");
    t_peliculas.addAll(Arrays.asList(peliculas));      
    return new Actores(t_nombre,t_fechan,t_nacionalidad,t_anod,t_peliculas);
     } 
    public String[] state(){
        Locale spanish=new Locale("es", "ES");
        NumberFormat nf=NumberFormat.getInstance(spanish);
        String tmp_anod=nf.format(this.anod);
        String t_peliculas=String.join("/t",this.peliculas);
        String[] rd={this.nombre,this.fechan,this.nacionalidad,tmp_anod,t_peliculas};
        return rd;
    }
         
    public String getNombre(){
        return this.nombre;
    } 
    public String getFechan(){
        return this.fechan;
    }
    public String getNacionalidad(){
        return this.nacionalidad;
    }
    public int getAnod(){
        return this.anod;
    }
    public ArrayList<String> getPeliculas(){
        return this.peliculas;
    }
     public String tablaO(){
        String tabla=String.format("| %35s | %10s | %20s | %5d|", this.nombre, this.fechan, this.nacionalidad, this.anod);
        return tabla;
    }  
     
      public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechan(String nac) {
        this.fechan = nac;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setAnod(int anod) {
        this.anod = anod;
    }

    public void setPeliculasA(ArrayList<String> listadoPeliActor) {
        this.peliculas = listadoPeliActor;
    }
    
      
}
