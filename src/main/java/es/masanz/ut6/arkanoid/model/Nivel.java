package es.masanz.ut6.arkanoid.model;

import java.util.ArrayList;
import java.util.List;

import static es.masanz.ut6.arkanoid.conf.Const.TAM_CASILLA;

public class Nivel {

    int id;
    int filas, columnas;
    List<Ladrillo> ladrillos;
    int siguienteNivel;

    public Nivel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public List<Ladrillo> getLadrillos() {
        return ladrillos;
    }

    public void setLadrillos(List<Ladrillo> ladrillos) {
        this.ladrillos = ladrillos;
    }

    public int getSiguienteNivel() {
        return siguienteNivel;
    }

    public void setSiguienteNivel(int siguienteNivel) {
        this.siguienteNivel = siguienteNivel;
    }

    public void generarLadrillosDesdeTexto(String ladrillosStr) {
        // TODO 03: En funcion del String recibido, cargar los ladrillos del nivel
        ladrillos = new ArrayList<>();
        for (int i = 0; i < ladrillosStr.length(); i++) {
            int vidas = Integer.parseInt(String.valueOf(ladrillosStr.charAt(i)));
            if(vidas > 0){
                int fila = i / columnas;
                int columna = i % columnas;
                Ladrillo ladrillo = new Ladrillo(columna, fila);
                ladrillo.setVidas(vidas);
                ladrillos.add(ladrillo);
            }
        }
    }

    public String generarTextoDesdeLadrillos(){
        // TODO 04: En funcion de los ladrillos del nivel, generar el String que los represente
        StringBuilder sb = new StringBuilder();
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int vidas = 0;
                for (Ladrillo ladrillo : ladrillos) {
                    if(ladrillo.getX()/TAM_CASILLA == col && ladrillo.getY()/TAM_CASILLA == fila){
                        vidas = ladrillo.getVidas();
                        break;
                    }
                }
                sb.append(vidas);
            }
        }
        return sb.toString();
    }
}
