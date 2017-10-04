package com.example.gui.orsys.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.gui.orsys.Adapter.ProdutoAdapter;
import com.example.gui.orsys.DAO.Produto;
import com.example.gui.orsys.DAO.ProdutoDAO;
import com.example.gui.orsys.R;

import java.util.List;

/**
 * Created by Gui on 02/10/2017.
 */

public class ListarProdutosActivity extends Activity {

    private ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listaProdutos = (ListView) findViewById(R.id.listProdutos);
        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        List<Produto> produtosList = produtoDAO.carregarListaProdutos();
        ProdutoAdapter myAdapter = new ProdutoAdapter(this, R.layout.item_produto, produtosList);
        listaProdutos.setAdapter(myAdapter);
    }

}
