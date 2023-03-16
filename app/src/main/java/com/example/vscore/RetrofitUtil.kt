package com.example.vscore

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtilClass {
    companion object {
        private lateinit var retrofit: Retrofit

        val API_BASE_URL_PROD = "Url will be here"


        fun getRetrofit(token: String? = null): Retrofit {

            if (!::retrofit.isInitialized) {

                retrofit = Retrofit.Builder()
                    .baseUrl(API_BASE_URL_PROD)
                    .addConverterFactory(
                        GsonConverterFactory.create()
                    ).client(OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            chain.proceed(chain.request().newBuilder().also {
                                it.addHeader("Authorization", "Bearer $token")
                            }.build())
                        }.also { client ->
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                            client.addInterceptor(logging);
                        }.build()
                    ).build()
                return retrofit
            }
            return retrofit
        }

    }
}