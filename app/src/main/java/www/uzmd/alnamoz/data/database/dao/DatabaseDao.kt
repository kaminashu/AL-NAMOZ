package www.uzmd.alnamoz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import www.uzmd.alnamoz.data.database.dbmode.UserDbModel

@Dao
interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(userDbModel: UserDbModel)
    @Query("SELECT * FROM user where id=1")
    fun getUser(): UserDbModel

}