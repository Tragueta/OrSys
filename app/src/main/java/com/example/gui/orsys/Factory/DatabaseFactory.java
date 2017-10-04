package com.example.gui.orsys.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gui.orsys.Util.BancoUtil;

/**
 * Created by Gui on 27/09/2017.
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    public DatabaseFactory(Context context){
        super(context, BancoUtil.NOME_BANCO,null,BancoUtil.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*
        String  sql = "CREATE TABLE "+ BancoUtil.TABELA_LIVRO+"("
                + BancoUtil.ID_LIVRO+ " integer primary key autoincrement,"
                + BancoUtil.TITULO_LIVRO + " text,"
                + BancoUtil.GENERO_LIVRO + " text,"
                + BancoUtil.LIVRO_FAVORITO + " integer"
                +")";
        db.execSQL(sql);
         */
        String  sql = "CREATE TABLE " + BancoUtil.TABELA_PRODUTO + "("
                + BancoUtil.ID_PRODUTO + " integer primary key autoincrement,"
                + BancoUtil.FABRICANTE + " text,"
                + BancoUtil.NOME + " text,"
                + BancoUtil.COR + " text,"
                + BancoUtil.LARGURA + " real,"
                + BancoUtil.COMPRIMENTO + " real,"
                + BancoUtil.VALOR_PECA + " real,"
                + BancoUtil.VALOR_METRAGEM + " real"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BancoUtil.TABELA_PRODUTO);

        onCreate(db);
    }

}
