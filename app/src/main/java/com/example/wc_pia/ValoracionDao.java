package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ValoracionDao {
    @Insert
    void insert(Valoracion valoracion);

    @Update
    void update(Valoracion valoracion);

    @Delete
    void delete(Valoracion valoracion);

    @Query("SELECT * FROM valoraciones")
    List<Valoracion> getAllValoraciones();

    @Query("SELECT * FROM valoraciones WHERE id_usuario = :idUsuario")
    List<Valoracion> getValoracionesByUsuario(int idUsuario);

    @Query("SELECT * FROM valoraciones WHERE id_contenido = :idContenido")
    List<Valoracion> getValoracionesByContenido(int idContenido);

    @Query("SELECT * FROM valoraciones WHERE id_valoracion = :idValoracion")
    Valoracion getValoracionById(int idValoracion);
}
