package dev.marcello.oneminuteshare.ui.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;

import dev.marcello.oneminuteshare.ui.ProgressListener;
import dev.marcello.oneminuteshare.ui.ResponseListener;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public interface Login {

    interface View extends ProgressListener {

        void onLoginSuccess();

        void onLoginFailure(String message);

    }

    interface Presenter extends ResponseListener {

        void onLoginRequest(Task<GoogleSignInAccount> googleSignInResult);

    }

    interface Model {

        void doLogin(GoogleSignInAccount account);

    }

}