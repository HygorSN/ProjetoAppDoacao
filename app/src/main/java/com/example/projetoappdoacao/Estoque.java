package com.example.projetoappdoacao;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Estoque extends AppCompatActivity {

    EditText editBuscar;
    Button btnAlimentos, btnCestas, btnAdicionar;
    ListView listaEstoque;
    ArrayList<String> listaAlimentos;
    ArrayList<String> listaCestas;
    ArrayAdapter<String> adapter;
    boolean mostrandoAlimentos = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        editBuscar = findViewById(R.id.editBuscar);
        btnAlimentos = findViewById(R.id.btnAlimentos);
        btnCestas = findViewById(R.id.btnCestas);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listaEstoque = findViewById(R.id.listaEstoque);

        listaAlimentos = new ArrayList<>();
        listaCestas = new ArrayList<>();
        listaAlimentos.add("Arroz - 5kg - Val: 12/2025");
        listaCestas.add("Cesta Básica Completa x3");

        atualizarLista();

        btnAlimentos.setOnClickListener(v -> {
            mostrandoAlimentos = true;
            atualizarLista();
        });

        btnCestas.setOnClickListener(v -> {
            mostrandoAlimentos = false;
            atualizarLista();
        });

        btnAdicionar.setOnClickListener(v -> {
            if (mostrandoAlimentos) {
                listaAlimentos.add("Novo alimento - Val: XX/XXXX");
            } else {
                listaCestas.add("Nova cesta básica");
            }
            atualizarLista();
        });

        listaEstoque.setOnItemClickListener((parent, view, position, id) -> {
            String item = mostrandoAlimentos ? listaAlimentos.get(position) : listaCestas.get(position);
            new AlertDialog.Builder(this)
                    .setTitle("Detalhes do item")
                    .setMessage(item + "\nDeseja remover?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        if (mostrandoAlimentos) {
                            listaAlimentos.remove(position);
                        } else {
                            listaCestas.remove(position);
                        }
                        atualizarLista();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        editBuscar.setOnEditorActionListener((v, actionId, event) -> {
            String texto = editBuscar.getText().toString().toLowerCase();
            ArrayList<String> origem = mostrandoAlimentos ? listaAlimentos : listaCestas;
            ArrayList<String> filtrado = new ArrayList<>();
            for (String item : origem) {
                if (item.toLowerCase().contains(texto)) filtrado.add(item);
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filtrado);
            listaEstoque.setAdapter(adapter);
            return true;
        });
    }

    private void atualizarLista() {
        ArrayList<String> origem = mostrandoAlimentos ? listaAlimentos : listaCestas;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, origem);
        listaEstoque.setAdapter(adapter);
    }
}
