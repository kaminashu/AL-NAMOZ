package www.uzmd.alnamoz.data.mapper

import www.uzmd.alnamoz.data.database.db.UserDbModel
import www.uzmd.alnamoz.domain.entities.UserModel

class Mapper {
    fun mapperUserModelToUserDbModel(userModel: UserModel):UserDbModel{
        return UserDbModel(userModel.id,userModel.name,userModel.familia,userModel.region)
    }
}