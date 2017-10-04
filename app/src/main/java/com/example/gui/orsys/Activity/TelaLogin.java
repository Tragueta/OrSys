package com.example.gui.orsys.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gui.orsys.R;

public class TelaLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        // Instanciando o botão.
        Button efetuarLogin = (Button) findViewById(R.id.efetuarLogin);
        efetuarLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                // Pegando os valores de entrada.
                TextView tUsuario = (TextView) findViewById(R.id.usuario);
                TextView tSenha = (TextView) findViewById(R.id.senha);

                // Transormandoo valor recebido em STRING.
                String usuario = tUsuario.getText().toString();
                String senha = tSenha.getText().toString();

                if (usuario.equals("Tragueta") && senha.equals("g123")){
                    Intent intent = new Intent(TelaLogin.this, OrSys.class);
                    startActivity(intent);
                    exibirMensagem("Login realizado com sucesso!");
                }else{
                    exibirMensagem("Usuário e/ou Senha inválido.");
                }
            }
        });

        }
    private void exibirMensagem(String mensagem){ Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show(); }

    }

