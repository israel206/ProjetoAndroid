package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.R;

public class HistoricoGeral extends AppCompatActivity {

    private FirebaseAuth usuarioFirebase;

    private Button btnAddIndividuo, btnListarIndividual, btnAddCadDomiciliar,
            btnListarDomiciliar,btnAddVisitaDomiciliar,btnListarVisitaDomiciliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_geral);

        usuarioFirebase = ConfiguracaoFirebase.getAutenticacao();

        //botoes de cadastros individual historico
        btnAddIndividuo = (Button) findViewById(R.id.btnAddIndividuo);
        btnListarIndividual = (Button) findViewById(R.id.btnListarIndividual);
        btnAddIndividuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddIndividuo();

            }
        });
        btnListarIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaIndividual();

            }
        });

        //botoes de cadastros domiciliar historico
        btnAddCadDomiciliar = (Button)findViewById(R.id.btnAddCadDomiciliar);
        btnListarDomiciliar = (Button)findViewById(R.id.btnListarDomiciliar);
        btnAddCadDomiciliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCadDomiciliar();
            }
        });
        btnListarDomiciliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaDormiciliar();
            }
        });

        //Botoes de Visita domiciliar historico
        btnAddVisitaDomiciliar = (Button)findViewById(R.id.btnAddVisitaDomiciliar);
        btnListarVisitaDomiciliar = (Button)findViewById(R.id.btnListarVisitaDomiciliar);
        btnAddVisitaDomiciliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddVisitaDomiciliar();
            }
        });
        btnListarVisitaDomiciliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListarVisitaDomiciliar();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.historico_geral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            deslogarUsuario();
        }
        return super.onOptionsItemSelected(item);
    }

    private void deslogarUsuario() {
        usuarioFirebase.signOut();
        Intent intent = new Intent(HistoricoGeral.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    //metodos cadastroIndividual
    private void AddIndividuo(){
        Intent intent = new Intent(HistoricoGeral.this,CadastroIndividualFireB.class);
        startActivity(intent);
        finish();
    }
    private void ListaIndividual(){
        Intent intent = new Intent(HistoricoGeral.this,IndividualActivity.class);
        startActivity(intent);
        finish();
    }

    //metodos cadastroDomiciliar
    private void AddCadDomiciliar(){
        Intent intent = new Intent(HistoricoGeral.this,CadastroDomiciliarFireB.class);
        startActivity(intent);
        finish();
    }
    private void ListaDormiciliar(){
        Intent intent = new Intent(HistoricoGeral.this,DomiciliarActivity.class);
        startActivity(intent);
        finish();
    }

    //metodos Visitar domiciliar
    private void AddVisitaDomiciliar(){
        Intent intent = new Intent(HistoricoGeral.this,VisitaDomiciliarFireB.class);
        startActivity(intent);
        finish();
    }
    private void ListarVisitaDomiciliar(){
        Intent intent = new Intent(HistoricoGeral.this,VisitaDomiciliaActivity.class);
        startActivity(intent);
        finish();
    }
}
