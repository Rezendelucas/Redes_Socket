package com.toybox.lucasrezende.trabalho_lab_redes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView usuarios;
    private Button conecta;
    private Button confirmna;
    Client_Chosen_One client;
    Mensagem mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = (ListView)findViewById(R.id.lstClienteAtivos);
        conecta = (Button)findViewById(R.id.btnChamaServer);

        mensagem = new Mensagem();
        ArrayAdapter<String> usuariosAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mensagem.getListUsuarios());
        usuarios.setAdapter(usuariosAdapter);

        conecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client = new Client_Chosen_One();
                try {
                    client.conexao();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        usuarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Chat_Window.class);
                intent.putExtra("Chat_window", "");
                startActivity(intent);
                return false;
            }
        });

    }
}
