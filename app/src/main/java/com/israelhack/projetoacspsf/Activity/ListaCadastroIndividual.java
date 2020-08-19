package com.israelhack.projetoacspsf.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import com.israelhack.projetoacspsf.Adapter.IndividualAdapter;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.R;

import java.util.ArrayList;

public class ListaCadastroIndividual extends AppCompatActivity {
/**
    private ListView listView;
    private ArrayAdapter<CadastroIndividual> adapter;
    private ArrayList<CadastroIndividual> individual;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerIndividual;
    private Button btnVoltarTelaInicial;
    private AlertDialog alerta;
    private CadastroIndividual IndividualExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cadastro_individual);

        individual = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewIndividual);
        adapter = new IndividualAdapter(this, individual);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("Individual");

        valueEventListenerIndividual = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                individual.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    CadastroIndividual cadastroIndividualNovo = dados.getValue(CadastroIndividual.class);

                    individual.add(cadastroIndividualNovo);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial2);
        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTelaInicial();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                IndividualExcluir = adapter.getItem(i);

                //cria o gerador do alertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaCadastroIndividual.this);

                //Define o título
                builder.setTitle("Confirma exclusão?");

                //define uma mensagem
                builder.setMessage("Você deseja excluir - " + IndividualExcluir.getNomeCompleto().toString() + " - ?");

                //define botão sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebase = ConfiguracaoFirebase.getFirebase().child("addprodutos");

                        firebase.child(IndividualExcluir.getNomeCompleto().toString()).removeValue();

                        Toast.makeText(ListaCadastroIndividual.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //define o botão não

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListaCadastroIndividual.this, "Exclusão Cancelada efetuada!", Toast.LENGTH_LONG).show();
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
        Intent intent = new Intent(ListaCadastroIndividual.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerIndividual);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerIndividual);
    }
    **/
}
