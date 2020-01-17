package dev.marcello.oneminuteshare;

import android.app.Application;
import android.content.Context;

/**
 * Created by marcellocamara@id.uff.br on 17/01/2020.
 */

public class App extends Application {

    private static Application application;

    private static Application getApplication() {
        return application;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
    }

}