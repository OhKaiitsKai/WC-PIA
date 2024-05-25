package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ContenidoEtiquetaDao {
    @Insert
    void insert(ContenidoEtiqueta contenidoEtiqueta);

    @Delete
    void delete(ContenidoEtiqueta contenidoEtiqueta);

    @Query("SELECT * FROM contenido_etiquetas")
    List<ContenidoEtiqueta> getAllContenidoEtiquetas();

    @Query("SELECT * FROM contenido_etiquetas WHERE id_contenido = :idContenido")
    List<ContenidoEtiqueta> getContenidoEtiquetasByContenido(int idContenido);

    @Query("SELECT * FROM contenido_etiquetas WHERE id_etiqueta = :idEtiqueta")
    List<ContenidoEtiqueta> getContenidoEtiquetasByEtiqueta(int idEtiqueta);
}
