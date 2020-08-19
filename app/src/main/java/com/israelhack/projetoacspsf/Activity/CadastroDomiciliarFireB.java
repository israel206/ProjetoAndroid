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
import com.israelhack.projetoacspsf.Entidades.CadastroDomiciliar;

import com.israelhack.projetoacspsf.R;



public class CadastroDomiciliarFireB extends AppCompatActivity {


    private EditText editCep,editNomeMunicipio,editNomeBairro,editEstado,editNomeLogradouro,editNumero,
            editNomeComplemento,editPontoReferencia,editNumeroResidencia,editNumeroCelular,editAnimaisDomicilio;

    private Spinner spiSituacaoMoradia,spiLocalizacao,spiTipoDomicilio,spiTipoAcessoDomicilio,
            spiCondicaoPosseTerra,spiEnergia,spiMaterialConstrucao,spiAbastecimento,spiAguaConsumoDomicilio,
            spiEscoamentoSanitario,spiDestinoLixo;

    private Button btnGravar, btnVoltarTelaInicial;

    private DatabaseReference referenceFirebase;

    private CadastroDomiciliar domiciliar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastro_domiciliar_fire_b);

        editCep = (EditText)findViewById(R.id.editCep);
        editNomeMunicipio = (EditText)findViewById(R.id.editNomeMunicipio);
        editNomeBairro = (EditText)findViewById(R.id.editNomeBairro);
        editEstado = (EditText)findViewById(R.id.editEstado);
        editNomeLogradouro = (EditText)findViewById(R.id.editNomeLogradouro);
        editNumero = (EditText)findViewById(R.id.editNumero);
        editNomeComplemento = (EditText)findViewById(R.id.editNomeComplemento);
        editPontoReferencia = (EditText)findViewById(R.id.editPontoReferencia);
        editNumeroResidencia = (EditText)findViewById(R.id.editNumeroResidencia);
        editNumeroCelular = (EditText)findViewById(R.id.editNumeroCelular);


        // ComboBox
        spiSituacaoMoradia = (Spinner) findViewById(R.id.spiSituacaoMoradia);
        ArrayAdapter listaSituacaoMoradia = ArrayAdapter.createFromResource(this, R.array.situacaoMoradia, android.R.layout.simple_spinner_item);
        spiSituacaoMoradia.setAdapter(listaSituacaoMoradia);


        // ComboBox
        spiLocalizacao = (Spinner) findViewById(R.id.spiLocalizacao);
        ArrayAdapter listaLocalizacao = ArrayAdapter.createFromResource(this, R.array.localizacao, android.R.layout.simple_spinner_item);
        spiLocalizacao.setAdapter(listaLocalizacao);


        // ComboBox
        spiTipoDomicilio = (Spinner) findViewById(R.id.spiTipoDomicilio);
        ArrayAdapter listaTipoDomicilio = ArrayAdapter.createFromResource(this, R.array.tipoDomicilio, android.R.layout.simple_spinner_item);
        spiTipoDomicilio.setAdapter(listaTipoDomicilio);

        // ComboBox
        spiTipoAcessoDomicilio = (Spinner) findViewById(R.id.spiTipoAcessoDomicilio);
        ArrayAdapter listaTipoAcessoDomicilio = ArrayAdapter.createFromResource(this, R.array.tipoAcessoDomicilio, android.R.layout.simple_spinner_item);
        spiTipoAcessoDomicilio.setAdapter(listaTipoAcessoDomicilio);

        // ComboBox
        spiCondicaoPosseTerra = (Spinner) findViewById(R.id.spiCondicaoPosseTerra);
        ArrayAdapter listaCondicaoPosseTerra = ArrayAdapter.createFromResource(this, R.array.condicaoPosseiTerra, android.R.layout.simple_spinner_item);
        spiCondicaoPosseTerra.setAdapter(listaCondicaoPosseTerra);

        // ComboBox
        spiEnergia = (Spinner) findViewById(R.id.spiEnergia);
        ArrayAdapter listaEnergia = ArrayAdapter.createFromResource(this, R.array.energia, android.R.layout.simple_spinner_item);
        spiEnergia.setAdapter(listaEnergia);

        // ComboBox
        spiMaterialConstrucao = (Spinner) findViewById(R.id.spiMaterialConstrucao);
        ArrayAdapter listaMaterialConstrucao = ArrayAdapter.createFromResource(this, R.array.materialCnstrucao, android.R.layout.simple_spinner_item);
        spiMaterialConstrucao.setAdapter(listaMaterialConstrucao);

        // ComboBox
        spiAbastecimento = (Spinner) findViewById(R.id.spiAbastecimento);
        ArrayAdapter listaAbastecimento = ArrayAdapter.createFromResource(this, R.array.abastecimentoAgua, android.R.layout.simple_spinner_item);
        spiAbastecimento.setAdapter(listaAbastecimento);

        // ComboBox
        spiAguaConsumoDomicilio = (Spinner) findViewById(R.id.spiAguaConsumoDomicilio);
        ArrayAdapter listaAguaConsumoDomicilio = ArrayAdapter.createFromResource(this, R.array.aguaConsumoDomicilio, android.R.layout.simple_spinner_item);
        spiAguaConsumoDomicilio.setAdapter(listaAguaConsumoDomicilio);

        // ComboBox
        spiEscoamentoSanitario = (Spinner) findViewById(R.id.spiEscoamentoSanitario);
        ArrayAdapter listaEscoamentoSanitario = ArrayAdapter.createFromResource(this, R.array.escoamentoSanitario, android.R.layout.simple_spinner_item);
        spiEscoamentoSanitario.setAdapter(listaEscoamentoSanitario);

        // ComboBox
        spiDestinoLixo = (Spinner) findViewById(R.id.spiDestinoLixo);
        ArrayAdapter listaDestinoLixo = ArrayAdapter.createFromResource(this, R.array.destinoLixo, android.R.layout.simple_spinner_item);
        spiDestinoLixo.setAdapter(listaDestinoLixo);

        editAnimaisDomicilio = (EditText)findViewById(R.id.editAnimaisDomicilio);


        btnGravar = (Button) findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                domiciliar = new CadastroDomiciliar();

                domiciliar.setCep(editCep.getText().toString());
                domiciliar.setNomeMunicipio(editNomeMunicipio.getText().toString());
                domiciliar.setNomeBairro(editNomeBairro.getText().toString());
                domiciliar.setNomeEstado(editEstado.getText().toString());
                domiciliar.setNomeLogradouro(editNomeLogradouro.getText().toString());
                domiciliar.setNumero(editNumero.getText().toString());
                domiciliar.setNomeComplemento(editNomeComplemento.getText().toString());
                domiciliar.setPontoReferencia(editPontoReferencia.getText().toString());
                domiciliar.setNumeroResidencia(editNumeroResidencia.getText().toString());
                domiciliar.setNumeroCelular(editNumeroCelular.getText().toString());

                domiciliar.setSituacaoMoradia(spiSituacaoMoradia.getSelectedItem().toString());
                domiciliar.setLocalizacao(spiLocalizacao.getSelectedItem().toString());
                domiciliar.setTipoDomicilio(spiTipoDomicilio.getSelectedItem().toString());
                domiciliar.setTipoAcessoDomicilio(spiTipoAcessoDomicilio.getSelectedItem().toString());
                domiciliar.setCondicaoPosseTerra(spiCondicaoPosseTerra.getSelectedItem().toString());
                domiciliar.setEnergia(spiEnergia.getSelectedItem().toString());
                domiciliar.setMaterialConstrucao(spiMaterialConstrucao.getSelectedItem().toString());
                domiciliar.setAbastecimentoAgua(spiAbastecimento.getSelectedItem().toString());
                domiciliar.setAguaConsumoDomicilio(spiAguaConsumoDomicilio.getSelectedItem().toString());
                domiciliar.setEscoamentoSanitario(spiEscoamentoSanitario.getSelectedItem().toString());
                domiciliar.setDestinoLixo(spiDestinoLixo.getSelectedItem().toString());
                domiciliar.setAnimaisDomicilio(editAnimaisDomicilio.getText().toString());

                //metodo
                cadastroDomiciliar(domiciliar);
            }
        });

        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);

        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoltarTelaInicial();
            }
        });
    }
    private boolean cadastroDomiciliar(CadastroDomiciliar domiciliar){

        try {
            referenceFirebase = ConfiguracaoFirebase.getFirebase().child("CadDomiciliar");
            referenceFirebase.child(domiciliar.getNomeMunicipio()).setValue(domiciliar);

            Toast.makeText(CadastroDomiciliarFireB.this, "Cadastro Domiciliar inserido com sucesso", Toast.LENGTH_LONG).show();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    private void VoltarTelaInicial(){
        Intent intent = new Intent(CadastroDomiciliarFireB.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
