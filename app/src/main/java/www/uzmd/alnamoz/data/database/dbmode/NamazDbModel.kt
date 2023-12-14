package www.uzmd.alnamoz.data.database.dbmode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import www.uzmd.alnamoz.data.internet.model_dto.HijriDate
import www.uzmd.alnamoz.data.internet.model_dto.Times

@Entity(tableName = "namaz")
class NamazDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,
    val date: String? = null,
    val weekday: String? = null,
)
