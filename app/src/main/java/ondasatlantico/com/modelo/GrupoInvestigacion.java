package ondasatlantico.com.modelo;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GrupoInvestigacion {
    private String id;
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

    public GrupoInvestigacion(String id, String nombre, String municipio, String sede) {
        this.id = id;
        this.nombre = nombre;
        this.municipio = municipio;
        this.sede = sede;
    }

    public String getId() { return id; }

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
}
