package Data.data

import Data.dao.Habilidade_Dao
import Data.dao.Player_Dao
import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player_entity::class, Habilidade_entity::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): Player_Dao
    abstract fun habilidadeDao(): Habilidade_Dao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
