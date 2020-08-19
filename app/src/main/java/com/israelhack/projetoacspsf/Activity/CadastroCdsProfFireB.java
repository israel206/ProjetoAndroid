package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.CadastroCdsProf;
import com.israelhack.projetoacspsf.Helper.Base64Custom;
import com.israelhack.projetoacspsf.Helper.Preferencias;
import com.israelhack.projetoacspsf.R;

public class CadastroCdsProfFireB extends AppCompatActivity {

    private EditText edtCadNome;
    private EditText edtCadEmail;
    private EditText edtCadSenha;
    private EditText edtCadConfirmaSenha;
    private EditText edtCadNU_CNS;
    private EditText edtCadNU_INE;
    private EditText edtCadNU_CBO;
    private EditText edtCadNU_CNES;
    private Button btnSalvar,btnVoltarTelaLogin;
    private CadastroCdsProf profissional;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastro_cds_prof_fire_b);

        //Recuperando
        edtCadNome = (EditText)findViewById(R.id.edtCadNome);
        edtCadEmail = (EditText)findViewById(R.id.edtCadEmail);
        edtCadSenha = (EditText)findViewById(R.id.edtCadSenha);
        edtCadConfirmaSenha = (EditText)findViewById(R.id.edtCadConfirmaSenha);
        edtCadNU_CNS = (EditText)findViewById(R.id.edtCadNU_CNS);
        edtCadNU_INE = (EditText)findViewById(R.id.edtCadNU_INE);
        edtCadNU_CBO = (EditText)findViewById(R.id.edtCadNU_CBO);
        edtCadNU_CNES = (EditText)findViewById(R.id.edtCadNU_CNES);



        btnVoltarTelaLogin = (Button) findViewById(R.id.btnVoltarTelaLogin);
        btnVoltarTelaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoltarTelaLogin();
            }
        });

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        // Evento de click do button
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            // metodo Onclick
            @Override
            public void onClick(View v) {
                // Ser edtCadsenha senha for igual a editCadConfirma senha ok, se não re-digite a senha
                if (edtCadSenha.getText().toString().equals(edtCadConfirmaSenha.getText().toString())){

                    // intancia da classe cadastroCdsProf
                    profissional = new CadastroCdsProf();

                    profissional.setNome(edtCadNome.getText().toString());
                    profissional.setEmail(edtCadEmail.getText().toString());
                    profissional.setSenha(edtCadSenha.getText().toString());
                    profissional.setNU_CNS(edtCadNU_CNS.getText().toString());
                    profissional.setNU_INE(edtCadNU_INE.getText().toString());
                    profissional.setNU_CBO(edtCadNU_CBO.getText().toString());
                    profissional.setNU_CNES(edtCadNU_CNES.getText().toString());

                    //metodo cadastraProf
                    cadastrarProfissional();

                // Ser não Re-digite a senha
                }else {
                    Toast.makeText(CadastroCdsProfFireB.this, "As senhas não correspondentes", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void cadastrarProfissional(){
        // autenticação do firebase
        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(profissional.getEmail(), profissional.getSenha()).addOnCompleteListener(CadastroCdsProfFireB.this, new OnCompleteListener<AuthResult>() {
          // metodos Oncomplete
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                // ser deu certo a criacao
                if (task.isSuccessful()){
                    Toast.makeText(CadastroCdsProfFireB.this, "Profissional cadastrado com sucesso", Toast.LENGTH_LONG).show();

                   // codificar os dados do profissional
                    String identificadorProfissional = Base64Custom.codificarBase64(profissional.getEmail());

                    FirebaseUser profissionalFirebase = task.getResult().getUser();
                    profissional.setId(identificadorProfissional);
                    profissional.salvar();

                    Preferencias preferencias = new Preferencias(CadastroCdsProfFireB.this);
                    preferencias.salvaUsuarioPreferencias(identificadorProfissional, profissional.getNome());

                    // metodos abrir login
                    abrirLoginProf();

                    // excecoes
                }else {
                    String erroExcecao = "";
                    try {

                        throw task.getException();

                        //teste de exceçoes
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = " Digite uma senha mais forte, contendo no minimo 8 caracteres de letras e numeros";

                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = " O e-mail digitado é invalido, digite uma novo e-mail";

                    }catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = " Esse e-mail já esta cadastrado no sistema";

                    }catch (Exception e) {
                        erroExcecao = " Erro ao efetuar o cadastro ";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroCdsProfFireB.this, "Erro:" + erroExcecao, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // metodos para abrir a tela de login
    public void abrirLoginProf(){
        Intent intent = new Intent(CadastroCdsProfFireB.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void VoltarTelaLogin(){
        Intent intent = new Intent(CadastroCdsProfFireB.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
