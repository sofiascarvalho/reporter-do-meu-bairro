package com.example.mobileintegrador2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobileintegrador2.R

@Composable
fun LoginScreen(navegacao: NavHostController?) {

    var nameState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(
                R.drawable.wallpaper_city
            ),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xbb000000))
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ){
            Icon(
                painter = painterResource(
                    R.drawable.logo
                ),
                contentDescription = "",
                tint = Color(0xcffc1121),
                modifier = Modifier.size(75.dp)
            )

            Spacer(modifier = Modifier.height(36.dp))

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "LOGIN",
                    color = Color.White,
                    fontSize = 52.sp)

                Spacer(modifier = Modifier.height(130.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .height(45.dp)
                        .width(322.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xffffffff),
                        unfocusedBorderColor = Color(0xffffffff)
                    )
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Senha") },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 28.dp)
                        .height(45.dp)
                        .width(322.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xffffffff),
                        unfocusedBorderColor = Color(0xffffffff)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        Color(0xffc1121f)
                    ),
                    modifier = Modifier.padding(top = 25.dp).width(150.dp).height(50.dp),
                    shape = RoundedCornerShape(5.dp)
                ){
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(text = "Already have an account?", color = Color.White)

                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    onClick = {
                        if (nameState.value.isEmpty()){
                            isErrorState.value=true
                        }else{
                            navegacao!!.navigate("register")
                        }
                    },

                ) { }

                Spacer(modifier = Modifier.height(36.dp))

                Text(text = "Stay disconnected", color = Color(0xffc1121f), textDecoration = TextDecoration.Underline)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(null)
}