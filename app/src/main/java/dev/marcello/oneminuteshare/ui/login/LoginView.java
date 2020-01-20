package dev.marcello.oneminuteshare.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.ui.dialogs.LoadingDialog;
import dev.marcello.oneminuteshare.ui.main.MainActivity;

import static dev.marcello.oneminuteshare.util.ConstantsUtil.RC_GOOGLE_SIGN_IN;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginView extends AppCompatActivity implements Login.View {

    private LoadingDialog loadingDialog;
    private GoogleSignInClient googleSignInClient;
    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loadingDialog = new LoadingDialog(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getApplicationContext().getString(R.string.google_sign_in))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.buttonGoogle)
    void onClickButtonGoogle() {
        showProgress();
        startActivityForResult(googleSignInClient.getSignInIntent(), RC_GOOGLE_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        hideProgress();
        if (requestCode == RC_GOOGLE_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            presenter.onLoginRequest(task);
        }
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onLoginFailure(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.sign_in)
                .setMessage(message)
                .setPositiveButton(getApplicationContext().getString(R.string.close), null);
        builder.show();
    }

    @Override
    public void showProgress() {
        loadingDialog.show();
    }

    @Override
    public void hideProgress() {
        loadingDialog.dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onCheckLoggedIn(GoogleSignIn.getLastSignedInAccount(getApplicationContext()));
    }

}