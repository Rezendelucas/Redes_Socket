package com.toybox.lucasrezende.trabalho_lab_redes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import Models.AMensagem;

public class Chat_Window extends AppCompatActivity {

    private ListView mensagens;
    private Button close;
    private Button gravarAudio;
    private boolean flag = true;
    private ArrayAdapter<String> mensagenAdapter;
    private Comunicaçao_Server conexao;

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
          //  mensagenAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,conexao.getInstance().getNovaMensagen());
            mensagens.setAdapter(mensagenAdapter);//push no servidor procura msg nova);
        }
        Intent intent = new Intent(Chat_Window.this, MainActivity.class);
        startActivity(intent);
    }
}
