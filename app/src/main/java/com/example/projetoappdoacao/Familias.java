package com.example.projetoappdoacao;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Familias extends AppCompatActivity {

    ListView listViewFamilias;
    Button btnCadastrar, btnIr;
    ArrayList<String> listaFamilias;
    String familiaSelecionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familias);

        listViewFamilias = findViewById(R.id.listViewFamilias);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnIr = findViewById(R.id.btnIr);

        listaFamilias = new ArrayList<>();
        listaFamilias.add("Família Marta Santos");
        listaFamilias.add("Família Andrea Ferreira");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, listaFamilias);
        listViewFamilias.setAdapter(adapter);
        listViewFamilias.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewFamilias.setOnItemClickListener((parent, view, position, id) ->
                familiaSelecionada = listaFamilias.get(position)
        );

        btnCadastrar.setOnClickListener(v -> startActivity(new Intent(this, CadFamilia.class)));

        btnIr.setOnClickListener(v -> {
            if (familiaSelecionada != null) {
                new AlertDialog.Builder(this)
                        .setTitle("Detalhes da Família")
                        .setMessage("Informações:\n\n" + familiaSelecionada + "\n(Endereço, contato, observações...)")
                        .setPositiveButton("Fechar", null)
                        .show();
            } else {
                Toast.makeText(this, "Selecione uma família", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

