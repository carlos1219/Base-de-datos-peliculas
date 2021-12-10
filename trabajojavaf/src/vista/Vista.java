/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.coti.tools.Esdia;
import com.coti.tools.OpMat;
import com.coti.tools.Rutas;
import java.io.File;
import modelo.Director;
import modelo.Filmoteca;
import java.io.FileNotFoundException;
import controlador.Controlador;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vista {

    int dato1, dato2;
    int resultado;
    Controlador c = new Controlador();

    public void runMenu(String menu) throws Exception{
        boolean salir = false;
        String opcion;
        do {
            opcion = Esdia.readString(menu).toLowerCase();
            switch (opcion) {
                case "1" ->
                    this.archivos();

                case "2" ->
                    this.peliculas();

                case "3" ->
                    this.directores();

                case "4" ->
                    this.actores();

                case "5" ->
                    this.listados();

                case "q" ->
                    salir = this.salir();

                default ->
                    System.out.printf("%n Opcion Incorecta %n");

            }
        } while (!salir);
    }

    private void archivos() throws Exception{
        boolean salir = false;

        do {
            String o = Esdia.readString("%nElija una opcion%n"
                    + "1.-Exportar directores en formato de columna%n"
                    + "2.-Exportar peliculas en formato html%n"
                    + "q.-Salir");
            switch (o) {
                case "1" ->
                    c.exportarColumnas();

                case "2" ->
                    this.crearHTMLDePelicula();

                case "q" ->
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    
                default ->
                    System.out.printf("%n Opcion Incorecta %n");
            }
        } while (!salir);
    }

    private void peliculas() throws ParseException, FileNotFoundException {
        boolean salir = false;

        do {
            String o = Esdia.readString("%nOperaciones con peliculas%n"
                    + "*************************%n"
                    + "1.-Altas%n"
                    + "2.-Bajas%n"
                    + "3.-Modificaciones%n"
                    + "4.-Consulta%n"
                    + "q.-Salir");
            switch (o) {
                case "1" ->
                    this.añadirPelicula();

                case "2" ->
                    this.borrarPelicula();

                case "3" ->
                    this.modificarPelicula();

                case "4" ->
                    this.consultarPelicula();

                case "q" ->
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    
                default ->
                    System.out.printf("%n Opcion Incorecta %n");
            }
        } while (!salir);
    }

    private void directores() throws ParseException, FileNotFoundException {
        boolean salir = false;

        do {
            String o = Esdia.readString("%nOperaciones con director%n"
                    + "*************************%n"
                    + "1.-Altas%n"
                    + "2.-Bajas%n"
                    + "3.-Modificaciones%n"
                    + "q.-Salir");
            switch (o) {
                case "1" ->
                    this.altasDirector();

                case "2" ->
                    this.bajasDirector();

                case "3" ->
                    this.modificarDirector();

                case "q" ->
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    
                default ->
                    System.out.printf("%n Opcion Incorecta %n");
            }
        } while (!salir);
    }

    private void actores() throws ParseException,FileNotFoundException{
        boolean salir = false;

        do {
            String o = Esdia.readString("%nOperaciones con actor%n"
                    + "*************************%n"
                    + "1.-Altas%n"
                    + "2.-Bajas%n"
                    + "3.-Modificaciones%n"
                    + "4.-Peliculas de un actor%n"
                    + "q.-Salir");
            switch (o) {
                case "1" ->
                    this.altasActor();

                case "2" ->
                    this.bajasActor();

                case "3" ->
                    this.modificarActor();

                case "4" ->
                    this.consultarA();

                case "q" ->
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    
                 default ->
                    System.out.printf("%n Opcion Incorecta %n");   
            }
        } while (!salir);
    }

    private void listados() {
        boolean salir = false;

        do {
            String o = Esdia.readString("%nListados%n"
                    + "********%n"
                    + "1.-Enseñar Peliculas por orden alfabetico(Titulo)%n"
                    + "2.-Enseñar Directores por orden de nacionalidad y año%n"
                    + "3.-Enseñar Actores por orden de año debut y nombre%n"
                    + "q.-Salir");
            switch (o) {
                case "1" ->
                    this.peliculasTitulo();

                case "2" ->
                    this.directoresNacionalidad();

                case "3" ->
                   this.actoresanod();

                case "4" ->
                    this.actorEnseñar();

                case "q" ->
                    salir = Esdia.siOno("¿Estas seguro de querer salir? ");
                    
                default ->
                    System.out.printf("%n Opcion Incorecta %n");
            }
        } while (!salir);
    }

    public void comprobacion() throws Exception {
        String namef = "IMDB21";
        String pbin = "peliculas.bin";
        String dbin = "directores.bin";
        String abin = "actores.bin";

        String ruta = Rutas.fileToFileInFolderOnDesktop(namef, pbin).toString();
        File rutap = new File(ruta);
        String ptxt = "peliculas.txt";

        String ruta2 = Rutas.fileToFileInFolderOnDesktop(namef, dbin).toString();
        File rutad = new File(ruta2);
        String dtxt = "directores.txt";

        String ruta3 = Rutas.fileToFileInFolderOnDesktop(namef, abin).toString();
        File rutaa = new File(ruta3);
        String atxt = "actores.txt";

        if (rutap.exists()) {
            System.out.println("El fichero " + ruta + " existe");
            System.out.println("*****" + ruta);
            c.importarDatosBinP(pbin);
            if (c.getNumeroTotalP() != 0) {
                System.out.printf("Se han importado las peliculas");
            } else {
                System.err.printf("No fue posible leer el archivo");
            }
        } else {
            System.out.println("El fichero" + ruta + "no existe");
            System.out.println("Importando archivo peliculas.txt");
            c.importarDatosP(ptxt);
        }

        if (rutad.exists()) {
            System.out.println("El fichero " + ruta2 + " existe");
            System.out.println("*****" + ruta2);

            c.importarDatosBinD("directores.bin");
            if (c.getNumeroTotalD() != 0) {
                System.out.printf("Se han importado los directores");
            } else {
                System.err.printf("No fue posible leer el archivo");
            }
        } else {
            System.out.println("El fichero" + ruta2 + "no existe");
            System.out.println("Importando archivo directores.txt");
            c.importarDatosD(dtxt);
        }

        if (rutaa.exists()) {
            System.out.println("El fichero " + ruta3 + " existe");
            System.out.println("*****" + ruta3);
            c.importarDatosBinA(abin);
            if (c.getNumeroTotalA() != 0) {
                System.out.printf("Se han importado los actores");
            } else {
                System.err.printf("No fue posible leer el archivo");
            }
        } else {
            System.out.println("El fichero" + ruta3 + "no existe");
            System.out.println("Importando archivo actores.txt");
            c.importarDatosA(atxt);
        }
    }

    private void crearHTMLDePelicula() {
        c.crearHTMLDePeliculas();
        System.out.printf("%n Se ha creado %s", c.getNombreArchivoHTML());
    }

    private void imprimirPeliculas() throws Exception {
        System.out.printf("%nListado de peliculas%n");
        String archivo = "peliculas.txt";
        String[][] tmp = c.importarDatosP(archivo);
        if (tmp != null) {
            if (tmp.length != 0) {
                OpMat.printToScreen3(tmp);
                System.out.printf("%nImportadas correctamente");
            }
        } else {
            System.out.printf("Tabla de peliculas vacia");
        }
    }

    private void imprimirDirector() throws Exception {
        System.out.printf("%nListado de directores%n");
        String archivo = "directores.txt";
        String[][] tmp = c.importarDatosD(archivo);
        if (tmp != null) {
            if (tmp.length != 0) {
                OpMat.printToScreen3(tmp);
                System.out.printf("%nImportadas correctamente");
            }
        } else {
            System.err.printf("%nTabla de directores vacia");
        }
    }

    private void imprimirActores() throws Exception {
        System.out.printf("%nListado de actores%n");
        String archivo = "actores.txt";
        String[][] tmp = c.importarDatosA(archivo);
        if (tmp != null) {
            if (tmp.length != 0) {
                OpMat.printToScreen3(tmp);
                System.out.printf("%nImportadas correctamente");
            }
        } else {
            System.err.printf("%nTabla de actores vacia");
        }
    }

    private boolean salir() {
        System.out.printf("%nEscribiendo los archivos .bin");
        System.out.printf("%nactores.bin finalizado");
        c.pasarBinA();
        System.out.printf("%ndirectores.bin finalizado");
        c.pasarBinD();
        System.out.printf("%npeliculas.bin finalizado");
        c.pasarBinP();

        boolean salir = Esdia.siOno("¿Estas seguro de querer salir? ");
        return salir;
    }

    public void altasActor() {
        System.out.printf("%nVamos a añadir un nuevo actor a la lista para ello:");

        String nactor = Esdia.readString("Introduzca el nombre del actor");
        String fechan = Esdia.readString("Introduzca la fecha de nacimiento del actor(yyyy-mm-dd)");
        String nacionalidad = Esdia.readString("Introduzca la nacionalidad del actor");
        int anod = Esdia.readInt("Introduzca el año del debut del actor");
        String peliculas = Esdia.readString("Introduzca las peliculas realizadas por el actor");
        ArrayList<String> cpeliculas = new ArrayList<String>(Arrays.asList(peliculas.split(",")));

      c.añadirActor(nactor, fechan, nacionalidad, anod, cpeliculas);
    }
    public void bajasActor(){
        String nombre=Esdia.readString("%nIntroduzca el nombre del actor a elimimnar");
        if(c.bajasActor(nombre).isEmpty()){
            System.out.printf("%s eliminado perfectamente",nombre);
        }else{
            if(c.bajasActor(nombre).get(0).compareTo("1")==0){
                System.out.printf("No se ha podido eliminar el actor,por que no existe o tiene todavia peliculas en la base de datos :");
                for(int j=0;j<c.bajasActor(nombre).size();j++){
               System.out.printf("%s\t%n",c.bajasActor(nombre).get(j));
           }
        }
        }
    }

    public void actorEnseñar() {
        try {
            this.imprimirActores();
        } catch (Exception ex) {
            System.err.printf("Error al imprimir");
        }
    }

    public void peliculasEnseñar() {
        try {
            String ptxt = "peliculas.txt";
            c.importarDatosP(ptxt);
            this.imprimirPeliculas();
        } catch (Exception ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void directorEnseñar() {
        try {
            this.imprimirDirector();
        } catch (Exception ex) {
            System.err.printf("Error al imprimir");
        }
    }

    public List eliminarA() throws Exception {
        int a = Esdia.readInt("¿Que fila quieres eliminar?");
        return c.eliminarA(a);
    }
    
    public void peliculasTitulo(){
        c.ordenarTitulo();
        String temp=c.mostrarP();
        System.out.printf("%s%n", temp);
    }
    public void actoresanod(){
        c.ordenarAnod();
        String temp=c.mostrarA();
        System.out.printf("%s%n", temp);
    }
    public void directoresNacionalidad(){
        c.ordenarNacionalidad();
        String temp=c.mostrarD();
        System.out.printf("%s%n", temp);
    }
    public void modificarActor() throws ParseException, FileNotFoundException{
        String nombre;
        nombre=Esdia.readString("Introduzca el nombre del actor que quiere modificar");
        c.modificarActor(nombre);
         
    }
    public void consultarA() throws ParseException, FileNotFoundException{
        String nombre;
        nombre=Esdia.readString("Introduzca el nombre del actor que quiere consultar sus peliculas");
        System.out.printf("%nLas peliculas de su actor son%n");
       c.PeliActor(nombre);
            System.out.printf("Actor no encontrado");
    }
    public void altasDirector() {
        System.out.printf("%nVamos a añadir un nuevo director a la lista para ello:");

        String nombre = Esdia.readString("Introduzca el nombre del director");
        String fechan = Esdia.readString("Introduzca la fecha de nacimiento del director(yyyy-mm-dd)");
        String nacionalidad = Esdia.readString("Introduzca la nacionalidad del director");
        String ocupacion = Esdia.readString("Introduzca la ocupacion del director");
        String peliculas = Esdia.readString("Introduzca las peliculas realizadas por el director");
        ArrayList<String> cpeliculas = new ArrayList<String>(Arrays.asList(peliculas.split("/t")));
        
      c.añadirDirector(nombre, nacionalidad, ocupacion,fechan, cpeliculas);
    
    }
    public void bajasDirector(){
        String nombre=Esdia.readString("%nIntroduzca el nombre del director a elimimnar");
        if(c.bajasDirector(nombre).isEmpty()){
            System.out.printf("%s eliminado perfectamente",nombre);
        }else{
            if(c.bajasDirector(nombre).get(0).compareTo("7")==0){
                System.out.printf("No se ha podido eliminar el director,por que no existe o tiene todavia peliculas en la base de datos :");
                for(int j=0;j<c.bajasDirector(nombre).size();j++){
               System.out.printf("%s\t%n",c.bajasDirector(nombre).get(j));
           }
        }
        }
    }
    public void modificarDirector() throws ParseException, FileNotFoundException{
        String nombre;
        nombre=Esdia.readString("Introduzca el nombre del director que quiere modificar");
        c.modificarDirector(nombre);  
    }
    public void borrarPelicula(){
        String nombre=Esdia.readString("Escribe el nombre de la pelicula que quieres borrar");
        boolean r=c.borrarPelicula(nombre);
        if(r==false){
            System.out.println("La pelicula no existe");
        }else{
            System.out.println("La pelicula se ha borrado correctamente");
        }
    }
    public void añadirPelicula(){
        ArrayList<String> t_direccion = new ArrayList<>();
        ArrayList<String> t_reparto= new ArrayList<>();
        System.out.printf("Ingresa los datos de la nueva pelicula");
        String titulo=Esdia.readString("%nTitulo");
        int anio= Esdia.readInt("Año");
        int duracion=Esdia.readInt("Duracion");
        String pais=Esdia.readString("Introduce el pais");
        String guionista=Esdia.readString("Introduce el/la guionista");
        String musica=Esdia.readString("Introduce la musica");
        String productora=Esdia.readString("Introduce el nombre de la productora");
        String genero=Esdia.readString("Introduce el genero");
        String sinopsis=Esdia.readString("Introduce la sinopsis");
        int i=0;
        String[] directores=new String[15];
         String[] actor=new String[15];
        boolean salir=false;
        do{
        actor[i]=Esdia.readString("Introduce un actor");
        salir= Esdia.siOno("¿Quieres añadir otro actor? ");
        }while(salir);
        
        directores[0]=Esdia.readString("Introduce un director");
        
        t_direccion.addAll(Arrays.asList(directores));
         t_reparto.addAll(Arrays.asList(actor));
        
        boolean ret=c.añadirPelicula(titulo,pais,guionista,musica,productora,genero,sinopsis,anio,duracion,t_direccion,t_reparto);
        if (ret==true){
            System.out.printf("Pelicula añadida con exito.");
        }else System.out.printf("La pelicula no se ha podido añadir");
    }
    public void consultarPelicula(){
        String titulo=Esdia.readString("Introduce el titulo de la pelicula que quieres consultar");
        boolean tmp=c.consultarPelicula(titulo);
        if(tmp=false){
            System.out.println("no existe el titulo en la base de datos");
        }
    }
        public void modificarPelicula() throws ParseException, FileNotFoundException{
        String nombre;
        nombre=Esdia.readString("Introduzca titulo de la pelicula que quiere modificar");
        c.modificarPelicula(nombre);  
    }
    
}

