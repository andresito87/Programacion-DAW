package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.err;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

/**
 * Aplicación principal del programa.
 *
 * @author Profesor
 */
public class Aplicacion {

    /**
     * Nombre de la base de datos.
     */
    private static final String DB_NAME = "PROYECTOBASE";
    /**
     * URL para la conexión a la base de datos. Modificar "localhost" si la base
     * de datos está en otro sistema.
     */
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:33060/" + DB_NAME;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Opciones adicionales de conexión.
     */
    private static final String CU_PARAMS = "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";

    /**
     * UUSUARIO para conectar (dependerá de tu instalación de MySQL)
     */
    private static final String USUARIO = "root";

    /**
     * Password para conectar (dependerá de tu instalación de MySQL)
     */
    private static final String PASSWORD = "root";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB = "/resources/estructuradb.sql";

    /**
     * Método principal de la aplicación. En él se realiza la preparación del
     * entorno antes de empezar. A destacar:
     *
     * - Se carga el DRIVER (Class.forName) - solo necesario para JDBC menor que
     * 4.0. - Se establece una conexión con la base de datos
     * (DriverManager.getConnection) - Se crean las tablas, si no están creadas,
     * invocando el método createTables. - Se ejecuta una consulta de prueba
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean DRIVERCargado = false;

        //Carga del DRIVER de la base de datos (solo necesario JDBC < 4.0).
        try {
            Class.forName(DRIVER);
            DRIVERCargado = true;
        } catch (ClassNotFoundException e) {
            err.printf("No se encuentra el DRIVER de la base de datos (%s)\n", DRIVER);
        }

        //Si el DRIVER está cargado, aseguramos que podremos conectar.
        if (DRIVERCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            System.out.println(CONNECTION_URL + CU_PARAMS);
            try (Connection con = DriverManager.getConnection(CONNECTION_URL + CU_PARAMS, USUARIO, PASSWORD)) {

                /*Creamos las tablas y algunos datos de prueba si no existen
                y continuamos*/
                if (createTables(con)) {
                    //insertamos un registro más en tabla producto
                    nuevoProducto(con, "Producto Nuevo", "51584881370380", 20.7447817594662);

                    //Mostramos los productos almacenados
                    System.out.println("Los productos almacenados son:");
                    mostrarTodosLosProductos(con);

                    //insertamos un registro en la tabla ticket
                    nuevoTicket(con);

                    //mostramos los tickets de la base de datos
                    System.out.println("Los tickets almacenados son:");
                    mostrarTodosLosTickets(con);

                    //buscar y mostrar productos a partir de un precio minimo
                    System.out.println("Los productos con un precio mayor a 18.0 son:");
                    mostrarProductosPrecioMinimo(con, 18.0);

                    //Mostrar los tickets que aun no estan cerrados
                    System.out.println("Los tickets abiertos son:");
                    mostrarTicketsNoCerrados(con);

                    //Actualizar un ticket por id como ticketcerrado
                    cerrarTicket(con, 4);

                    //Borramos los productos del 5 al 10
                    System.out.println("Borrando productos del 5 al 10");
                    for (int i = 5; i <= 10; i++) {
                        borrarProducto(con, i);
                    }

                    //Creacion de lineas de tickets con sus productos y tickets asociados
                    System.out.println("Creando líneas de tickets:");
                    nuevaLineaTicket(con, 3, 2.33, 2, 2);
                    nuevaLineaTicket(con, 3, 2.33, 2, 1000);

                    //Mostrando LíneasTicket
                    System.out.println("Mostrando tabla LineaTicket");
                    mostrarTodosLasLineasTickets(con);

                    //Borrar Productos con verificacion de que no pertenerzca a ninguna líneaTicket
                    System.out.println("Borrando un ticket borrable");
                    borrarProductoConVerificacion(con, 1);
                    System.out.println("Borrando un ticket no borrable");
                    borrarProductoConVerificacion(con, 2);

                } else {
                    err.println("Problema creando las tablas.");

                }

            } catch (SQLException ex) {
                err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NAME);
            }
        }

    }

    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura de la
     * base de datos, usando como SQL para la creación el contenido en la
     * constante ESTRUCTURA_DB
     *
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creo la estructura y false en caso contrario.
     */
    public static boolean createTables(Connection con) {
        boolean ok = false;

        try (Statement st = con.createStatement()) {
            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);

            if (sqlScript != null) {
                String sqlSentences[] = sqlScript.split(";");
                for (String sqlSentence : sqlSentences) {
                    if (!sqlSentence.trim().isEmpty()) {
                        st.execute(sqlSentence);
                    }
                }
                ok = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return ok;
    }

    /**
     * Carga un recurso que estará dentro del JAR como cadena de texto.
     *
     * @param resourceName Nombre del recurso dentro del JAR.
     * @return Cadena que contiene el contenido del archivo.
     */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }

    /**
     * Método que inserta un nuevo producto en la base de datos.
     *
     * @param con Conexión con la base de datos.
     * @param nombre Nombre del nuevo producto.
     * @param barcode Nombre del código de barras.
     * @param precio Nombre del precio.
     * @return Id del producto recién creado.
     */
    public static long nuevoProducto(Connection con, String nombre,
            String barcode, double precio) {
        String query = "INSERT INTO PRODUCTO (nombre, barcode, precio) VALUES (?,?,?)";
        long id = -1;
        if (con != null) {

            try (PreparedStatement consulta = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS)) {

                consulta.setString(1, nombre);
                consulta.setString(2, barcode);
                consulta.setDouble(3, precio);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    ResultSet m = consulta.getGeneratedKeys();
                    if (m.next()) {
                        id = m.getLong(1);
                        System.out.printf("Producto insertado con ID=%d\n", id);
                    }
                } else {
                    System.out.println("El producto no ha podido ser insertado.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
        return id;
    }

    /**
     * Método para mostrar los productos almacenados
     *
     * @param con Conexión con la base de datos.
     */
    public static void mostrarTodosLosProductos(Connection con) {
        try (Statement consulta = con.createStatement()) {
            if (consulta.execute("SELECT id,nombre,precio FROM PRODUCTO")) {
                ResultSet resultados = consulta.getResultSet();
                while (resultados.next()) {
                    long id = resultados.getLong("id");
                    String nombre = resultados.getString("nombre");
                    double precio = resultados.getDouble("precio");
                    System.out.printf("%5d %-15s %10.2f\n", id, nombre, precio);
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
        }
    }

    /**
     * Método que inserta un nuevo ticket en la base de datos
     *
     * @param con Conexión con la base de datos.
     * @return Id del producto recién creado.
     */
    public static long nuevoTicket(Connection con) {
        String query = "INSERT INTO TICKET (fecha, hora, ticketcerrado) VALUES (?,?,false)";
        long id = -1;
        if (con != null) {

            try (PreparedStatement consulta = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS)) {

                java.sql.Date fecha = java.sql.Date.valueOf(LocalDate.now());
                java.sql.Time hora = java.sql.Time.valueOf(LocalTime.now());
                consulta.setDate(1, fecha);
                consulta.setTime(2, hora);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    ResultSet m = consulta.getGeneratedKeys();
                    if (m.next()) {
                        id = m.getLong(1);
                        System.out.printf("Ticket creado con ID=%d\n", id);
                    }
                } else {
                    System.out.println("El ticket no ha podido ser creado.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
        return id;
    }

    /**
     * Método que muestra todos los tickets
     *
     * @param con Conexión con la base de datos.
     */
    public static void mostrarTodosLosTickets(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                ResultSet resultados = consulta.executeQuery("SELECT id,fecha,hora,ticketcerrado FROM TICKET");

                while (resultados.next()) {
                    long id = resultados.getLong("id");
                    Date fecha = resultados.getDate("fecha");
                    Time hora = resultados.getTime("hora");
                    boolean estaCerrado = resultados.getBoolean("ticketcerrado");
                    System.out.printf("%-5d %-12s %s %7b\n", id, fecha.toString(), hora.toString(), estaCerrado);
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }

    /**
     * Método para buscar y mostrar productos a partir de un precio mínimo
     *
     * @param con Conexión con la base de datos.
     * @param precioMinimo Precio mínimo a partir del que buscar
     */
    public static void mostrarProductosPrecioMinimo(Connection con, double precioMinimo) {
        String query = "SELECT id,nombre,precio FROM PRODUCTO WHERE precio>=?";
        if (con != null) {
            try (PreparedStatement consulta = con.prepareStatement(query)) {
                consulta.setDouble(1, precioMinimo);
                if (consulta.execute()) {
                    ResultSet resultados = consulta.getResultSet();
                    while (resultados.next()) {
                        long id = resultados.getLong("id");
                        String nombre = resultados.getString("nombre");
                        double precio = resultados.getDouble("precio");
                        System.out.printf("%5d %-15s %10.2f\n", id, nombre, precio);
                    }
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }

    /**
     * Método que ejecuta una consulta tipo SELECT para mostrar todos los
     * tickets que no están cerrados.
     *
     * @param con Conexión con la base de datos.
     */
    public static void mostrarTicketsNoCerrados(Connection con) {
        String query = "SELECT id,fecha,hora FROM TICKET WHERE TICKETCERRADO=false";
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                ResultSet resultados = consulta.executeQuery(query);
                while (resultados.next()) {
                    long id = resultados.getLong("id");
                    LocalDate fecha = resultados.getDate("fecha").toLocalDate();
                    LocalTime hora = resultados.getTime("hora").toLocalTime();
                    System.out.printf("%5d %-15s %-15s\n", id, fecha.toString(), hora.toString());
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }

    /**
     * Método que actualizada el registro por el id con ticketcerrado=true
     *
     * @param con Conexión con la base de datos.
     * @param id Id del ticket cuyo campo va a ser actualizado.
     */
    public static void cerrarTicket(Connection con, long id) {
        String query = "UPDATE TICKET SET ticketcerrado=true WHERE id=?";
        if (con != null) {

            try (PreparedStatement consulta = con.prepareStatement(query)) {

                consulta.setLong(1, id);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.printf("El ticket con id %d ha sido cerrado.\n", id);
                } else {
                    System.out.printf("El ticket con id %d no ha podido ser cerrado, no existe.\n", id);
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
            }
        }
    }

    /**
     * Método que borra un producto de la base de datos por su id
     *
     * @param con Conexión con la base de datos.
     * @param id Id del producto.
     */
    public static void borrarProducto(Connection con, long id) {
        String queryDelete = "DELETE FROM PRODUCTO WHERE id=?";
        if (con != null) {
            try (PreparedStatement consultaDelete = con.prepareStatement(queryDelete)) {
                consultaDelete.setLong(1, id);
                int registrosAfectados = consultaDelete.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.println("El producto ha sido eliminado correctamente");
                } else {
                    System.out.println("El producto no ha sido eliminado, porque no existe.");
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
    }

    /**
     * Método que borra un producto verificando
     *
     * @param con Conexión con la base de datos.
     * @param id Id del producto.
     */
    public static void borrarProductoConVerificacion(Connection con, long id) {
        /*Consulta 1: Comprobar que no hay ninguna lineaticket que esté usando el producto. */
        String querySelect = "SELECT count(*) FROM LINEATICKET WHERE producto_id=?";
        /*Consulta 2: Eliminar el producto */
        String queryDelete = "DELETE FROM PRODUCTO WHERE id=?";
        int recuento = -1;
        if (con != null) {
            try (PreparedStatement consultaSelect = con.prepareStatement(querySelect)) {

                consultaSelect.setLong(1, id);

                ResultSet result = consultaSelect.executeQuery();
                if (result.next()) {
                    recuento = result.getInt(1);
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }

            if (recuento == 0) {
                try (PreparedStatement consultaDelete = con.prepareStatement(queryDelete)) {

                    consultaDelete.setLong(1, id);
                    int registrosAfectados = consultaDelete.executeUpdate();
                    if (registrosAfectados > 0) {
                        System.out.println("El producto ha sido eliminado correctamente");
                    } else {
                        System.out.println("El producto no ha sido eliminado, porque no existe.");
                    }
                } catch (SQLException ex) {
                    System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
                }
            } else if (recuento != -1) {
                System.out.println("El producto no se puede eliminar porque ya aparece en líneas de ticket.");
            }
        }
    }

    /**
     * Método que crea una nueva LineaTicket realizando las comprobaciones
     * oportunas
     *
     * @param con Conexión con la base de datos.
     * @param cantidad cantidad de productos del ticket
     * @param precio precio del ticket
     * @param idproducto Id del producto del ticket
     * @param idticket Id del ticket asociado a la lineaIicket
     * @return
     */
    public static long nuevaLineaTicket(Connection con, int cantidad, double precio,
            long idproducto, long idticket) {
        String query = "INSERT INTO LINEATICKET (CANTIDAD,PRECIOVENTA,PRODUCTO_ID,TICKET_ID) VALUES (?,?,?,?);";
        long id = -1;
        if (con != null) {

            try (PreparedStatement consulta = con.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS)) {

                consulta.setInt(1, cantidad);
                consulta.setDouble(2, precio);
                consulta.setLong(3, idproducto);
                consulta.setLong(4, idticket);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    ResultSet m = consulta.getGeneratedKeys();
                    if (m.next()) {
                        id = m.getLong(1);
                        System.out.printf("LineaTicket creada con ID=%d\n", id);
                    }
                } else {
                    System.out.println("La línea de ticket no ha podido ser creada.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
                System.err.printf("SQLState: %s\n", ex.getSQLState());
                System.err.printf("SQLError: %s\n", ex.getMessage());
            }
        }
        return id;
    }

    public static void mostrarTodosLasLineasTickets(Connection con) {
        try (Statement consulta = con.createStatement()) {
            if (consulta.execute("SELECT id,cantidad,precioventa,producto_id,ticket_id FROM LINEATICKET")) {
                ResultSet resultados = consulta.getResultSet();
                while (resultados.next()) {
                    long id = resultados.getLong("id");
                    int cantidad = resultados.getInt("cantidad");
                    double precio = resultados.getDouble("precioventa");
                    int idProducto = resultados.getInt("producto_id");
                    int idTicket = resultados.getInt("ticket_id");
                    System.out.printf("%3d %3d %5.2f %d %d\n", id, cantidad, precio, idProducto, idTicket);
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
        }
    }
}
