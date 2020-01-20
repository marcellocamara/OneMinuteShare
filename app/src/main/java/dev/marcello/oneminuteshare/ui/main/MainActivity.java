package dev.marcello.oneminuteshare.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.data.database.Database;
import dev.marcello.oneminuteshare.ui.dialogs.LoadingDialog;
import dev.marcello.oneminuteshare.ui.login.LoginView;
import dev.marcello.oneminuteshare.util.GoogleUtil;

/**
 * Created by marcellocamara@id.uff.br on 17/01/2020.
 */

public class MainActivity extends AppCompatActivity implements Main.View {

    @BindView(R.id.textView)
    protected TextView textView;

    private LoadingDialog loadingDialog;
    private Main.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        loadingDialog = new LoadingDialog(this);

        //TODO: Temporary
        {
            Database database = new Database();
            if (database.getUser() != null) {
                String log = "Logged as\n\n" +
                        database.getUser().getDisplayName() + "\n" +
                        database.getUser().getEmail();
                textView.setText(log);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            presenter.onLogoutRequest(
                    GoogleSignIn.getClient(
                            this,
                            GoogleUtil.getGoogleSignInOptions(this)
                    )
            );
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLogoutSuccess() {
        startActivity(new Intent(this, LoginView.class));
        finish();
    }

    @Override
    public void onLogoutFailure(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.sign_out)
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

}