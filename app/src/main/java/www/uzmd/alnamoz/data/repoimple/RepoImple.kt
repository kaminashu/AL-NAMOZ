package www.uzmd.alnamoz.data.repoimple

import android.app.Application
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import www.uzmd.alnamoz.data.database.db.AppDatabase
import www.uzmd.alnamoz.data.mapper.Mapper
import www.uzmd.alnamoz.data.service.RebaseWorker
import www.uzmd.alnamoz.domain.entities.NamazTime
import www.uzmd.alnamoz.domain.entities.UserModel
import www.uzmd.alnamoz.domain.repositories.AppRepository

class RepoImple(val application: Application) : AppRepository {
    val db = AppDatabase.getInstance(application)
    val mapper = Mapper()
    override fun AddUserDatabase(userModel: UserModel) {
        db.databaseDao().addUser(mapper.mapperUserModelToUserDbModel(userModel))
    }

    override fun loadData() {
        val work = WorkManager.getInstance(application)
        work.enqueueUniqueWork(
            RebaseWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RebaseWorker.makeRequest()
        )
    }

    override fun getTimes(): NamazTime {
        return mapper.mapperTimesDbModelToNamazTime(db.timesDbDao().getTimesInfo())
    }

    override fun getUserInfo(): UserModel {
        return mapper.mapperUserDbModelToUserModel(db.databaseDao().getUser())
    }

}