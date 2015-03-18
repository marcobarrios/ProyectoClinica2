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
public class ActividadesListAdapter extends ArrayAdapter<ItemActividad> {

    private Activity ctx;

    public ActividadesListAdapter(Activity context, List<ItemActividad> actividad) {
        super(context, R.layout.item_row_actividad, actividad);
        this.ctx = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            view = ctx.getLayoutInflater().inflate(R.layout.item_row_actividad, parent, false);
        }
        ItemActividad actual = this.getItem(position);
        inicializarCampos(view, actual);
        return view;
    }

    private void inicializarCampos(View view, ItemActividad actual) {
        TextView textView = (TextView)view.findViewById(R.id.txt_row_title);
        textView.setText(actual.gettituloActividad());
        textView = (TextView)view.findViewById(R.id.txt_row_subtitle);
        textView.setText(actual.getfechaActividad());
    }
}
