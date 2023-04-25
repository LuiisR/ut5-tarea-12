package pkgaeropuerto.modelo;

import java.util.Comparator;

public class ComparadorPorPlazas implements Comparator<Regular> {


    @Override
    public int compare(Regular o1, Regular o2) {
        return o2.nPlazasLibres - o1.nPlazasLibres;
    }
}
