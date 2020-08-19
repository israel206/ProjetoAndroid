package com.israelhack.projetoacspsf.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.israelhack.projetoacspsf.Entidades.CadastroDomiciliar;
import com.israelhack.projetoacspsf.R;

import java.util.ArrayList;

public class DomicilarAdapter extends ArrayAdapter<CadastroDomiciliar> {

    private ArrayList<CadastroDomiciliar> domiciliar;
    private Context context;

    public DomicilarAdapter(Context contxtt, ArrayList<CadastroDomiciliar> objects) {
        super(contxtt, 0, objects);

        this.context = contxtt;
        this.domiciliar = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (domiciliar != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_cadastro_domiciliar, parent, false);

            TextView txtViewCadastDomiciliar = (TextView) view.findViewById(R.id.txtViewCadastDomiciliar);

            CadastroDomiciliar cadastroDomiciliar2 = domiciliar.get(position);

            txtViewCadastDomiciliar.setText(cadastroDomiciliar2.getNomeMunicipio());
        }

        return view;
    }
}
