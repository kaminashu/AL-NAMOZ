package www.uzmd.alnamoz.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import www.uzmd.alnamoz.data.repoimple.RepoImple
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.usecases.AddUser


class NamazViewModel(application: Application) : AndroidViewModel(application) {
    private val imple = RepoImple(application)
    private val addUseCase = AddUser(imple)
    fun addUser(name: String, familia: String, region: String) {
        val userModel = UserModel(name = name, familia = familia, region = region)
        addUseCase.invoke(userModel)
    }

}