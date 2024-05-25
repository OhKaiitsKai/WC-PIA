package com.example.wc_pia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreo, etContrasena;
    private Button btnIniciarSesion;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = AppDatabase.getDatabase(this);

        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion() {
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();

        new Thread(() -> {
            Usuario usuario = db.usuarioDao().findByCorreoAndContrasena(correo, contrasena);
            runOnUiThread(() -> {
                if (usuario != null) {
                    // Inicio de sesión exitoso
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Aquí puedes redirigir a otra actividad después de un inicio de sesión exitoso
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class); // com.example.wc_pia.HomeActivity es un ejemplo, crea esta actividad si es necesario
                    startActivity(intent);
                    finish();
                } else {
                    // Fallo en el inicio de sesión
                    Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }
}
