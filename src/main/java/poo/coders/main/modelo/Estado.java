package poo.coders.main.modelo;

import poo.coders.main.modelo.modificadores.Multiplicador;

public enum Estado {
	INICIO, // INSTANCIA LOS OBJETOS NECESARIOS PARA QUE LA PREGUNTA. ANDE
	EN_JUEGO, // SE CARGA LA PREGUNTA A LA VISTA Y SE CAPTURA LAS OPCIONES DEL JUEGADOR
	FINAL_JUGADA, //PREGUNTA LLAMA A CALCULAR PUNTAJE DE JUGADORES Y LO MUESTRA POR PANTALLA
	SALIDA,
    ;//SE TERMINO LA LISTA DE PREGUNTAS SE MUESTRA EL GANADOR Y SE SALE

    public static class MultiplicadorBasicoX2 extends ModificadorGod implements Multiplicador {
        private Jugador jugador;

        public MultiplicadorBasicoX2(){

        }

        @Override
        public int aplicarMultiplicador(int puntajeBase){
            return puntajeBase * 2;
        }


        @Override
        public void agregarJugador(Jugador jugador) {
            this.jugador = jugador;
        }
    }
}
