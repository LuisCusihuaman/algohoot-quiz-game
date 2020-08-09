
package poo.coders.main.modelo.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpcionSerializada {

    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("texto")
    @Expose
    private String texto;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
