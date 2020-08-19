package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.israelhack.projetoacspsf.ConexaoDB.ConfiguracaoFirebase;
import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.Entidades.VisitaDomiciliar;
import com.israelhack.projetoacspsf.R;

public class VisitaDomiciliarFireB extends AppCompatActivity {

    private EditText txtDtAtendimento,txtTipoMovel,txtNumCartaoSus,txtDtNascimento;
    private Spinner spiTurno,spiMotivoVisita,spiSexo,spiStVisitaCompartilhada,spiControleVetoria,spiDesfecho;

    private Button btnSalvarVisitaDomiciliar,btnVoltarTelaInicial;
    private VisitaDomiciliar visitaDomiciliar;
    private DatabaseReference referenceFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_domiciliar_fire_b);

        txtDtAtendimento = (EditText)findViewById(R.id.txtDtAtendimento);
        txtTipoMovel = (EditText)findViewById(R.id.txtTipoMovel);
        txtNumCartaoSus = (EditText)findViewById(R.id.txtNumCartaoSus);
        txtDtNascimento = (EditText)findViewById(R.id.txtDtNascimento);

        spiTurno = (Spinner) findViewById(R.id.spiTurno);
        ArrayAdapter listaTurnos = ArrayAdapter.createFromResource(this, R.array.Turno, android.R.layout.simple_spinner_item);
        spiTurno.setAdapter(listaTurnos);

        spiMotivoVisita = (Spinner) findViewById(R.id.spiMotivoVisita);
        ArrayAdapter listaMotivoVisita = ArrayAdapter.createFromResource(this, R.array.motivoVisita, android.R.layout.simple_spinner_item);
        spiMotivoVisita.setAdapter(listaMotivoVisita);

        spiSexo = (Spinner) findViewById(R.id.spiSexo);
        ArrayAdapter listaSexo = ArrayAdapter.createFromResource(this, R.array.Sexo, android.R.layout.simple_spinner_item);
        spiSexo.setAdapter(listaSexo);

        spiStVisitaCompartilhada = (Spinner) findViewById(R.id.spiStVisitaCompartilhada);
        ArrayAdapter listaStVisitaCompartilhada = ArrayAdapter.createFromResource(this, R.array.stVisitaCompartilhada, android.R.layout.simple_spinner_item);
        spiStVisitaCompartilhada.setAdapter(listaStVisitaCompartilhada);

        spiControleVetoria = (Spinner) findViewById(R.id.spiControleVetoria);
        ArrayAdapter listaControleVetoria = ArrayAdapter.createFromResource(this, R.array.controleVetorial, android.R.layout.simple_spinner_item);
        spiControleVetoria.setAdapter(listaControleVetoria);

        spiDesfecho = (Spinner) findViewById(R.id.spiDesfecho);
        ArrayAdapter listaDesfecho = ArrayAdapter.createFromResource(this, R.array.controleVetorial, android.R.layout.simple_spinner_item);
        spiDesfecho.setAdapter(listaDesfecho);

        btnSalvarVisitaDomiciliar = (Button) findViewById(R.id.btnSalvarVisitaDomiciliar);

        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);


        btnSalvarVisitaDomiciliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                visitaDomiciliar = new VisitaDomiciliar();
                visitaDomiciliar.setTurno(spiTurno.getSelectedItem().toString());
                visitaDomiciliar.setDtAtendimento(txtDtAtendimento.getText().toString());
                visitaDomiciliar.setMotivoVisita(spiMotivoVisita.getSelectedItem().toString());
                visitaDomiciliar.setTipoMovel(txtTipoMovel.getText().toString());
                visitaDomiciliar.setNumCartaoSus(txtNumCartaoSus.getText().toString());
                visitaDomiciliar.setDtNascimento(txtDtNascimento.getText().toString());
                visitaDomiciliar.setSexo(spiSexo.getSelectedItem().toString());
                visitaDomiciliar.setStVisitaCompartilhada(spiStVisitaCompartilhada.getSelectedItem().toString());
                visitaDomiciliar.setControleVetorial(spiControleVetoria.getSelectedItem().toString());
                visitaDomiciliar.setDesfecho(spiDesfecho.getSelectedItem().toString());

                AddVisitaDomiciliar(visitaDomiciliar);

            }
        });

        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoltarTelaInicial();
            }
        });
    }
    private boolean AddVisitaDomiciliar(VisitaDomiciliar visitaDomiciliar){

        try {
            referenceFirebase = ConfiguracaoFirebase.getFirebase().child("VisitaDomiciliar");
            referenceFirebase.child(visitaDomiciliar.getNumCartaoSus()).setValue(visitaDomiciliar);

            Toast.makeText(VisitaDomiciliarFireB.this, "Visita inserido com sucesso", Toast.LENGTH_LONG).show();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private void VoltarTelaInicial(){
        Intent intent = new Intent(VisitaDomiciliarFireB.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
