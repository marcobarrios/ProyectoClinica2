package marcobarrios.biotasp2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by MarcoBarrios on 15/03/2015.
 */
public class FragmentActivities extends Fragment {

    View v;
    Button btnNewActividad;
    private ArrayAdapter<ItemActividad> adapter;
    private ListView activitiesListView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_listactivities, container, false);
        inicializarComponentes();
        inicializarListView();


        agregarActividad("Actividad 1","11/01/2015");
        agregarActividad("Actividad 2","12/02/2015");
        agregarActividad("Actividad 3","13/03/2015");
        agregarActividad("Actividad 4","14/04/2015");
        agregarActividad("Actividad 5","15/05/2015");
        agregarActividad("Actividad 6","16/06/2015");
        agregarActividad("Actividad 7","17/07/2015");
        agregarActividad("Actividad 8","18/08/2015");
        agregarActividad("Actividad 9","19/09/2015");
        agregarActividad("Actividad 10","20/10/2015");

        return v;
    }

    public void inicializarComponentes() {
        activitiesListView = (ListView)v.findViewById(R.id.list);
        activitiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listEvents, View view, int position, long id) {
                Intent i =  new Intent(getActivity().getApplicationContext(), ActivityDetailActividad.class);
                startActivity(i);
            }
        });

        btnNewActividad = (Button)v.findViewById(R.id.button_new_actividad);
        btnNewActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(getActivity().getApplicationContext(), ActivityNewActividad.class);
                startActivity(i);
            }
        });
    }

    private void agregarActividad(String titulo, String fecha) {
        ItemActividad nuevo = new ItemActividad(titulo, fecha);
        adapter.add(nuevo);
    }

    private void inicializarListView() {
        adapter = new ActividadesListAdapter(getActivity(), new ArrayList<ItemActividad>());
        activitiesListView.setAdapter(adapter);
    }
}
