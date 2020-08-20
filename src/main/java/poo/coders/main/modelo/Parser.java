package poo.coders.main.modelo;

import com.google.gson.Gson;
import poo.coders.main.modelo.builders.*;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.data.PreguntaSerializada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Parser {
	private Pregunta convertirPreguntas(List<PreguntaSerializada> preguntaSerializadas) {
		ArrayList<Pregunta> preguntas = new ArrayList<>();
		preguntaSerializadas.forEach(preguntaSerializada -> {
			String tipoPregunta = preguntaSerializada.getType();
			DirectorPregunta director = new DirectorPregunta(preguntaSerializada);

			switch (tipoPregunta) {
				case "vof":
					VoFBuilder voFBuilder = new VoFBuilder();
					director.asignar(voFBuilder);
					preguntas.add(voFBuilder.construirPregunta());
					break;
				case "multiple":
					MultipleChoiceBuilder multipleChoiceBuilder = new MultipleChoiceBuilder();
					director.asignar(multipleChoiceBuilder);
					preguntas.add(multipleChoiceBuilder.construirPregunta());
					break;
				case "order":
					OrderedChoiceBuilder orderedChoiceBuilder = new OrderedChoiceBuilder();
					director.asignar(orderedChoiceBuilder);
					preguntas.add(orderedChoiceBuilder.construirPregunta());
					break;
				default:
					GroupChoiceBuilder groupChoiceBuilder = new GroupChoiceBuilder();
					director.asignar(groupChoiceBuilder);
					preguntas.add(groupChoiceBuilder.construirPregunta());
					break;
			}
		});
		preguntas.add(new Pregunta("", new ComportamientoVoF()));
		return this.convertirEnPreguntaCiclica(preguntas);
	}

	private Pregunta convertirEnPreguntaCiclica(ArrayList<Pregunta> preguntas) {
		Pregunta actual = preguntas.get(0); //[p1]+ p*
		Pregunta siguiente;
		if (preguntas.size() > 1) {
			siguiente = preguntas.get(1);
			actual.setSiguientePregunta(siguiente);

			for (int i = 2; i < preguntas.size(); i++) { //4 ("")
				siguiente.setSiguientePregunta(preguntas.get(i));
				siguiente = preguntas.get(i);
			}
		}
		return actual;
	}

	public Pregunta parsear() {
		Gson gson = new Gson();
		BufferedReader br = null;
		List<PreguntaSerializada> preguntaSerializadas = null;
		try {
			br = new BufferedReader(new FileReader("data.json"));
			preguntaSerializadas = Arrays.asList(gson.fromJson(br, PreguntaSerializada[].class));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		assert preguntaSerializadas != null;
		return this.convertirPreguntas(preguntaSerializadas);
	}
}
