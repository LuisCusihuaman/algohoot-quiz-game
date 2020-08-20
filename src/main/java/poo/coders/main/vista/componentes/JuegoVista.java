package poo.coders.main.vista.componentes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.controlador.Botones.MultiplicadorExclusividadHandlerBoton;
import poo.coders.main.controlador.Botones.MultiplicadorX2HandlerBoton;
import poo.coders.main.controlador.Botones.MultiplicadorX3HandlerBoton;
import poo.coders.main.modelo.*;
import poo.coders.main.vista.OpcionVista;
import poo.coders.main.vista.componentes.botones.BotonExclusividad;
import poo.coders.main.vista.componentes.botones.BotonX2;
import poo.coders.main.vista.componentes.botones.BotonX3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JuegoVista implements Observer {
	Juego juego;
	Stage primaryStage;
	ContenedorJuego contenedorJuego;
	ContenedorInformacion contenedorInformacion;
	ContenedorModificadores contenedorModificadores;
	ContenedorOpciones contenedorOpciones;
	ContenedorSiguiente contenedorSiguiente;

	private ContenedorModificadores getContenedorModificadores(String tipoDePregunta) {
		ContenedorModificadores contenedorModificadores = new ContenedorModificadores();

		if (tipoDePregunta.contains("Penalidad")) {
			contenedorModificadores.agregarBoton(new BotonX2(new MultiplicadorX2HandlerBoton(this.juego)));
			contenedorModificadores.agregarBoton(new BotonX3(new MultiplicadorX3HandlerBoton(this.juego)));
		} else {
			contenedorModificadores.agregarBoton(new BotonExclusividad(new MultiplicadorExclusividadHandlerBoton(this.juego, this)));
		}
		return contenedorModificadores;
	}

	private ContenedorOpciones getContenedorOpciones(String tipoDePregunta, List<Opcion> opciones, Set<String> claves) {
		ContenedorOpciones contenedorOpciones = new ContenedorOpciones();

		List<OpcionVista> opcionesVista = new ArrayList<>();

		if (tipoDePregunta.contains("Verdadero o Falso")) {
			OpcionVista opcionVistaVOF = new OpcionVista(opciones.get(0).getClave(), opciones.get(0).getTextoOpcion());
			opcionVistaVOF.agregarOpcionSeleccionBox("Verdadero");
			opcionVistaVOF.agregarOpcionSeleccionBox("Falso");
			opcionVistaVOF.setearPrimeraOpcion();
			opcionesVista.add(opcionVistaVOF);

		} else if (tipoDePregunta.contains("Multiple Choice")) {
			for (Opcion opcion : opciones) {
				OpcionVista opcionMCActual = new OpcionVista(opcion.getClave(), opcion.getTextoOpcion());
				// el texto muy largo no se muestra completo
				opcionMCActual.agregarOpcionesSeleccionBox(claves);
				if (esClasico(tipoDePregunta)) opcionMCActual.setearPrimeraOpcion();
				opcionesVista.add(opcionMCActual);
			}
		} else if (tipoDePregunta.contains("Group Choice")) {
			for (Opcion opcion : opciones) {
				OpcionVista opcionGCActual = new OpcionVista(opcion.getClave(), opcion.getTextoOpcion());
				opcionGCActual.agregarOpcionesSeleccionBox(claves);
				opcionGCActual.setearPrimeraOpcion();
				opcionesVista.add(opcionGCActual);
			}
		} else {
			for (Opcion opcion : opciones) {
				OpcionVista opcionOCActual = new OpcionVista(opcion.getClave(), opcion.getTextoOpcion());
				opcionOCActual.agregarOpcionesSeleccionBox(claves);
				opcionOCActual.setearPrimeraOpcion();
				opcionesVista.add(opcionOCActual);
			}
		}
		opcionesVista.forEach(contenedorOpciones::agregarOpcion);
		return contenedorOpciones;
	}

	private boolean esClasico(String tipoDePregunta) {
		return tipoDePregunta.contains("Clasico");
	}

	private void setearJuego(Pregunta pregunta, String tipoDePregunta, String nombreJugador, List<Opcion> opciones, Set<String> claves) {
		this.contenedorJuego = new ContenedorJuego();
		this.contenedorInformacion = new ContenedorInformacion(tipoDePregunta, nombreJugador, pregunta.getEnunciado());
		this.contenedorModificadores = getContenedorModificadores(tipoDePregunta);
		this.contenedorOpciones = getContenedorOpciones(tipoDePregunta, opciones, claves);
		this.contenedorSiguiente = new ContenedorSiguiente(this.juego, this);
	}


	public JuegoVista(Juego juego) {
		this.juego = juego;
	}


	@Override
	public void update() {
		//OBTENES DATOS DEL MODELO
		Pregunta pregunta = juego.getPreguntaActual();
		if (pregunta.getEnunciado().equals("")) {
			//Jugador JugadorModeloGanador = this.juegoMock.ganador(); tendria que pasarle
			// y no el juego mock, porque el jugadorganador tiene referencia al siguiente

			Scene scene = new Scene(new VistaPuntajes(this.juego).mostrar());
			this.primaryStage.setScene(scene);
		} else {
			String nombreJugador = juego.getJugadorActual().getNombre();
			String tipoDePregunta = pregunta.getTipoPregunta();
			List<Opcion> opciones = pregunta.getOpciones();
			Set<String> claves = opciones.stream().map(Opcion::getClave).collect(Collectors.toSet());
			//CONFIGURAS LA VISTA
			setearJuego(pregunta, tipoDePregunta, nombreJugador, opciones, claves);
			//CREAS EL CONTENDOR-VISTA-JUEGO
			this.contenedorJuego.getChildren().removeAll();
			this.contenedorJuego.getChildren().addAll(contenedorInformacion, contenedorModificadores, contenedorOpciones, contenedorSiguiente);
			Scene scene = new Scene(this.contenedorJuego);
			this.primaryStage.setScene(scene);
		}
	}

	public ContenedorJuego mostrar() {
		return this.contenedorJuego;
	}

	public List<Opcion> obtenerRespuestaJugador() {
		//ifs es grupchoice agarrar la lista y volver a crear otra pero construyendo con opcionconjunto
		List<Opcion> opciones = this.contenedorOpciones.obtenerRespuestas();

		return opciones;
	}

	public void setVentana(Stage ventana) {
		this.primaryStage = ventana;
	}

	public void bloquearBoton(String botonID) {
		this.contenedorModificadores.bloquearBoton(botonID);
	}
}
