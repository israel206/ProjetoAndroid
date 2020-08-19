package com.israelhack.projetoacspsf.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.israelhack.projetoacspsf.Entidades.CadastroIndividual;
import com.israelhack.projetoacspsf.R;
import java.util.ArrayList;

public class IndividualAdapter extends ArrayAdapter<CadastroIndividual>{


    private ArrayList<CadastroIndividual> individual;
    private Context context;

    public IndividualAdapter(Context contxt, ArrayList<CadastroIndividual> objects) {
        super(contxt, 0, objects);

        this.context = contxt;
        this.individual = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (individual != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_cadastro_individual, parent, false);

            TextView txtViewNomeCompleto = (TextView) view.findViewById(R.id.txtViewNomeCompleto);

            CadastroIndividual cadastroIndividual2 = individual.get(position);

            txtViewNomeCompleto.setText(cadastroIndividual2.getNomeCompleto());
        }

        return view;
    }
}
