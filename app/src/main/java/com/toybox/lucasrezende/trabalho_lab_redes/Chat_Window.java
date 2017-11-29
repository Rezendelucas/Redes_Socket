package com.toybox.lucasrezende.trabalho_lab_redes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Chat_Window extends AppCompatActivity {

    private ListView mensagens;
    private Button close;
    private Button gravarAudio;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat__window);

        mensagens = (ListView) findViewById(R.id.lstMensagens);
        close = (Button) findViewById(R.id.btnFechaConversa);
        gravarAudio = (Button) findViewById(R.id.btnGravarEnviar);


        while(flag){
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //encerrra conversa
                //envia pedido de encerramento pro servidor
                //perde lista de usuarios ativos
                //retorna pra menu anterios com lista de ativos atualizada
                flag = false;
            }
        });

        gravarAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inicia app de gravar audio
                //envia pro servidor
            }
        });

            mensagens.setAdapter();//push no servidor procura msg nova);
        }
        Intent intent = new Intent(Chat_Window.this, MainActivity.class);
        startActivity(intent);
    }
}
