package poo.coders.main.controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import poo.coders.main.modelo.Juego;

public class ControladorVerdaderoFalso implements ControladorInterfaz{

	@FXML
	private Label pregunta;
	@FXML
	private Label tiempo;
	@FXML
	private Label jugador;
	@FXML
	private Label tipoPregunta;
	@FXML
	private Button multiplicadorx2;
	@FXML
	private Button multiplicadorx3;
	@FXML
	private Label verdadero;
	@FXML
	private Label falso;
	private Juego juego;

	@Override
	public void setearJuego(Juego juego) {
		this.juego = juego;
		pregunta.setText(juego.getPregunta());
		jugador.setText(juego.getNombre());
		tipoPregunta.setText(juego.getTipoPregunta());

	}
}

