package poo.coders.main.modelo;

import java.util.List;

public interface Interpretador {

	List<Respuesta> evaluarRespuestas(List<String> textoRespuestasJugador);
}
