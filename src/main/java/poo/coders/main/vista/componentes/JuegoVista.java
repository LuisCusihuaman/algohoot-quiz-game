package poo.coders.main.vista.componentes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.controlador.botones.MultiplicadorExclusividadHandlerBoton;
import poo.coders.main.controlador.botones.MultiplicadorX2HandlerBoton;
import poo.coders.main.controlador.botones.MultiplicadorX3HandlerBoton;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.Observer;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.vista.componentes.botones.BotonExclusividad;
import poo.coders.main.vista.componentes.botones.BotonX2;
import poo.coders.main.vista.componentes.botones.BotonX3;
import poo.coders.main.vista.componentes.contenedores.ContenedorInformacion;
import poo.coders.main.vista.componentes.contenedores.ContenedorJuego;
import poo.coders.main.vista.componentes.contenedores.ContenedorSiguiente;
import poo.coders.main.vista.componentes.contenedores.modificadores.ContenedorModificadores;
import poo.coders.main.vista.componentes.contenedores.modificadores.Temporizador;
import poo.coders.main.vista.componentes.contenedores.opciones.ContenedorOpcion;
import poo.coders.main.vista.componentes.contenedores.opciones.ContenedorOpciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JuegoVista implements Observer {
	Juego juego;
	Stage ventana;
	ContenedorJuego contenedorJuego;
	ContenedorInformacion contenedorInformacion;
	ContenedorModificadores contenedorModificadores;
	ContenedorOpciones contenedorOpciones;
	ContenedorSiguiente contenedorSiguiente;

	public JuegoVista(Juego juego) {
		this.juego = juego;
	}

	public void setVentana(Stage ventana) {
		this.ventana = ventana;
	}

	public void bloquearBoton(String botonID) {
		this.contenedorModificadores.bloquearBoton(botonID);
	}

	private boolean esClasico(String tipoDePregunta) {
		return tipoDePregunta.contains("Clasico") || !(tipoDePregunta.contains("Multiple Choice"));
	}

	public List<Opcion> obtenerRespuestaJugador() {
		return this.contenedorOpciones.obtenerRespuestas();
	}

	private ContenedorModificadores construirModificadores(String tipoDePregunta) {
		Temporizador temporizador = new Temporizador(this.juego, this);
		ContenedorModificadores modificadoresConBotones = new ContenedorModificadores(temporizador);

		if (tipoDePregunta.contains("Penalidad")) {
			modificadoresConBotones.agregarBoton(new BotonX2(new MultiplicadorX2HandlerBoton(this.juego)));
			modificadoresConBotones.agregarBoton(new BotonX3(new MultiplicadorX3HandlerBoton(this.juego)));
		} else {
			modificadoresConBotones.agregarBoton(new BotonExclusividad(new MultiplicadorExclusividadHandlerBoton(this.juego, this)));
		}
		return modificadoresConBotones;
	}

	private ContenedorOpciones construirOpciones(String tipoDePregunta, List<Opcion> opciones, Set<String> claves) {
		ContenedorOpciones opcionesConPreguntas = new ContenedorOpciones();

		List<ContenedorOpcion> opcionesVista = new ArrayList<>();

		if (tipoDePregunta.contains("Verdadero o Falso")) {
			ContenedorOpcion opcionVOF = new ContenedorOpcion(opciones.get(0).getClave(), opciones.get(0).getTextoOpcion());
			opcionVOF.agregarOpcionSeleccionBox("Verdadero");
			opcionVOF.agregarOpcionSeleccionBox("Falso");
			opcionVOF.setearPrimeraOpcion();
			opcionesVista.add(opcionVOF);

		} else {
			for (Opcion opcion : opciones) {
				ContenedorOpcion opcionConjunto = new ContenedorOpcion(opcion.getClave(), opcion.getTextoOpcion());
				opcionConjunto.agregarOpcionesSeleccionBox(claves);
				if (esClasico(tipoDePregunta)) opcionConjunto.setearPrimeraOpcion();
				opcionesVista.add(opcionConjunto);
			}
		}
		opcionesVista.forEach(opcionesConPreguntas::agregarOpcion);
		return opcionesConPreguntas;
	}

	private void configurarVista(Pregunta pregunta, String tipoDePregunta, String nombreJugador, List<Opcion> opciones, Set<String> claves) {
		this.contenedorJuego = new ContenedorJuego();
		this.contenedorInformacion = new ContenedorInformacion(tipoDePregunta, nombreJugador, pregunta.getEnunciado());
		this.contenedorModificadores = construirModificadores(tipoDePregunta);
		this.contenedorOpciones = construirOpciones(tipoDePregunta, opciones, claves);
		this.contenedorSiguiente = new ContenedorSiguiente(this.juego, this);
	}

	private boolean terminoElJuego(Pregunta pregunta) {
		return pregunta.getEnunciado().equals("");
	}

	@Override
	public void update() {
		Pregunta pregunta = juego.getPreguntaActual();

		if (this.terminoElJuego(pregunta)) {

			Scene scene = new Scene(new PuntajeVista(this.juego).mostrar());
			scene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("styles.css")));
			this.ventana.setScene(scene);

		} else {

			String nombreJugador = juego.getJugadorActual().getNombre();
			String tipoDePregunta = pregunta.getTipoPregunta();
			List<Opcion> opciones = pregunta.getOpciones();
			Set<String> claves = opciones.stream().map(Opcion::getClave).collect(Collectors.toSet());

			this.configurarVista(pregunta, tipoDePregunta, nombreJugador, opciones, claves);
			this.contenedorJuego.limpiar();
			this.contenedorJuego.construir(contenedorInformacion, contenedorModificadores, contenedorOpciones, contenedorSiguiente);

			Scene scene = new Scene(this.contenedorJuego);
			scene.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("styles.css")));
			this.ventana.setScene(scene);
		}
	}
}
