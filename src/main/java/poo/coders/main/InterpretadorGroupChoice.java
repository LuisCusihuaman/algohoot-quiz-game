package poo.coders.main;

import java.util.ArrayList;
import java.util.List;

public class InterpretadorGroupChoice{

	private List<String> textoRespuestas;

    public InterpretadorGroupChoice(List<String> textoRespuestas) {
		this.textoRespuestas = textoRespuestas;
    }

	public List<Respuesta> evaluarRespuestas(List<String> textoRespuestasJugador){
		List<Respuesta> listaRespuestas = new ArrayList<>();
		if(textoRespuestasJugador.containsAll(textoRespuestas))
			listaRespuestas.add(new RespuestaCorrecta("Correcta"));
		else
			listaRespuestas.add(new RespuestaIncorrecta("Incorrecta"));
		return listaRespuestas;
	}
}
