package com.example.gui.orsys.DAO;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Created by Gui on 27/09/2017.
 */

public class Produto {

    private int id;
    private String fabricante;
    private String nome;
    private String cor;
    private double largura;
    private double comprimento;
    private BigDecimal valorPeca;
    private BigDecimal valorMetragem;

    //Construtores
    public Produto() {

    }

    public Produto(int id, String fabricante, String nome, String cor, double largura, double comprimento,
                                                                BigDecimal valorPeca, BigDecimal valorMetragem) {
        this.id = id;
        this.fabricante = fabricante;
        this.nome = nome;
        this.cor = cor;
        this.largura = largura;
        this.comprimento = comprimento;
        this.valorPeca = valorPeca;
        this.valorMetragem = valorMetragem;
    }

    // Metodos de acesso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public BigDecimal getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(BigDecimal valorPeca) {
        this.valorPeca = valorPeca;
    }

    public BigDecimal getValorMetragem() {
        return valorMetragem;
    }

    public void setValorMetragem(BigDecimal valorMetragem) {
        this.valorMetragem = valorMetragem;
    }

    // Metodo que irá realizar o calculo re retornar o valor da metragem
    public BigDecimal CalcularValorMetragem(double pLargura, double pComprimento, BigDecimal pValorPeca)
    {
        double area = pLargura * pComprimento / 10000;

        area = 1 / area;
        BigDecimal calculo = pValorPeca.multiply(BigDecimal.valueOf(area));

        String resultado = String.format(Locale.getDefault(), "%.2f", calculo);
        double resultadoNovo = Double.valueOf(resultado);

        BigDecimal valorMetragem = BigDecimal.valueOf(resultadoNovo);

        return valorMetragem;
    }
}
