package dev.marcello.oneminuteshare.ui.login;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.marcello.oneminuteshare.R;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginView extends AppCompatActivity implements Login.View {

    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);

    }

    @OnClick(R.id.buttonGoogle)
    void onClickButtonGoogle() {
        Toast.makeText(this, "Login button clicked.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFailure() {

    }

}