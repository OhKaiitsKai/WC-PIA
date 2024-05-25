package com.example.wc_pia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ArchivoDao {
    @Insert
    void insert(Archivo archivo);

    @Update
    void update(Archivo archivo);

    @Delete
    void delete(Archivo archivo);

    @Query("SELECT * FROM archivos")
    List<Archivo> getAllArchivos();

    @Query("SELECT * FROM archivos WHERE id_contenido = :idContenido")
    List<Archivo> getArchivosByContenido(int idContenido);

    @Query("SELECT * FROM archivos WHERE id_archivo = :idArchivo")
    Archivo getArchivoById(int idArchivo);
}
