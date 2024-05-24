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
    public String imagenPath;
    @TypeConverters({Converters.class})
    public Date fechaCreacion;

    public Usuario() {
        this.fechaCreacion = new Date();  // Establecer la fecha de creación en el momento de instanciar el objeto
    }
}
