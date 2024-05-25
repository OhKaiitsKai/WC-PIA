package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoritos",
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
public class Favorito {
    @PrimaryKey(autoGenerate = true)
    public int id_favorito;

    public int id_usuario; // Foreign Key
    public int id_contenido; // Foreign Key

    // Constructor, getters y setters pueden ser añadidos aquí si se desean
}
