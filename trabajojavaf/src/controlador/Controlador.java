 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import modelo.Pelicula;
import modelo.Actores;
import modelo.Director;
import modelo.Filmoteca;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import com.coti.tools.OpMat;
import com.coti.tools.Rutas;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import vista.Vista;
import java.nio.file.Path;
import java.text.ParseException;



public class Controlador {
    Filmoteca m=new Filmoteca();
    final int MAX=90;
    public int getNumeroTotalP(){
        return  m.getNumPeliculasImp();
    }
    public int getNumeroTotalA(){
        return  m.getNumActoresImp();
    }
    public int getNumeroTotalD(){
        return  m.getNumDirectoresImp();
    }
    public List getcactores(){
        return m.cactores;
    }
    public List getcpelicula(){
        return m.cpelicula;
    }
    public List getcdirector(){
        return m.cdirector;
    }
    public String[][] importarDatosD(String archivo){
        return m.importarDatosD(archivo);
    }
    public String[][] importarDatosA(String archivo){ 
        return m.importarDatosA(archivo);
    }
    public String[][] importarDatosP(String archivo){
        return  m.importarDatosP(archivo);
    }      
    public void importarDatosBinP(String archivo){
          m.importarDatosBinP(archivo);
    }
     public void importarDatosBinA(String archivo){
        m.importarDatosBinA(archivo);
    }
    public void importarDatosBinD(String archivo){
        m.importarDatosBinD(archivo);
    }
    public  void crearHTMLDePeliculas(){
        m.crearHtmlDePeliculas();
    }
    public String getNombreArchivoHTML(){
        return m.getNameOfHTMLFile();
    }
    public void exportarColumnas()throws Exception{
        m.exportarColumnas();
    }
      
    public void pasarBinP(){
         m.pasarabinP();
    }
    public void pasarBinD(){
         m.pasarbinD();
    }
    public void pasarBinA(){
         m.pasarabinA();
    }   
    public List eliminarA(int a){
        return m.eliminarA(a);
    }
    public String[][] tablaP(){
        return m.tablaPeliculas();
    }
    public String[][] tablaA(){
        return m.tablaActores();
    }
    public String[][] tablaD(){
        return m.tablaDirectores();
    }
    public void ordenarTitulo(){
       m.ordenarTitulo();
    }
    public String mostrarP(){
        return m.mostrarP();
    }
    public void ordenarAnod(){
        m.ordenarAnod();
    }
    public String mostrarA(){
        return m.mostrarA();
    }
    public void ordenarNacionalidad(){
       m.ordenarNacionalidad();
    }
    public String mostrarD(){
        return m.mostrarD();
    }
    public boolean añadirActor(String Nombre,String fechan,String nacionalidad,int anod,ArrayList<String> peliculas){
       return m.añadirActor(Nombre,fechan,nacionalidad,anod,peliculas);
    }
    public ArrayList<String> bajasActor(String nombre){
        return m.bajasActor(nombre);
    }
    public void modificarActor(String nombre){
        m.modificarActor(nombre);
       
    }   
    public void añadirDirector(String Nombre,String nacionalidad,String ocupacion,String fechan,ArrayList<String> peliculas){
        m.añadirDirector(Nombre,nacionalidad,ocupacion,fechan,peliculas);
    }
    public ArrayList<String> bajasDirector(String nombre){
        return m.bajasDirector(nombre);
    }
    public void modificarDirector(String nombre){
         m.modificarDirector(nombre);
    }
    public boolean borrarPelicula(String titulo){
        return m.borrarpelicula(titulo);
    }
    public boolean añadirPelicula(String titulo, String pais, String guionista, String musica, String productora, String genero, String sinopsis, int ano, int duracion, ArrayList<String> direccion, ArrayList<String> reparto){
        return m.añadirPelicula(titulo, pais, guionista, musica, productora, genero, sinopsis, ano, duracion, direccion, reparto);
    }
    public boolean consultarPelicula(String nombre){
        return m.consultaPelicula(nombre);
    }
    public void modificarPelicula(String titulo){
        m.modificarPelicula(titulo);
    }
    public ArrayList<String> PeliActor(String titulo){
        return m.PelisActor(titulo);
    }
}