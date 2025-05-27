package com.example.mobileintegrador2.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitFactory {
    private val BASE_URL = "http://10.0.2.2:3030/"

    private val RETROFIT_FACTORY = Retrofit
            .Builder()
            .baseUrl(BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getUserService(): UserService{
            return RETROFIT_FACTORY
                .create(UserService::class.java)
    }
}