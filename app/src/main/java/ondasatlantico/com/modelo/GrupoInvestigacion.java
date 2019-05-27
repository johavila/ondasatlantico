package ondasatlantico.com.modelo;

public class GrupoInvestigacion {
    private String nombre;
    private String municipio;
    private String sede;

    public GrupoInvestigacion() {
    }

    public GrupoInvestigacion(String nombre, String municipio, String sede) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void saveGroup(){
    }
}
