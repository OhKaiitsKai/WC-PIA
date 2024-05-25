package com.example.wc_pia;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "contenido_etiquetas",
        primaryKeys = {"id_contenido", "id_etiqueta"},
        foreignKeys = {
                @ForeignKey(entity = Contenido.class,
                        parentColumns = "id_contenido",
                        childColumns = "id_contenido",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Etiqueta.class,
                        parentColumns = "id_etiqueta",
                        childColumns = "id_etiqueta",
                        onDelete = ForeignKey.CASCADE)
        })
public class ContenidoEtiqueta {
    public int id_contenido; // Foreign Key
    public int id_etiqueta; // Foreign Key

    // Constructor, getters y setters pueden ser añadidos aquí si se desean
}
