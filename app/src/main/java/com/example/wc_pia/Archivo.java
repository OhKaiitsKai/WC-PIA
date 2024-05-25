package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "archivos",
        foreignKeys = @ForeignKey(entity = Contenido.class,
                parentColumns = "id_contenido",
                childColumns = "id_contenido",
                onDelete = ForeignKey.CASCADE))
public class Archivo {
    @PrimaryKey(autoGenerate = true)
    public int id_archivo;

    public int id_contenido; // Foreign Key
    public String ruta_archivo;
    public String tipo_archivo;

    // Constructor, getters y setters pueden ser añadidos aquí si se desean
}
