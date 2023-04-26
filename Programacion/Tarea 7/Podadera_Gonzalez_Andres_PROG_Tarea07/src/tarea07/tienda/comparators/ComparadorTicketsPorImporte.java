package tarea07.tienda.comparators;

import java.util.Comparator;
import tarea07.tienda.TicketCompra;

/**
 *
 * @author Andrés Samuel Podadera González
 */
public class ComparadorTicketsPorImporte implements Comparator<TicketCompra> {

    @Override
    public int compare(TicketCompra o1, TicketCompra o2) {
        //para evitar la pérdida de información al castear de double a enteros
        return Double.compare(o1.getImporte(),o2.getImporte());
    }

}
