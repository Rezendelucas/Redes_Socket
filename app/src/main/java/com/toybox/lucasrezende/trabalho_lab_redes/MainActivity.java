package com.toybox.lucasrezende.trabalho_lab_redes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView usuarios;
    private Button conecta;
    private Button confirmna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = (ListView)findViewById(R.id.lstClienteAtivos);
        conecta = (Button)findViewById(R.id.btnChamaServer);
        confirmna = (Button)findViewById(R.id.btnConfirmaConexao);

        conecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}
