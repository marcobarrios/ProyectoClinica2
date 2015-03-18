package marcobarrios.biotasp2;

/**
 * Created by Marco Barrios on 26/10/2014.
 */
public class ItemActividad {

    private String tituloActividad;
    private String fechaActividad;

    public ItemActividad(String tituloActividad, String fechaActividad) {
        this.tituloActividad = tituloActividad;
        this.fechaActividad = fechaActividad;
    }

    public ItemActividad() {
    }

    //<editor-fold desc="GETTERS">
    public String gettituloActividad() {
        return tituloActividad;
    }

    public String getfechaActividad() {
        return fechaActividad;
    }

    //</editor-fold>

    //<editor-fold desc="SETTERS">
    public void settituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public void setfechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    //</editor-fold>

    //<editor-fold desc="EQUALS & HASHCODE">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemActividad anotacion = (ItemActividad) o;

        if (!fechaActividad.equals(anotacion.fechaActividad)) return false;
        if (!tituloActividad.equals(anotacion.tituloActividad)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tituloActividad.hashCode();
        result = 31 * result + fechaActividad.hashCode();
        return result;
    }
    //</editor-fold>
}
