package www.uzmd.alnamoz.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import www.uzmd.alnamoz.data.repoimple.RepoImple
import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.usecases.AddUser
import www.uzmd.alnamoz.domain.usecases.GetTimeUsecase
import www.uzmd.alnamoz.domain.usecases.GetUserInfo
import www.uzmd.alnamoz.domain.usecases.LoadUsecase


class NamazViewModel(application: Application) : AndroidViewModel(application) {
    private val imple = RepoImple(application)
    private val addUseCase = AddUser(imple)
    private val _mutableLiveDataBtn = MutableLiveData<Boolean>()
    private val getUserInfo=GetUserInfo(imple)

    val btnLiveData: MutableLiveData<Boolean>
        get() = _mutableLiveDataBtn

    fun addUser(name: String, familia: String, region: String) {
        val userModel = UserModel(name = name, familia = familia, region = region)
        addUseCase(userModel)
        _mutableLiveDataBtn.value = true
    }

    fun testFragment():Boolean{
        val name=getUserInfo.invoke().name
        return name.isNotEmpty()
    }


}