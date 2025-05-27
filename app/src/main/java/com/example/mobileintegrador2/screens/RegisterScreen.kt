package com.example.mobileintegrador2.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobileintegrador2.R
import com.example.mobileintegrador2.model.UserRequest
import com.example.mobileintegrador2.services.RetrofitFactory
import androidx.compose.ui.platform.LocalContext
import android.util.Log


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun RegisterScreen(navegacao: NavHostController?) {

    val context = LocalContext.current


    val nomeState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val senhaState = remember { mutableStateOf("") }



    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.wallpaper_city),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xbb000000)))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.logo_nova),
                contentDescription = null,
                tint = Color(0xcffc1121),
                modifier = Modifier.size(75.dp)
            )

            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "REGISTER",
                    color = Color.White,
                    fontSize = 52.sp
                )

                Spacer(modifier = Modifier.height(130.dp))

                CustomTextField(value = nomeState.value, onValueChange = { nomeState.value = it }, label = "Nome", )
                CustomTextField(value = emailState.value, onValueChange = { emailState.value = it }, label = "Email")
                CustomTextField(value = senhaState.value, onValueChange = { senhaState.value = it }, label = "Senha", isPassword = true)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val user = UserRequest(
                            nome = nomeState.value,
                            email = emailState.value,
                            senha = senhaState.value
                        )
                        val call=RetrofitFactory()
                            .getUserService()
                            .registerUser(user)

                        call.enqueue(object : Callback<UserRequest> {
                            override fun onResponse(call: retrofit2.Call<UserRequest>, response: retrofit2.Response<UserRequest>) {
                                if (response.isSuccessful) {
                                    Log.i("API", "Usuário cadastrado com sucesso: ${response.body()}")
                                } else {
                                    Log.e("API", "Erro ao cadastrar: ${response.code()}")
                                }
                            }
                            override fun onFailure(call: retrofit2.Call<UserRequest>, t: Throwable) {
                                Log.e("API", "Falha na requisição: ${t.message}")
                            }

                        })

                        navegacao!!.navigate("login")
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xffc1121f)),
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .width(150.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Register",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(text = "Do you have an account?", color = Color.White)

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Login",
                    color = Color.White,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable {
                        navegacao?.navigate("login")
                    }
                )

                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}

@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String, isPassword: Boolean = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.White) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 14.dp)
            .height(60.dp)
            .width(322.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(null)
}
