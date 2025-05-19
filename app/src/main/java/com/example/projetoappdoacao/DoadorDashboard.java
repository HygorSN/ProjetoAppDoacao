package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DoadorDashboard extends AppCompatActivity {

    Button btnVerDoacoes, btnAtualizarPerfil, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doador_dashboard);

        btnVerDoacoes = findViewById(R.id.btnVerDoacoes);
        btnAtualizarPerfil = findViewById(R.id.btnAtualizarPerfil);
        btnSair = findViewById(R.id.btnSair);

        btnVerDoacoes.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidade Ver Doações em breve!", Toast.LENGTH_SHORT).show();
            // Aqui você pode chamar uma Activity que mostra as doações feitas
        });

        btnAtualizarPerfil.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidade Atualizar Perfil em breve!", Toast.LENGTH_SHORT).show();
            // Aqui pode abrir uma tela de edição do perfil do doador
        });

        btnSair.setOnClickListener(v -> {
            finish(); // Fecha o dashboard e retorna para a tela anterior (ex: login)
        });
    }
}
