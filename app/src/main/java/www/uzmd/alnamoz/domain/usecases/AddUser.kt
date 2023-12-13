package www.uzmd.alnamoz.domain.usecases

import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.repositories.AppRepository

class AddUser(private val repository: AppRepository) {
    operator fun invoke(userModel: UserModel)=repository.AddUserDatabase(userModel)
}