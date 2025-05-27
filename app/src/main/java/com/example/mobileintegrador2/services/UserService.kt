package com.example.mobileintegrador2.services

import com.example.mobileintegrador2.model.User
import com.example.mobileintegrador2.model.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
        @POST("http://10.107.134.3:8080/v1/controle-usuario/usuario")
        fun registerUser(@Body user: UserRequest): Call<User>

}