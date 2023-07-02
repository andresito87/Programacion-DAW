package juego;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * El clásico Pong de dos jugadores donde el jugador de la izquierda mueve la
 * pala o raqueta con las teclas W y S, y el jugador de la derecha la mueve con
 * las teclas de arriba y abajo del cursor.
 *
 * @author profesorado
 */
public class PongFX extends Application {

    /**
     * Tamaño de la pantalla en ancho
     */
    public static final int WIDTH = 800;
    /**
     * Tamaño de la pantalla en alto
     */
    public static final int HEIGHT = 600;

    /**
     * Anchura de cada pala
     */
    public static final int ANCHURA_PALA = 7;
    /**
     * Altura de cada pala
     */
    public static final int ALTURA_PALA = 50;

    /**
     * Tamaño de la pelota
     */
    public static final int TAMANO_PELOTA = 6;

    /**
     * Coordenadas del eje X donde se ubica laa pala izquierda
     */
    public static final int POSICION_X_PALA_IZQUIERDA = 100;
    /**
     * Coordenadas del eje X donde se ubica laa pala derecha
     */
    public static final int POSICION_X_PALA_DERECHA = 700;

    /**
     * Número de vidas, en este caso de juegos para terminar la partida
     */
    public static final int NUM_VIDAS = 3;

    /**
     * Tamaño del texto para los marcadores
     */
    public static final int TEXT_SIZE = 30;

    /**
     * URL del sonido que se reproduce al marcar punto alguno de los dos
     * jugadores
     */
    public static final String SONIDO_PUNTO = "src/recursos/336913__the-sacha-rush__coin1.wav";
    /**
     * URL del sonido que se reproduce al rebotar la pelota
     */
    public static final String SONIDO_REBOTE = "src/recursos/rebote.wav";
    /**
     * URL del sonido que se reproduce al terminar la partida
     */
    public static final String SONIDO_GAMEOVER = "src/recursos/pacman-dies.wav";
    /**
     * URL del icono del juego
     */
    public static final String ICONO = "file:src/recursos/palas.jpg";

    // Coordenada X de la pelota. La primera vez la pelota se iniciará desde la
    // izquierda más un poco
    private int posXpelota = PongFX.POSICION_X_PALA_IZQUIERDA + 10;
    // La pelota irá avanzando en X según este atributo
    private int velocidadActualX = 3;

    // Coordenada Y de la pelota. 
    private int posYpelota = 30;
    // La pelota irá avanzando en Y según este atributo
    private int velocidadActualY = 3;

    /**
     * Atributos de posición y velocidad de la pala derecha
     */
    //cambio el 200 por esa expresion para que aparezca la pala centrada
    //sino lo hago tendría que repetir la expresion en dos lugares diferentes
    private int posicionYpalaDerecha = (PongFX.HEIGHT - PongFX.ALTURA_PALA) / 2;
    private int velocidadPalaDerecha = 0;

    /**
     * Atributos de posición y velocidad de la pala izquierda
     */
    //cambio el 200 por esa expresion para que aparezca la pala centrada
    //sino lo hago tendría que repetir la expresion en dos lugares diferentes
    private int posicionYpalaIzquierda = (PongFX.HEIGHT - PongFX.ALTURA_PALA) / 2;
    private int velocidadPalaIzquierda = 0;

    // Contador de puntos de cada jugador
    private int puntosJugadorDerecho;
    private int puntosJugadorIzquierdo;

    // Texto para los puntos de cada jugador
    private Text puntosDer, puntosIzq;

    /**
     * Cuando uno de los dos jugadores gane el punto,se ejecuta este método para
     * sacar la pelota de nuevo, estableciendo los valores posXpelota,
     * posYpelota y velocidadActualX
     */
    private void iniciarSiguientePunto() {
        // Establecer la posición X de la pelota como POSICION_X_PALA_IZQUIERDA + 10 por ejemplo
        this.posXpelota = PongFX.POSICION_X_PALA_IZQUIERDA + 10;
        // Establecer la velocidad actual X a 3
        this.velocidadActualX = 3;
        // Establecer la posición Y de la polota como un número aleatorio entero entre 0 y HEIGHT
        Random numeroAleatorio = new Random();
        this.posYpelota = numeroAleatorio.nextInt(PongFX.HEIGHT + 1);
    }

    /**
     * Dibuja la red y los marcadores de cada jugador
     *
     * @param root Panel donde se representa el juego
     */
    private void dibujarRedYmarcador(Pane panelDeJuego) {
        // Dibujar red con un bucle como se ve en el turorial del tema
        for (int i = 0; i < PongFX.HEIGHT; i += 29) {
            Line line = new Line(PongFX.WIDTH / 2, i, PongFX.WIDTH / 2, i += 10);
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(5);
            panelDeJuego.getChildren().add(line);
        }

        // Dibujar texto de pntuaciones, podemos usar un panales HBox,
        // unos Text para el texto del marcador
        HBox puntuaciones = new HBox();
        puntuaciones.setTranslateY(20);
        puntuaciones.setMinWidth(PongFX.WIDTH / 2);
        puntuaciones.setAlignment(Pos.CENTER);
        puntuaciones.setSpacing(100);
        panelDeJuego.getChildren().add(puntuaciones);
        HBox jugadores = new HBox();
        jugadores.setSpacing(10);
        puntuaciones.getChildren().add(jugadores);
        // Texto del marcador de jugador izquierdo
        Text jugador1 = new Text("Jugador 1:");
        jugador1.setStyle(String.format("-fx-font-size: %dpx; -fx-font-weight: bold;", PongFX.TEXT_SIZE));
        jugador1.setTranslateX(50);
        jugador1.setFill(Color.CYAN);

        if (this.puntosIzq != null) {
            this.puntosIzq.setText(String.valueOf(this.puntosJugadorIzquierdo));
        } else {
            this.puntosIzq = new Text(String.valueOf(this.puntosJugadorIzquierdo));
            this.puntosIzq.setFont(Font.font(PongFX.TEXT_SIZE));
            this.puntosIzq.setTranslateX(-10);
            this.puntosIzq.setFill(Color.CYAN);
            // Añadir el texto al layout
            puntuaciones.getChildren().add(jugador1);
            puntuaciones.getChildren().add(this.puntosIzq);
        }

        // Texto de puntuación del jugador 2
        Text jugador2 = new Text("Jugador 2:");
        jugador2.setStyle(String.format("-fx-font-size: %dpx; -fx-font-weight: bold;", PongFX.TEXT_SIZE));
        jugador2.setTranslateX(-20);
        jugador2.setFill(Color.RED);
        if (this.puntosDer != null) {
            this.puntosDer.setText(String.valueOf(this.puntosJugadorDerecho));
        } else {
            this.puntosDer = new Text(String.valueOf(this.puntosJugadorDerecho));
            this.puntosDer.setFont(Font.font(TEXT_SIZE));
            this.puntosDer.setTranslateX(-80);
            this.puntosDer.setFill(Color.RED);
            //Añadir el texto al layout
            puntuaciones.getChildren().add(jugador2);
            puntuaciones.getChildren().add(this.puntosDer);
        }
    }

    /**
     * Método de arranque de la aplicación
     *
     * @param escenario Escenario de la aplicación
     */
    @Override
    public void start(Stage escenario) {

        // Panel donde se desarrollará el juego
        Pane panelDeJuego = new Pane();

        // Escena
        Scene scene = new Scene(panelDeJuego, PongFX.WIDTH, PongFX.HEIGHT);

        // Fondo negro
        panelDeJuego.setStyle("-fx-background-color:black");

        // Dibujar red y marcador
        this.dibujarRedYmarcador(panelDeJuego);

        // Definir las teclas para el movimiento de las palas
        this.definirMovimientoTeclas(scene);

        // Crear la pelota
        Circle pelota = new Circle(posXpelota, posYpelota, PongFX.TAMANO_PELOTA);
        pelota.setFill(Color.YELLOW);
        //pelota.setFill(Paint.valueOf("yellow")); otra alternativa

        // Añadir la pelota al panel
        panelDeJuego.getChildren().add(pelota);

        // Dibujar la pala derecha y añadirla al panel
        Rectangle palaDerecha = new Rectangle(PongFX.POSICION_X_PALA_DERECHA,
                posicionYpalaDerecha, PongFX.ANCHURA_PALA, PongFX.ALTURA_PALA);
        palaDerecha.setFill(Color.RED);
        panelDeJuego.getChildren().add(palaDerecha);

        // Dibular la pala izquierda y añadirla al panel
        Rectangle palaIzquierda = new Rectangle(PongFX.POSICION_X_PALA_IZQUIERDA,
                posicionYpalaIzquierda, PongFX.ANCHURA_PALA, PongFX.ALTURA_PALA);
        palaIzquierda.setFill(Color.CYAN);
        panelDeJuego.getChildren().add(palaIzquierda);

        // Iniciar puntos de cada jugador
        this.puntosDer.setText(String.valueOf(this.puntosJugadorDerecho));
        this.puntosIzq.setText(String.valueOf(this.puntosJugadorIzquierdo));

        // Se usa una línea de tiempo para definir una animación.
        // La idea básica en una animaciones JavaFX es manipular el valor de una
        // o más propiedades de un nodo a intervalos regulares. Por ejemplo, 
        // en el caso que nos ocupa, tenemos un círculo que representa una bola
        // y se desea moverlo desde un lado de la pantalla hacia el otro.
        Timeline animacion = new Timeline();
        // Crear un KeyFrame, un punto de referencia que se agregará a la línea
        // de tiempo. Una línea de tiempo funciona empleando KeyFrames como 
        // puntos de referencia en la animación.
        // Observa que en la creación del objeto se pasa por parámetro
        // un objeto KeyFrame al que se le indica cada cuánto tiempo se 
        // ejecutarán las acciones, se indica 0.017 para que se ejecute cada 
        // 0.017 segundos que equivale a unos 60 frames por segundo.
        KeyFrame kf = new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {

            // Comprobar si es fin de juego según los puntos que lleve
            this.esFinDeJuego(panelDeJuego, animacion);

            // Define la posición horizontal del centro de la pelota en pixels.
            pelota.setCenterX(this.posXpelota);

            // Incrementamos el valor de atributo de la posición horizontal
            this.posXpelota += this.velocidadActualX;

            // Comprobar si la pelota debe rebotar horizontalmente, es decir,
            // cambiar la dirección si se ha llegado al final o al principio de 
            // la pantalla a la derecha o a la izquierda
            //if (posición X de la pelota mayor o igual que la anchura de la pantalla)
            // Poner la velocidadActualX a -3
            if (this.posXpelota >= PongFX.WIDTH) {
                this.velocidadActualX *= (-1);
            }

            //if (posición X de la pelota es menor o igual que  0)
            // Pone velocidadActualX a  3 
            if (this.posXpelota <= 0) {
                this.velocidadActualX *= (-1);
            }

            // Define la posición vertical del centro de la pelota en pixels.
            pelota.setCenterY(this.posYpelota);

            // Incrementamos el valor de atributo de la posición vertical
            this.posYpelota += this.velocidadActualY;

            // Comprobar si la pelota debe rebotar, es decir cambiar la dirección
            //if (posición Y de la pelota es mayor o igual que la altura de la pantalla) {
            // Poner la velocidadActualY a -3 
            if (this.posYpelota >= PongFX.HEIGHT) {
                this.velocidadActualY *= (-1);

                // Reproducir sonido de rebote
                this.reproducirSonido(PongFX.SONIDO_REBOTE);

            }
            // Comprobar si la pelota debe rebotar, es decir cambiar la dirección
            // si se ha llegado arriba o abajo de la pantalla
            //if (posición Y de la pelota es menor o igual que 0) {
            // Poner la velocidadActualY a 3 
            if (this.posYpelota <= 0) {
                this.velocidadActualY *= (-1);

                // Reproducir sonido de rebote
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
            }

            // Actualizar la posición de las palas cuidando que no se salgan de la pantalla
            this.actualizarPosicionPalas(palaIzquierda, palaDerecha);

            // Comprobar colisión con pala derecha        
            int zonaColision = this.getZonaColisionEnLaPala(pelota, palaDerecha);
            this.calcularVelocidadPelotaPalaDer(zonaColision);

            // Comprobar colisión con pala izquierda            
            zonaColision = this.getZonaColisionEnLaPala(pelota, palaIzquierda);
            this.calcularVelocidadPelotaPalaIzq(zonaColision);

        }
        );

        // Añadir el keyframe a la animación
        animacion.getKeyFrames().addAll(kf);
        // Establecer el ciclo de la nimación indefinido
        animacion.setCycleCount(Timeline.INDEFINITE);
        // Poner en marcha la animación        
        animacion.play();

        // Título de la ventana
        escenario.setTitle("Pong con JavaFX");
        // Icono de la aplicación
        escenario.getIcons().add(new Image(PongFX.ICONO));
        // Establecer la escena        
        escenario.setScene(scene);
        // Mostrar el escenario
        escenario.show();
    }

    /**
     * Método para averiguar la zona de contacto de la pelota con la pala. La
     * variable offsetBallStick almacena la distancia que se detecta entre la
     * posición del rectángulo (la pala) y centro de la bola. Si ese valor es
     * menor que el 10% de la altura de la pala se considerará que ha contactado
     * en la zona 1. Si no es ese caso, se comprueba si ha contactado de la
     * mitad de la pala hacia arriba, en cuyo caso sería la zona 2. Se considera
     * que ha contactado en la zona 3 si la posición de la bola es mayor al
     * centro de la pala y menor que el 90% de su altura. La zona de contacto se
     * considera la 4 si el punto de contacto es mayor que el 90% del tamaño de
     * la pala. Ver en:
     * https://javiergarciaescobedo.es/programacion-en-java/93-proyectos-de-aula/478-programacion-java-desarrollando-el-juego-pong-con-javafx-parte-ix
     *
     * @param pelota Pelota
     * @param pala Pala
     * @return Valor 0 si no hay contacto o bien 1, 2 o 3 según la zona.
     */
    private int getZonaColisionEnLaPala(Circle pelota, Rectangle pala) {
        int valor = 0;

        Shape figuraColision = Shape.intersect(pelota, pala);
        boolean hayColision = !figuraColision.getBoundsInLocal().isEmpty();
        if (hayColision) {
            double distanciaEntrePalaYPelota = pelota.getCenterY() - pala.getY();
            if (distanciaEntrePalaYPelota < pala.getHeight() * 0.1) {
                valor = 1;
            } else if (distanciaEntrePalaYPelota < pala.getHeight() / 2) {
                valor = 2;
            } else if (distanciaEntrePalaYPelota < pala.getHeight() / 2
                    && distanciaEntrePalaYPelota < pala.getHeight() * 0.9) {
                valor = 3;
            } else {
                valor = 4;
            }
        }

        return valor;
    }

    /**
     * Según la zona de la pala derecha donde impacte la pelota se modifican los
     * atributos de velocidadActualX y velocidadActualY de la pelota para que en
     * la animación se vayan incrementando o decrementando la posición, las
     * coordenadas de la pelota segúnm corresponda.
     *
     * @param zonaDeColision Entero de 0 a 4 que representa la zona de la pala
     * donde impacta la pelota.
     */
    private void calcularVelocidadPelotaPalaDer(int zonaDeColision) {

        switch (zonaDeColision) {
            // No hay colisión de la pala con la pelota.
            case 0:
                break;
            // Hay colisión en la esquina superior de la pala
            case 1:
                this.velocidadActualX = -3;
                this.velocidadActualY = -6;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en el lado superior de la pala
            case 2:
                this.velocidadActualX = -3;
                this.velocidadActualY = -3;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en el lado inferior de la pala
            case 3:
                this.velocidadActualX = -3;
                this.velocidadActualY = 3;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en la esquina inferior de la pala
            case 4:
                this.velocidadActualX = -3;
                this.velocidadActualY = 6;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
        }
    }

    /**
     * Según la zona de la pala izquierda donde impacte la pelota se modifican
     * los atributos de velocidadActualX y velocidadActualY de la pelota para
     * que en la animación se vayan incrementando o decrementando la posición,
     * las coordenadas de la pelota segúnm corresponda.
     *
     * @param zonaDeColision Entero de 0 a 4 que representa la zona de la pala
     * donde impacta la pelota.
     */
    private void calcularVelocidadPelotaPalaIzq(int zonaDeColision) {

        // Según la zona de colisión
        switch (zonaDeColision) {
            //No hay colisión
            case 0:
                break;
            // Hay colisión en la esquina superior
            case 1:
                this.velocidadActualX = 3;
                this.velocidadActualY = 6;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en el lado superior
            case 2:
                this.velocidadActualX = 3;
                this.velocidadActualY = 3;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en el lado inferior    
            case 3:
                this.velocidadActualX = 3;
                this.velocidadActualY = -3;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
            // Hay colisión en la esquina inferior
            case 4:
                this.velocidadActualX = 3;
                this.velocidadActualY = -6;
                this.reproducirSonido(PongFX.SONIDO_REBOTE);
                break;
        }
    }

    /**
     * Presenta dos botones: uno para jugar de nuevo una partida y otro para
     * terminar la aplicación y salir al sistema operativo.
     *
     * @param animacion Animación que rige el juego.
     * @param panelPadre Panel donde se desarrolla el juego
     */
    private void seguirOterminar(Timeline animacion, Pane panelPadre) {

        // Parar la animación
        animacion.pause();

        // Crear un panel ancla
        AnchorPane anchorPane = new AnchorPane();

        // Crear el botón de nueva partida
        Button jugarOtravez = new Button("Nueva Partida");
        jugarOtravez.setStyle("-fx-font-size: 2em;");

        // Añadir el manejador al botón de nueva partida
        jugarOtravez.setOnAction((ActionEvent e) -> {
            // Poner marcadores a 0
            this.puntosJugadorDerecho = 0;
            this.puntosJugadorIzquierdo = 0;
            this.puntosDer.setText(String.valueOf(this.puntosJugadorDerecho));
            this.puntosIzq.setText(String.valueOf(this.puntosJugadorIzquierdo));
            //Borrar el panel donde tenemos los botones de jugar o salir
            panelPadre.getChildren().remove(anchorPane);

            // Sacar la pelota de nuevo
            this.iniciarSiguientePunto();

            // Arrancar animación
            animacion.play();
        });

        AnchorPane.setTopAnchor(jugarOtravez, 120.0);
        AnchorPane.setLeftAnchor(jugarOtravez, 10.0);
        AnchorPane.setRightAnchor(jugarOtravez, 220.0);

        // Crear el botón de salir de la aplicación
        Button terminar = new Button("Salir del juego");
        terminar.setStyle("-fx-font-size: 2em;");
        // Añadir EventHandler al botón
        terminar.setOnAction((ActionEvent e) -> {
            // Salir del programa
            Platform.exit();
        });

        AnchorPane.setTopAnchor(terminar, 120.0);
        AnchorPane.setLeftAnchor(jugarOtravez, 205.0);
        AnchorPane.setRightAnchor(terminar, 10.0);

        // Añadir los botones en la parte superior del panel
        anchorPane.getChildren().add(jugarOtravez);
        anchorPane.getChildren().add(terminar);

        // Añadir el panel ancla al panel padre
        panelPadre.getChildren().add(anchorPane);
    }

    /**
     * Comprobar si la pelota ha rebasado la pala y por tanto es punto, además
     * de si se ha llegado al número total de visdas, invocar al método que se
     * encargue de dibujar los botones de jugar otra partida o salir del juego
     *
     * @param root Panel donde se representa el juego
     * @param animacion Animación que rige el juego
     */
    private void esFinDeJuego(Pane root, Timeline animacion) {

        // Si la pelota está más allá de la pala derecha
        if (this.posXpelota > PongFX.POSICION_X_PALA_DERECHA) {
            // Incrementar puntos del jugador izquierdo
            this.puntosJugadorIzquierdo++;
            this.puntosIzq.setText(String.valueOf(this.puntosJugadorIzquierdo));
            // Establecer en el texto del marcador del jugador izquierdo
            this.dibujarRedYmarcador(root);
            // Reproducir sonido al anotar punto
            this.reproducirSonido(PongFX.SONIDO_PUNTO);

            // Comprobar si se acabó la partida, si los puntos del jugador
            // izquierdo es igual a la constante NUM_VIDAS
            if (this.puntosJugadorIzquierdo == PongFX.NUM_VIDAS) {
                // Reproducir sonido al acabar la partida
                this.reproducirSonido(PongFX.SONIDO_GAMEOVER);
                // Preguntar si jugar otra vez o terminar
                this.seguirOterminar(animacion, root);
            } else {
                // Sacar de nuevo la pelota
                this.iniciarSiguientePunto();
            }
        }

        // Si la pelota está más acá de la pala izuquierda es porque
        // ha hecho punto el jugador derecho
        if (this.posXpelota < PongFX.POSICION_X_PALA_IZQUIERDA) {
            // Incrementar puntos del jugador derecho
            this.puntosJugadorDerecho++;
            this.puntosDer.setText(String.valueOf(this.puntosJugadorDerecho));
            // Establecer en el texto del marcador del jugador derecho
            this.dibujarRedYmarcador(root);
            // Reproducir sonido al anotar punto
            this.reproducirSonido(PongFX.SONIDO_PUNTO);

            // Comprobar si se acabó la partida, o sea si los puntos del jugador
            // derecho son igual a la constante NUM_VIDAS
            if (this.puntosJugadorDerecho == PongFX.NUM_VIDAS) {
                // Reproducir sonido al acabar la partida
                this.reproducirSonido(PongFX.SONIDO_GAMEOVER);
                // Preguntar si jugar otra vez o terminar
                this.seguirOterminar(animacion, root);
            } else // Sacar de nuevo la pelota
            {
                this.iniciarSiguientePunto();
            }
        }
    }

    /**
     * Actualizar la posición de las palas cuidando que no se salgan de la
     * pantalla.
     *
     * @param palaIzquierda Objeto de la clase Rectangle que es la pala
     * izquierda.
     * @param palaDerecha Objeto de la clase Rectangle que es la pala derecha.
     */
    private void actualizarPosicionPalas(Rectangle palaIzquierda, Rectangle palaDerecha) {

        // Para la pala derecha, actualizar posición de la pala, es decir,
        // acumular en la posición Y de la pala derecha lo que se tenga más velocidadPalaDerecha
        this.posicionYpalaDerecha += this.velocidadPalaDerecha;

        //Controlar que la palaDerecha no salga de la pantalla. Así
        // Si la posición Y de la pala derecha es menor que 0 entonces la ponesmos a 0
        if (this.posicionYpalaDerecha < 0) {
            //No sobrepasar el borde superior de la ventana
            this.posicionYpalaDerecha = 0;
            // Si no es así    
        } else {
            // Si la posición Y es mayor que la altura menos la altura de la pala
            if (this.posicionYpalaDerecha > PongFX.HEIGHT - PongFX.ALTURA_PALA) {
                // hacemos que la posición Y sea la altura menos la altura de la pala
                this.posicionYpalaDerecha = PongFX.HEIGHT - PongFX.ALTURA_PALA;
            }
        }

        // Establecer con setY la posición Y de la pala derecha
        palaDerecha.setY(this.posicionYpalaDerecha);

        // AQUÍ hacer lo mismo pero para la pala izquierda
        this.posicionYpalaIzquierda += this.velocidadPalaIzquierda;
        if (this.posicionYpalaIzquierda < 0) {
            this.posicionYpalaIzquierda = 0;
        } else {
            if (this.posicionYpalaIzquierda > PongFX.HEIGHT - PongFX.ALTURA_PALA) {
                this.posicionYpalaIzquierda = PongFX.HEIGHT - PongFX.ALTURA_PALA;
            }
        }
        palaIzquierda.setY(this.posicionYpalaIzquierda);
    }

    /**
     * Reproducir el sonido cuya ruta se indique en el parámetro.
     *
     * @param nombreSonido Ruta con el nombre del sonido a reproducir
     */
    public void reproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream
                    = AudioSystem.getAudioInputStream(
                            new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.err.println("Error al reproducir el sonido.");
        }
    }

    /**
     * Definir las teclas para mover las palas arriba y abajo o dejar de
     * moverlas al dejar de presionar las teclas.
     *
     * @param scene La escena donde se desarrolla el juego
     */
    private void definirMovimientoTeclas(Scene scene) {

        // Tratar los eventos de teclado en la escena
        scene.setOnKeyPressed((KeyEvent t) -> {
            switch (t.getCode()) {
                case UP:
                    // Pulsada tecla arriba pala derecha
                    this.velocidadPalaDerecha = -6;
                    break;
                case DOWN:
                    // Pulsada tecla abajo pala derecha
                    this.velocidadPalaDerecha = 6;
                    break;
                case W:
                    // Pulsada tecla arriba pala izquierda
                    this.velocidadPalaIzquierda = -6;
                    break;
                case S:
                    // Pulsada tecla arriba pala izquierda
                    this.velocidadPalaIzquierda = 6;
                    break;
            }
        });

        /**
         * Definir qué pasa cuando se dejen de pulsar las teclas. Cuando se
         * libere la pulsación de las teclas de la pala, se dejarán de desplazar
         * por la pantalla, por tanto, dado que el movimiento es en la vertical,
         * velocidadPalaDerecha o bien velocidadPalaIzquierda será establecido a
         * 0, según la pala que sea, o sea, según la tecla de la pala que se
         * haya dejadp de pulsar
         */
        scene.setOnKeyReleased((KeyEvent t) -> {
            // Detenemos el movimiento de la pala al dejar de presionar
            switch (t.getCode()) {
                case UP:
                    // Soltada tecla arriba pala derecha
                    this.velocidadPalaDerecha = 0;
                    break;
                case DOWN:
                    // Soltada tecla abajo pala derecha
                    this.velocidadPalaDerecha = 0;
                    break;
                case W:
                    // Soltada tecla arriba pala izquierda
                    this.velocidadPalaIzquierda = 0;
                    break;
                case S:
                    // Soltada tecla arriba pala izquierda
                    this.velocidadPalaIzquierda = 0;
                    break;
            }
        });
    }

    /**
     * Programa principal, lanza la aplicación.
     *
     * @param args Argumentos o parámetros (no hay en este caso)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
