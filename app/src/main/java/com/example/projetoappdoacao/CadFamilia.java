package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CadFamilia extends AppCompatActivity {

    EditText edtNome, edtDocumento, edtEndereco, edtContato, edtDependentes, edtObservacoes;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_familia);

        edtNome = findViewById(R.id.edtNome);
        edtDocumento = findViewById(R.id.edtDocumento);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtContato = findViewById(R.id.edtContato);
        edtDependentes = findViewById(R.id.edtDependentes);
        edtObservacoes = findViewById(R.id.edtObservacoes);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> {
            String nome = edtNome.getText().toString().trim();
            String contato = edtContato.getText().toString().trim();
            String resumo = nome + "\nContato: " + contato;

            Intent resultado = new Intent();
            resultado.putExtra("novaFamilia", resumo);
            setResult(RESULT_OK, resultado);
            finish(); // Retorna para a tela anterior
        });
    }
}
