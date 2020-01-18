package dev.marcello.oneminuteshare.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.ui.dialogs.LoadingDialog;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginView extends AppCompatActivity implements Login.View {

    private LoadingDialog loadingDialog;
    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loadingDialog = new LoadingDialog(this);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.buttonGoogle)
    void onClickButtonGoogle() {
        presenter.onLoginRequest();
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFailure() {

    }

    @Override
    public void showProgress() {
        loadingDialog.show();
    }

    @Override
    public void hideProgress() {
        loadingDialog.dismiss();
    }

}