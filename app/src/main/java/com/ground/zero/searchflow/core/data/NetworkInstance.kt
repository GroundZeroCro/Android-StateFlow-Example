package com.ground.zero.searchflow.core.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInstance {

    val getNetwork: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://api.github.com/"
    }
}