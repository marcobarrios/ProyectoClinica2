package marcobarrios.biotasp2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by MarcoBarrios on 15/03/2015.
 */
public class ActivityNewActividad extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_activities);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
}
