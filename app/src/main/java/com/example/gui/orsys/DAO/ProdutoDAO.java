package com.example.gui.orsys.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gui.orsys.Factory.DatabaseFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.gui.orsys.Util.BancoUtil.COMPRIMENTO;
import static com.example.gui.orsys.Util.BancoUtil.COR;
import static com.example.gui.orsys.Util.BancoUtil.FABRICANTE;
import static com.example.gui.orsys.Util.BancoUtil.ID_PRODUTO;
import static com.example.gui.orsys.Util.BancoUtil.LARGURA;
import static com.example.gui.orsys.Util.BancoUtil.NOME;
import static com.example.gui.orsys.Util.BancoUtil.TABELA_PRODUTO;
import static com.example.gui.orsys.Util.BancoUtil.VALOR_METRAGEM;
import static com.example.gui.orsys.Util.BancoUtil.VALOR_PECA;

/**
 * Created by Gui on 27/09/2017.
 */

public class ProdutoDAO {

    private SQLiteDatabase db;
    private DatabaseFactory bancoProduto;

    /*
     * Construtos da DAO
     * Recebe como parametro o context
     *   - O context será/é a Activity em que o objeto ProdutoDAO está sendo instanciado.
     */
    public ProdutoDAO(Context context){
        bancoProduto = new DatabaseFactory(context);
    }

    public long cadastrarProduto(Produto produto ){
        ContentValues  valores = null;
        long retornoBanco = 0;

        db = bancoProduto.getWritableDatabase();

        valores = new ContentValues();
        // Passando o valor para cada coluna com os valores recebidos no cadastro do produto.
        valores.put(FABRICANTE, produto.getFabricante());
        valores.put(NOME, produto.getNome());
        valores.put(COR, produto.getCor());
        valores.put(LARGURA, produto.getLargura());
        valores.put(COMPRIMENTO, produto.getComprimento());

        System.out.println(valores);


        BigDecimal valorPecaBD = produto.getValorPeca();
        double valorPeca = valorPecaBD.doubleValue();
        valores.put(VALOR_PECA, valorPeca);

        BigDecimal valorMetragemBD = produto.getValorMetragem();
        double valorMetragem = valorMetragemBD.doubleValue();
        valores.put(VALOR_METRAGEM, valorMetragem);

        // O retorno do INSERT será 0 ou 1 (true or false).
        retornoBanco = db.insert(TABELA_PRODUTO, null, valores);

        db.close();

        return retornoBanco;
    }

    public Cursor listarProdutos(){

        Cursor cursor;

        String[] campos = {ID_PRODUTO, FABRICANTE, NOME, COR, LARGURA, COMPRIMENTO, VALOR_PECA, VALOR_METRAGEM};
        db = bancoProduto.getReadableDatabase();

        cursor = db.query(TABELA_PRODUTO, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public List<Produto> carregarListaProdutos(){
        Cursor cursor = listarProdutos();
        List<Produto> listaProdutos = new ArrayList<>();

        try{
            do{
                Produto produto = new Produto();

                int id = cursor.getInt(cursor.getColumnIndexOrThrow(ID_PRODUTO));
                String fabricante = cursor.getString(cursor.getColumnIndexOrThrow(FABRICANTE));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(NOME));
                String cor = cursor.getString(cursor.getColumnIndexOrThrow(COR));
                double largura = cursor.getDouble(cursor.getColumnIndexOrThrow(LARGURA));
                double comprimento = cursor.getDouble(cursor.getColumnIndexOrThrow(COMPRIMENTO));
                double valorPeca = cursor.getDouble(cursor.getColumnIndexOrThrow(VALOR_PECA));
                double valorMetragem = cursor.getDouble(cursor.getColumnIndexOrThrow(VALOR_METRAGEM));

                produto.setId(id);
                produto.setFabricante(fabricante);
                produto.setNome(nome);
                produto.setCor(cor);
                produto.setLargura(largura);
                produto.setComprimento(comprimento);
                produto.setValorPeca(BigDecimal.valueOf(valorPeca));
                produto.setValorMetragem(BigDecimal.valueOf(valorMetragem));

                listaProdutos.add(produto);

            } while(cursor.moveToNext());
        } finally {
            cursor.close();
        }
        return listaProdutos;
    }

}
