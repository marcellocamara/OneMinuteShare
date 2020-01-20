package dev.marcello.oneminuteshare.util;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import dev.marcello.oneminuteshare.R;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public class GoogleUtil {

    public static GoogleSignInOptions getGoogleSignInOptions(Context context) {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.google_sign_in))
                .requestEmail()
                .build();
    }

}