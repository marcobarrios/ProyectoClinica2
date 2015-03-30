package marcobarrios.biotasp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MarcoBarrios on 30/03/2015.
 */
public class SelectItsTvc extends Activity {

    private TextView txtITS, txtTVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_its_tvc);

        txtITS = (TextView)findViewById(R.id.txt_select_its);
        txtITS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: LLamar a ITS
            }
        });

        txtTVC = (TextView)findViewById(R.id.txt_select_tvc);
        txtTVC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: LLamar a TVC
            }
        });
    }
}

