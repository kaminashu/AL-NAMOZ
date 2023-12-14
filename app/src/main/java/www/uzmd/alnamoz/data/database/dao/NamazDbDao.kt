package www.uzmd.alnamoz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import www.uzmd.alnamoz.data.database.dbmode.NamazDbModel
@Dao
interface NamazDbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNamazInfo(namazDbModel: NamazDbModel)
    @Query("SELECT * FROM namaz where id=1")
    fun getNamazInfo():NamazDbModel
}