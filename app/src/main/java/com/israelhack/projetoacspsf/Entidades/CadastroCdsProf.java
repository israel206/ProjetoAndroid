package com.israelhack.projetoacspsf.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Israel
 * Meu objeto Cadastro do profissional ou class
 */

public class CadastroCdsProf {

    // atributos de cds Profissional
    private String id;
    private String Nome;
    private String Email;
    private String Senha;
    private String NU_CNS;
    private String NU_INE;
    private String NU_CBO;
    private String NU_CNES;

    // contrutor vazio
    public CadastroCdsProf(){
    }

    // metodos salva
    public void salvar(){

        //salva auteticacao, e cria um db
        DatabaseReference referenceFirebase = ConfiguracaoFirebase.getFirebase();
        referenceFirebase.child("cadastroCdsProf").child(String.valueOf(getId())).setValue(this);
    }

    //
    @Exclude

    public Map<String, Object> toMap(){
        HashMap<String, Object> hashMapcadastroCdsProf = new HashMap<>();

        hashMapcadastroCdsProf.put("id",getId());
        hashMapcadastroCdsProf.put("Nome",getNome());
        hashMapcadastroCdsProf.put("Email",getEmail());
        hashMapcadastroCdsProf.put("senha",getSenha());
        hashMapcadastroCdsProf.put("NU_CNS",getNU_CNS());
        hashMapcadastroCdsProf.put("NU_INE",getNU_INE());
        hashMapcadastroCdsProf.put("NU_CBO",getNU_CBO());
        hashMapcadastroCdsProf.put("NU_CNES",getNU_CNES());

        return hashMapcadastroCdsProf;
    }

    // get e set

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
    public String getNU_CNS() {
        return NU_CNS;
    }

    public void setNU_CNS(String NU_CNS) {
        this.NU_CNS = NU_CNS;
    }

    public String getNU_INE() {
        return NU_INE;
    }

    public void setNU_INE(String NU_INE) {
        this.NU_INE = NU_INE;
    }

    public String getNU_CBO() {
        return NU_CBO;
    }

    public void setNU_CBO(String NU_CBO) {
        this.NU_CBO = NU_CBO;
    }

    public String getNU_CNES() {
        return NU_CNES;
    }

    public void setNU_CNES(String NU_CNES) {
        this.NU_CNES = NU_CNES;
    }

}
