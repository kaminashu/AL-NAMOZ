package www.uzmd.alnamoz.data

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import www.uzmd.alnamoz.data.database.db.AppDatabase
import www.uzmd.alnamoz.data.mapper.Mpper
import www.uzmd.alnamoz.data.service.MyWorkService
import www.uzmd.alnamoz.domain.entities.UserTimesModel
import www.uzmd.alnamoz.domain.repositories.UserRepository

class RepoImple(val context: Context) : UserRepository {
    val db=AppDatabase.getInstance(context).namazDao()
    override fun getNamazTimes(): UserTimesModel {
        return Mpper.mapperTimesToTimesUser(db.getTimes())
    }

    override fun loadData() {
        val worker = WorkManager.getInstance(context)
        worker.enqueueUniqueWork(
            MyWorkService.NAME,
            ExistingWorkPolicy.REPLACE,
            MyWorkService.makeRequest()
        )
    }
}