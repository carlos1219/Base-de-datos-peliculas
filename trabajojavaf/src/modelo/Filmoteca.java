/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import com.coti.tools.Esdia;
import com.coti.tools.OpMat;
import java.util.Locale;
import java.text.ParseException;
import com.coti.tools.Rutas;
import controlador.Controlador;
import java.io.BufferedInputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import java.util.Collections;
import java.util.Comparator;
import modelo.Actores;

/**
 *
 * @author uni
 */
public class Filmoteca implements Serializable{
   
    String namef="IMDB21";
     private final String nameOfHTMLFILE="películas.html";
    final String  RUTA_PB = Rutas.fileToFileInFolderOnDesktop( namef, "peliculas.bin").toString();
    final String  RUTA_PT = Rutas.fileToFileInFolderOnDesktop( namef, "peliculas.txt").toString();
    final String  RUTA_AB = Rutas.fileToFileInFolderOnDesktop( namef, "actores.bin").toString();
    final String  RUTA_AT = Rutas.fileToFileInFolderOnDesktop( namef, "actores.txt").toString();
    final String  RUTA_DB = Rutas.fileToFileInFolderOnDesktop( namef, "directores.bin").toString();
    final String  RUTA_DT = Rutas.fileToFileInFolderOnDesktop( namef, "directores.txt").toString();
    public final String fechand="21-06-1999";
    public final String nacionalidadd="España";
    public final String ocupaciond="actor-director";
    public final ArrayList<String> peliculasd=new ArrayList<>();
    public final int anodd=1996;
     
  public List <Actores> cactores=null;
  public List <Director> cdirector=null;
  public List <Pelicula> cpelicula=null;
  public Filmoteca(){
      this.cactores=new ArrayList<Actores>();
      this.cdirector=new ArrayList<Director>();
      this.cpelicula=new ArrayList<Pelicula>();

  }
  
    public int getNumPeliculasImp(){
       return cpelicula.size();
    }
     public int getNumDirectoresImp(){
       return cdirector.size();
    }
    public int getNumActoresImp(){
       return cactores.size();
    }
     
    public void pasarabinP(){
        File ruta_p=Rutas.fileToFileInFolderOnDesktop("IMDB21", "peliculas.bin");
        try{
            FileOutputStream fos=new FileOutputStream(ruta_p);
            ObjectOutputStream oss=new ObjectOutputStream(fos);
            oss.writeObject(cpelicula);
            oss.close();
            
        }catch(IOException ex){
           
    }}
        
     public void pasarbinD(){
        File ruta_p=Rutas.fileToFileInFolderOnDesktop("IMDB21", "directores.bin");
        try{
            FileOutputStream fos=new FileOutputStream(ruta_p);
            ObjectOutputStream oss=new ObjectOutputStream(fos);
            oss.writeObject(cdirector);
            oss.close();
            
        }catch(IOException ex){
          
    }}
    public void pasarabinA(){
        File ruta_p=Rutas.fileToFileInFolderOnDesktop("IMDB21", "actores.bin");
        try{
            FileOutputStream fos=new FileOutputStream(ruta_p);
            ObjectOutputStream oss=new ObjectOutputStream(fos);
            oss.writeObject(cactores);
            oss.close();
            
        }catch(IOException ex){
          
    }}
   
     
    public List eliminarA(int a){
         cactores.remove(a);
         return this.cactores;
    }

    public void crearHtmlDePeliculas(){
        File f= Rutas.fileToFileInFolderOnDesktop("IMDB21", "peliculas.html");
        try{
             
            PrintWriter pw=new PrintWriter(f);
            pw.printf("<!DOCTYPE html>%n"
                + "<HTML>%n"
                + "<HEAD>%n"
                + "<meta charset=\"UTF-8\">%n"
                + "Listado de Peliculas%n"
                + "</meta>%n"  
                + "</HEAD>%n"
                + "<BODY>%n"
                + "<H1>Listado de Peliculas</H1>%n");
            pw.printf("<TABLE BORDER=1>%n");
            for(Pelicula pel: this.cpelicula){
             pw.printf("%s%n",pel.asHTMLTableRow());
            }
            pw.printf("</TABLE>%n</Body>%n</HTML>%n");
            pw.close();
        }catch(FileNotFoundException ex){
        System.out.printf("ERROR:no se ha creado %s%n", f.toString());
        return;
        }
        System.out.printf("Se ha creado una tabla con  registros.%n");
        System.out.printf("La ruta del archivo es:%n"+f.toString());
    }
    public String getNameOfHTMLFile(){
        return this.nameOfHTMLFILE;
    }
    
      
    public String[][] importarDatosP(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.pathToFileInFolderOnDesktop(carpeta, archivo).toFile();
        
        if(!f.exists()){
            System.err.printf("%n%s No existe ",archivo);
            System.err.printf("%n copie peliculas.txt en la carpeta IMDB21");
        }
        String[][] temp;
        try{
            temp=OpMat.importFromDisk(f, "#");
        }catch(Exception ex){
            System.err.println("No fue posible importar el archivo"); return null;
        }
        for(String[] s : temp){
            Pelicula pel=Pelicula.factory(s);
            if(null != pel){
                this.cpelicula.add(pel);
            }
            }
            
           
            return temp;
        }
    public String[][] importarDatosA(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.pathToFileInFolderOnDesktop(carpeta, archivo).toFile();
        if(!f.exists()){
            System.err.printf("%n%s No existe ",archivo);
            System.err.printf("%n copie peliculas.txt en la carpeta IMDB21");
        }
        String[][] temp;
        try{
            temp=OpMat.importFromDisk(f, "#");
        }catch  (Exception ex){
            System.err.println("No fue posible importar el archivo"); return null;
        }
        List <Actores> result=new ArrayList<>();
        for(String[] s : temp){
            Actores act=Actores.factory(s);
            if(null != act){
                 result.add(act);
            }}
            this.cactores.addAll(result);
            return temp;
    }
    public String[][] importarDatosD(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.pathToFileInFolderOnDesktop(carpeta, archivo).toFile();
        if(!f.exists()){
            System.err.printf("%n%s No existe ",archivo);
            System.err.printf("%n copie peliculas.txt en la carpeta IMDB21");
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        }
        String[][] temp;
        try{
            temp=OpMat.importFromDisk(f, "#");
        }catch  (Exception ex){
            System.out.println("No fue posible importar el archivo");
            return null;
        }
        List <Director> result=new ArrayList<>();
        
        for(String[] s : temp){
            Director dic=Director.factory(s);
            if(null != dic){
               result.add(dic);
            }
        }
        this.cdirector.addAll(result);
          return temp;
    }
    public void importarDatosBinP(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.fileToFileInFolderOnDesktop(carpeta, archivo);
        try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(f));
            cpelicula=(ArrayList<Pelicula>) os.readObject();
            os.close();
        }catch(IOException | ClassNotFoundException ex ){
    }}
    public void importarDatosBinA(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.fileToFileInFolderOnDesktop(carpeta, archivo);
        try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(f));
            cactores=(ArrayList<Actores>) os.readObject();
            os.close();
        }catch(IOException | ClassNotFoundException ex ){
    }}   
    public void importarDatosBinD(String archivo){
        String carpeta="IMDB21";
        File f=Rutas.fileToFileInFolderOnDesktop(carpeta, "directores.bin");
        try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(f));
            cdirector=(ArrayList<Director>) os.readObject();
            os.close();
        }catch(IOException | ClassNotFoundException ex ){
    }}   
    public String[][] tablaPeliculas(){
         
        int numeroPeliculas=this.cpelicula.size();
        String[][] tdm=new String[numeroPeliculas][];
        int n;
        for(n=0;n<numeroPeliculas;n++) {
            tdm[n]=cpelicula.get(n).state();
        }
        return tdm;
    }
    public String[][] tablaActores(){
         
        int numeroActores=this.cactores.size();
        String[][] tdm=new String[numeroActores][];
        int n;
        for(n=0;n<numeroActores;n++) {
            tdm[n]=cactores.get(n).state();
        }
        return tdm;
    }
    public String[][] tablaDirectores(){
         
        int numeroDirectores=this.cdirector.size();
        String[][] tdm=new String[numeroDirectores][];
        int n;
        for(n=0;n<numeroDirectores;n++) {
            tdm[n] = cdirector.get(n).state();
        }
        return tdm;
    }
    public  void exportarColumnas() throws IOException{
         
        File excol=Rutas.fileToFileInFolderOnDesktop("IMDB21", "director.col");
        FileWriter f = null;
        PrintWriter pw = null;
        if(null==cdirector){
            System.err.printf("Lista diector vacia");
        }
        try{
        f = new FileWriter(excol);
        pw = new PrintWriter(f);
        
        for (Director p:cdirector){
           pw.printf("|%20s|%25s|%20s|%50s|%40s|%n",p.getNombre(),p.getNacionalidad(),p.getOcupacion(),p.getFechan(),p.getPeliculas());
        }
        }catch(IOException e){
               System.err.printf("ERROR de escritura.%n");
        }
         f.close();
    }
    public void ordenarTitulo(){
       Comparator peliculan=Comparator.comparing(Pelicula::getTitulo);
       cpelicula.sort(peliculan);
    
    }
    public void ordenarNacionalidad(){
 Comparator dirnacionalidad =Comparator.comparing(Director::getNacionalidad).thenComparing(Director::getFechan);
        cdirector.sort(dirnacionalidad);
    }
    public String mostrarD(){
        StringBuilder cons=new StringBuilder();
        for(Director dic:cdirector){
            cons.append(dic.tablaO()).append("\n");
        }
        return cons.toString();
    }
    public String mostrarP(){
        StringBuilder cons=new StringBuilder();
        for(Pelicula Pel:cpelicula){
            cons.append(Pel.tablaO()).append("\n");
        }
        return cons.toString();
    }
    public void ordenarAnod(){
        Comparator actorano =Comparator.comparing(Actores::getAnod).thenComparing(Actores::getNombre);
        cactores.sort(actorano);
    }
    public String mostrarA(){
        StringBuilder cons=new StringBuilder();
        for(Actores act:cactores){
            cons.append(act.tablaO()).append("\n");
        }
        return cons.toString();
    }
    public boolean añadirActor(String nombre,String fechan,String nacionalidad,int anod,ArrayList<String> peliculas){
        boolean ret=true;
        Actores act;
        act=new Actores(nombre,fechan,nacionalidad,anod,peliculas);
        cactores.add(act);
        return ret;
    }
    public ArrayList<String> bajasActor(String nombre){
        ArrayList<String> r=new ArrayList<>();
        r.add("1");
  
        for (int i=0;i<cactores.size();i++){
            if(cactores.get(i).getNombre().compareToIgnoreCase(nombre)==0){
                r.clear();
                System.out.println(cactores.get(i).getNombre());
                for(int j=0;j<cpelicula.size();j++){
                    for(int z=0; z<cactores.get(i).getPeliculas().size();z++){
                        if(cpelicula.get(j).getTitulo().compareTo(cactores.get(i).getPeliculas().get(z))==0){
                            
                            r.add(cpelicula.get(j).getTitulo());
        }}}}}
        if(r.isEmpty());
        for(int i=0;i<cactores.size();i++){
                if(cactores.get(i).getNombre().compareToIgnoreCase(nombre)==0){
                    cactores.remove(i);
        }}
        return r; 
    }
    public void modificarActor(String nombre){
        boolean salir = false;
        int i=0;
         String fechan;
         String nacionalidad;
         int anod;
         Boolean encontrado = false;
        for(Actores a : cactores){
            if(nombre.equals(cactores.get(i).getNombre())){
        do {
            String o = Esdia.readString("Seleccione el campo que quiere cambiar%n"
                    + "**************************************%n"
                    + "1.-Modificar fecha de nacimiento%n"
                    + "2.-Modificar nacionalidad%n"
                    + "3.-Modificar año de debut%n"
                    + "q.-Salir");
            switch (o) {
                case "1" :
                    fechan=Esdia.readString("Introduce una nueva fecha");   
                    cactores.get(i).setFechan(fechan);
                    break;
                case "2":
                    nacionalidad=Esdia.readString("Introduce una nueva nacionalidad");
                    cactores.get(i).setNacionalidad(nacionalidad);
                    break;
                case "3":
                    anod=Esdia.readInt("Introduce un nuevo año de debut");
                    cactores.get(i).setAnod(anod);
                    break;
                case "q" :
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    break;
                default :
                    System.out.printf("%n Opcion Incorecta %n");
                    break;
                }
            } while (!salir);
        encontrado=true;
            }
            i++;
        }
        if(encontrado == false){
            System.err.printf("ERROR al buscar actor.%n");
                    
        }
    }


    public boolean añadirDirector(String nombre,String nacionalidad,String ocupacion,String fechan,ArrayList<String> peliculas){
        boolean ret=true;
        Director dic;
        dic=new Director(nombre,ocupacion,fechan,nacionalidad,peliculas);
        cdirector.add(dic);
        return ret;
    }
    public ArrayList<String> bajasDirector(String nombre){
        ArrayList<String> r=new ArrayList<>();
        r.add("7");
  
        for (int i=0;i<cdirector.size();i++){
            if(cdirector.get(i).getNombre().compareToIgnoreCase(nombre)==0){
                r.clear();
                System.out.printf(cdirector.get(i).getNombre());
                for(int j=0;j<cpelicula.size();j++){
                    for(int z=0; z<cdirector.get(i).getPeliculas().size();z++){
                        if(cpelicula.get(j).getTitulo().compareTo(cdirector.get(i).getPeliculas().get(z))==0){
                            
                            r.add(cpelicula.get(j).getTitulo());
        }}}}}
        if(r.isEmpty());
        for(int i=0;i<cdirector.size();i++){
                if(cdirector.get(i).getNombre().compareToIgnoreCase(nombre)==0){
                    cdirector.remove(i);
        }}
        return r; 
    }
    public void modificarDirector(String nombre){
        boolean salir = false;
        int i=0;
         String fechan,nacionalidad,ocupacion;
         Boolean encontrado = false;
        for(Director dic : cdirector){
            if(nombre.equals(cdirector.get(i).getNombre())){
        do {
            String o = Esdia.readString("Seleccione el campo que quiere cambiar%n"
                    + "**************************************%n" 
                    + "1.-Modificar nacionalidad%n"
                    + "2.-Modificar ocupaciont%n"
                    + "3.-Modificar fecha de nacimiento%n"
                    + "q.-Salir");
            switch (o) {
                    case "1":
                    nacionalidad=Esdia.readString("Introduce una nueva nacionalidad");
                    cdirector.get(i).setNacionalidad(nacionalidad);
                    break;
                case "2":
                    ocupacion=Esdia.readString("Introduce un nuevo año de debut");
                    cdirector.get(i).setOcupacion(ocupacion);
                    break;
                    case "3" :
                    fechan=Esdia.readString("Introduce una nueva fecha");   
                    cdirector.get(i).setFechan(fechan);
                    break;
                case "q" :
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    break;
                default :
                    System.out.printf("%n Opcion Incorecta %n");
                    break;
                }
            } while (!salir);
        encontrado=true;
            }
            i++;
        }
        if(encontrado == false){
            System.err.printf("ERROR al buscar director.%n");
                    
        }
    }
    public boolean borrarpelicula(String titulo){
        boolean dev=false;
        for(int i=0;i<cpelicula.size(); i++){
            if(cpelicula.get(i).getTitulo().compareToIgnoreCase(titulo)==0){
                cpelicula.remove(i);
                dev=true;
            }
        }
         for(int i=0;i<cdirector.size(); i++){
              for(int j=0;j<cdirector.get(i).getPeliculas().size(); j++){
                  if(cdirector.get(i).getPeliculas().get(j).compareToIgnoreCase(titulo)==0){
                   cdirector.get(i).getPeliculas().remove(j);
                    if(cdirector.get(i).getPeliculas().isEmpty()){
                        cdirector.remove(i);
                    }
                }
              }
         }
        
        return dev;
    }
    public boolean añadirPelicula(String titulo, String pais, String guionista, String musica, String productora, String genero, String sinopsis, int ano, int duracion, ArrayList<String> direccion, ArrayList<String> reparto){
        boolean ex=false;
        boolean dev=true;
        String actor="h";
        String director="h";
        Pelicula pel=new Pelicula(titulo,pais,guionista,musica,productora,genero,sinopsis,ano,duracion,direccion,reparto);        
        cpelicula.add(pel);
            return dev;

}
    
    public boolean consultaPelicula(String nombre){

        boolean existe=false;
        for(int i=0;i<cpelicula.size(); i++){
            if(cpelicula.get(i).getTitulo().compareToIgnoreCase(nombre)==0){
                System.out.printf("Titulo:%s%n ",cpelicula.get(i).getTitulo());
                System.out.printf("Año: %d%n",cpelicula.get(i).getAno());
                System.out.printf("Duracion: %d%n",cpelicula.get(i).getDuracion());
                System.out.printf("Pais: %s%n",cpelicula.get(i).getPais());
                System.out.printf("Direccion: %s%n",cpelicula.get(i).getDireccion());
                System.out.printf("Guion: %s%n",cpelicula.get(i).getGuionista());
                System.out.printf("Musica: %s%n",cpelicula.get(i).getMusica());
                System.out.printf("Reparto: %s%n",cpelicula.get(i).getReparto());
                System.out.printf("Productora: %s%n",cpelicula.get(i).getProdutora());
                System.out.printf("Genero: %s%n",cpelicula.get(i).getGenero());
                System.out.printf("Sinopsis: %s%n",cpelicula.get(i).getSinopsis());
            existe=true;
            };
        } 
        return existe;  
    }
    public void modificarPelicula(String nombre){
        boolean salir = false;
       
         String guionista,musica,productora,genero,sinopsis;
         int ano,duracion;
         Boolean encontrado = false;
        for(int i=0;i<cpelicula.size(); i++){
            if(cpelicula.get(i).getTitulo().compareToIgnoreCase(nombre)==0){
        do {
            String o = Esdia.readString("Seleccione el campo que quiere cambiar%n"
                    + "**************************************%n" 
                    + "1.-Modificar año%n"
                    + "2.-Modificar duraciont%n"
                    + "3.-Modificar guionista%n"
                    + "4.-Modificar musica%n"
                    + "5.-Modificar productora%n"
                    + "6.-Modificar genero%n"
                    + "7.-Modificar sinopsis%n"
                    + "q.-Salir");
            switch (o) {
                    case "1" -> {
                        ano=Esdia.readInt("Introduce un nuevo año");
                        cpelicula.get(i).setAno(ano);
                }
                case "2" -> {
                    duracion=Esdia.readInt("Introduce una nueva duracion");
                    cpelicula.get(i).setDuracion(duracion);
                }
                    case "3" -> {
                        guionista=Esdia.readString("Introduce un nuevo guionista");
                        cpelicula.get(i).setGuionista(guionista);
                }
                    case "4" -> {
                        musica=Esdia.readString("Introduce un/una nuev@ music@");
                        cpelicula.get(i).setMusica(musica);
                }
                    case "5" -> {
                        productora=Esdia.readString("Introduce una nueva productora");
                        cpelicula.get(i).setProductora(productora);
                }
                    case "6" -> {
                        genero=Esdia.readString("Introduce un nuevo genero");
                        cpelicula.get(i).setGenero(genero);
                }
                    case "7" -> {
                        sinopsis=Esdia.readString("Introduce una nueva sinopsis");
                        cpelicula.get(i).setSinopsis(sinopsis);
                }
                case "q" -> salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                default -> System.out.printf("%n Opcion Incorecta %n");
                }
            } while (!salir);
        encontrado=true;
            }
        }
        if(encontrado == false){
            System.err.printf("ERROR al buscar pelicula.%n");
                    
        }
    }
    public ArrayList<String> PelisActor(String nombre){
        ArrayList<Pelicula> ordenarp=new ArrayList<>();
        ArrayList<String> apelicula=new ArrayList<>();
        apelicula.add("7");
        for(int i=0;i<cactores.size();i++){
            if(cactores.get(i).getNombre().compareToIgnoreCase(nombre)==0){
               apelicula.clear();
               for(String st:cactores.get(i).getPeliculas()){
                   for(Pelicula pel:cpelicula){
                       if(st.compareToIgnoreCase((pel.getTitulo()))==0){
                           ordenarp.add(pel);
        }}}}}
        ordenarp.sort(Comparator.comparing(Pelicula::getAno));
        for(Pelicula pe:ordenarp){
            System.out.printf("%s|%d|%d|%s|%s|%n",pe.getTitulo(),pe.getAno(),pe.getDuracion(),pe.getPais(),pe.getGenero());;
        }
        return apelicula;
    }

    

}

