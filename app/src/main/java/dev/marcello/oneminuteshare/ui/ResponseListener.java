package dev.marcello.oneminuteshare.ui;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public interface ResponseListener {

    void onSuccess();

    void onFailure(String message);

}