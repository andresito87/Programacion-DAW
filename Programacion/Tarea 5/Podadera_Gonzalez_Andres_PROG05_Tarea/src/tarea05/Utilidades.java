package tarea05;

import java.time.format.DateTimeFormatter;
import static tarea05.Utilidades.cabecera;

/**
 * Utilidades para los programas de pruebas de la clase <code>Teatro</code>.
 *
 * @author profe
 */
public class Utilidades {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    public static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

    // Declaramos un constructor privado para que la clase no sea instanciable
    // Es una "toolbox" o "caja de herramientas"
    private Utilidades() {

    }

    public static String cabecera(String texto) {
        StringBuilder cabecera = new StringBuilder();
        String lineas = "-".repeat(texto.length());
        cabecera.append(lineas).append("\n").append(texto).append("\n").append(lineas).append("\n");

        return cabecera.toString();
    }

    public static String consultaAtributosPublicosClase() {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera("CONSULTA DE ATRIBUTOS PÚBLICOS DE CLASE TEATRO"));
        consulta.append(String.format("AFORO MÁXIMO DE TEATROS: %d\n", Teatro.AFORO_MAX));
        consulta.append(String.format("AFORO MÍNIMO DE TEATROS: %d\n", Teatro.AFORO_MIN));
        consulta.append(String.format("DEFAULT AFORO:  %d\n", Teatro.DEFAULT_AFORO));

        return consulta.toString();
    }

    public static Teatro constructor2Parametros(String nombre, int aforo) {
        Teatro miTeatro = null;
        try {
            System.out.printf("Intentando crear objeto con los parámetros: %s, %d.\n",
                    nombre, aforo);
            miTeatro = new Teatro(nombre, aforo);
            System.out.printf("Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | NullPointerException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return miTeatro;
    }

    public static Teatro constructor1Parametro(String nombre) {
        Teatro miTeatro = null;
        try {
            System.out.printf("Intentando crear objeto con los parámetros: %s.\n",
                    nombre);
            miTeatro = new Teatro(nombre);
            System.out.printf("Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | NullPointerException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return miTeatro;
    }

    public static Teatro constructorSinParametros() {
        Teatro miTeatro;
        System.out.printf("Intentando crear objeto sin parámetros.\n");
        miTeatro = new Teatro();
        System.out.printf("Objeto creado con éxito.\n");
        return miTeatro;
    }

    /*
    COMENTAR A PARTIR DE ESTA LÍNEA PARA PROBAR EL PROGRAMA DE PRUEBAS "Pruebas01012.java"
     */
    public static String consultaEstadoClase() {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera("CONSULTA DE INFORMACIÓN DE CLASE TEATRO:"));
        consulta.append(String.format("Número total de teatros: %d\n", Teatro.getTeatrosTotales()));
        consulta.append(String.format("Número de obras activas en todos los teatros: %d\n", Teatro.getObrasActivas()));
        consulta.append(String.format("Número de entradas vendidas en todos los teatros: %d \n", Teatro.getEntradasVendidasTotales()));
        return consulta.toString();
    }

    public static String consultaEstadoObjeto(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(cabecera("CONSULTA DE INFORMACIÓN DE OBJETO TEATRO")));
        consulta.append(String.format("Código del teatro: %s.\n", miTeatro.getCodigoTeatro()));
        consulta.append(String.format("Nombre del teatro: %s.\n", miTeatro.getNombreTeatro()));
        consulta.append(String.format("Aforo: %d butacas.\n", miTeatro.getAforo()));
        consulta.append(String.format("Tiene obra en este momento: %s.\n", miTeatro.tieneObra() ? "sí" : "no"));
        consulta.append(String.format("Obra que se está representando: %s.\n", !miTeatro.tieneObra() ? "---" : miTeatro.getObra()));
        consulta.append(String.format("Entradas vendidas: %d entradas.\n", miTeatro.getEntradasVendidas()));
        return consulta.toString();
    }

    /*
    COMENTAR A PARTIR DE ESTA LÍNEA PARA PROBAR EL PROGRAMA DE PRUEBAS "Pruebas03.java"
     */
    public static void asignarObraTeatro(Teatro miTeatro, String unaObra) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando asignar obra al teatro \"%s\"", miTeatro.getNombreTeatro())));
            miTeatro.asignarObra(unaObra);
            consulta.append("Obra asignada correctamente.\n");
        } catch (IllegalArgumentException | IllegalStateException | NullPointerException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Representándose la obra \"%s\" en el teatro \"%s\"\n", miTeatro.getObra(), miTeatro.getNombreTeatro()));
            consulta.append(String.format("Número de obras totales representándose: %d\n", Teatro.getObrasActivas()));
        }
        System.out.print(consulta);
    }

    public static void terminarObraTeatro(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando terminar la obra del teatro \"%s\"", miTeatro.getNombreTeatro())));
            miTeatro.terminarObra();
            consulta.append("Obra terminada correctamente.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de obras totales representándose: %d\n", Teatro.getObrasActivas()));
        }
        System.out.print(consulta);
    }

    /*
    COMENTAR A PARTIR DE ESTA LÍNEA PARA PROBAR EL PROGRAMA DE PRUEBAS "Pruebas04.java"
     */
    public static void comprarEntradasTeatro(Teatro miTeatro, int entradas) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando comprar %d entradas para la obra \"%s\" en el teatro \"%s\"", entradas, miTeatro.tieneObra() ? miTeatro.getObra() : "---", miTeatro.getNombreTeatro())));
            miTeatro.comprarEntradas(entradas);
            consulta.append("Compra realizada con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    public static void comprarEntradaTeatro(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando comprar 1 entrada para la obra \"%s\" en el teatro \"%s\"", miTeatro.tieneObra() ? miTeatro.getObra() : "---", miTeatro.getNombreTeatro())));
            miTeatro.comprarEntrada();
            consulta.append("Compra realizada con éxito.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    public static void devolverEntradasTeatro(Teatro miTeatro, int entradas) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando devolver %d entradas de la obra \"%s\" en el teatro \"%s\"", entradas, miTeatro.tieneObra() ? miTeatro.getObra() : "---", miTeatro.getNombreTeatro())));
            miTeatro.devolverEntradas(entradas);
            consulta.append("Devolución realizada con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    public static void devolverEntradaTeatro(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando devolver 1 entrada de la obra \"%s\" en el teatro \"%s\"", miTeatro.tieneObra() ? miTeatro.getObra() : "---", miTeatro.getNombreTeatro())));
            miTeatro.devolverEntrada();
            consulta.append("Devolución realizada con éxito.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    public static void llenarTeatro(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando llenar el teatro \"%s\"", miTeatro.getNombreTeatro())));
            miTeatro.llenarTeatro();
            consulta.append("Llenado realizado correctamente.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    public static void vaciarTeatro(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando vaciar el teatro \"%s\"", miTeatro.getNombreTeatro())));
            miTeatro.vaciarTeatro();
            consulta.append("Vaciado realizado correctamente.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            consulta.append(String.format("Número de entradas vendidas para la obra actual: %d\n", miTeatro.getEntradasVendidas()));
            consulta.append(String.format("Número de entradas vendidas totales: %d\n", Teatro.getEntradasVendidasTotales()));
        }
        System.out.print(consulta);
    }

    /*
    COMENTAR A PARTIR DE ESTA LÍNEA PARA PROBAR EL PROGRAMA DE PRUEBAS "Pruebas05.java"
     */
    public static void traspasarObraTeatro(Teatro teatroOrigen, Teatro teatroDestino) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando traspasar la obra \"%s\" %s ", teatroOrigen.tieneObra() ? teatroOrigen.getObra() : "---",
                    teatroDestino == null ? "a un teatro que no existe" : "al teatro \"" + teatroDestino.getNombreTeatro() + "\"")));
            teatroOrigen.traspasarObra(teatroDestino);
            consulta.append("Traspaso realizado con éxito.\n");
        } catch (IllegalStateException | NullPointerException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()));
        } finally {
            if (teatroDestino != null && teatroDestino.tieneObra()) {
                consulta.append(String.format("\nRepresentándose la obra \"%s\" en el teatro \"%s\"\n", teatroDestino.getObra(), teatroDestino.getNombreTeatro()));
                consulta.append(String.format("Número de entradas vendidas: %d\n", teatroDestino.getEntradasVendidas()));
            }
        }
        System.out.print(consulta);
    }

    /*
    COMENTAR A PARTIR DE ESTA LÍNEA PARA PROBAR EL PROGRAMA DE PRUEBAS "Pruebas06.java"
     */
    public static String consultaToString(Teatro miTeatro) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera(String.format("MÉTODO TO STRING DE OBJETO TEATRO %s", miTeatro.getCodigoTeatro())));
        consulta.append(String.format("Resultado del toString del Teatro \"%s\":\n", miTeatro.getNombreTeatro()));
        consulta.append(String.format("%s\n", miTeatro.toString()));
        return consulta.toString();
    }

}