package www.uzmd.alnamoz.data.database.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import www.uzmd.alnamoz.data.internet.dto.Times
import java.net.IDN
@Entity(tableName = "Namaz")
class NamazModelDb(
    @PrimaryKey(autoGenerate = true)
    var id: Int= UNKOWN,
    var region:String,
    var date:String,
    var weekday:String
    ){
    companion object{
        const val UNKOWN=1
    }
}