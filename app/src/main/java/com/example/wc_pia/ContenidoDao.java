package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ContenidoDao {
    @Insert
    void insert(Contenido contenido);

    @Update
    void update(Contenido contenido);

    @Delete
    void delete(Contenido contenido);

    @Query("SELECT * FROM contenido")
    List<Contenido> getAllContenidos();

    @Query("SELECT * FROM contenido WHERE id_usuario = :idUsuario")
    List<Contenido> getContenidosByUsuario(int idUsuario);

    @Query("SELECT * FROM contenido WHERE id_contenido = :idContenido")
    Contenido getContenidoById(int idContenido);
}
