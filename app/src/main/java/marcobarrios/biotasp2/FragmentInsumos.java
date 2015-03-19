package marcobarrios.biotasp2;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Marco Barrios on 08/03/2015.
 */
public class FragmentInsumos extends Fragment {
    View v;
    Button btn;
    Spinner tipoInsumos;
    ArrayAdapter adapter;
    EditText codPaciente, cantidad, observaciones;
    Button fingerprint;
    String idActividad = "codigo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_insumos, container, false);
        //TODO: LLAMAR A consultarDatosActividad();
        inicializarComponentes();
        return v;
    }

    private void consultarDatosActividad() {
        TextView nombreActividad = (TextView)v.findViewById(R.id.text_view_name_activity);
        TextView fechaActividad = (TextView)v.findViewById(R.id.text_view_date_activity);
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(v.getContext(), "renn", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor consulta = db.rawQuery("SELECT Lugar, Fecha from activities where idActividad = '" + idActividad + "'", null);
        if (consulta.moveToFirst()) {
            nombreActividad.setText(consulta.getString(0));
            fechaActividad.setText(consulta.getString(1));
        }
        db.close();
    }

    public void inicializarComponentes() {

        codPaciente = (EditText)v.findViewById(R.id.edit_text_pacient_code);
        codPaciente.requestFocus();
        cantidad = (EditText)v.findViewById(R.id.edit_text_cantidad);
        observaciones = (EditText)v.findViewById(R.id.edit_text_observations);
        tipoInsumos = (Spinner)v.findViewById(R.id.spinner_tipo_insumo);

        fingerprint = (Button)v.findViewById(R.id.button_register_fingerprint);
        fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Registrar Huella Digital", Toast.LENGTH_SHORT).show();
                //TODO: Implementar registro de huella digital
            }
        });

        btn = (Button)v.findViewById(R.id.button_save_data_insumos);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AdminSQLOpenHelper admin = new AdminSQLOpenHelper(v.getContext(), "renn", null, 1);
                    SQLiteDatabase db = admin.getWritableDatabase();
                    String cod = codPaciente.getText().toString();
                    String tipo = tipoInsumos.getSelectedItem().toString();
                    int cant = Integer.parseInt(cantidad.getText().toString());
                    String obs = observaciones.getText().toString();
                    ContentValues registro = new ContentValues();
                    registro.put("codigoPaciente", cod);
                    registro.put("idActividad", idActividad);
                    registro.put("tipoInsumo", tipo);
                    registro.put("cantidad", cant);
                    registro.put("observaciones", obs);
                    //TODO:AGREGAR HUELLA DACTILAR
                    db.insert("insumos", null, registro);
                    db.close();
                    Toast.makeText(v.getContext(), "Datos Guardados Correctamete", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                } catch(Exception exp) {
                    Toast.makeText(v.getContext(), "No deben haber espacios en blanco", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiarCampos() {
        codPaciente.setText("");
        cantidad.setText("");
        observaciones.setText("");
        codPaciente.requestFocus();
    }
}
