package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class OpcionesGrupales {

	private ArrayList<Grupo> grupos;

	OpcionesGrupales(String nombreGrupo1, String nombreGrupo2) {
		grupos = new ArrayList<>();
		grupos.add(new Grupo(nombreGrupo1));
		grupos.add(new Grupo(nombreGrupo2));
	}

	public void agregarAGrupo1(Opcion opcion) {
		grupos.get(0).agregarAGrupo(opcion);
	}
	public void agregarAGrupo2(Opcion opcion) {
		grupos.get(1).agregarAGrupo(opcion);
	}

	public void asignarOpcionesAGrupos(List<Opcion> opciones){
		for (Opcion opcion: opciones) {
			if(opcion.getClave().equals(grupos.get(0).getNombreGrupo())) this.agregarAGrupo1(opcion);
			if(opcion.getClave().equals(grupos.get(0).getNombreGrupo())) this.agregarAGrupo2(opcion);
		}
	}
	public ArrayList<Respuesta> verificarRespuestas() {
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (Grupo grupo : grupos) {
			respuestas.add(grupo.verificarRespuestas());
		}
		return respuestas;
	}

}
