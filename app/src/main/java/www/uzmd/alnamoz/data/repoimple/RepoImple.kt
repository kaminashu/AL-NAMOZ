package www.uzmd.alnamoz.data.repoimple

import android.app.Application
import www.uzmd.alnamoz.data.database.db.AppDatabase
import www.uzmd.alnamoz.data.mapper.Mapper
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.repositories.AppRepository

class RepoImple(application: Application) : AppRepository {
    val db = AppDatabase.getInstance(application).databaseDao()
    val mapper = Mapper()
    override fun AddUserDatabase(userModel: UserModel) {
        db.addUser(mapper.mapperUserModelToUserDbModel(userModel))
    }
}