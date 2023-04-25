package pkgaeropuerto.modelo;

import java.util.Comparator;
import java.util.Objects;

public abstract class Vuelo implements Comparable<Vuelo>{
    private String destino;
    private String modelo;
    private int numPlazas;

    public Vuelo(String destino, String modelo, int numPlazas) {
        this.destino = destino;
        this.modelo = modelo;
        this.numPlazas = numPlazas;
    }


    public String getDestino() {
        return destino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return numPlazas == vuelo.numPlazas && Objects.equals(destino, vuelo.destino) && Objects.equals(modelo, vuelo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destino, modelo, numPlazas);
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========\n");
        sb.append("\n------------\n");
        sb.append("\nDestino: ").append(getDestino());
        sb.append("\nAvion: ").append(getModelo());
        sb.append("\nPlazas: ").append(getNumPlazas()).append("\n");
        return sb.toString();
    }

}