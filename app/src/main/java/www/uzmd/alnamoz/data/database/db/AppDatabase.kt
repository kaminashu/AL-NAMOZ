package www.uzmd.alnamoz.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import www.uzmd.alnamoz.data.database.dao.NamazDao
import www.uzmd.alnamoz.data.database.dbModel.NamazModelDb
import www.uzmd.alnamoz.data.database.dbModel.UserDbModel
import www.uzmd.alnamoz.data.internet.dto.Times

@Database(entities = [NamazModelDb::class, Times::class,UserDbModel::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
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

    abstract fun namazDao(): NamazDao
}