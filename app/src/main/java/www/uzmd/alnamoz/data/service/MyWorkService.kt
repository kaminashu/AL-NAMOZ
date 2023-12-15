package www.uzmd.alnamoz.data.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import www.uzmd.alnamoz.data.database.db.AppDatabase
import www.uzmd.alnamoz.data.database.dbModel.NamazModelDb
import www.uzmd.alnamoz.data.internet.connection.ApiCillent
import www.uzmd.alnamoz.data.internet.connection.ApiService
import www.uzmd.alnamoz.data.internet.dto.NamazDto
import www.uzmd.alnamoz.data.mapper.Mpper

class MyWorkService(val context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    val create = ApiCillent.getRetrofit().create(ApiService::class.java)
    val db = AppDatabase.getInstance(context).namazDao()

    override suspend fun doWork(): Result {
        while (true) {
            val region = db.getUser().region
            val regionNamazTime = create.loadRegionNamazTime(region)
            db.addNamazDb(Mpper.mapperNamazDtoToNamazDbModel(regionNamazTime))
            delay(500000)
        }
        return Result.success()
    }

    companion object {
        const val NAME = "MyWorkService"
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<MyWorkService>().build()
        }
    }
}