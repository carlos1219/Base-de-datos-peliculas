/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajojavaf;

import com.coti.tools.Esdia;
import vista.Vista;

/**
 *
 * @author uni
 */
public class Trabajojavaf {

    public static void main(String[] args) throws Exception {
        Vista v = new Vista();
        v.comprobacion();

        Esdia.underline2("TRABAJO FINAL DE PROGRA");
        v.runMenu("%n1.-Archivos:%n"
                + "2.-Películas%n"
                + "3.-Directores%n"
                + "4.-Actores%n"
                + "5.-Listados%n"    
                + "q.-salir");
    }
}
