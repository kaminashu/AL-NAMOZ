package www.uzmd.alnamoz.data.internet.connection

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetApiConnection {

    fun getRetrofit():Retrofit{

        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    const val BASE_URL="https://islomapi.uz/"
}