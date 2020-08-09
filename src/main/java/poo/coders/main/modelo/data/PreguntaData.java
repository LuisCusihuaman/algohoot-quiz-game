
package poo.coders.main.modelo.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreguntaData {

    @SerializedName("questions")
    @Expose
    private List<Pregunta> preguntas = null;

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public PreguntaData withQuestions(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
        return this;
    }

}
