package com.example.projetoappdoacao;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class Estoque extends AppCompatActivity {

    ListView listViewAlimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        listViewAlimentos = findViewById(R.id.listViewAlimentos);

        String[] alimentos = {
                "Arroz: 10",
                "Feijão: 5",
                "Macarrão: 7",
                "Óleo: 2",
                "Cesta Básica: 15"
        };

        listViewAlimentos.setAdapter(new android.widget.ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alimentos));
    }
}
