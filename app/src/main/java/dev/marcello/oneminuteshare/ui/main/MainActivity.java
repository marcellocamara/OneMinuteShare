package dev.marcello.oneminuteshare.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.data.database.Database;

/**
 * Created by marcellocamara@id.uff.br on 17/01/2020.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database database = new Database();

        if (database.getUser() != null){
            Toast.makeText(this, "Logged as: " + database.getUser().getDisplayName(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show();
        }

    }

}