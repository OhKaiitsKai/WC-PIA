package com.example.wc_pia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class SignUpActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;

    private EditText etUsuario, etNombres, etApellidos, etCorreo, etContrasena;
    private ImageView ivImagen;
    private Button btnCargarImagen, btnGuardar;
    private Uri imageUri;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        db = AppDatabase.getDatabase(this);

        etUsuario = findViewById(R.id.etUsuario);
        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        ivImagen = findViewById(R.id.ivImagen);
        btnCargarImagen = findViewById(R.id.btnCargarImagen);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnCargarImagen.setOnClickListener(v -> openGallery());
        btnGuardar.setOnClickListener(v -> saveUser());
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            ivImagen.setImageURI(imageUri);
        }
    }


    private void saveUser() {
        String usuario = etUsuario.getText().toString();
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();
        String imagenPath = saveImageToInternalStorage();

        if (usuario.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || imagenPath == null) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {
            Usuario existingUser = db.usuarioDao().findUsuarioByCorreo(correo);
            if (existingUser != null) {
                runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show());
            } else {
                Usuario user = new Usuario();
                user.usuario = usuario;
                user.nombres = nombres;
                user.apellidos = apellidos;
                user.correo = correo;
                user.contrasena = contrasena;
                user.imagenPath = imagenPath;
                user.fechaCreacion = new Date();

                db.usuarioDao().insert(user);
                runOnUiThread(() -> Toast.makeText(SignUpActivity.this, "Usuario guardado", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }


    private String saveImageToInternalStorage() {
        if (imageUri == null) return null;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            File directory = getDir("images", MODE_PRIVATE);
            File file = new File(directory, "image_" + System.currentTimeMillis() + ".png");

            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();

            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

