package dev.marcello.oneminuteshare.ui.main;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import dev.marcello.oneminuteshare.ui.ProgressListener;
import dev.marcello.oneminuteshare.ui.ResponseListener;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public interface Main {

    interface View extends ProgressListener {

        void onLogoutSuccess();

        void onLogoutFailure(String message);

    }

    interface Presenter extends ResponseListener {

        void onLogoutRequest(GoogleSignInClient client);

    }

    interface Model {

        void doLogout();

    }

}