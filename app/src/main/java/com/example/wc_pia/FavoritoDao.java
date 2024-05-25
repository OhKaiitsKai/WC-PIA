package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface FavoritoDao {
    @Insert
    void insert(Favorito favorito);

    @Update
    void update(Favorito favorito);

    @Delete
    void delete(Favorito favorito);

    @Query("SELECT * FROM favoritos")
    List<Favorito> getAllFavoritos();

    @Query("SELECT * FROM favoritos WHERE id_usuario = :idUsuario")
    List<Favorito> getFavoritosByUsuario(int idUsuario);

    @Query("SELECT * FROM favoritos WHERE id_contenido = :idContenido")
    List<Favorito> getFavoritosByContenido(int idContenido);

    @Query("SELECT * FROM favoritos WHERE id_favorito = :idFavorito")
    Favorito getFavoritoById(int idFavorito);
}
