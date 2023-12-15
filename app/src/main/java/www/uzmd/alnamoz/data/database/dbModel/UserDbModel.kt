package www.uzmd.alnamoz.data.database.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Users")
class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var familia: String,
    var region: String
) {

}