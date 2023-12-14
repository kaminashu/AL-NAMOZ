package www.uzmd.alnamoz.domain.repositories

import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel

interface AppRepository {
    fun AddUserDatabase(userModel: UserModel)
    fun loadData()
    fun getTimes(): NamazTime
    fun getUserInfo(): UserModel
}