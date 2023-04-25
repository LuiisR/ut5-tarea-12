package pkgaeropuerto.modelo;

import java.util.*;

public class Aeropuerto {

    private Map<String, Set<Vuelo>> vuelos;


    public Aeropuerto() {
        this.vuelos = new TreeMap<>();
    }

    /**
     * A�ade un vuelo a la aerolinea correspondiente solo en el caso de que el vuelo
     * no estuviese ya introducido, si la aerolinea no existiese se a�ade tanto la
     * aerolinea como el vuelo.
     */
    public void addVuelo(String aerolinea, Vuelo vuelo) {

        if (vuelos.containsKey(aerolinea)) {
            vuelos.get(aerolinea).add(vuelo);
        } else {
            Set vueloAerolinea = new TreeSet();
            vueloAerolinea.add(vuelo);
            vuelos.put(aerolinea, vueloAerolinea);
        }
    }

    /**
     * Imprime los vuelos por cada aerolinea ordenados por destino, tanto aerolineas
     * como vuelos estaran ordenados alfabeticamente (Ver resultados de ejecucion)
     */
    public void ordenAerolineasAlfabetico() {
        for (String aerolinea : vuelos.keySet()) {
            System.out.println(aerolinea);
            for (Vuelo v1 : vuelos.get(aerolinea)) {
                System.out.println(v1.toString());
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
        Set<Regular> listaOrdenada = new TreeSet<>(new ComparadorPorPlazas());
        for (Vuelo v : vuelos.get(aerolinea)) {
            if (v instanceof Regular) {
                Regular regular = (Regular) v;
                listaOrdenada.add(regular);
            }
        }
        for (Regular r : listaOrdenada) {
            System.out.println(r);
        }
    }

    /**
     * Devuelve una lista con vuelos regulares con plazas libres
     *
     * @return aerolina Aerolina del avion charter con m�s capacidad
     */
    public List<Vuelo> plazasLibres() {
        List<Vuelo> nuevo = new ArrayList<>();
        for (String aerolinea : vuelos.keySet()) {
            for (Vuelo v : vuelos.get(aerolinea)) {
                if (v instanceof Regular) {
                    if (((Regular) v).getnPlazasLibres() > 0) {
                        nuevo.add(v);
                    }
                }
            }
        }
        return nuevo;
    }

    /**
     * Muestra el numero de vuelos de cada aerolinea que llegan al destino pasado
     * por parametro, ver resultados de ejecucion
     *
     * @param destino Destino del que se debe sacar la estadistica
     */
    public void estadisticaDestino(String destino) {
        int contador = 0;
        for (String aerolinea : vuelos.keySet()) {
            for (Vuelo v : vuelos.get(aerolinea)) {
                if (v.getDestino().equalsIgnoreCase(destino)) {
                    contador++;
                }

            }
            System.out.println(contador + " de cada " + vuelos.get(aerolinea).size() + " de la aerolinea " + aerolinea + " vuelan a " + destino);
            contador = 0;
        }
    }

    /**
     * Borra los vuelos reservados por una empresa y devuelve el numero de vuelos
     * borrados, utiliza un conjunto de entradas
     *
     * @param nifEmpresa
     * @return numero de vuelos borrados
     */
    public int borrarVuelosEmpresa(String nifEmpresa) {
        for (String aerolinea : vuelos.keySet()) {
            for (Vuelo v : vuelos.get(aerolinea)) {
                if (v instanceof Charter) {
                    if (((Charter) v).getNif().equalsIgnoreCase(nifEmpresa)) {

                    }
                }
            }
        }
        return 0;
    }

    /**
     * Imprime la lista de vuelos pasada por parametro
     *
     * @param listaVuelos
     */
    public void imprimirListaVuelos(List<Vuelo> listaVuelos) {
        for (Vuelo v : listaVuelos) {
            System.out.println(v.toString());
        }
    }

    /**
     * Represetaci�n textual del mapa tal y como se muestra en el enunciado
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
            entrada = new Scanner(this.getClass().getResourceAsStream("/aviones.txt"));
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