package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RespuestaTest {
	@Test
	void deberiaCrearseRespuestaConElTextoCorrespo() {
		RespuestaCorrecta   correcta   = new RespuestaCorrecta("Ver.");
		RespuestaIncorrecta incorrecta = new RespuestaIncorrecta("Falso.");
		correcta.setTextoRespuesta("Verdadero.");
		Assertions.assertEquals("Verdadero.", correcta.getTextoRespuesta());
		Assertions.assertEquals("Falso.", incorrecta.getTextoRespuesta());
	}
}
