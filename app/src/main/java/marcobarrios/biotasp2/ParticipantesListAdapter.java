package marcobarrios.biotasp2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Marco Barrios on 29/10/2014.
 */
public class ParticipantesListAdapter extends ArrayAdapter<ItemParticipante> {

    private Activity ctx;

    public ParticipantesListAdapter(Activity context, List<ItemParticipante> participante) {
        super(context, R.layout.list_row_participante, participante);
        this.ctx = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            view = ctx.getLayoutInflater().inflate(R.layout.list_row_participante, parent, false);
        }
        ItemParticipante actual = this.getItem(position);
        inicializarCampos(view, actual);
        return view;
    }

    private void inicializarCampos(View view, ItemParticipante actual) {
        TextView textView = (TextView)view.findViewById(R.id.txt_row_name_participante);
        textView.setText(actual.getnombreParticipante());
        textView = (TextView)view.findViewById(R.id.txt_row_dato_participante);
        textView.setText(actual.getdatoParticipante());
    }
}
