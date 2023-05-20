package com.nurlanamirzayeva.newsapplication.network

import com.nurlanamirzayeva.newsapplication.api.API
import com.nurlanamirzayeva.newsapplication.api.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    private val myApi: API

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(API::class.java)
    }

    fun getMyApi(): API {
        return myApi
    }

    companion object {
        @get:Synchronized
        var RetrofitInstance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }
}