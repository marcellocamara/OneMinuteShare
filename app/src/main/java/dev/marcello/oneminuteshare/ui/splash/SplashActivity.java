package dev.marcello.oneminuteshare.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.marcello.oneminuteshare.ui.main.MainActivity;

/**
 * Created by marcellocamara@id.uff.br on 17/01/2020.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}