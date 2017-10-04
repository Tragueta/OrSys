package com.example.gui.orsys.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gui.orsys.DAO.Produto;
import com.example.gui.orsys.DAO.ProdutoDAO;
import com.example.gui.orsys.R;

import java.math.BigDecimal;

/**
 * Created by Gui on 28/09/2017.
 */

public class CadastrarProdutoActivity extends Activity {

    private Spinner spinnerFabricante;
    private EditText editNome;
    private EditText editCor;
    private EditText editLargura;
    private EditText editComprimento;
    private EditText editValorPeca;
    BigDecimal valorMetragem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        spinnerFabricante = (Spinner) findViewById(R.id.spinnerFabricante);
        editNome = (EditText) findViewById(R.id.editNome);
        editCor = (EditText) findViewById(R.id.editCor);
        editLargura = (EditText) findViewById(R.id.editLargura);
        editComprimento = (EditText) findViewById(R.id.editComprimento);
        editValorPeca = (EditText) findViewById(R.id.editValorPeca);
    }

    public void cadastrarProduto(View v){

        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        Produto produto = new Produto();

        produto.setFabricante(spinnerFabricante.getSelectedItem().toString());
        produto.setNome(editNome.getText().toString());
        produto.setCor(editCor.getText().toString());

        double largura = Double.valueOf(editLargura.getText().toString());
        produto.setLargura(largura);

        double comprimento = Double.valueOf(editComprimento.getText().toString());
        produto.setComprimento(comprimento);

        /* O valorPeca precisará ser um BIGDECIMAL e para isso acontecer foi instanciado um objeto (valorPeca)
        * do tipo BIDDECIMAL e passando como parametro o valor do editValorPeca sendo convertido para String.
        */
        // BigDecimal valorPea = new BigDecimal(editValorPeca.getText().toString());

        double valorEditPeca = Double.valueOf(editValorPeca.getText().toString());
        BigDecimal valorPeca = BigDecimal.valueOf(valorEditPeca);
        produto.setValorPeca(valorPeca);

        // Metodo responsável por cadastrar o valor da metragem deste produto.
        valorMetragem = produto.CalcularValorMetragem(largura, comprimento, valorPeca);
        produto.setValorMetragem(valorMetragem);

        long retornoBanco = produtoDAO.cadastrarProduto(produto);

        if(retornoBanco > 0){
            exibirMensagem("Produto cadastrado com sucesso! ");
        }
        else{
            exibirMensagem("Erro ao cadastrar o produto");
        }
    }

    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
