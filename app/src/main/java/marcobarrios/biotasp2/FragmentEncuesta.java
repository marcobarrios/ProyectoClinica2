package marcobarrios.biotasp2;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by MarcoBarrios on 17/03/2015.
 */
public class FragmentEncuesta extends Fragment implements View.OnClickListener {

    View v;
    Button btnEnviar;
    Spinner resp11, resp12, resp13, resp21, resp22, resp23, resp31, resp32, resp33, resp41, resp42, resp43, resp51, resp52, resp53;
    int numAnsiedad, numDepresion, numEstres, numAutoestima, numComunicacion;
    int idActividad  = 100, idPaciente = 100, idEncuesta = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_encuestapv, container, false);
        inicializarComponentes();
        return v;
    }

    private void inicializarComponentes() {

        numAnsiedad = numDepresion = numEstres = numAutoestima = numComunicacion = 0;

        resp11 = (Spinner)v.findViewById(R.id.spinner_p11);
        resp12 = (Spinner)v.findViewById(R.id.spinner_p12);
        resp13 = (Spinner)v.findViewById(R.id.spinner_p13);
        resp21 = (Spinner)v.findViewById(R.id.spinner_p21);
        resp22 = (Spinner)v.findViewById(R.id.spinner_p22);
        resp23 = (Spinner)v.findViewById(R.id.spinner_p23);
        resp31 = (Spinner)v.findViewById(R.id.spinner_p31);
        resp32 = (Spinner)v.findViewById(R.id.spinner_p32);
        resp33 = (Spinner)v.findViewById(R.id.spinner_p33);
        resp41 = (Spinner)v.findViewById(R.id.spinner_p41);
        resp42 = (Spinner)v.findViewById(R.id.spinner_p42);
        resp43 = (Spinner)v.findViewById(R.id.spinner_p43);
        resp51 = (Spinner)v.findViewById(R.id.spinner_p51);
        resp52 = (Spinner)v.findViewById(R.id.spinner_p52);
        resp53 = (Spinner)v.findViewById(R.id.spinner_p53);

        btnEnviar = (Button)v.findViewById(R.id.btn_enviar_cuestionario_pv);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        numAnsiedad = (resp11.getSelectedItemPosition() + 1) + (resp12.getSelectedItemPosition() + 1) + (resp13.getSelectedItemPosition() + 1);
        numDepresion = (resp21.getSelectedItemPosition() + 1) + (resp22.getSelectedItemPosition() + 1) + (resp23.getSelectedItemPosition() + 1);
        numEstres = (resp31.getSelectedItemPosition() + 1) + (resp32.getSelectedItemPosition() + 1) + (resp33.getSelectedItemPosition() + 1);
        numAutoestima = (resp41.getSelectedItemPosition() + 1) + (resp42.getSelectedItemPosition() + 1) + (resp43.getSelectedItemPosition() + 1);
        numComunicacion = (resp51.getSelectedItemPosition() + 1) + (resp52.getSelectedItemPosition() + 1) + (resp53.getSelectedItemPosition() + 1);

        Toast.makeText(v.getContext(), "Ansiedad: " + String.valueOf(numAnsiedad)
                + ", Depresion: " + String.valueOf(numDepresion)
                + ", Estres: " + String.valueOf(numEstres)
                + ", Autoestima: " + String.valueOf(numAutoestima)
                + ", Comunicacion: " + String.valueOf(numComunicacion), Toast.LENGTH_SHORT).show();

        try {
            AdminSQLOpenHelper admin = new AdminSQLOpenHelper(v.getContext(), "renn", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("idPaciente", idPaciente);
            registro.put("idActividad", idActividad);
            registro.put("respAnsiedad", 0);
            registro.put("respDepresion", 0);
            registro.put("respEstres", 0);
            registro.put("respAutoestima", 0);
            registro.put("respComunicacion", 0);
            db.insert("encuestapv", null, registro);
            db.close();

            //TODO: CONSULTA POR CORREGIR
            /*db = admin.getWritableDatabase();
            Cursor consulta = db.rawQuery("SELECT MAX(idEncuestapv) from encuestapv", null);
            if (consulta.moveToFirst()) {
                idEncuesta = consulta.getInt(0);
            }
            consulta.close();
            db.close();*/

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 1);
            registro.put("respuesta", resp11.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 2);
            registro.put("respuesta", resp12.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 3);
            registro.put("respuesta", resp13.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 4);
            registro.put("respuesta", resp21.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 5);
            registro.put("respuesta", resp22.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 6);
            registro.put("respuesta", resp23.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 7);
            registro.put("respuesta", resp31.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 8);
            registro.put("respuesta", resp32.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 9);
            registro.put("respuesta", resp33.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 10);
            registro.put("respuesta", resp41.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 11);
            registro.put("respuesta", resp42.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 12);
            registro.put("respuesta", resp43.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 13);
            registro.put("respuesta", resp51.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 14);
            registro.put("respuesta", resp52.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("idEncuestapv", idEncuesta);
            registro.put("numPregunta", 15);
            registro.put("respuesta", resp53.getSelectedItemPosition());
            db.insert("respuestasencuestapv", null, registro);
            db.close();

            db = admin.getWritableDatabase();
            registro = new ContentValues();
            registro.put("respAnsiedad", 0);
            registro.put("respDepresion", 0);
            registro.put("respEstres", 0);
            registro.put("respAutoestima", 0);
            registro.put("respComunicacion", 0);
            db.update("encuestapv", registro, "idencuestapv = ? ", new String[] {String.valueOf(idEncuesta)});

            //TODO: MOSTRAR RESULTADOS DE ENCUESTA
        } catch(Exception exp) {
            Toast.makeText(v.getContext(), "Error al Guardar los Datos: " + exp.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
