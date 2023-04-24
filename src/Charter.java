
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
        sb.append(super.toString());
        sb.append("NIF Empresa: ").append(nif).append('\n');
        return sb.toString();
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.getDestino().compareTo(o.getDestino());
    }
}
