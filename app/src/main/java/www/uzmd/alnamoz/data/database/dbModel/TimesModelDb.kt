package www.uzmd.alnamoz.data.database.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Times")
class TimesModelDb(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var  asr: String,
    var  quyosh: String,
    var  hufton: String,
    var  shomIftor: String,
    var  tongSaharlik: String,
    var  peshin: String
) {

}