package poo.coders.main.modelo;

import com.google.gson.Gson;
import poo.coders.main.modelo.data.PreguntaSerializada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	public static void parsear() {
		Gson gson = new Gson();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data.json"));
			PreguntaSerializada[] preguntaSerializadas = gson.fromJson(br, PreguntaSerializada[].class);
			System.out.println("lol");
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
	}
}
