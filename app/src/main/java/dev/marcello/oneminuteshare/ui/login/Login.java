package dev.marcello.oneminuteshare.ui.login;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public interface Login {

    interface View {

        void onLoginSuccess();

        void onLoginFailure();

    }

    interface Presenter {

        void onLoginRequest();

    }

    interface Model {

    }

}