package www.uzmd.alnamoz.data.database.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
//@Database() entty yasab kegin kel
abstract class AppDatabase:RoomDatabase() {
companion object{
    private var INSTANCE: AppDatabase?=null
    private val LOCK = Any()
    private val DB_NAME="al-namaz.db"
    fun getInstance(context: Context): AppDatabase {
        INSTANCE?.let {
            return it
        }
        synchronized(LOCK){
            INSTANCE?.let{
                return it
            }
        }
        val db= Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).allowMainThreadQueries().build()
        return db
    }
}
}