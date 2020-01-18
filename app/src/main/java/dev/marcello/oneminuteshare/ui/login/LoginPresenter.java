package dev.marcello.oneminuteshare.ui.login;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View view;

    LoginPresenter(Login.View view) {
        this.view = view;
    }

    @Override
    public void onLoginRequest() {
        view.showProgress();
        //TODO: doLogin
    }

}