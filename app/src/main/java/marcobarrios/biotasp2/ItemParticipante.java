package marcobarrios.biotasp2;

/**
 * Created by Marco Barrios on 26/10/2014.
 */
public class ItemParticipante {

    private String nombreParticipante;
    private String datoParticipante;

    public ItemParticipante(String nombreParticipante, String datoParticipante) {
        this.nombreParticipante = nombreParticipante;
        this.datoParticipante = datoParticipante;
    }

    public ItemParticipante() {
    }

    //<editor-fold desc="GETTERS">
    public String getnombreParticipante() {
        return nombreParticipante;
    }

    public String getdatoParticipante() {
        return datoParticipante;
    }

    //</editor-fold>

    //<editor-fold desc="SETTERS">
    public void setnombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public void setdatoParticipante(String datoParticipante) {
        this.datoParticipante = datoParticipante;
    }

    //</editor-fold>

    //<editor-fold desc="EQUALS & HASHCODE">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemParticipante anotacion = (ItemParticipante) o;

        if (!datoParticipante.equals(anotacion.datoParticipante)) return false;
        if (!nombreParticipante.equals(anotacion.nombreParticipante)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombreParticipante.hashCode();
        result = 31 * result + datoParticipante.hashCode();
        return result;
    }
    //</editor-fold>
}
