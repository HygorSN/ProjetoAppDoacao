package com.example.projetoappdoacao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String senha = edtSenha.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha email e senha", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Busca usuário mock
            Usuario usuarioLogado = null;
            for (Usuario u : RegisterActivity.usuarios) {
                if (u.email.equals(email) && u.senha.equals(senha)) {
                    usuarioLogado = u;
                    break;
                }
            }

            if (usuarioLogado == null) {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();

            // Redireciona conforme tipo
            if (usuarioLogado.tipo.equals("Ong")) {
                startActivity(new Intent(this, OngDashboard.class));
            } else {
                startActivity(new Intent(this, DoadorDashboard.class));
            }
            finish();
        });
    }
}
