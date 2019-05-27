package ondasatlantico.com.views;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import ondasatlantico.com.R;
import ondasatlantico.com.modelo.GrupoInvestigacion;

public class CreateGroup extends AppCompatActivity {
    private EditText txt_nombre, txt_municipio, txt_sede;
    private Button bt_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        // CREAR GRUPO DE INVESTIGACION
        txt_nombre = (EditText)findViewById(R.id.txt_nombre);
        txt_municipio = (EditText)findViewById(R.id.txt_municipio);
        txt_sede = (EditText)findViewById(R.id.txt_sede);
        bt_save = (Button)findViewById(R.id.bt_save);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String group_name = txt_nombre.getText().toString();
                String group_municipio = txt_municipio.getText().toString();
                String group_sede = txt_sede.getText().toString();
                GrupoInvestigacion group = new GrupoInvestigacion(group_name, group_municipio, group_sede);

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("first", "Ada");
                user.put("last", "Lovelace");
                user.put("born", 1815);

                // Add a new document with a generated ID
                db.collection("grupos")
                        .add(group)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("", "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(getApplicationContext(),"EXITO", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("", "Error adding document", e);
                                Toast.makeText(getApplicationContext(),"Falló", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
