package dev.marcello.oneminuteshare.ui.login;

import dev.marcello.oneminuteshare.ui.ProgressListener;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public interface Login {

    interface View extends ProgressListener {

        void onLoginSuccess();

        void onLoginFailure();

    }

    interface Presenter {

        void onLoginRequest();

    }

    interface Model {

    }

}