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

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginView extends AppCompatActivity implements Login.View {

    private LoadingDialog loadingDialog;
    private GoogleSignInClient googleSignInClient;
    private Login.Presenter presenter;
    private int RC_GOOGLE_SIGN_IN = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loadingDialog = new LoadingDialog(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
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
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_GOOGLE_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            presenter.onLoginRequest(task);
        }
    }

    @Override
    public void onLoginSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.sign_in)
                .setMessage("Login successful")
                .setPositiveButton("Close", null);
        builder.show();
    }

    @Override
    public void onLoginFailure(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.sign_in)
                .setMessage("signInResult:failed code=" + message)
                .setPositiveButton("Close", null);
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

}