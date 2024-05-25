package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "etiquetas")
public class Etiqueta {
    @PrimaryKey(autoGenerate = true)
    public int id_etiqueta;

    public String nombre_etiqueta;

    // Constructor, getters y setters pueden ser añadidos aquí si se desean
}
