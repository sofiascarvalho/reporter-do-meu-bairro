package com.example.mobileintegrador2.screens

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

@Composable
fun RegisterScreen(navegacao: NavHostController?) {
    val nomeState = remember { mutableStateOf("") }
    val telefoneState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val senhaState = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.wallpaper_city),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(modifier = Modifier.fillMaxSize().background(Color(0xbb000000)))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.logo),
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

                CustomTextField(value = nomeState.value, onValueChange = { nomeState.value = it }, label = "Nome")
                CustomTextField(value = telefoneState.value, onValueChange = { telefoneState.value = it }, label = "Telefone")
                CustomTextField(value = emailState.value, onValueChange = { emailState.value = it }, label = "Email")
                CustomTextField(value = senhaState.value, onValueChange = { senhaState.value = it }, label = "Senha", isPassword = true)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        println("Usuário registrado: ${nomeState.value}, ${telefoneState.value}, ${emailState.value}")
                        // navegacao?.navigate("home")
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
        label = { Text(text = label) },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 14.dp)
            .height(45.dp)
            .width(322.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(null)
}
