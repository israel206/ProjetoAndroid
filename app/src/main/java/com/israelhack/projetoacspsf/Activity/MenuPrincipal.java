package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.israelhack.projetoacspsf.Entidades.AtividadeColetiva;
import com.israelhack.projetoacspsf.Entidades.CadastroDomiciliar;
import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.Entidades.VisitaDomiciliar;
import com.israelhack.projetoacspsf.R;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    // atributos das cardView
    private CardView cadIndCard, cadDomCard, fichAtCard, visitDomCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // definição das cardView
        cadIndCard = (CardView) findViewById(R.id.cad_Ind);
        cadDomCard = (CardView) findViewById(R.id.cad_domic);
        fichAtCard = (CardView) findViewById(R.id.fich_Atend);
        visitDomCard = (CardView) findViewById(R.id.visit_Domic);

        //adicionando ouvintes de click na cardView
        cadIndCard.setOnClickListener(this);
        cadDomCard.setOnClickListener(this);
        fichAtCard.setOnClickListener(this);
        visitDomCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //intenção
        Intent i;
        switch (v.getId()){
            case R.id.cad_Ind : i = new Intent(this,CadastroIndividual.class);startActivity(i); break;
            case R.id.cad_domic : i = new Intent(this,CadastroDomiciliar.class);startActivity(i); break;
            case R.id.fich_Atend : i = new Intent(this,AtividadeColetiva.class);startActivity(i); break;
            case R.id.visit_Domic : i = new Intent(this,VisitaDomiciliar.class); startActivity(i);break;
            default:break;
        }

    }
}
