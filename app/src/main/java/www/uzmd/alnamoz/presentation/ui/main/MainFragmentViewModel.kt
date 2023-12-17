package www.uzmd.alnamoz.presentation.ui.main

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import www.uzmd.alnamoz.data.repoimple.RepoImple
import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.usecases.AddUser
import www.uzmd.alnamoz.domain.usecases.GetTimeUsecase
import www.uzmd.alnamoz.domain.usecases.GetUserInfo
import www.uzmd.alnamoz.domain.usecases.LoadUsecase
import java.lang.RuntimeException

class MainFragmentViewModel(application: Application) :
    AndroidViewModel(application = application) {
    private val imple = RepoImple(application)
    private val getUserInfo = GetUserInfo(imple)
    private val getTimeUsecase = GetTimeUsecase(imple)
    private val addUseCase = AddUser(imple)
    private val loadUsecase = LoadUsecase(imple)
    fun load(){
        loadUsecase.invoke()
    }

    fun getUserInfofunc(): UserModel {
        return getUserInfo()
    }

    fun getTimes(): NamazTime {
        return getTimeUsecase()
    }

    fun nextNamaz(h: Int, m: Int): IntArray {
        Log.d("TAG", "nextNamaz: $h:$m")
        val ms2 = IntArray(3)
        val times = getTimeUsecase()
        var saxarlik = times.tongSaharlik.toString().split(":").toTypedArray()
        var peshin = times.peshin.toString().split(":").toTypedArray()
        var asr = times.asr.toString().split(":").toTypedArray()
        var hufton = times.hufton.toString().split(":").toTypedArray()
        var shom = times.shomIftor.toString().split(":").toTypedArray()
        val ms = ArrayList<Array<String>>()
        ms.add(saxarlik)
        ms.add(peshin)
        ms.add(asr)
        ms.add(shom)
        ms.add(hufton)
        var s = 0
        for (i in ms) {

            ms2[0] = s
            Log.d("TAG", "nextNamaz: soat local$h ${i[0].toInt()}")
            s++
            if (h <= i[0].toInt()) {
                if (m <= i[1].toInt()) {
                    var hour = i[0].toInt() - h
                    val minutes = i[1].toInt() - m
                    ms2[1] = hour
                    ms2[2] = minutes
                    return ms2
                } else {
                    var hour = i[0].toInt() - h - 1
                    val minutes = (i[1].toInt() + 60) - m
                    ms2[1] = hour
                    ms2[2] = minutes
                    return ms2
                }
            }else{
                ms2[1] = -1
                ms2[2] = -1
                return ms2
            }
        }
        return ms2
    }
    fun addUser(name: String, familia: String, region: String) {
        val userModel = UserModel(name = name, familia = familia, region = region)
        addUseCase(userModel)
    }
}