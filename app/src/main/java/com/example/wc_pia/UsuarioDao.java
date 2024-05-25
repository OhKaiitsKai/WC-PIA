package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface UsuarioDao {
    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Query("SELECT * FROM usuarios")
    List<Usuario> getAllUsuarios();

    @Query("SELECT * FROM usuarios WHERE id = :id")
    Usuario getUsuarioById(int id);

    @Query("SELECT * FROM usuarios WHERE correo = :correo AND contrasena = :contrasena LIMIT 1")
    Usuario findByCorreoAndContrasena(String correo, String contrasena);

    @Query("SELECT * FROM usuarios WHERE correo = :correo LIMIT 1")
    Usuario findUsuarioByCorreo(String correo);

}


