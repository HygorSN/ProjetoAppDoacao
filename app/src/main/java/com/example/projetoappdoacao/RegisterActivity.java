package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNome, edtEmail, edtTelefone, edtDocumento, edtSenha, edtConfirmarSenha;
    Spinner spinnerTipo;
    Button btnRegisterUser;

    // Simula banco de usuários (em app real, use banco ou SharedPreferences)
    static ArrayList<Usuario> usuarios = new ArrayList<>();

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

        // Botão registra usuário
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

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica se já existe email cadastrado
        for (Usuario u : usuarios) {
            if (u.email.equalsIgnoreCase(email)) {
                Toast.makeText(this, "Email já cadastrado", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Cria novo usuário e adiciona na lista
        Usuario novoUsuario = new Usuario(nome, email, telefone, documento, senha, tipo);
        usuarios.add(novoUsuario);

        Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();

        // Redireciona para dashboard de acordo com o tipo
        if (tipo.equals("Ong")) {
            startActivity(new Intent(this, OngDashboard.class));
        } else {
            startActivity(new Intent(this, DoadorDashboard.class));
        }

        finish(); // Fecha essa activity para não voltar ao registro
    }
}
