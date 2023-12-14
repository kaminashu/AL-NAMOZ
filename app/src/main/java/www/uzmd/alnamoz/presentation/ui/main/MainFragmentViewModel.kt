package www.uzmd.alnamoz.presentation.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import www.uzmd.alnamoz.data.repoimple.RepoImple
import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.usecases.AddUser
import www.uzmd.alnamoz.domain.usecases.GetTimeUsecase
import www.uzmd.alnamoz.domain.usecases.GetUserInfo
import www.uzmd.alnamoz.domain.usecases.LoadUsecase

class MainFragmentViewModel(application: Application):AndroidViewModel(application = application) {
    private val imple = RepoImple(application)
    private val getUserInfo= GetUserInfo(imple)
    private val getTimeUsecase= GetTimeUsecase(imple)
    private val loadUsecase= LoadUsecase(imple)

    init {
        loadUsecase.invoke()
    }
    fun getUserInfofunc(): UserModel {
        return getUserInfo()
    }
    fun getTimes(): NamazTime {
        return getTimeUsecase()
    }
}