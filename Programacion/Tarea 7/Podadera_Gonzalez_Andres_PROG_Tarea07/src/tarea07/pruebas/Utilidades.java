package tarea07.pruebas;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import tarea07.tienda.Compra;
import tarea07.tienda.TicketCompra;
import tarea07.tienda.Tienda;

/**
 * Utilidades para los programas de pruebas de la clases <code>Tienda</code>,
 * <code>TicketCompra</code> y <code>Compra</code>.
 * @author profe
 */
public class Utilidades {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    public static final  DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
    
    // Declaramos un constructor privado para que la clase no sea instanciable
    // Se trata de una "toolbox" o "caja de herramientas"
    private Utilidades() { }

    // Métodos para crear tickets de compra de ejemplo
    
    private static List<Compra> listaCompras1() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p1", 10.50, 1) );
       listaCompraProducto.add (new Compra ("p6",  0.60, 1) );
       listaCompraProducto.add (new Compra ("p3",  1.50, 2) );
       listaCompraProducto.add (new Compra ("p4",  1.60, 3) );
       
       return listaCompraProducto;
    }

    private static List<Compra> listaCompras2() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p1", 10.50, 2) );
       listaCompraProducto.add (new Compra ("p4",  1.60, 5) );
       
       return listaCompraProducto;
    }

    private static List<Compra> listaCompras3() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p5",  0.70, 4) );
       listaCompraProducto.add (new Compra ("p6",  0.60, 2) );
       listaCompraProducto.add (new Compra ("p7",  2.50, 1) );
       
       return listaCompraProducto;
    }

    private static List<Compra> listaCompras4() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p6",  0.60, 1) );
       listaCompraProducto.add (new Compra ("p2",  7.25, 3) );
       listaCompraProducto.add (new Compra ("p7",  2.50, 2) );
       
       return listaCompraProducto;
    }
    
    private static List<Compra> listaCompras5() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p1",  0.60, 1) );
       listaCompraProducto.add (new Compra ("p3",  1.50, 2) );
       listaCompraProducto.add (new Compra ("p5",  0.70, 1) );
       
       return listaCompraProducto;
    }
    
    private static List<Compra> listaCompras6() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
      
       listaCompraProducto.add (new Compra ("p1",  0.60, 1) );
       listaCompraProducto.add (new Compra ("p3",  1.50, 1) );
       listaCompraProducto.add (new Compra ("p7",  2.50, 1) );
       
       return listaCompraProducto;
    }

    private static List<Compra> listaCompras7() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
       listaCompraProducto.add (new Compra ("p1",  0.60, 1) );
       return listaCompraProducto;
    }
 
    private static List<Compra> listaCompras8() {
       List<Compra> listaCompraProducto = new LinkedList<>();       
       listaCompraProducto.add (new Compra ("p1",  0.60, 1) );
       listaCompraProducto.add (new Compra ("p7",  2.50, 1) );
       return listaCompraProducto;
    }

    /**
     * Crea un ejemplo de Ticket de compra. 
     * @param numEjemplo un número entre 1 y 8
     * @return un objeto de tipo <code>TicketCompra</code>
     */
    public static TicketCompra creaEjemploTicketCompra(int numEjemplo) {
        TicketCompra compraCliente;
        switch (numEjemplo) {
            case 1:
                compraCliente = new TicketCompra ("Fran", LocalDateTime.of(2023, 2, 5, 17, 2, 12), Utilidades.listaCompras1());
                break;
            case 2:
                compraCliente = new TicketCompra ("Fran", LocalDateTime.of(2022, 5, 3, 11, 37, 14), Utilidades.listaCompras2());
                break;
            case 3:
                compraCliente = new TicketCompra ("Fran", LocalDateTime.of(2022, 5, 4, 10, 45, 10), Utilidades.listaCompras3());
                break;
            case 4:
                 compraCliente = new TicketCompra ("Lina", LocalDateTime.of(2023, 2, 3, 19, 11, 55), Utilidades.listaCompras4());
                break;
            case 5:
                compraCliente = new TicketCompra ("Lina", LocalDateTime.of(2022, 12, 3, 9, 31, 59), Utilidades.listaCompras5());
                break;
            case 6:
                compraCliente = new TicketCompra ("Mara", LocalDateTime.of(2022, 12, 3, 10, 35, 10), Utilidades.listaCompras6());
                break;
            case 7:
                compraCliente = new TicketCompra ("Mara", LocalDateTime.of(2023, 2, 10, 10, 37, 0), Utilidades.listaCompras7());
                break;
            case 8:
                compraCliente = new TicketCompra ("Dani", LocalDateTime.of(2023, 2, 10, 10, 35, 12), Utilidades.listaCompras8());
                break;
            default:
                compraCliente = new TicketCompra ("Fran", LocalDateTime.of(2023, 2, 5, 17, 2, 12), Utilidades.listaCompras1());                
        }       
                
        return compraCliente;        
    }
        

    /**
     * Crea un ejemplo de objeto <code>Tienda</code> con una lista de tickets de compra.
     * @return ejemplo de objeto <code>Tienda</code>
     */    
    public static Tienda CreaEjemploTienda () {
        Tienda ejemploTienda = new Tienda ("0001");
        for (int i=1 ; i<= 8 ; i++) {
            ejemploTienda.getListaTickets().add (creaEjemploTicketCompra(i));
        }
        return ejemploTienda;
    }
    
    /**
     * Crea una cadena de caracteres con un título y una línea separadora encima y debajo.
     * @param texto título o cabecera de texto
     * @return título adornado con una línea separadora inferior y otra superior
     */    
    public static String cabecera(String texto) {
        StringBuilder cabecera = new StringBuilder();
        String lineas = "-".repeat(texto.length());
        cabecera.append(lineas).append("\n").append(texto).append("\n").append(lineas).append("\n");

        return cabecera.toString();
    }

}
