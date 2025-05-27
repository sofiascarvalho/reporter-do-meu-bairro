package com.example.mobileintegrador2.services

import com.example.mobileintegrador2.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
        @POST("v1/controle-usuario/usuario")
        fun registerUser(@Body user: User): Call<User>

}