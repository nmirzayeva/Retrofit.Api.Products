package com.nurlanamirzayeva.newsapplication.api

import com.nurlanamirzayeva.newsapplication.api.models.DTO
import com.nurlanamirzayeva.newsapplication.api.models.Results
import retrofit2.Call
import retrofit2.http.GET


interface API {

    @GET ("products")

    fun getInfo(): Call<Results?>?

}