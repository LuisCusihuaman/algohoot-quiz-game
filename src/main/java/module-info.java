module poo.coders {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.google.gson;

	exports poo.coders.main.modelo;
	exports poo.coders.main.modelo.excepciones;
	exports poo.coders.main.modelo.modificadores;
	exports poo.coders.main.modelo.data;
	exports poo.coders.main.modelo.comportamientos;
	exports poo.coders.main.modelo.builders;
	exports poo.coders.main.vista;

	opens poo.coders.main.modelo;
	opens poo.coders.main.modelo.excepciones;
	opens poo.coders.main.modelo.modificadores;
	opens poo.coders.main.modelo.data;
	opens poo.coders.main.modelo.comportamientos;
	opens poo.coders.main.modelo.builders;
	opens poo.coders.main.vista;

}
