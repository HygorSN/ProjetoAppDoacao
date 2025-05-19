package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class OngDashboard extends AppCompatActivity {

    LinearLayout btnFamilias, btnEstoques, btnDoacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ong_dashboard);

        btnFamilias = findViewById(R.id.btnFamilias);
        btnEstoques = findViewById(R.id.btnEstoques);
        btnDoacao = findViewById(R.id.btnDoacao);

        btnFamilias.setOnClickListener(v -> startActivity(new Intent(this, Familias.class)));
        btnEstoques.setOnClickListener(v -> startActivity(new Intent(this, Estoque.class)));
        btnDoacao.setOnClickListener(v -> startActivity(new Intent(this, OngDoacao.class)));
    }
}
