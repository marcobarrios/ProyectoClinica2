package marcobarrios.biotasp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by MarcoBarrios on 30/03/2015.
 */
public class DialogSelect extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(
                R.array.elementos_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            //TODO: IMPLEMENTAR LLAMADA A ITS O TVC
                        }
                    }
                });
        return builder.create();
    }
}

