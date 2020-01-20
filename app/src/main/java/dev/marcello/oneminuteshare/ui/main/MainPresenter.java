package dev.marcello.oneminuteshare.ui.main;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import dev.marcello.oneminuteshare.App;
import dev.marcello.oneminuteshare.R;
import dev.marcello.oneminuteshare.data.dao.UserDAO;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public class MainPresenter implements Main.Presenter {

    private Main.View view;
    private Main.Model model;

    MainPresenter(Main.View view) {
        this.view = view;
        model = new UserDAO(this);
    }

    @Override
    public void onLogoutRequest(GoogleSignInClient client) {
        view.showProgress();
        client.signOut().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                model.doLogout();
            } else {
                onFailure(App.getContext().getString(R.string.sign_out_error));
            }
        });
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.hideProgress();
            view.onLogoutSuccess();
        }
    }

    @Override
    public void onFailure(String message) {
        if (view != null) {
            view.hideProgress();
            view.onLogoutFailure(message);
        }
    }

}