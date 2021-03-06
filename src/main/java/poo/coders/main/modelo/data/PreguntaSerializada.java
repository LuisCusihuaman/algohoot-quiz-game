
package poo.coders.main.modelo.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PreguntaSerializada {

	@SerializedName("type")
	@Expose
	private String type;

	@SerializedName("enunciado")
	@Expose
	private String enunciado;

	@SerializedName("options")
	@Expose
	private List<OpcionSerializada> options = null;

	@SerializedName("puntaje_type")
	@Expose
	private String puntajeType;

	public String getType() {
		return type;
	}



	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


	public List<OpcionSerializada> getOptions() {
		return options;
	}


	public String getPuntajeType() {
		return puntajeType;
	}




}
