package www.uzmd.alnamoz.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database() entty yasab kegin kel
@Database(entities = [UserDbModel::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private val DB_NAME = "al-namaz.db"
        fun getInstance(context: Context): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries().build()
            INSTANCE = db
            return db
        }
    }
}