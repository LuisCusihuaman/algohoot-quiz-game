package poo.coders.main.modelo;

import com.google.gson.Gson;
import poo.coders.main.modelo.data.PreguntaData;

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
			PreguntaData preguntaData = gson.fromJson(br, PreguntaData.class);
			System.out.println("hola");
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
