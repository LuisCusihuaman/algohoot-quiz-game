
package poo.coders.main.modelo.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pregunta {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("enunciado")
    @Expose
    private String enunciado;
    @SerializedName("options")
    @Expose
    private List<Opcion> options = null;
    @SerializedName("puntaje_type")
    @Expose
    private String puntajeType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pregunta withType(String type) {
        this.type = type;
        return this;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Pregunta withQuestion(String question) {
        this.enunciado = question;
        return this;
    }

    public List<Opcion> getOptions() {
        return options;
    }

    public void setOptions(List<Opcion> options) {
        this.options = options;
    }

    public Pregunta withOptions(List<Opcion> options) {
        this.options = options;
        return this;
    }

    public String getPuntajeType() {
        return puntajeType;
    }

    public void setPuntajeType(String puntajeType) {
        this.puntajeType = puntajeType;
    }

    public Pregunta withPuntajeType(String puntajeType) {
        this.puntajeType = puntajeType;
        return this;
    }

}
