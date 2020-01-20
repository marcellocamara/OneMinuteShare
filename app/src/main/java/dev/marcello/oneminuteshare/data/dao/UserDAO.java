package dev.marcello.oneminuteshare.data.dao;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import dev.marcello.oneminuteshare.App;
import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.data.database.Database;
import dev.marcello.oneminuteshare.ui.ResponseListener;
import dev.marcello.oneminuteshare.ui.login.Login;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public class UserDAO implements Login.Model {

    private ResponseListener responseListener;
    private Database database;

    public UserDAO(ResponseListener responseListener) {
        this.responseListener = responseListener;
        this.database = new Database();
    }

    @Override
    public void doLogin(GoogleSignInAccount account) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        database.getFirebaseAuthInstance().signInWithCredential(authCredential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                responseListener.onSuccess();
            } else {
                responseListener.onFailure(App.getContext().getString(R.string.sign_in_error));
            }
        });
    }

}