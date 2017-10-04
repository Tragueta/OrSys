package com.example.gui.orsys.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gui.orsys.R;

public class OrSys extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_or_sys);
    }

    public void carregarOpcaoMenu(View v){
        switch (v.getId()) {
            case R.id.cadastrarProduto:
                carregarIntent(CadastrarProdutoActivity.class);
                break;
            case R.id.listarProdutos:
                carregarIntent(ListarProdutosActivity.class);
                break;
        }
    }

    private void carregarIntent(Class classe){
        Intent intent = new Intent(OrSys.this,classe);
        startActivity(intent);
    }

}
