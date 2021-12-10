/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.io.File;
import java.io.PrintWriter;
import modelo.Filmoteca;
import java.io.FileNotFoundException;
import com.coti.tools.Rutas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author uni
 */
public class Pelicula implements Serializable {

    Filmoteca m = new Filmoteca();
    final int MAX = 90;
    private String titulo, pais, guionista, musica, productora, genero, sinopsis;
    private int ano, duracion;
    private ArrayList<String> direccion = new ArrayList<>();
    private ArrayList<String> reparto = new ArrayList<>();

    public Pelicula(String titulo, String pais, String guionista, String musica, String productora, String genero, String sinopsis, int ano, int duracion, ArrayList<String> direccion, ArrayList<String> reparto) {
        this.titulo = titulo;
        this.pais = pais;
        this.guionista = guionista;
        this.musica = musica;
        this.productora = productora;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.ano = ano;
        this.duracion = duracion;
        this.direccion = direccion;
        this.reparto = reparto;

    }

    public String[] state() {
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        String tmp_ano = nf.format(this.ano);
        String tmp_duracion = nf.format(this.duracion);
        String t_direccion = String.join("/t", this.direccion);
        String t_reparto = String.join("/t", this.reparto);
        String[] rd = {this.titulo,
            this.pais,
            this.guionista,
            this.musica,
            this.productora,
            this.genero,
            this.sinopsis,
            tmp_ano,
            tmp_duracion,
            t_direccion,
            t_reparto};
        return rd;
    }

    public static Pelicula factory(String[] tokens) {
        if (11 != tokens.length) {
            return null;
        }
        String t_titulo, t_pais, t_guionista, t_musica, t_productora, t_genero, t_sinopsis;
        int t_ano, t_duracion;
        ArrayList<String> t_direccion = new ArrayList<>();
        ArrayList<String> t_reparto = new ArrayList<>();
        for (String t : tokens) {
            if (t.equals("")) {
                t = "X";
            }
        }
        t_titulo = tokens[0];
        t_pais = (tokens[3]);
        t_guionista = (tokens[5]);
        t_musica = (tokens[6]);
        t_productora = (tokens[8]);
        t_genero = (tokens[9]);
        t_sinopsis = (tokens[10]);
        try {
            t_ano = Integer.parseInt(tokens[1]);
        } catch (Exception ex) {
            t_ano = 1;
        }
        try {
            t_duracion = Integer.parseInt(tokens[2]);
        } catch (Exception ex) {
            t_duracion = 1;
        }
        if (t_ano <= 0 || t_duracion <= 0) {
            return null;
        }
        String[] directores = tokens[4].split("\t");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        String[] actores = tokens[7].split("\t");
        t_direccion.addAll(Arrays.asList(directores));
        t_reparto.addAll(Arrays.asList(actores));
        return new Pelicula(t_titulo, t_pais, t_guionista, t_musica, t_productora, t_genero, t_sinopsis, t_ano, t_duracion, t_direccion, t_reparto);
    }

    public String asHTMLTableRow() {
        String resultado;
        resultado = String.format("<TR>"
                + "<TD>%s</TD>"
                + "<TD>%d</TD>"
                + "<TD>%d</TD>"
                + "<TD>%s</TD>"
                +"<TD>%s</TD>"
                +"<TD>%s</TD>"
                + "<TD>%s</TD>"
                + "<TD>%s</TD>"
                + "<TD>%s</TD>"
                + "<TD>%s</TD>"
                + "<TD>%s</TD"
                + "</TR>",
                this.titulo,
                this.ano,
                this.duracion,
                this.pais,
                this.direccion,
                this.reparto,
                this.guionista,
                this.musica,
                this.productora,
                this.genero,
                this.sinopsis
        );
        return resultado;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAno() {
        return this.ano;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public String getPais() {
        return this.pais;
    }

    public ArrayList getDireccion() {
        return this.direccion;
    }

    public ArrayList getReparto() {
        return this.reparto;
    }

    public String getGuionista() {
        return this.guionista;
    }

    public String getMusica() {
        return this.musica;
    }

    public String getProdutora() {
        return this.productora;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getSinopsis() {
        return this.sinopsis;
    }
    public String tablaO(){
        String tabla=String.format("| %35s | %4d | %5d | %20s | %15s |", this.titulo, this.ano, this.duracion, this.pais, this.genero);
        return tabla;
    }
     public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDireccion(ArrayList<String> Direccion) {
        this.direccion = Direccion;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public void setReparto(ArrayList<String> reparto) {
        this.reparto = reparto;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
