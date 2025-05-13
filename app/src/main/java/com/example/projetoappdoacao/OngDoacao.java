package com.example.projetoappdoacao;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OngDoacao extends AppCompatActivity {

    ListView listaDoacoes;
    ArrayList<String> doacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ong_doacao);

        listaDoacoes = findViewById(R.id.listaDoacoes);
        doacoes = new ArrayList<>();

        // Dados mockados
        doacoes.add("Alex - Arroz(3), Feijão(4), Cesta(2) - Coletar");
        doacoes.add("Maria - Cesta(1), Arroz(1) - Estocado");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doacoes);
        listaDoacoes.setAdapter(adapter);

        listaDoacoes.setOnItemClickListener((parent, view, position, id) -> mostrarDetalhesDoacao(position));
    }

    private void mostrarDetalhesDoacao(int index) {
        String detalhes = "Doador: Alex\n" +
                "Endereço: Rua das Flores, 123\n" +
                "Telefone: (11) 99999-8888\n" +
                "Itens: Arroz(3), Feijão(4), Cesta(2)\n" +
                "Status atual: Coletar";

        new AlertDialog.Builder(this)
                .setTitle("Detalhes da Doação")
                .setMessage(detalhes)
                .setPositiveButton("Marcar como Coletado", (dialog, which) -> {
                    Toast.makeText(this, "Status atualizado para Coletado", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Estocado", (dialog, which) -> {
                    Toast.makeText(this, "Status atualizado para Estocado", Toast.LENGTH_SHORT).show();
                })
                .setNeutralButton("Fechar", null)
                .show();
    }
}

