package www.uzmd.alnamoz.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import www.uzmd.alnamoz.data.database.dao.DatabaseDao
import www.uzmd.alnamoz.data.database.dao.NamazDbDao
import www.uzmd.alnamoz.data.database.dao.TimesDbDao
import www.uzmd.alnamoz.data.database.dbmode.NamazDbModel
import www.uzmd.alnamoz.data.database.dbmode.TimesDbModel
import www.uzmd.alnamoz.data.database.dbmode.UserDbModel

//@Database() entty yasab kegin kel
@Database(
    entities = [UserDbModel::class, TimesDbModel::class, NamazDbModel::class],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
    abstract fun namazDbDao(): NamazDbDao
    abstract fun timesDbDao(): TimesDbDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private val DB_NAME = "alnamaz.db"
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