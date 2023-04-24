import java.util.Comparator;

public class ComparadorPlazas implements Comparator<Vuelo> {


    @Override
    public int compare(Vuelo o1, Vuelo o2) {
        Regular r1 = (Regular) o1;
        Regular r2 = (Regular) o2;
        return r1.getnPlazasLibres() - r2.getnPlazasLibres();
    }
}
