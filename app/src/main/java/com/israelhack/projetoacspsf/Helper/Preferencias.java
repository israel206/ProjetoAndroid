package com.israelhack.projetoacspsf.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias{

    /**
     * Salvar quando o usuario estiver logado ou não
     * O que a class prefere faz
     */

    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "projetoacspsf.preferecias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,MODE);

        editor = preferences.edit();
    }
    public void salvaUsuarioPreferencias(String idenficadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, idenficadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }
    public String getIdenficador(){
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }
    public String getNome(){
        return preferences.getString(CHAVE_NOME,null);
    }


}
