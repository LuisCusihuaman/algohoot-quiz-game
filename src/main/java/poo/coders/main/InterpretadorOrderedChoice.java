package poo.coders.main;

import java.util.List;

public class InterpretadorOrderedChoice {
	List<String> respuestasOrdenadas;

	Respuesta evaluarRespuestas(List<String> respuestasJugador){
		if(respuestasOrdenadas.equals(respuestasJugador)) return new RespuestaCorrecta("");
		return new RespuestaIncorrecta("");
	}
}
