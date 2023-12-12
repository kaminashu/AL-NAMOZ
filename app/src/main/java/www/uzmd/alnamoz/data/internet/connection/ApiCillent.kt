package www.uzmd.alnamoz.data.internet.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCillent {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    const val BASE_URL = "https://islomapi.uz/"
}