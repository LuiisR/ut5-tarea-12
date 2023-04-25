package pkgaeropuerto.modelo;

public class Charter extends Vuelo{

   private String nif;

    public Charter(String destino, String modelo, int numPlazas, String nif) {
        super(destino, modelo, numPlazas);
        this.nif = nif;
    }
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vuelo Charter\n");
        sb.append(super.toString());
        sb.append("NIF Empresa: ").append(nif).append('\n');
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
