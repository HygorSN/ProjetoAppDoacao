package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtTelefone, edtDocumento, edtSenha, edtConfirmarSenha;
    Spinner spinnerTipo;
    Button btnRegisterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar componentes
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtDocumento = findViewById(R.id.edtDocumento);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfirmarSenha = findViewById(R.id.edtConfirmarSenha);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        btnRegisterUser = findViewById(R.id.btnRegisterUser);

        // Carregar opções no Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"Doador", "Ong"});
        spinnerTipo.setAdapter(adapter);

        // Lógica do botão
        btnRegisterUser.setOnClickListener(v -> registrarUsuario());
    }

    private void registrarUsuario() {
        String nome = edtNome.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim();
        String documento = edtDocumento.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String confirmarSenha = edtConfirmarSenha.getText().toString().trim();
        String tipo = spinnerTipo.getSelectedItem().toString();

        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || documento.isEmpty() ||
                senha.isEmpty() || confirmarSenha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        // Redirecionar de acordo com o tipo
        if (tipo.equals("Ong")) {
            startActivity(new Intent(this, OngDashboard.class));
        } else {
            startActivity(new Intent(this, DoadorDashboard.class));
        }
    }
}
