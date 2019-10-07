package com.example.pruebareciclerview

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiService {
    companion object {
        fun create(): PupusasApiService {
//region Logging de llamadas
            val httpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(logging)


//endregion
//region inicializacion de Retrofit
            val retrofit = Retrofit.Builder()

                .baseUrl("https://pupusapp-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
//endregion
//region retorna servicio
            return retrofit.create(PupusasApiService::class.java)
//endregion
        }
    }
}


