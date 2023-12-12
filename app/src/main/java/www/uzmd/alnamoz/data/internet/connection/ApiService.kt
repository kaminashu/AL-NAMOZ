package www.uzmd.alnamoz.data.internet.connection

import retrofit2.http.GET
import retrofit2.http.Query
import www.uzmd.alnamoz.data.internet.dto.NamazDto

interface ApiService {
    @GET("api/present/day")
    suspend fun loadRegionNamazTime(
        @Query(REGION) region: String,
    ):NamazDto

    companion object {
        const val REGION = "region"
    }
}