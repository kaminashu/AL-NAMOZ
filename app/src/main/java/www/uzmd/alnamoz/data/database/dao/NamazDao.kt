package www.uzmd.alnamoz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import www.uzmd.alnamoz.data.database.dbModel.NamazModelDb
import www.uzmd.alnamoz.data.database.dbModel.UserDbModel
import www.uzmd.alnamoz.data.internet.dto.Times

@Dao
interface NamazDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNamazDb(namazModelDb: NamazModelDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTimesDb(times: Times)

    @Query("SELECT * FROM namaz where id=1")
    fun getNamazInfo(): NamazModelDb

    @Query("SELECT * FROM users where id=1")
    fun getUser(): UserDbModel

    @Query("SELECT * FROM Times where id=1")
    fun getTimes(): Times
}