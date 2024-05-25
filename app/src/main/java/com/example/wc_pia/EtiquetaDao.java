package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface EtiquetaDao {
    @Insert
    void insert(Etiqueta etiqueta);

    @Update
    void update(Etiqueta etiqueta);

    @Delete
    void delete(Etiqueta etiqueta);

    @Query("SELECT * FROM etiquetas")
    List<Etiqueta> getAllEtiquetas();

    @Query("SELECT * FROM etiquetas WHERE id_etiqueta = :idEtiqueta")
    Etiqueta getEtiquetaById(int idEtiqueta);
}
