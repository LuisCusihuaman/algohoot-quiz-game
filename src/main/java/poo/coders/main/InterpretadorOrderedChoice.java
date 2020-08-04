package poo.coders.main;

import java.util.ArrayList;
import java.util.List;

public class InterpretadorOrderedChoice {
	private List<String> textoRespuestasOrdenadas;

	public InterpretadorOrderedChoice(List<String> textoRespuestasOrdenadas){
		this.textoRespuestasOrdenadas = textoRespuestasOrdenadas;
	}

	public List<Respuesta> evaluarRespuestas(List<String> textoRespuestasJugador){
		List<Respuesta> listaRespuestas = new ArrayList<>();
		if(textoRespuestasOrdenadas.equals(textoRespuestasJugador)) listaRespuestas.add(new RespuestaCorrecta("Correcta"));
		else listaRespuestas.add(new RespuestaIncorrecta("Incorrecta"));
		return listaRespuestas;
	}
}
