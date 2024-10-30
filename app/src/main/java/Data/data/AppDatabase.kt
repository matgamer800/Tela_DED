package Data.data

import Data.dao.Classe_Dao
import Data.dao.Habilidade_Dao
import Data.dao.Player_Dao
import Data.dao.Raca_Dao
import Data.entity.Classe_entity
import Data.entity.Habilidade_entity
import Data.entity.Player_entity
import Data.entity.Raca_entity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Player_entity::class, Habilidade_entity::class,Raca_entity::class,Classe_entity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): Player_Dao
    abstract fun habilidadeDao(): Habilidade_Dao
    abstract fun racaDao(): Raca_Dao
    abstract fun classeDao():Classe_Dao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).addCallback(DatabaseCallback())
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
        private class DatabaseCallback: RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val callback = CallBacksPopulation()
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        callback.popalatioRaca_Database(database.racaDao())
                    }
                }
            }
        }
    }
}
