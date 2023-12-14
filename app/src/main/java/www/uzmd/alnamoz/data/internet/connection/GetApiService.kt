package www.uzmd.alnamoz.data.internet.connection

import retrofit2.http.GET
import retrofit2.http.Query
import www.uzmd.alnamoz.data.internet.model_dto.NamazDto

interface GetApiService {
    @GET("api/present/day")
   suspend fun getInfo(
        @Query(MY_REGION) region: String
    ): NamazDto

    companion object {
        private const val MY_REGION = "region"
    }
}