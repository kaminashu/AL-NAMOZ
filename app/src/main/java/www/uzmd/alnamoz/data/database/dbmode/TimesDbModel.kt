package www.uzmd.alnamoz.data.database.dbmode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "time")
class TimesDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,
    val asr: String,
    val quyosh: String,
    val hufton: String,
    val shomIftor: String,
    val tongSaharlik: String,
    val peshin: String
)