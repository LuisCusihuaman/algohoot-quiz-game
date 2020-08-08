package poo.coders.main.modelo;

import java.util.ArrayList;

public class RespuestasGrupalesFactory {
	public Respuesta crearRespuestasSegun(ArrayList<OpcionesGrupales> grupoOpciones) {
		for (OpcionesGrupales grupo : grupoOpciones) {
			if (!grupo.elementosSonDelMismoGrupo()) {
				return new RespuestaIncorrecta("Incorrecto");
			}
		}
		return new RespuestaCorrecta("Correcto");
	}
}
