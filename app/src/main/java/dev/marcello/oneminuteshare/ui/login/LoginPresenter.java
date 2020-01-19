package dev.marcello.oneminuteshare.ui.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import dev.marcello.oneminuteshare.data.dao.UserDAO;

/**
 * Created by marcellocamara@id.uff.br on 18/01/2020.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private UserDAO userDAO;

    LoginPresenter(Login.View view) {
        this.view = view;
        this.userDAO = new UserDAO(this);
    }

    @Override
    public void onLoginRequest(Task<GoogleSignInAccount> googleSignInResult) {
        view.showProgress();
        try {
            GoogleSignInAccount account = googleSignInResult.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            if (account != null) {
                userDAO.doLogin(account);
            } else {
                onFailure("signInResult:failed");
            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            onFailure("signInResult:failed code=" + e.getStatusCode());
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.hideProgress();
            view.onLoginSuccess();
        }
    }

    @Override
    public void onFailure(String message) {
        if (view != null) {
            view.hideProgress();
            view.onLoginFailure(message);
        }
    }

}