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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import ondasatlantico.com.R;
import ondasatlantico.com.modelo.GrupoInvestigacion;

public class CreateGroup extends AppCompatActivity {
    private EditText txt_nombre, txt_municipio, txt_sede;
    private Button bt_save;
    private FirebaseDatabase mydb = FirebaseDatabase.getInstance();
    private DatabaseReference ref = mydb.getReference("grupos");

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
                saveProduct(v);
            }
        });
    }

    public void saveProduct(View view) {
        String code = txt_nombre.getText().toString() + (Math.random());
        String name = txt_nombre.getText().toString();
        String municipio = txt_municipio.getText().toString();
        String sede = txt_sede.getText().toString();
        ref.child(name).setValue(new GrupoInvestigacion(code, name, municipio, sede));
    }
}
