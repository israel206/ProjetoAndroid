package com.israelhack.projetoacspsf.ConexaoDB;

import com.google.firebase.database.FirebaseDatabase;

public class PermanenciaDisco extends ConfiguracaoFirebase{

    private static FirebaseDatabase ativaPermanenciaDatabase;


    public static FirebaseDatabase getAtivaPermanenciaDatabase() {
        if (ativaPermanenciaDatabase == null){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        return ativaPermanenciaDatabase;
    }
}
