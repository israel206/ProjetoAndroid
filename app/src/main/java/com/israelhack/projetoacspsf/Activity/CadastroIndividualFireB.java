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
import com.israelhack.projetoacspsf.R;


public class CadastroIndividualFireB extends AppCompatActivity {


    private EditText txtCnsCidadao,txtCnsResponsavelFamiliar,txtNomeCompleto, txtNomeSocial,txtDataDeNascimento,
            txtDadosPis,txtNomeMae,txtNomePai,txtPaisNascimento,txtDataDeNaturalizacao,txtPortariaDeNaturalizacao,
            txtMunicipioNascimento,txtDataEntradaBrasil,txtTelCelular,txtEmail;

    private Spinner txtCidadaoResponsavelFamiliar,txtRacaCor,txtSexo,txtNacionalidade,txtRelacaoParentesco,txtFrequentouEscola,txtSituacaoMercado,
            txtDeficiencia,txtGestante,txtPeso,txtRespiratorioPulmao,txtFumante,txtAlcool,txtOutrasDrogas,
            txtHipertansao,txtDiabete,txtAvcDerrame,txtInfarto,txtCardiaca,txtHanseniase, txtTuberculose,
            txtCancer,txtRins;

    private Button btnSalvarIndividual,btnVoltarTelaInicial;

    private CadastroIndividual individual;

    private DatabaseReference referenceFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastro_individual_fire_b);

        // INICIANDO OS CAMPOS CRIADOS NO ARQUIVO
        txtCnsCidadao = (EditText)findViewById(R.id.txtCnsCidadao);
        txtCnsResponsavelFamiliar = (EditText) findViewById(R.id.txtCnsResponsavelFamiliar);
        txtNomeCompleto = (EditText)findViewById(R.id.txtNomeCompleto);
        txtNomeSocial = (EditText)findViewById(R.id.txtNomeSocial);
        txtDataDeNascimento = (EditText)findViewById(R.id.txtDataDeNascimento);
        txtDadosPis = (EditText)findViewById(R.id.txtDadosPis);
        txtNomeMae = (EditText)findViewById(R.id.txtNomeMae);
        txtNomePai = (EditText)findViewById(R.id.txtNomePai);
        txtPaisNascimento = (EditText)findViewById(R.id.txtPaisNascimento);
        txtDataDeNaturalizacao = (EditText)findViewById(R.id.txtDataDeNaturalizacao);
        txtPortariaDeNaturalizacao = (EditText)findViewById(R.id.txtPortariaDeNaturalizacao);
        txtMunicipioNascimento = (EditText)findViewById(R.id.txtMunicipioNascimento);
        txtDataEntradaBrasil = (EditText)findViewById(R.id.txtDataEntradaBrasil);
        txtTelCelular = (EditText)findViewById(R.id.txtTelCelular);
        txtEmail = (EditText)findViewById(R.id.txtEmail);


        /*********************************************************************
         * CRIANDO AQUI A LISTA VINDOS DIRETO DO AQUIVO strings.xml*
         * INFORMAÇOES SOCIODEMOGRAFICAS
         *********************************************************************/


        txtCidadaoResponsavelFamiliar = (Spinner) findViewById(R.id.txtCidadaoResponsavelFamiliar);
        ArrayAdapter listaCidadaoResponsavelFamiliar = ArrayAdapter.createFromResource(this, R.array.cidadaoResponsavelFamiliar, android.R.layout.simple_spinner_item);
        txtCidadaoResponsavelFamiliar.setAdapter(listaCidadaoResponsavelFamiliar);

        // ComboBox de Raca da pessoa ou cor
        txtRacaCor = (Spinner) findViewById(R.id.txtRacaCor);
        ArrayAdapter listaRacaCor = ArrayAdapter.createFromResource(this, R.array.racaCor, android.R.layout.simple_spinner_item);
        txtRacaCor.setAdapter(listaRacaCor);

        // ComboBox de sexo da pessoa
        txtSexo = (Spinner) findViewById(R.id.txtSexo);
        ArrayAdapter listaSexoPessoa = ArrayAdapter.createFromResource(this, R.array.sexo, android.R.layout.simple_spinner_item);
        txtSexo.setAdapter(listaSexoPessoa);

        // ComboBox de nacionalidade da pessoa
        txtNacionalidade = (Spinner) findViewById(R.id.txtNacionalidade);
        ArrayAdapter listaNacionalidade = ArrayAdapter.createFromResource(this, R.array.nacionalidade, android.R.layout.simple_spinner_item);
        txtNacionalidade.setAdapter(listaNacionalidade);

        // ComboBox de relacao Parentesco da pessoa
        txtRelacaoParentesco = (Spinner) findViewById(R.id.txtRelacaoParentesco);
        ArrayAdapter listaRelacaoParentesco = ArrayAdapter.createFromResource(this, R.array.relacaoParentesco, android.R.layout.simple_spinner_item);
        txtRelacaoParentesco.setAdapter(listaRelacaoParentesco);

        // ComboBox Frequentou a escola
        txtFrequentouEscola = (Spinner) findViewById(R.id.txtFrequentouEscola);
        ArrayAdapter listaFrequentouEscola = ArrayAdapter.createFromResource(this, R.array.frequentouEscola, android.R.layout.simple_spinner_item);
        txtFrequentouEscola.setAdapter(listaFrequentouEscola);

        // ComboBox Situação no Mercado de trabalho
        txtSituacaoMercado = (Spinner) findViewById(R.id.txtSituacaoMercado);
        ArrayAdapter listaSituacaoMercado = ArrayAdapter.createFromResource(this, R.array.situacaoMercado, android.R.layout.simple_spinner_item);
        txtSituacaoMercado.setAdapter(listaSituacaoMercado);

        // ComboBox
        txtDeficiencia = (Spinner) findViewById(R.id.txtDeficiencia);
        ArrayAdapter listaDeficiencia = ArrayAdapter.createFromResource(this, R.array.deficiencia, android.R.layout.simple_spinner_item);
        txtDeficiencia.setAdapter(listaDeficiencia);

        // ComboBox
        txtGestante = (Spinner) findViewById(R.id.txtGestante);
        ArrayAdapter listaGetante = ArrayAdapter.createFromResource(this, R.array.gestante, android.R.layout.simple_spinner_item);
        txtGestante.setAdapter(listaGetante);


        // ComboBox
        txtPeso = (Spinner) findViewById(R.id.txtPeso);
        ArrayAdapter listaPeso = ArrayAdapter.createFromResource(this, R.array.peso, android.R.layout.simple_spinner_item);
        txtPeso.setAdapter(listaPeso);

        // ComboBox
        txtRespiratorioPulmao = (Spinner) findViewById(R.id.txtRespiratorioPulmao);
        ArrayAdapter listaRespiratorio = ArrayAdapter.createFromResource(this, R.array.respiratorioPulmao, android.R.layout.simple_spinner_item);
        txtRespiratorioPulmao.setAdapter(listaRespiratorio);

        // ComboBox
        txtFumante = (Spinner) findViewById(R.id.txtFumante);
        ArrayAdapter listaFumante = ArrayAdapter.createFromResource(this, R.array.fumante, android.R.layout.simple_spinner_item);
        txtFumante.setAdapter(listaFumante);

        // ComboBox
        txtAlcool = (Spinner) findViewById(R.id.txtAlcool);
        ArrayAdapter listaAlcool = ArrayAdapter.createFromResource(this, R.array.alcool, android.R.layout.simple_spinner_item);
        txtAlcool.setAdapter(listaAlcool);

        // ComboBox
        txtOutrasDrogas = (Spinner) findViewById(R.id.txtOutrasDrogas);
        ArrayAdapter listaOutraDrogas = ArrayAdapter.createFromResource(this, R.array.outrasDrogas, android.R.layout.simple_spinner_item);
        txtOutrasDrogas.setAdapter(listaOutraDrogas);

        // ComboBox
        txtHipertansao = (Spinner) findViewById(R.id.txtHipertansao);
        ArrayAdapter listaHipertansao = ArrayAdapter.createFromResource(this, R.array.hipertensao, android.R.layout.simple_spinner_item);
        txtHipertansao.setAdapter(listaHipertansao);

        // ComboBox
        txtDiabete = (Spinner) findViewById(R.id.txtDiabete);
        ArrayAdapter listaDiabete = ArrayAdapter.createFromResource(this, R.array.diabete, android.R.layout.simple_spinner_item);
        txtDiabete.setAdapter(listaDiabete);

        // ComboBox
        txtAvcDerrame = (Spinner) findViewById(R.id.txtAvcDerrame);
        ArrayAdapter listaAvnDerrame = ArrayAdapter.createFromResource(this, R.array.avcDerrame, android.R.layout.simple_spinner_item);
        txtAvcDerrame.setAdapter(listaAvnDerrame);

        // ComboBox
        txtInfarto = (Spinner) findViewById(R.id.txtInfarto);
        ArrayAdapter listaInfarto = ArrayAdapter.createFromResource(this, R.array.infarto, android.R.layout.simple_spinner_item);
        txtInfarto.setAdapter(listaInfarto);

        // ComboBox
        txtCardiaca = (Spinner) findViewById(R.id.txtCardiaca);
        ArrayAdapter listaCardiaca = ArrayAdapter.createFromResource(this, R.array.cardiaca, android.R.layout.simple_spinner_item);
        txtCardiaca.setAdapter(listaCardiaca);

        // ComboBox
        txtHanseniase = (Spinner) findViewById(R.id.txtHanseniase);
        ArrayAdapter listaHansease = ArrayAdapter.createFromResource(this, R.array.hanseniase, android.R.layout.simple_spinner_item);
        txtHanseniase.setAdapter(listaHansease);

        txtTuberculose = (Spinner) findViewById(R.id.txtTuberculose);
        ArrayAdapter listaTuberculose = ArrayAdapter.createFromResource(this, R.array.tuberculose, android.R.layout.simple_spinner_item);
        txtTuberculose.setAdapter(listaTuberculose);

        // ComboBox
        txtCancer = (Spinner) findViewById(R.id.txtCancer);
        ArrayAdapter listaCancer = ArrayAdapter.createFromResource(this, R.array.cancer, android.R.layout.simple_spinner_item);
        txtCancer.setAdapter(listaCancer);

        // ComboBox
        txtRins = (Spinner) findViewById(R.id.txtRins);
        ArrayAdapter listaRins = ArrayAdapter.createFromResource(this, R.array.rins, android.R.layout.simple_spinner_item);
        txtRins.setAdapter(listaRins);


        /**
         * INICIANDO OS BOTÕES CRIADOS E APLICANDO EVENTOS.
         */

        // Botão de salvar dados.
        btnSalvarIndividual = (Button) findViewById(R.id.btnSalvarIndividual);

        // Evento onclick
        btnSalvarIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intancia da classe CadastroIndividual
                individual = new CadastroIndividual();

                individual.setCnsCidadao(txtCnsCidadao.getText().toString());
                individual.setCidadaoResponsavelFamiliar(txtCidadaoResponsavelFamiliar.getSelectedItem().toString());
                individual.setCnsResponsavelFamiliar(txtCnsResponsavelFamiliar.getText().toString());
                individual.setNomeCompleto(txtNomeCompleto.getText().toString());
                individual.setNomeSocial(txtNomeSocial.getText().toString());
                individual.setDataNascimento(txtDataDeNascimento.getText().toString());

                individual.setRacaCor(txtRacaCor.getSelectedItem().toString());
                individual.setSexo(txtSexo.getSelectedItem().toString());

                individual.setDadosPis(txtDadosPis.getText().toString());
                individual.setNomeMae(txtNomeMae.getText().toString());
                individual.setNomePai(txtNomePai.getText().toString());

                individual.setNacionalidade(txtNacionalidade.getSelectedItem().toString());

                individual.setPaizNascimento(txtPaisNascimento.getText().toString());
                individual.setDataNaturalizacao(txtDataDeNaturalizacao.getText().toString());
                individual.setPortariaNaturalizacao(txtPortariaDeNaturalizacao.getText().toString());
                individual.setMunicipioNascimento(txtMunicipioNascimento.getText().toString());
                individual.setDataEntradaBrasil(txtDataEntradaBrasil.getText().toString());
                individual.setTelCelular(txtTelCelular.getText().toString());
                individual.setEmail(txtEmail.getText().toString());

                individual.setRelacaoParentesco(txtRelacaoParentesco.getSelectedItem().toString());
                individual.setFrequentouEscola(txtFrequentouEscola.getSelectedItem().toString());
                individual.setSituacaoMercado(txtSituacaoMercado.getSelectedItem().toString());
                individual.setDeficiencia(txtDeficiencia.getSelectedItem().toString());
                individual.setGestante(txtGestante.getSelectedItem().toString());
                individual.setRespiratorioPulmao(txtRespiratorioPulmao.getSelectedItem().toString());
                individual.setFumante(txtFumante.getSelectedItem().toString());
                individual.setAlcool(txtAlcool.getSelectedItem().toString());
                individual.setOutraDrogas(txtOutrasDrogas.getSelectedItem().toString());
                individual.setHipertensao(txtHipertansao.getSelectedItem().toString());
                individual.setDiabete(txtDiabete.getSelectedItem().toString());
                individual.setAvcDerrame(txtAvcDerrame.getSelectedItem().toString());
                individual.setInfarto(txtInfarto.getSelectedItem().toString());
                individual.setHanseniase(txtHanseniase.getSelectedItem().toString());
                individual.setTuberculose(txtTuberculose.getSelectedItem().toString());
                individual.setCancer(txtCancer.getSelectedItem().toString());
                individual.setRins(txtRins.getSelectedItem().toString());


                //metodo cadastroIndividual
                cadastroIndividual(individual);

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
    // Com os paramentros de cadastroIndividual
    private boolean cadastroIndividual(CadastroIndividual individual){

        try {
            referenceFirebase = ConfiguracaoFirebase.getFirebase().child("Individual");
            referenceFirebase.child(individual.getNomeCompleto()).setValue(individual);

            Toast.makeText(CadastroIndividualFireB.this, "Cadastro individual inserido com sucesso", Toast.LENGTH_LONG).show();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    private void VoltarTelaInicial(){
        Intent intent = new Intent(CadastroIndividualFireB.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
