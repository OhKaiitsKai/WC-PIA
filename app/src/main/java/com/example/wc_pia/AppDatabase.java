package com.example.wc_pia;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    // Define el DAO que utilizará la base de datos
    public abstract UsuarioDao usuarioDao();

    // Singleton para evitar tener múltiples instancias de la base de datos abierta al mismo tiempo
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Construir la base de datos
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "wc_pia_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

