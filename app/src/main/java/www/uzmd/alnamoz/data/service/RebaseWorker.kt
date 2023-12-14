package www.uzmd.alnamoz.data.service

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import www.uzmd.alnamoz.data.database.db.AppDatabase
import www.uzmd.alnamoz.data.database.dbmode.NamazDbModel
import www.uzmd.alnamoz.data.internet.connection.GetApiConnection
import www.uzmd.alnamoz.data.internet.connection.GetApiService
import www.uzmd.alnamoz.data.mapper.Mapper
import java.lang.Exception

class RebaseWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    private val cretae = GetApiConnection.getRetrofit().create(GetApiService::class.java)
    private val db = AppDatabase.getInstance(context)
    private val mapper = Mapper()
    override suspend fun doWork(): Result {
        while (true) {
            try {
                val region = db.databaseDao().getUser().region
                val getApiRegionInfo = cretae.getInfo(region)
                val timesRagion = getApiRegionInfo.times
                val weekday = getApiRegionInfo.weekday
                val date = getApiRegionInfo.date
                db.timesDbDao().addTimes(mapper.mapperTimesModelToTimesDbModel(timesRagion))
                db.namazDbDao().addNamazInfo(NamazDbModel(date = date, weekday = weekday))
                Log.d("TAG", "doWork: $timesRagion")
            } catch (e: Exception) {

            }
            delay(1000000)
        }
        return Result.success()
    }

    companion object {
        const val NAME = "RebaseWorker"
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RebaseWorker>().build()
        }
    }
}