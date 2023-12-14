package www.uzmd.alnamoz.data.database.dbmode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "time")
class TimesDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,
    val asr: String? = null,
    val quyosh: String? = null,
    val hufton: String? = null,
    val shomIftor: String? = null,
    val tongSaharlik: String? = null,
    val peshin: String? = null
)