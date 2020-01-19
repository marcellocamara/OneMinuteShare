package dev.marcello.oneminuteshare.data.database;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by marcellocamara@id.uff.br on 19/01/2020.
 */

public class Database {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    //Singleton FirebaseAuth
    public FirebaseAuth getFirebaseAuthInstance() {
        if (firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }

    //Singleton FirebaseUser
    public FirebaseUser getUser() {
        if (firebaseUser == null) {
            firebaseUser = getFirebaseAuthInstance().getCurrentUser();
        }
        return firebaseUser;
    }

}