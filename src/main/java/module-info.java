module poo.coders {
	requires javafx.controls;
	requires javafx.fxml;

	//exports poo.coders.main;
	exports poo.coders.main.modelo;
	exports poo.coders.main.controlador;
	exports poo.coders.main.vista;

	//opens poo.coders.main;
	opens poo.coders.main.modelo;
	opens poo.coders.main.controlador;
	opens poo.coders.main.vista;

}
