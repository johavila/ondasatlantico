package ondasatlantico.com.views;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ondasatlantico.com.R;
import ondasatlantico.com.modelo.Adapter;
import ondasatlantico.com.modelo.GrupoInvestigacion;

public class GroupList extends AppCompatActivity {
    RecyclerView nRecyclerView;
    List<GrupoInvestigacion> productos;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_groups);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Grupos");

        nRecyclerView = findViewById(R.id.myRecycler);
        nRecyclerView.setHasFixedSize(true);

        nRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(productos);
        nRecyclerView.setAdapter(adapter);
        database.getReference("grupos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productos.removeAll(productos);
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    GrupoInvestigacion producto = snapshot.getValue(GrupoInvestigacion.class);
                    productos.add(producto);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
    }
}
