package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "contenido",
        foreignKeys = @ForeignKey(entity = Usuario.class,
                parentColumns = "id",
                childColumns = "id_usuario",
                onDelete = ForeignKey.CASCADE))
public class Contenido {
    @PrimaryKey(autoGenerate = true)
    public int id_contenido;

    public int id_usuario; // Foreign Key
    public String tipo;
    public String titulo;
    public String descripcion;

    // Constructor, getters y setters
}
