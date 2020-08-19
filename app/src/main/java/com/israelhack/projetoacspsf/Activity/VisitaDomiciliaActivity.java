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

import com.israelhack.projetoacspsf.Adapter.VisitarDomiciliarAdapter;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.VisitaDomiciliar;
import com.israelhack.projetoacspsf.R;

import java.util.ArrayList;

public class VisitaDomiciliaActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<VisitaDomiciliar> adapter;
    private ArrayList<VisitaDomiciliar> visitaDomiciliar;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerVisitaDomiciliar;
    private Button btnVoltarTelaInicial;
    private AlertDialog alerta;
    private VisitaDomiciliar visitaDomiciliarExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_domicilia);

        visitaDomiciliar = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewVisitaDomiciliar);
        adapter = new VisitarDomiciliarAdapter(this, visitaDomiciliar);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("VisitaDomiciliar");

        valueEventListenerVisitaDomiciliar = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                visitaDomiciliar.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    VisitaDomiciliar visitaDomiciliarNovo = dados.getValue(VisitaDomiciliar.class);

                    visitaDomiciliar.add(visitaDomiciliarNovo);
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

                visitaDomiciliarExcluir = adapter.getItem(i);

                //cria o gerador do alertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(VisitaDomiciliaActivity.this);

                //Define o título
                builder.setTitle("Confirma exclusão?");

                //define uma mensagem
                builder.setMessage("Você deseja excluir - " + visitaDomiciliarExcluir.getNumCartaoSus().toString() + " - ?");

                //define botão sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebase = ConfiguracaoFirebase.getFirebase().child("VisitaDomiciliar");

                        firebase.child(visitaDomiciliarExcluir.getNumCartaoSus().toString()).removeValue();

                        Toast.makeText(VisitaDomiciliaActivity.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //define o botão não
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(VisitaDomiciliaActivity.this, "Exclusão Cancelada!", Toast.LENGTH_LONG).show();
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
        Intent intent = new Intent(VisitaDomiciliaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerVisitaDomiciliar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerVisitaDomiciliar);
    }
}
