package dev.marcello.oneminuteshare.data.dao;

import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

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
        //TODO: Insert user at DB
        Log.d("FIREBASE-LOGIN", "doLogin: SALVAR DADOS!\n" +
                "Nome: " + account.getDisplayName() + "\n" +
                "Email:" + account.getEmail() + "\n" +
                "Id: " + account.getId() + "\n" +
                "IdToken: " + account.getIdToken() + "\n"
        );
        responseListener.onSuccess();
    }

}