package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.CadastroCdsProf;
import com.israelhack.projetoacspsf.R;

/**
 * Uma tela de login que oferece login via email / senha.
 */
public class LoginActivity extends AppCompatActivity {

    // atributos ou referencias
    private EditText edtEmail;
    private EditText edtSenha;
    private TextView tvAbreCadastro;
    private Button btnLogar;
    private CadastroCdsProf profissionalAcs;
    private FirebaseAuth Autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        // Recuperando os atributos
        Autenticacao = FirebaseAuth.getInstance();
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        tvAbreCadastro = (TextView) findViewById(R.id.tvAbreCadastro);
        btnLogar = (Button) findViewById(R.id.btnLogar);

        //Evento Onclick de logar ususario
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ser não estive vazio o user digite
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {

                    //instancia de CadastroCdsProf
                    profissionalAcs = new CadastroCdsProf();
                    profissionalAcs.setEmail(edtEmail.getText().toString());
                    profissionalAcs.setSenha(edtSenha.getText().toString());

                    //chamando metodo
                    validaLogin();

                    // preencher os campus de email e senha
                } else {
                    //Toast mensagem da tela preencher campos
                    Toast.makeText(LoginActivity.this, "preencher campos de E-mail e Senha!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Evento Onclick abrir cadastro
        tvAbreCadastro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroProfissional();
            }
        });
    }

    // metodos de validação de login
    private void validaLogin() {
        //auteticacao recebe de configuracaFirebase de getauteticacao
        Autenticacao = ConfiguracaoFirebase.getAutenticacao();
        //chamando o email e senha
        Autenticacao.signInWithEmailAndPassword(profissionalAcs.getEmail(), profissionalAcs.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // Sucesso
                if (task.isSuccessful()) {

                    // metodos abrir menu principal
                    abrirMenu();

                    // mensagem de acesso positivo
                    Toast.makeText(LoginActivity.this, "Login efetuado com sucesso",
                            Toast.LENGTH_SHORT).show();

                    // mensagem de acesso negativo
                }else{
                    Toast.makeText(LoginActivity.this, "Login ou senha invalida",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    // metodo de chamada do Menu inicial ou principal
    public void abrirMenu() {
        Intent intentAbrirMenu = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentAbrirMenu);
    }

    // metodo de chamada de abrir cadastro do profissional
    public void abrirCadastroProfissional(){
        Intent intent = new Intent(LoginActivity.this, CadastroCdsProfFireB.class);
        startActivity(intent);

    }

}






