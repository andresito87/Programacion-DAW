package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import org.h2.tools.Server;
import static java.lang.System.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.stream.Collectors;
import utilidades.ES;

/**
 * Clase principal de inicio del programa.
 *
 * @author Profesorado
 */
public class Aplicacion {

    /**
     * Nombre del archivo de base de datos local.
     */
    private static final String DB_NOMBRE = "proyectobase.h2db";
    /**
     * URL para la conexión a la base de datos.
     */
    private static final String URL_CONEXION = "jdbc:h2:./" + DB_NOMBRE;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "org.h2.Driver";
    /**
     * Opciones de conexión.
     */
    private static final String PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB = "/resources/creaBD.sql";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String INSERTA_DB = "/resources/cargaBD.sql";

    /**
     * Método principal de la aplicación. En él se realiza la preparación del
     * entorno antes de empezar. A destacar:
     *
     * - Se carga el driver (Class.forName). - Se establece una conexión con la
     * base de datos (DriverManager.getConnection) - Se crean las tablas, si no
     * están creadas, invocando el método createTables. - Se ejecuta una
     * consulta de prueba
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean driverCargado = false;

        //Carga del driver de la base de datos.
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            driverCargado = true;
        } catch (ClassNotFoundException e) {
            err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        } catch (InstantiationException | IllegalAccessException ex) {
            err.printf("No se ha podido iniciar el driver de la base de datos (%s)\n", DRIVER);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Si el driver está cargado, aseguramos que podremos conectar.
        if (driverCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            String[] wsArgs = {"-baseDir", System.getProperty("user.dir"), "-browser"};
            try (Connection con = DriverManager.getConnection(URL_CONEXION + PARAMS, "", "")) {

                // Iniciamos el servidor web interno (consola H2 para depuraciones)
                Server sr = Server.createWebServer(wsArgs);
                sr.start();

                // Presentamos información inicial por consola
                out.println("¡¡Atención!!");
                out.println();
                out.println("Mientras tu aplicación se esté ejecutando \n"
                        + "puedes acceder a la consola de la base de datos \n"
                        + "a través del navegador web.");
                out.println();
                out.println("Página local: " + sr.getURL());
                out.println();
                out.println("Datos de acceso");
                out.println("---------------");
                out.println("Controlador: " + DRIVER);
                out.println("URL JDBC: " + URL_CONEXION);
                out.println("Usuario: (no indicar nada)");
                out.println("Password: (no indicar nada)");

                // Creamos las tablas y algunos datos de prueba si no existen
                // y continuamos
                if (crearTablas(con)) {

                    // Insertar los datos en las tablas de la BD
                    insertarDatosTablas(con);

                    boolean continuar = true;

                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println("----------------  MENÚ DE LA APLICACIÓN ----------------");
                        System.out.println("------------ ---------------------------- --------------");
                        System.out.println("1 - Consultar conductores");
                        System.out.println("2 - Consultar coches");
                        System.out.println("3 - Consultar suma de gasto total de todos los trayectos");
                        System.out.println("4 - Modificar matrícula de coche");
                        System.out.println("5 - Borrar conductor");
                        System.out.println("0 - Salir");
                        System.out.println("--------------------------------------------------------");
                        System.out.println("--------------------------------------------------------");
                        System.out.println();
                        System.out.println();

                        // Leer la opción correspondiente a ejecutar.
                        int opcion = ES.leeEntero("Escriba opción: ", 0, 5);
                        switch (opcion) {
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                consultarConductores(con);
                                break;
                            case 2:
                                consultarCoches(con);
                                break;

                            case 3:
                                consultarSumaGasto(con);
                                break;

                            case 4:
                                modificarMatricula(con);
                                break;

                            case 5:
                                borrarConductor(con);
                                break;
                        }
                    } while (continuar);

                    // Esperar tecla
                    ES.leeCadena("Antes de terminar, puedes acceder a la "
                            + "consola de H2 para ver y modificar la base de "
                            + "datos. Pulsa cualquier tecla para salir.");

                } else {
                    System.err.println("Problema creando las tablas.");

                }

                sr.stop();
                sr.shutdown();

            } catch (SQLException ex) {
                err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NOMBRE);
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
    public static boolean crearTablas(Connection con) {
        boolean todoBien = false;

        try (Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return todoBien;
    }

    /**
     * Dada una conexión válida, lleva a cabo la inserción de datos de la base
     * de datos, usando como SQL para la creación el contenido en la constante
     * INSERTA_DB
     *
     * @param con conexión a la base de datos.
     * @see INSERTA_DB
     * @return true si se creo la estructura y false en caso contrario.
     */
    private static boolean insertarDatosTablas(Connection con) {
        boolean todoBien = false;

        try (Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(INSERTA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", INSERTA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.err.printf("Problema insertando datos en la base de datos.\n");
        }
        return todoBien;
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
     * Consultar los conductores de la base de datos
     *
     * @param con Conexión a la BD
     */
    private static void consultarConductores(Connection con) {

        try (Statement consulta = con.createStatement()) {
            //creamos la sentencia SELECT para realizar la consulta
            if (consulta.execute("SELECT nss, nombre, apellidos FROM conductor")) {
                System.out.println("------------ Listado de conductores -------------------");
                System.out.println("NSS   Nombre              Apellidos");
                System.out.println("----- ------------------- ---------------------------");
                ResultSet resultados = consulta.getResultSet();
                //recorremos el resultset
                while (resultados.next()) {
                    int numSeguridadSocial = resultados.getInt("nss");
                    String nombre = resultados.getString("nombre");
                    String apellidos = resultados.getString("apellidos");
                    System.out.printf("%-5d %-19s %-20s \n", numSeguridadSocial, nombre, apellidos);
                }
            } else {
                System.out.println("No hay conductores en la base de datos");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Modificar la matrícula del coche cuyo número de bástidor se introduzca
     * por teclado.
     *
     * @param con Conexión a la BD
     */
    private static void modificarMatricula(Connection con) {
        //leemos parametros de la query(numero de bastidor y matricula)
        int numBastidor = ES.leeEntero("Escriba el número de bastidor cuya matrícula se cambiará: ");
        String matricula = ES.leeCadena("Escriba la nueva matrícula: ");
        //creamos la sentencia update para realizar la actualizacion
        String updateMatricula = "UPDATE COCHE SET MATRICULA = ? WHERE N_BASTIDOR = ?";

        try (PreparedStatement consulta = con.prepareStatement(updateMatricula)) {
            //colocamos los parámetros de la query
            consulta.setString(1, matricula);
            consulta.setInt(2, numBastidor);
            consulta.executeUpdate();
            if (consulta.getUpdateCount() > 0) {
                System.out.println("Modificación correcta.");
            } else {
                System.out.println("No se realizó ninguna modificación en la base de datos.");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Borrar conductor de la BD
     *
     * @param con Conexión a la BD
     */
    private static void borrarConductor(Connection con) {

        // Leer el NSS del conductor
        int numSeguridadSocial = ES.leeEntero("Escriba el NSS del conductor a borrar: ");

        //Creamos la sentencia SQL de borrado
        String deleteConductor = "DELETE FROM CONDUCTOR WHERE NSS = ?";
        try (PreparedStatement consulta = con.prepareStatement(deleteConductor)) {
            //colocamos el parámetro en la query
            consulta.setInt(1, numSeguridadSocial);
            consulta.executeUpdate();
            if (consulta.getUpdateCount() > 0) {
                System.out.printf("Borrado conductor con código %d correctamente", numSeguridadSocial);
            } else {
                System.out.println("No se realizó ningún borrado en la base de datos.");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Consultar los coches de la base de datos
     *
     * @param con Conexión a la BD
     */
    private static void consultarCoches(Connection con) {

        try (Statement consulta = con.createStatement()) {
            //creamos la sentencia Select para realizar la consulta a la base de datos
            if (consulta.execute("SELECT n_bastidor, matricula, marca, modelo, color FROM coche")) {
                System.out.println("------------------- Listado de coches --------------------");
                System.out.println("N_Bastidor Matrícula   Marca        Modelo     Color");
                System.out.println("---------- ----------  ------------ ---------- -----------");
                ResultSet resultados = consulta.getResultSet();
                //recorremos el resultset de datos obtenidos por la consulta Select
                while (resultados.next()) {
                    //para cada registro guardamos los valores de sus campos
                    int numBastidor = resultados.getInt("n_bastidor");
                    String matricula = resultados.getString("matricula");
                    String marca = resultados.getString("marca");
                    String modelo = resultados.getString("modelo");
                    String color = resultados.getString("color");
                    //mostramos por pantalla la información
                    System.out.printf("%10d %-11s %-12s %-10s %-10s\n",
                            numBastidor, matricula, marca, modelo, color);
                }
            } else {
                System.out.println("No hay conductores en la base de datos");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
        }

    }

    /**
     * Consultar la suma del gasto
     *
     * @param con
     */
    private static void consultarSumaGasto(Connection con) {

        try (Statement consulta = con.createStatement()) {
            //creamos la sentencia Select usando sum() para sumar los valores de un campo
            if (consulta.execute("SELECT sum(gastorepostaje) as gastoTotal FROM trayecto")) {
                System.out.println("------------------ Total de gasto en todos los trayectos -------------------");
                ResultSet resultados = consulta.getResultSet();
                //la consulta solo devuelve un valor, no necesitamos while()
                resultados.next();
                double gastoTotal = resultados.getDouble("gastoTotal");
                System.out.printf("El total en euros de los gastos en "
                        + "repostaje de los trayectos es: %10.2f \n", gastoTotal);
            } else {
                System.out.println("No hay naves en la base de datos");
            }
        } catch (SQLException ex) {
            System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
        }

    }
}
