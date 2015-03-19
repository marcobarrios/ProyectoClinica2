package marcobarrios.biotasp2;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import marcobarrios.biotasp2.Dialogs.DatePickerFragment;
import marcobarrios.biotasp2.Dialogs.TimePickerFragment;
import marcobarrios.biotasp2.Interface.OnDateSelected;
import marcobarrios.biotasp2.Interface.OnTimeSelected;

/**
 * Created by MarcoBarrios on 15/03/2015.
 */
public class ActivityNewActividad extends Activity implements OnDateSelected, OnTimeSelected{

    private Button btnDate;
    private Button btnTime;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_activities);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        btnDate = (Button) findViewById(R.id.txt_fecha_da);
        btnTime = (Button) findViewById(R.id.txt_hora_da);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });
    }

    @Override
    public void onDateSelected(String date) {
        //////Recibe Fecha seleccionada en String
        btnDate.setText(date);
    }

    @Override
    public void onTimeSelected(String time) {
        //////Recibe Hora selecionada en String
        btnTime.setText(time);
    }
}
