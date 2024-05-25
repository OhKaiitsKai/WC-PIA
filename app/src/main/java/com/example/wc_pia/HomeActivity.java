package com.example.wc_pia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private AppDatabase db;
    private Usuario user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        db = AppDatabase.getDatabase(this);

        // Suponiendo que tienes el ID del usuario logueado, puedes obtener el usuario de la base de datos
        int userId = getIntent().getIntExtra("USER_ID", -1); // Ajusta esto según cómo obtengas el ID del usuario
        new Thread(() -> {
            user = db.usuarioDao().getUsuarioById(userId);
            runOnUiThread(this::updateNavHeader);
        }).start();
    }

    private void updateNavHeader() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        ImageView ivPerfil = navigationView.getHeaderView(0).findViewById(R.id.ivPerfil);
        TextView tvNombreUsuario = navigationView.getHeaderView(0).findViewById(R.id.tvNombreUsuario);

        if (user != null) {
            // Set the user's name
            tvNombreUsuario.setText(user.nombres);

            // Load the user's profile image
            if (user.imagenPath != null && !user.imagenPath.isEmpty()) {
                Bitmap bitmap = BitmapFactory.decodeFile(user.imagenPath);
                ivPerfil.setImageBitmap(bitmap);
            }
        }
    }
}

