package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.Date;

@Entity(tableName = "usuarios")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String usuario;
    public String nombres;
    public String apellidos;
    public String correo;
    public String contrasena;
    public String imagenPath;  // Campo para la ruta de la imagen de perfil
    @TypeConverters({Converters.class})
    public Date fechaCreacion;

    public Usuario() {
        this.fechaCreacion = new Date();
    }

    // Agregar getters y setters para imagenPath
    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }
}
