package pkgaeropuerto.modelo;

public class Regular extends Vuelo{

    int nPlazasLibres;

    public Regular(String destino, String modelo, int numPlazas, int nPlazasLibres) {
        super(destino, modelo, numPlazas);
        this.nPlazasLibres = nPlazasLibres;
    }


    public int getnPlazasLibres() {
        return nPlazasLibres;
    }

    public void setnPlazasLibres(int nPlazasLibres) {
        this.nPlazasLibres = nPlazasLibres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vuelo Regular\n");
        sb.append(super.toString());
        sb.append("Plazas libres: ").append(nPlazasLibres).append('\n');
        return sb.toString();
    }

    @Override
    public int compareTo(Vuelo o){
        if (this.getDestino().compareTo(o.getDestino()) == 0){
            if (this.getModelo().compareTo(o.getModelo()) == 0){
                if (this.getNumPlazas() == o.getNumPlazas()){
                    return 0;
                }
                return (this.getNumPlazas() - o.getNumPlazas());
            }
            return (this.getModelo().compareTo(o.getModelo()));
        }
        return (this.getDestino().compareTo(o.getDestino()));
    }
}
