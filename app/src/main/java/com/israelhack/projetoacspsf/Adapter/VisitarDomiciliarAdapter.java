package com.israelhack.projetoacspsf.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.Entidades.VisitaDomiciliar;
import com.israelhack.projetoacspsf.R;

import java.util.ArrayList;

public class VisitarDomiciliarAdapter extends ArrayAdapter<VisitaDomiciliar> {

    private ArrayList<VisitaDomiciliar> visitaDomiciliar;
    private Context context;

    public VisitarDomiciliarAdapter(Context cont, ArrayList<VisitaDomiciliar> objects) {
        super(cont, 0, objects);

        this.context = cont;
        this.visitaDomiciliar = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (visitaDomiciliar != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_domiciliar, parent, false);

            TextView txtViewCartaoSus = (TextView) view.findViewById(R.id.txtViewCartaoSus);

            VisitaDomiciliar visitaDomiciliar2 = visitaDomiciliar.get(position);

            txtViewCartaoSus.setText(visitaDomiciliar2.getNumCartaoSus());
        }

        return view;
    }
}
