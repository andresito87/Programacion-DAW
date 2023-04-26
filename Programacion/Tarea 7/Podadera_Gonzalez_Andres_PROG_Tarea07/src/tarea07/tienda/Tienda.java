package tarea07.tienda;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tarea07.tienda.comparators.ComparadorTicketsPorImporte;
import tarea07.tienda.comparators.ComparadorTicketsPorInstante;
import tarea07.tienda.comparators.ComparadorTicketsPorNumArticulos;
import tarea07.tienda.comparators.ComparadorTicketsPorVendedor;

/**
 * Representa todas las compras que se han llevado a cabo en un comercio.
 * Contiene un identificador de tienda y una lista con todos los tickets de
 * todas las compras que se hayan realizado.
 *
 * @author profe + Andrés Samuel Podadera González
 */
public class Tienda {

    private final String idTienda;
    private final List<TicketCompra> listaTickets;

    // --------------------------------------------------
    //               CONSTRUCTORES
    // --------------------------------------------------
    /**
     * Constructor que instancia un objeto Tienda a partir de un identificador
     * de tienda y una lista de tickets. Si la lista de tickets es
     * <code>null</code>, se crea una lista vacía.
     *
     * @param idTienda identificador de la tienda
     * @param listaTickets lista de tickets incial
     */
    public Tienda(String idTienda, List<TicketCompra> listaTickets) {
        this.idTienda = idTienda;
        if (listaTickets != null) {
            this.listaTickets = listaTickets;
        } else {
            this.listaTickets = new LinkedList<>();
        }
    }

    /**
     * Constructor que instancia un objeto Tienda a partir de un identificador
     * de tienda. Se crea una lista de tickets vacía.
     *
     * @param idTienda identificador de la tienda
     */
    public Tienda(String idTienda) {
        this(idTienda, null);
    }

    // --------------------------------------------------
    //                    GETTERS
    // --------------------------------------------------
    /**
     * Obtiene el identificador de la tienda.
     *
     * @return identificador de la tienda
     */
    public String getIdTienda() {
        return this.idTienda;
    }

    /**
     * Obtiene la lista de todos los tickets de compra de la tienda.
     *
     * @return lista de tickets de compra.
     */
    public List<TicketCompra> getListaTickets() {
        return this.listaTickets;
    }

    /**
     * Obtiene el número de tickets actuales en la tienda.
     *
     * @return número de tickets de la tienda
     */
    public int getNumTickets() {
        return this.listaTickets.size();
    }

    // --------------------------------------------------
    //                   TOSTRING
    // --------------------------------------------------
    /**
     * Obtiene una representación textual de la tienda. Tendrá el formato
     * {idTienda, numTickets}
     *
     * @return representación textual de la tienda
     */
    @Override
    public String toString() {
        return String.format("{id: %s, Número de tickets: %d}",
                this.getIdTienda(), this.getNumTickets());
    }

    /**
     * Obtiene una representación textual más detallada de la tienda. Se
     * muestran todos los tickets en detalle. Tendrá un formato multilínea donde
     * cada línea mostrará la representación textual de un ticket.
     *
     * @return representación textual detallada de la tienda (incluye los
     * tickets)
     */
    public String toStringTicketsCompra() {
        int contador = 1;
        StringBuilder resultado = new StringBuilder();
        for (TicketCompra ticket : this.listaTickets) {
            resultado.append(String.format("%d. Ticket de compra: %s\n", contador++, ticket));
        }
        return resultado.toString();
    }

    // --------------------------------------------------
    // MÉTODOS QUE DEBEN SER IMPLEMETADOS POR EL ALUMNADO
    // --------------------------------------------------
    // Ejercicio 2
    // -----------    
    // Ejercicio 2.1: número total de artículos
    // ----------------------------------------
    /**
     * Devuelve el total de artículos comprados en la tienda. Tiene en cuenta la
     * cantidad de cada uno de los productos comprados.
     *
     * @return importe total de la compra
     */
    public int getNumArticulosVendidos() {
        int cantidadArticulosVendidos = 0;

        for (TicketCompra ticket : this.getListaTickets()) {
            cantidadArticulosVendidos += ticket.getNumArticulos();
        }

        return cantidadArticulosVendidos;
    }

    // Ejercicio 2.2: facturación total
    // --------------------------------
    /**
     * Devuelve el importe total de todas las compras realizadas en la tienda.
     *
     * @return importe total de todas las compras
     */
    public double getFacturacionTotal() {
        double totalFacturado = 0;

        for (TicketCompra ticket : this.getListaTickets()) {
            totalFacturado += ticket.getImporte();
        }
        return totalFacturado;
    }

    // Ejercicio 3: productos vendidos a partir de una fecha
    // -----------------------------------------------------
    /**
     * Devuelve un conjunto con todos los productos adquiridos a partir de una
     * fecha determinada.
     *
     * @param fecha fecha a partir de la cual queremos obtener los prodcutos
     * adquiridos
     * @return conjunto con los nombres de los productos comprados a partir de
     * la fecha proporcionada
     */
    
    public Set<String> getProductosComprados(LocalDate fecha) {
        /* Otra forma con bucles foreach
        Set productosComprados = new HashSet<String>();

        for (TicketCompra ticket : this.getListaTickets()) {
            if (ticket.getInstante().toLocalDate().isAfter(fecha)
                    || ticket.getInstante().toLocalDate().equals(fecha)) {
                for (Compra compra : ticket.getListaCompra()) {
                    productosComprados.add(compra.getProducto());
                }
            }
        }
        return productosComprados;*/
        
        Set<String> productosComprados = new HashSet<>();

        Iterator<TicketCompra> iteratorTickets = this.getListaTickets().iterator();
        while (iteratorTickets.hasNext()) {
            TicketCompra ticket = iteratorTickets.next();
            if (ticket.getInstante().toLocalDate().isAfter(fecha)
                    || ticket.getInstante().toLocalDate().equals(fecha)) {
                Iterator<Compra> iteratorCompras = ticket.getListaCompra().iterator();
                while (iteratorCompras.hasNext()) {
                    Compra compra = iteratorCompras.next();
                    productosComprados.add(compra.getProducto());
                }
            }
        }
        return productosComprados;
    }

// Ejercicio 4: clasificación de ventas por fechas
// -----------------------------------------------
    /**
     * Devuelve un Map con las cantidades totales facturadas cada fecha.
     *
     * @return Map donde las claves son fechas y los valores las cantidades
     * facturadas en esa fecha.
     */
    public Map<LocalDate, Double> getImportesPorFechas() {
        Map mapaImporteFecha = new HashMap<LocalDate, Double>();

        for (TicketCompra ticket : this.getListaTickets()) {
            double importe = 0;
            for (Compra compra : ticket.getListaCompra()) {
                importe += compra.getImporte();
            }
            if (mapaImporteFecha.containsKey(ticket.getInstante().toLocalDate())) {
                importe += (double) mapaImporteFecha.get(ticket.getInstante().toLocalDate());
            }
            mapaImporteFecha.put(ticket.getInstante().toLocalDate(), importe);
        }
        return mapaImporteFecha;
    }

    // Ejercicio 5: clasificación de compras por vendedores y por años
    // ---------------------------------------------------------------    
    /**
     * Devuelve un Map con las cantidades facturadas por cada vendedor cada año.
     *
     * @return Map donde las claves sean nombres de vendedor y los valores un
     * nuevo Map donde las claves serán años y los valores serán las cantidades
     * facturadas por ese vendedor en ese año
     */
    public Map<String, Map<Integer, Double>> getComprasPorVendedorYear() {
        Map <String, Map<Integer, Double>> comprasPorVendedorEnAnyo = new HashMap<>();
        Map <Integer, Double> fechaImporteCompra = new HashMap<>();

        for (TicketCompra ticket : this.getListaTickets()) {
            double importe = 0;
            for (Compra compra : ticket.getListaCompra()) {
                importe += compra.getImporte();
            }
            if (comprasPorVendedorEnAnyo.containsKey(ticket.getVendedor())) {
                if (fechaImporteCompra.containsKey(ticket.getInstante().getYear())) {
                    importe += (double) fechaImporteCompra.get(ticket.getInstante().getYear());
                }
                fechaImporteCompra.put(ticket.getInstante().getYear(), importe);
            } else {
                fechaImporteCompra = new HashMap<>();
                fechaImporteCompra.put(ticket.getInstante().getYear(), importe);
                comprasPorVendedorEnAnyo.put(ticket.getVendedor(), fechaImporteCompra);
            }
        }
        return comprasPorVendedorEnAnyo;
    }

    // Ejercicio 6
    // -------------    
    // Ejercicio 6.1. Borrado de compras de un determinado vendedor
    /**
     * Elimina todos los tickets de compra en los que aparezca el vendedor que
     * se pasa como parámetro.
     *
     * @param vendedor vendedor cuyos tickets se desean borrar
     * @return número de tickets borrados
     */
    public int removeCompras(String vendedor) {
        int contadorElementosEliminados = 0;
        Iterator<TicketCompra> iterador = this.getListaTickets().iterator();

        while (iterador.hasNext()) {
            TicketCompra ticket = iterador.next();
            if (ticket.getVendedor().equals(vendedor)) {
                iterador.remove();
                contadorElementosEliminados++;
            }
        }
        return contadorElementosEliminados;
    }

    // Ejercicio 6.2. Borrado de compras en una determinada fecha
    /**
     * Elimina todos los tickets de compra en los que aparezca la fecha que se
     * pasa como parámetro.
     *
     * @param fecha fecha cuyos tickets se desean borrar
     * @return número de tickets borrados
     */
    public int removeCompras(LocalDate fecha) {
        int contadorElementosEliminados = 0;
        Iterator<TicketCompra> iterador = this.getListaTickets().iterator();

        while (iterador.hasNext()) {
            TicketCompra ticket = iterador.next();
            if (ticket.getInstante().toLocalDate().equals(fecha)) {
                iterador.remove();
                contadorElementosEliminados++;
            }
        }
        return contadorElementosEliminados;
    }

    // Ejercicio 6.3. Borrado de compras de un vendedor en una determinada fecha
    /**
     * Elimina todos los tickets de compra en los que aparezcan tanto el
     * vendedor como la fecha que se pasan como parámetros como parámetro.
     *
     * @param vendedor vendedor cuyos tickets se desean borrar
     * @param fecha fecha cuyos tickets se desean borrar
     * @return número de tickets borrados
     */
    public int removeCompras(String vendedor, LocalDate fecha) {
        int contadorElementosEliminados = 0;
        Iterator<TicketCompra> iterador = this.getListaTickets().iterator();

        while (iterador.hasNext()) {
            TicketCompra ticket = iterador.next();
            if (ticket.getVendedor().equals(vendedor)
                    && ticket.getInstante().toLocalDate().equals(fecha)) {
                iterador.remove();
                contadorElementosEliminados++;
            }
        }
        return contadorElementosEliminados;
    }

    // Ejercicio 7
    // -------------
    // Ejercicio 7.1: ordenación de compras por fecha y hora ascendentemente
    /**
     * Ordena la lista de tickets por instante o timestamp (fecha+hora) en orden
     * ascendente.
     */
    public void sortListaTicketsPorInstante() {
        Collections.sort(this.getListaTickets(), new ComparadorTicketsPorInstante());
    }

    // Ejercicio 7.2: ordenación de compras por número de artículos ascendentemente
    /**
     * Ordena la lista de tickets por número de artículos en orden ascendente.
     */
    public void sortListaTicketsPorNumArticulos() {
        Collections.sort(this.getListaTickets(), new ComparadorTicketsPorNumArticulos());
    }

    // Ejercicio 7.3: ordenación de compras por vendedor ascendentemente
    /**
     * Ordena la lista de tickets por vendedor (orden alfabético) en orden
     * ascendente.
     */
    public void sortListaTicketsPorVendedor() {
        Collections.sort(this.getListaTickets(), new ComparadorTicketsPorVendedor());
    }

    // Ejercicio 7.4: ordenación de compras por importe ascendentemente
    /**
     * Ordena la lista de tickets por importe en orden ascendente.
     */
    public void sortListaTicketsPorImporte() {
        Collections.sort(this.getListaTickets(), new ComparadorTicketsPorImporte());
    }
}
