package ondasatlantico.com.modelo;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Data {
    private static ArrayList<GrupoInvestigacion> groups = new ArrayList<>();

    public static void Save(GrupoInvestigacion c){groups.add(c);}

    public static ArrayList<GrupoInvestigacion> get(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("grupos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // document.toObject(GrupoInvestigacion.class).getNombre(), document.toObject(GrupoInvestigacion.class).getMunicipio(), document.toObject(GrupoInvestigacion.class).getSede();
                                GrupoInvestigacion grupo = new GrupoInvestigacion("Robinson", "Barranquilla", "Principal");
                                Data.Save(grupo);
                            }
                            System.out.println(groups);
                        } else {
                            Log.w("", "Error getting documents.", task.getException());
                        }
                    }
                });
        GrupoInvestigacion grupo = new GrupoInvestigacion("Robinson", "Barranquilla", "Principal");
        Data.Save(grupo);
        System.out.println(groups);
        return groups;
    }
}
