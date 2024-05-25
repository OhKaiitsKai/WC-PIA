package com.example.wc_pia;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

@Database(entities = {Usuario.class, Contenido.class, Archivo.class, Comentario.class, Valoracion.class, Favorito.class, Etiqueta.class, ContenidoEtiqueta.class}, version = 8, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract ContenidoDao contenidoDao();
    public abstract ArchivoDao archivoDao();
    public abstract ComentarioDao comentarioDao();
    public abstract ValoracionDao valoracionDao();
    public abstract FavoritoDao favoritoDao();
    public abstract EtiquetaDao etiquetaDao();
    public abstract ContenidoEtiquetaDao contenidoEtiquetaDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "wc_pia_database")
                            .fallbackToDestructiveMigration() // Para manejar cambios de esquema de manera más fácil durante el desarrollo
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}





