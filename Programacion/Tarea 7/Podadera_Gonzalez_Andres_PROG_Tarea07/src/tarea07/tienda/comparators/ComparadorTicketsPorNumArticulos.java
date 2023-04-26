package tarea07.tienda.comparators;

import java.util.Comparator;
import tarea07.tienda.TicketCompra;

/**
 *
 * @author Andrés Samuel Podadera González
 */
public class ComparadorTicketsPorNumArticulos implements Comparator<TicketCompra> {

    @Override
    public int compare(TicketCompra o1, TicketCompra o2) {
        return o1.getNumArticulos() - o2.getNumArticulos();
    }
}
