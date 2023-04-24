import java.util.*;

public class Aeropuerto {

    private Map<String, Set<Vuelo>> vuelos;


    public Aeropuerto() {
        this.vuelos = new TreeMap<>();
    }

    /**
     * Añade un vuelo a la aerolinea correspondiente solo en el caso de que el vuelo
     * no estuviese ya introducido, si la aerolinea no existiese se añade tanto la
     * aerolinea como el vuelo.
     */
    public void addVuelo(String aerolinea, Vuelo vuelo) {
        if (vuelos.containsKey(aerolinea)) {
            Set<Vuelo> claves = vuelos.get(aerolinea);
            claves.add(vuelo);
        } else {
            Set<Vuelo> claves = new TreeSet<>();
            claves.add(vuelo);
            vuelos.put(aerolinea, claves);
        }
    }

    /**
     * Imprime los vuelos por cada aerolinea ordenados por destino, tanto aerolineas
     * como vuelos estaran ordenados alfabeticamente (Ver resultados de ejecucion)
     */
    public void ordenAerolineasAlfabetico() {
        Set<Map.Entry<String, Set<Vuelo>>> entradas = vuelos.entrySet();
        for (Map.Entry<String, Set<Vuelo>> v1 : entradas) {
            String nombreAerolinea = v1.getKey();
            Set<Vuelo> listaVuelos = v1.getValue();
            System.out.println(nombreAerolinea);
            for (Vuelo v : listaVuelos) {
                System.out.println(v.toString());
            }
        }
    }

    /**
     * Muestra los vuelos regulares de la aerolinea pasada por parametro, se
     * visualizaran de mayor a menor segun el numero de plazas
     *
     * @param aerolinea Aerolinea de la que se imprimiran los vuelos regulares
     */
    public void regularPorPlazas(String aerolinea) {
        if (vuelos.containsKey(aerolinea)) {
            for (Map.Entry<String, Set<Vuelo>> v1 : vuelos.entrySet()) {
                Set<Vuelo> listaVuelos = v1.getValue();
                ComparadorPlazas comparador = new ComparadorPlazas();
                Set<Vuelo> listaVuelosOrdenados = new TreeSet<>(comparador);
                listaVuelosOrdenados.addAll(listaVuelos);
                for (Vuelo v : listaVuelosOrdenados) {
                    if (v instanceof Regular) {
                        System.out.println(v.toString());
                    }
                }
            }
        }
    }

    /**
     * Devuelve una lista con vuelos regulares con plazas libres
     *
     * @return aerolina Aerolina del avion charter con más capacidad
     */
    public List<Vuelo> plazasLibres() {
        List<Vuelo> nuevo = new ArrayList<>();
        return nuevo;
    }

    /**
     * Muestra el numero de vuelos de cada aerolinea que llegan al destino pasado
     * por parametro, ver resultados de ejecucion
     *
     * @param destino Destino del que se debe sacar la estadistica
     */
    public void estadisticaDestino(String destino) {

    }

    /**
     * Borra los vuelos reservados por una empresa y devuelve el numero de vuelos
     * borrados, utiliza un conjunto de entradas
     *
     * @param nifEmpresa
     * @return numero de vuelos borrados
     */
    public int borrarVuelosEmpresa(String nifEmpresa) {
        return 0;
    }

    /**
     * Imprime la lista de vuelos pasada por parametro
     *
     * @param listaVuelos
     */
    public void imprimirListaVuelos(List<Vuelo> listaVuelos) {

    }

    /**
     * Represetación textual del mapa tal y como se muestra en el enunciado
     */
    public String toString() {
        return "";
    }

    /**
     * Rellena el mapa haciendo uso de un fichero de texto
     */
    public void leerFicheroCursos() {
        Scanner entrada = null;
        try {
            entrada = new Scanner(this.getClass().getResourceAsStream("aviones.txt"));
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                int pos = linea.indexOf(":");
                String aerolinea = linea.substring(0, pos);
                String[] vuelo = linea.substring(pos + 1).split(":");
                String destino = vuelo[1];
                String avion = vuelo[2];
                int plazas = Integer.parseInt(vuelo[3].trim());
                if (vuelo[0].equals("R")) {
                    int plazasLibres = Integer.parseInt(vuelo[4].trim());
                    this.addVuelo(aerolinea, new Regular(destino, avion, plazas, plazasLibres));
                } else {
                    String nifEmpresa = vuelo[4];
                    this.addVuelo(aerolinea, new Charter(destino, avion, plazas, nifEmpresa));
                }
            }

        } finally {
            try {
                entrada.close();
            } catch (NullPointerException e) {
                System.out.println("Error en IO , no se ha creado el fichero");
            }
        }

    }

}
