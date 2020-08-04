package poo.coders.main;

import java.util.List;

public class InterpretadorOrderedChoice {
	List<String> respuestasOrdenadas;

	InterpretadorOrderedChoice(List<String> respuestasOrdenadas){
		this.respuestasOrdenadas = respuestasOrdenadas;
	}

	Respuesta evaluarRespuestas(List<String> respuestasJugador){
		if(respuestasOrdenadas.equals(respuestasJugador)) return new RespuestaCorrecta("Correcta");
		return new RespuestaIncorrecta("Incorrecta");
	}
}
