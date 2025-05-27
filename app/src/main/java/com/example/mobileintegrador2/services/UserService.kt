package com.example.mobileintegrador2.services

import com.example.mobileintegrador2.model.UserRequest
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
        @Headers("Content-Type: application/json")
        @POST("usuario")
        fun registerUser(@Body user: UserRequest): retrofit2.Call<UserRequest>
}