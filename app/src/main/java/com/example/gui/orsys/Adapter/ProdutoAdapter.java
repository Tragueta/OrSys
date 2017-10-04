package com.example.gui.orsys.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gui.orsys.DAO.Produto;
import com.example.gui.orsys.R;

import java.util.List;

/**
 * Created by Gui on 03/10/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private int resource;
    private List<Produto> produtosList;

    public ProdutoAdapter(Context context, int resource,List<Produto> objects){
        super(context, resource, objects);

        this.resource = resource;
        produtosList = objects;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){

        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource,null,false);
        }

        Produto produto = produtosList.get(position);

        TextView textId = (TextView) mView.findViewById(R.id.textId);
        TextView textFabricante = (TextView) mView.findViewById(R.id.textFabricante);
        TextView textNome = (TextView) mView.findViewById(R.id.textNome);
        TextView textCor = (TextView) mView.findViewById(R.id.textCor);
        TextView textLargura = (TextView) mView.findViewById(R.id.textLargura);
        TextView textComprimento = (TextView) mView.findViewById(R.id.textComprimento);
        TextView textValorPeca = (TextView) mView.findViewById(R.id.textValorPeca);
        TextView textValorMetragem = (TextView) mView.findViewById(R.id.textValorMetragem);

        if(textId != null){
            textId.setText(String.valueOf(produto.getId()));
        }
        if(textFabricante != null){
            textFabricante.setText(String.valueOf(produto.getFabricante()));
        }
        if(textNome != null){
            textNome.setText(String.valueOf(produto.getNome()));
        }
        if(textCor != null){
            textCor.setText(String.valueOf(produto.getCor()));
        }
        if(textLargura != null){
            textLargura.setText(String.valueOf(produto.getLargura()));
        }
        if(textComprimento != null){
            textComprimento.setText(String.valueOf(produto.getComprimento()));
        }
        if(textValorPeca != null){
            textValorPeca.setText(String.valueOf(produto.getValorPeca()));
        }
        if(textValorMetragem != null){
            textValorMetragem.setText(String.valueOf(produto.getValorMetragem()));
        }
        return mView;
    }

}
