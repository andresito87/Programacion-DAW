package tarea07.tienda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Representa el ticket de la compra realizada por un cliente. Contiene
 * información sobre fecha y hora, así como el vendedor, los productos
 * adquiridos, cantidades, precios, etc. El registro de los productos comprados,
 * junto con la cantidad y el precio se almacenan en forma de lista de objetos
 * <code>Compra</code>, es decir, una lista de ternas
 * <code>(producto, precio, unidades)</code>.
 *
 * @author profe + Andrés Samuel Podadera González
 */
public class TicketCompra {

    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
    private final String vendedor;
    private final LocalDateTime instante;
    private final List<Compra> listaCompra;

    // --------------------------------------------------
    //               CONSTRUCTORES
    // --------------------------------------------------
    /**
     * Constructor para instanciar un ticket a partir de un vendedor, un
     * instante (timestamp) y una lista de objetos Compra. Si la lista pasada es
     * <code>null</code>, se creará una lista vacía.
     *
     * @param vendedor vendedor que atendió en la compra
     * @param instante momento de la compra (fecha y hora)
     * @param listaCompra lista de la compra. Lista de objetos Compra, ternas
     * del tipo (producto, precio, unidades)
     */
    public TicketCompra(String vendedor, LocalDateTime instante, List<Compra> listaCompra) {
        this.vendedor = vendedor;
        this.instante = instante;
        if (listaCompra != null) {
            this.listaCompra = listaCompra;
        } else {
            this.listaCompra = new LinkedList<>();
        }
    }

    /**
     * Constructor para instanciar un ticket a partir de un vendedor y un
     * instante (timestamp). Inicialmente la lista de objetos compra estará
     * vacía.
     *
     * @param vendedor vendedor que atendió en la compra
     * @param instante momento de la compra (fecha y hora)
     */
    public TicketCompra(String vendedor, LocalDateTime instante) {
        this(vendedor, instante, null);
    }

    /**
     * Constructor para instanciar un ticket a partir de un vendedor y una lista
     * de compras. El momento de la compra se considerará el actual.
     *
     * @param vendedor vendedor que atendió en la compra
     * @param listaCompra lista de la compra. Lista de objetos Compra, ternas
     * del tipo (producto, precio, unidades)
     */
    public TicketCompra(String vendedor, List<Compra> listaCompra) {
        this(vendedor, LocalDateTime.now(), listaCompra);
    }

    /**
     * Constructor para instanciar un ticket a partir de un vendedor. El momento
     * de la compra se considerará el actual. Inicialmente la lista de objetos
     * compra estará vacía.
     *
     * @param vendedor vendedor que atendió en la compra
     */
    public TicketCompra(String vendedor) {
        this(vendedor, LocalDateTime.now());
    }

    // --------------------------------------------------
    //                    GETTERS
    // --------------------------------------------------
    /**
     * Obtiene el vendedor que atendió en la compra
     *
     * @return vendedor que atendió en la compra
     */
    public String getVendedor() {
        return this.vendedor;
    }

    /**
     * Obtiene el instante (<code>timestamp</code> o fecha y hora) en el que se
     * realizó la compra.
     *
     * @return instante de la compra
     */
    public LocalDateTime getInstante() {
        return instante;
    }

    /**
     * Obtiene la lista completa de los objetos <code>Compra</code> del ticket.
     *
     * @return lista de objetos <code>Compra</code>
     */
    public List<Compra> getListaCompra() {
        return listaCompra;
    }

    // --------------------------------------------------
    //                   TOSTRING
    // --------------------------------------------------
    /**
     * Representación textual de un ticket de compra. Tendrá el formato
     * {vendedor, instante, numArticulos, importe, [lista de tickets]}.
     *
     * @return representación textual del ticket.
     */
    @Override
    public String toString() {
        return String.format("{%s, %s, %d, %6.2f, %s}",
                this.vendedor,
                this.instante.format(FORMATO_FECHA_HORA),
                this.getNumArticulos(),
                this.getImporte(),
                this.listaCompra);
    }

    // --------------------------------------------------
    // MÉTODOS QUE DEBEN SER IMPLEMETADOS POR EL ALUMNADO
    // --------------------------------------------------
    // Ejercicio 1.1
    // -------------
    /**
     * Devuelve el importe total de la compra. Tiene en cuenta todos los
     * productos comprados, su cantidad y su precio.
     *
     * @return importe total de la compra
     */
    public double getImporte() {
        double total = 0;

        for (Compra producto : this.getListaCompra()) {
            total += producto.getImporte();
        }
        return total;
    }

    // Ejercicio 1.2
    // -------------
    /**
     * Devuelve el total de artículos adquiridos en la compra. Tiene en cuenta
     * la cantidad de cada uno de los productos comprados.
     *
     * @return importe total de la compra
     */
    public int getNumArticulos() {
        int cantidadProductos = 0;

        for (Compra producto : this.getListaCompra()) {
            cantidadProductos += producto.getUnidades();
        }
        return cantidadProductos;
    }
}
