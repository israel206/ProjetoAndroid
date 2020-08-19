package com.israelhack.projetoacspsf.ConexaoDB;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    //atributos estaticos
    private static DatabaseReference referenceFirebase;
    private static FirebaseAuth Autenticacao;

    //metodos referencia ou BD
    public static DatabaseReference getFirebase() {
        //teste ser for igual a null vai cria
        if (referenceFirebase == null){

            //Caso não tenha uma refereceFirebase crie uma a referencia
            referenceFirebase = FirebaseDatabase.getInstance().getReference();
        }
        //Caso ja tenha feito a referncia retorne refereceFirebase
        return referenceFirebase;
    }


    //metodo de autenticacao
    public static FirebaseAuth getAutenticacao() {
        if (Autenticacao == null){

            //Caso não tenha uma autenticacao crie uma
            Autenticacao = FirebaseAuth.getInstance();
        }
        //Caso ja tenha feito a autenticacao  retorne
        return Autenticacao;
    }
}
