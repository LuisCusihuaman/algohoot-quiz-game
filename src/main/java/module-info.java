module poo.coders {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;

	exports poo.coders.main;
	exports poo.coders.main.modelo;
	exports poo.coders.main.controlador;
	//exports poo.coders.main.vista;
	//si esta vacio te tira un error mvn

	opens poo.coders.main;
	opens poo.coders.main.modelo;
	opens poo.coders.main.controlador;
	//opens poo.coders.main.vista;

}
