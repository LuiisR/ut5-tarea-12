package pkgaeropuerto.modelo;

public class Charter extends Vuelo{

   private String nif;

    public Charter(String destino, String modelo, int numPlazas, double precio, String nif) {
        super(destino, modelo, numPlazas, precio);
        this.nif = nif;
    }
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    public double getPrecioCharter(){
        if (this.getNumPlazas() < 200){
            return (int) (this.getPrecio() * 1.25 + 50);
        } else{
            return (int) (this.getPrecio() * 1.25);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nVuelo Charter");
        sb.append(super.toString());
        sb.append("Precio billete: ").append(getPrecioCharter()).append(" $");
        sb.append("\nNIF Empresa: ").append(nif).append('\n');
        return sb.toString();
    }


}
