package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "comentarios",
        foreignKeys = {
                @ForeignKey(entity = Usuario.class,
                        parentColumns = "id",
                        childColumns = "id_usuario",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Contenido.class,
                        parentColumns = "id_contenido",
                        childColumns = "id_contenido",
                        onDelete = ForeignKey.CASCADE)
        })
public class Comentario {
    @PrimaryKey(autoGenerate = true)
    public int id_comentario;

    public int id_usuario; // Foreign Key
    public int id_contenido; // Foreign Key
    public String comentario;

    @TypeConverters({Converters.class})
    public Date fecha_comentario;

    // Constructor, getters y setters pueden ser añadidos aquí si se desean
}
