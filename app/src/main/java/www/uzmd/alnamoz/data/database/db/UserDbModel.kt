package www.uzmd.alnamoz.data.database.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int=1,
    var name:String,
    var familia:String,
    var region:String,
)