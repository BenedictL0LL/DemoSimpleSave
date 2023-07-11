package sg.edu.rp.c346.id22021506.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // step 1: obtain the sharered preferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //step2:create a shared preferences editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //step3: set a key value pair in the editor
        prefEdit.putString("greetings", "Hello!");
        //step4: call commit to save the changes made to the shared preference
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String msg = prefs.getString("greetings", "No greetings name");
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}