package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ComentarioDao {
    @Insert
    void insert(Comentario comentario);

    @Update
    void update(Comentario comentario);

    @Delete
    void delete(Comentario comentario);

    @Query("SELECT * FROM comentarios")
    List<Comentario> getAllComentarios();

    @Query("SELECT * FROM comentarios WHERE id_usuario = :idUsuario")
    List<Comentario> getComentariosByUsuario(int idUsuario);

    @Query("SELECT * FROM comentarios WHERE id_contenido = :idContenido")
    List<Comentario> getComentariosByContenido(int idContenido);

    @Query("SELECT * FROM comentarios WHERE id_comentario = :idComentario")
    Comentario getComentarioById(int idComentario);
}
