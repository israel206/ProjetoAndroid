package com.israelhack.projetoacspsf.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.israelhack.projetoacspsf.Adapter.DomicilarAdapter;
import com.israelhack.projetoacspsf.Adapter.IndividualAdapter;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.CadastroDomiciliar;
import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.R;

import java.util.ArrayList;

public class DomiciliarActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<CadastroDomiciliar> adapter;
    private ArrayList<CadastroDomiciliar> domiciliar;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerDomiciliar;
    private Button btnVoltarTelaInicial;
    private AlertDialog alerta;
    private CadastroDomiciliar domiciliarExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domiciliar);

        domiciliar = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewDomiciliar);
        adapter = new DomicilarAdapter(this, domiciliar);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("CadDomiciliar");

        valueEventListenerDomiciliar = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                domiciliar.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    CadastroDomiciliar cadastroDomiciliarNovo = dados.getValue(CadastroDomiciliar.class);

                    domiciliar.add(cadastroDomiciliarNovo);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);

        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTelaInicial();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                domiciliarExcluir = adapter.getItem(i);

                //cria o gerador do alertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(DomiciliarActivity.this);

                //Define o título
                builder.setTitle("Confirma exclusão?");

                //define uma mensagem
                builder.setMessage("Você deseja excluir - " + domiciliarExcluir.getNomeMunicipio().toString() + " - ?");

                //define botão sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebase = ConfiguracaoFirebase.getFirebase().child("CadDomiciliar");

                        firebase.child(domiciliarExcluir.getNomeMunicipio().toString()).removeValue();

                        Toast.makeText(DomiciliarActivity.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //define o botão não

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DomiciliarActivity.this, "Exclusão Cancelada efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //criar o alertdialog
                alerta = builder.create();

                //exibe alertdialog
                alerta.show();
            }
        });

    }

    private void voltarTelaInicial() {
        Intent intent = new Intent(DomiciliarActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerDomiciliar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerDomiciliar);
    }
}
