package tarea07.tienda.comparators;

import java.util.Comparator;
import tarea07.tienda.TicketCompra;

/**
 *
 * @author Andrés Samuel Podadera González
 */
public class ComparadorTicketsPorInstante implements Comparator<TicketCompra> {

    @Override
    public int compare(TicketCompra o1, TicketCompra o2) {
        return o1.getInstante().compareTo(o2.getInstante());
    }
}
