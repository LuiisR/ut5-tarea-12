package pkgaeropuerto.modelo;

public class Regular extends Vuelo{

    int nPlazasLibres;

    public Regular(String destino, String modelo, int numPlazas, double precio, int nPlazasLibres) {
        super(destino, modelo, numPlazas, precio);
        this.nPlazasLibres = nPlazasLibres;
    }


    public int getnPlazasLibres() {
        return nPlazasLibres;
    }
    public double getPrecioRegular(){
        return (this.getPrecio() * 1.1) + (5 * getnPlazasLibres());
    }

    public void setnPlazasLibres(int nPlazasLibres) {
        this.nPlazasLibres = nPlazasLibres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nVuelo Regular");
        sb.append(super.toString());
        sb.append("Precio billete: ").append(getPrecioRegular()).append(" $");
        sb.append("\nPlazas libres: ").append(nPlazasLibres).append('\n');
        return sb.toString();
    }


}
