package www.uzmd.alnamoz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import www.uzmd.alnamoz.data.database.dbmode.TimesDbModel
@Dao
interface TimesDbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTimes(timesDbModel: TimesDbModel)
    @Query("select * from time where id=1")
    fun getTimesInfo():TimesDbModel?
}