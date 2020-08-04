package poo.coders.main;

import java.util.List;

public class InterpretadorOrderedChoice {
	private List<String> respuestasOrdenadas;

	public InterpretadorOrderedChoice(List<String> respuestasOrdenadas){
		this.respuestasOrdenadas = respuestasOrdenadas;
	}

	public Respuesta evaluarRespuestas(List<String> respuestasJugador){
		if(respuestasOrdenadas.equals(respuestasJugador)) return new RespuestaCorrecta("Correcta");
		return new RespuestaIncorrecta("Incorrecta");
	}
}
