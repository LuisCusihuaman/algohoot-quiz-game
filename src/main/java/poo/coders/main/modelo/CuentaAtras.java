package poo.coders.main.modelo;
import java.util.Timer;
import java.util.TimerTask;

	public class CuentaAtras {
	private static int intervalo;
	private static Timer timer;

	public CuentaAtras(int tiempo){
		timer = new Timer();
		intervalo = tiempo;
	}

	public void comenzar() {
		int retraso = 1000;
		int periodo = 1000;
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println(setInterval());
			}
		}, retraso, periodo);
	}
	private static int setInterval() {
		if (intervalo == 1)
			timer.cancel();
			//hacer algo aqui
		return --intervalo;
	}
}
