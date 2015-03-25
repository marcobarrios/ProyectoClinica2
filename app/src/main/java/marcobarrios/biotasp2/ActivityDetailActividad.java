package marcobarrios.biotasp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by MarcoBarrios on 16/03/2015.
 */
public class ActivityDetailActividad extends Activity {


    Button btnNewParticipante;
    private ArrayAdapter<ItemParticipante> adapter;
    private ListView activitiesListView;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_actividad);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        inicializarComponentes();
        inicializarListView();

        agregarParticipante("Participante 1","Dato Participante 1");
        agregarParticipante("Participante 2","Dato Participante 2");
        agregarParticipante("Participante 3","Dato Participante 3");
        agregarParticipante("Participante 4","Dato Participante 4");
        agregarParticipante("Participante 5","Dato Participante 5");
        agregarParticipante("Participante 6","Dato Participante 6");
        agregarParticipante("Participante 7","Dato Participante 7");
        agregarParticipante("Participante 8","Dato Participante 8");
        agregarParticipante("Participante 9","Dato Participante 9");
        agregarParticipante("Participante 10","Dato Participante 10");
    }

    public void inicializarComponentes() {
        activitiesListView = (ListView)findViewById(R.id.list_participante);
        activitiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listEvents, View view, int position, long id) {

            }
        });

        btnNewParticipante = (Button)findViewById(R.id.button_new_participante);
        btnNewParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void agregarParticipante(String titulo, String fecha) {
        ItemParticipante nuevo = new ItemParticipante(titulo, fecha);
        adapter.add(nuevo);
    }

    private void inicializarListView() {
        adapter = new ParticipantesListAdapter(this, new ArrayList<ItemParticipante>());
        activitiesListView.setAdapter(adapter);
    }
}
