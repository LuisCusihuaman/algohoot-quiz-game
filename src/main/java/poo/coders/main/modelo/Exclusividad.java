package poo.coders.main.modelo;

public class Exclusividad {
	private int multiplicadorExclusividad;

	Exclusividad(){
		this.multiplicadorExclusividad = 1;
	}

	public int aplicar(int puntajeOriginal){
		return puntajeOriginal * multiplicadorExclusividad;
	}

	public void activarExclusividad(){
		this.multiplicadorExclusividad *= 2;
		if(this.multiplicadorExclusividad > 4) throw new RuntimeException();
	}

	public void darPuntosAJugadores(Jugador jugador1, Jugador jugador2, int puntajeJugador1, int puntajeJugador2) {
		if(this.multiplicadorExclusividad == 1){
			jugador1.ganarPuntaje(puntajeJugador1);
			jugador2.ganarPuntaje(puntajeJugador2);
		}else {
			if (puntajeJugador1 != puntajeJugador2) {
				if (puntajeJugador1 > puntajeJugador2) {
					jugador1.ganarPuntaje(multiplicadorExclusividad * puntajeJugador1);
				} else {
					jugador2.ganarPuntaje(multiplicadorExclusividad * puntajeJugador2);
				}
			}
		}

	}
}
